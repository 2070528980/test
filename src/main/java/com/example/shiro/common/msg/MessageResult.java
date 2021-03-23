package com.example.shiro.common.msg;



import com.example.shiro.common.enums.CodeStatus;
import lombok.AllArgsConstructor;
import lombok.Data;
import org.springframework.validation.Errors;
import org.springframework.validation.FieldError;
import org.springframework.validation.ObjectError;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

/**
 * 消息响应
 *
 * @author marker
 * Created by ROOT on 2018/03/08.
 */
@Data
@AllArgsConstructor
public class MessageResult implements Serializable {


    /**
     * 状态码
     */
    private String code;

    /**
     * 消息内容
     */
    private String msg;

    /**
     * 数据
     */
    private Object data;


    /**
     * 消息枚举构造
     *
     * @param status 消息枚举
     * @param data
     */
    public MessageResult(CodeStatus status, Object data) {
        this.code = status.getCode();
        this.msg = status.getMsg();
        this.data = data;
    }

    /**
     * 构造消息
     *
     * @param code 错误码
     * @param data 数据
     * @param msg  消息
     */
    public MessageResult(String code, Object data, String msg) {
        this.code = code;
        this.msg = msg;
        this.data = data;
    }


    /**
     * 操作成功
     *
     * @return
     */
    public static MessageResult success() {
        return new MessageResult(CodeStatus.STATUS_SUCCESS, null);
    }

    /**
     * 操作成功
     * 附加数据
     *
     * @return
     */
    public static MessageResult success(Object data) {
        return new MessageResult(CodeStatus.STATUS_SUCCESS, data);
    }


    /**
     * 操作失败
     *
     * @return
     */
    public static MessageResult error() {
        return new MessageResult(CodeStatus.STATUS_ERROR, null);
    }

    /**
     * 操作失败
     *
     * @param msg 消息内容
     * @return
     */
    public static MessageResult error(String msg) {
        return new MessageResult(CodeStatus.STATUS_ERROR.getCode(), (Object) null, msg);
    }

    /**
     * 操作失败
     * （自定义状态码）
     *
     * @param msg 消息内容
     * @return
     */
    public static MessageResult error(String status, String msg) {
        return new MessageResult(status, (Object) null, msg);
    }



    /**
     * 包装消息枚举
     *
     * @param resultCode 消息枚举
     * @return
     */
    public static MessageResult warpper(CodeStatus resultCode) {
        return new MessageResult(resultCode, null);
    }


    /**
     * 包装消息枚举(含有数据)
     *
     * @param resultCode 消息枚举
     * @return
     */
    public static MessageResult warpper(CodeStatus resultCode, Object data) {
        return new MessageResult(resultCode, data);
    }


    /**
     * 错误信息
     * @param e 异常
     * @return
     */
    public static MessageResult error(Exception e) {
        return new MessageResult(CodeStatus.STATUS_ERROR.getCode(), (Object) null, e.getMessage());
    }

    /**
     * 包装错误信息
     * @param errors
     * @return
     */
    public static MessageResult warpper(Errors errors) {

        List<ObjectError> list = errors.getAllErrors();
        List<FieldMsg> dataList = new ArrayList<>(list.size());

        for(ObjectError error : list){
            FieldError field = (FieldError)error;
            dataList.add(new FieldMsg(field.getField(), field.getDefaultMessage()));
        }
        return new MessageResult(CodeStatus.FORM_VALID_ERROR, dataList);
    }

    /**
     * 判断状态码是否相同
     * @param codeStatus
     * @return
     */
    public boolean eq(CodeStatus codeStatus){
        return this.code.equals(codeStatus.getCode());
    }
}
