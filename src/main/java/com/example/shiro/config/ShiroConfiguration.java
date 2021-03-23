package com.example.shiro.config;


import com.example.shiro.shiro.UserShiroRealm;
import org.apache.shiro.authc.credential.HashedCredentialsMatcher;
import org.apache.shiro.cache.MemoryConstrainedCacheManager;
import org.apache.shiro.mgt.SecurityManager;
import org.apache.shiro.session.mgt.eis.MemorySessionDAO;
import org.apache.shiro.spring.security.interceptor.AuthorizationAttributeSourceAdvisor;
import org.apache.shiro.spring.web.ShiroFilterFactoryBean;
import org.apache.shiro.web.mgt.DefaultWebSecurityManager;
import org.apache.shiro.web.servlet.SimpleCookie;
import org.apache.shiro.web.session.mgt.DefaultWebSessionManager;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;


import java.util.HashMap;

/**
 * shiro配置类
 * Created by Administrator on 2018/9/5.
 */
@Configuration
public class ShiroConfiguration {

    //将自己的验证方式加入容器
    @Bean
    public UserShiroRealm userShiroRealm() {
        return new UserShiroRealm();
    }

    @Bean
    public MemorySessionDAO getMemorySessionDAO() {
        return new MemorySessionDAO();
    }

    @Bean
    public SimpleCookie getSimpleCookie() {
        SimpleCookie simpleCookie = new SimpleCookie();
        simpleCookie.setName("SHRIOSESSIONID");
        return simpleCookie;
    }

    @Bean
    public MemoryConstrainedCacheManager memoryConstrainedCacheManager() {
        return new MemoryConstrainedCacheManager();
    }

    //配置shiro session 的一个管理器
    @Bean
    public DefaultWebSessionManager getDefaultWebSessionManager() {
        DefaultWebSessionManager sessionManager = new DefaultWebSessionManager();
        sessionManager.setSessionDAO(getMemorySessionDAO());
        sessionManager.setGlobalSessionTimeout(-1000);  //session有效期 默认值1800000 30分钟 1800000毫秒  -1000表示永久
        SimpleCookie simpleCookie = getSimpleCookie();
        simpleCookie.setHttpOnly(true);                 //设置js不可读取此Cookie
        simpleCookie.setMaxAge(3 * 365 * 24 * 60 * 60); //3年 cookie有效期
        sessionManager.setSessionIdCookie(simpleCookie);
        return sessionManager;
    }

    //配置核心安全事务管理器
    @Bean
    public SecurityManager securityManager() {
        DefaultWebSecurityManager manager = new DefaultWebSecurityManager();
        manager.setRealm(userShiroRealm());
        manager.setCacheManager(memoryConstrainedCacheManager());
        manager.setSessionManager(getDefaultWebSessionManager());
        return manager;
    }

    //加入注解的使用，不加入这个注解不生效
    @Bean
    public AuthorizationAttributeSourceAdvisor authorizationAttributeSourceAdvisor() {
        AuthorizationAttributeSourceAdvisor authorizationAttributeSourceAdvisor = new AuthorizationAttributeSourceAdvisor();
        authorizationAttributeSourceAdvisor.setSecurityManager(securityManager());
        return authorizationAttributeSourceAdvisor;
    }

    //Filter工厂，设置对应的过滤条件和跳转条件
    @Bean
    public ShiroFilterFactoryBean shiroFilterFactoryBean() {

        ShiroFilterFactoryBean shiroFilterFactoryBean = new ShiroFilterFactoryBean();

        shiroFilterFactoryBean.setSecurityManager(securityManager());

//        配置需要验证的
        HashMap<String, String> map = new HashMap<>();

        //登出
//        map.put("/core/user/logout", "logout");
        //认证 /###/@@@/**

//        登录验证拦截路径API开头的地址
//        map.put("/api/**", "authc");
        map.put("/api/index/**", "user");// 所有默认配置

        //登录认证不通过跳转（访问上面路径如果未登录就跳转到loginUnAuth）
        shiroFilterFactoryBean.setLoginUrl("/loginUnAuth");

        //登录成功后要跳转的链接
        //shiroFilterFactoryBean.setSuccessUrl("/index");
        //权限认证不通过跳转
        shiroFilterFactoryBean.setUnauthorizedUrl("/authorUnAuth");
//        配置需要拦截的
        shiroFilterFactoryBean.setFilterChainDefinitionMap(map);
        return shiroFilterFactoryBean;
    }


}
