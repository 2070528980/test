package com.example.shiro.controller;


import com.alibaba.fastjson.JSONObject;
import com.example.shiro.common.enums.CodeStatus;
import com.example.shiro.common.msg.MessageResult;
import com.example.shiro.common.utils.MD5Utils;
import com.example.shiro.service.IDrmUserService;
import org.apache.shiro.SecurityUtils;
import org.apache.shiro.authc.AuthenticationException;
import org.apache.shiro.authc.IncorrectCredentialsException;
import org.apache.shiro.authc.LockedAccountException;
import org.apache.shiro.authc.UsernamePasswordToken;
import org.apache.shiro.subject.PrincipalCollection;
import org.apache.shiro.subject.Subject;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

//@Controller
//@RequestMapping("/api/login")

@RestController
@RequestMapping("/api/login")
public class LoginController {

    private Logger logger = LoggerFactory.getLogger(UserController.class);

    @Autowired
    private IDrmUserService userService;

    /**
     * 登录
     *
     * @param
     * @return
     */
    @RequestMapping("")
    public Object login(String userName, String password) {
        JSONObject jsonObject = new JSONObject();
        jsonObject.put("code", CodeStatus.STATUS_ERROR.getCode());

        Subject subject = SecurityUtils.getSubject();

        UsernamePasswordToken token = new UsernamePasswordToken(userName, MD5Utils.stringToMD5( password));
        try {
//            登录校验，会运行doGetAuthenticationInfo方法验证
            subject.login(token);
            jsonObject.put("token", subject.getSession().getId());
            jsonObject.put("msg", "登录成功");
            jsonObject.put("code", CodeStatus.STATUS_SUCCESS.getCode());

        } catch (IncorrectCredentialsException e) {
            jsonObject.put("msg", "密码错误");
        } catch (LockedAccountException e) {

            jsonObject.put("msg", "登录失败，该用户已被冻结");
        } catch (AuthenticationException e) {
            jsonObject.put("msg", "该用户不存在");
        } catch (Exception e) {
            logger.error("", e);
            jsonObject.put("msg", e.getMessage());
        }


        return jsonObject;
    }

    @GetMapping("/logout")
    public Object logout() {
        SecurityUtils.getSubject().logout();
        return MessageResult.success("退出登录成功");
    }

    @RequestMapping("/info")
    public Object findUser() {
        Subject subject = SecurityUtils.getSubject();
        PrincipalCollection collection = subject.getPrincipals();
        String userName = (String) collection.iterator().next();
//            System.out.println("获取当前登录用户" + userName);
        return userService.findOneByUserName(userName).toString();

    }




}
