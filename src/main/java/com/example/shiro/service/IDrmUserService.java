package com.example.shiro.service;


import com.baomidou.mybatisplus.extension.service.IService;
import com.example.shiro.entity.DrmUser;



/**
 * <p>
 * 用户表 服务类
 * </p>
 *
 * @author wto
 * @since 2019-11-26
 */
public interface IDrmUserService extends IService<DrmUser> {

    DrmUser findOneByUserName(String userName);


    DrmUser selectByLoginName(String userName);
}
