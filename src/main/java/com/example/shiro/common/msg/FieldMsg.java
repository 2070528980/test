package com.example.shiro.common.msg;
/**
 * Created by marker on 2018/5/28.
 */


import lombok.AllArgsConstructor;
import lombok.Data;

import java.io.Serializable;

/**
 * 字段校验信息
 *
 * @author marker
 * @create 2018-05-28 17:41
 **/
@Data
@AllArgsConstructor
public class FieldMsg implements Serializable {


    /**
     * 字段
     */
    private String field;

    /**
     * 消息内容
     */
    private String msg;



}
