package com.example.shiro.shiro;

import com.example.shiro.common.msg.MessageResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * Created by Administrator on 2018/9/5.
 */
@RestController
public class ShiroCoreController {


    @GetMapping("/loginUnAuth")
    public Object loginUnAuth() {

        return MessageResult.error("0","会话失效，请重新登录系统。");

//        return "{\n" +
//                "    \"codeEnum\": \"OVERTIME\",\n" +
//                "    \"code\": 0,\n" +
//                "    \"data\": null,\n" +
//                "    \"msg\": \"未登陆/登陆超时\",\n" +
//                "    \"success\": false\n" +
//                "}";
    }


    @GetMapping("/authorUnAuth")
    public Object authorUnAuth() {

        return MessageResult.error("-2","无此权限");

//        return "{\n" +
//                "    \"codeEnum\": \"ERR_PERMISSIONS\",\n" +
//                "    \"code\": -2,\n" +
//                "    \"data\": null,\n" +
//                "    \"msg\": \"无此权限\",\n" +
//                "    \"success\": false\n" +
//                "}";
    }
}
