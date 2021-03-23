package com.example.shiro.entity;

import com.alibaba.fastjson.annotation.JSONField;
import com.baomidou.mybatisplus.annotation.IdType;
import com.baomidou.mybatisplus.annotation.TableField;
import com.baomidou.mybatisplus.annotation.TableId;
import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.experimental.Accessors;

import java.io.Serializable;
import java.util.Date;

/**
 * <p>
 * 用户表
 * </p>
 *
 * @author wto
 * @since 2019-11-28
 */
@Data
@EqualsAndHashCode(callSuper = false)
@Accessors(chain = true)
@ApiModel(value="DrmUser对象", description="用户表")
public class DrmUser implements Serializable {

    private static final long serialVersionUID=1L;

    @TableId(value = "userID", type = IdType.AUTO)
    private Integer userID;

    @ApiModelProperty(value = "手机号")
    @TableField("phoneNumber")
    private String phoneNumber;

    @ApiModelProperty(value = "姓名")
    @TableField("username")
    private String username;

    @ApiModelProperty(value = "密码")
    @TableField("password")
    private String password;

    @ApiModelProperty(value = "状态 0正常 1冻结")
    @TableField("state")
    private String state;

    @JSONField(format = "yyyy-MM-dd HH:mm:ss")
    @ApiModelProperty(value = "创建日期")
    @TableField("createDate")
    private Date createDate;

    @ApiModelProperty(value = "身份证路径")
    @TableField("idCardImg")
    private String idCardImg;


}
