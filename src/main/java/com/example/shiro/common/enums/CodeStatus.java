package com.example.shiro.common.enums;


import com.example.shiro.common.msg.MessageResult;


/**
 * 状态代码
 * <p>
 * 返回码定义，不同业务使用不同的状态区间，50个状态码一个区间，例如：
 * [ 000, 049] 公共状态码
 * [ 050, 099] 系统管理相关业务
 * [ 100, 149] Web组件先关业务
 * [ 150, 199] 活动业务
 * [ 200, 249] 资源业务
 * <p>
 * 具体返回开发接口同志们在群里沟通即可，避免出现重复定义。
 * <p>
 * Created by marker on 2018/3/8.
 */
public enum CodeStatus {

    // ==========================
    //       公共状态码
    // ==========================
    STATUS_SUCCESS("000", "操作成功"),
    STATUS_ERROR("-1", "操作失败"),
    ERROR_REQUEST("001", "当前版本有安全漏洞，请更新完最新安全版本！"),
    SERVER_BUSY("002", "服务器繁忙，请稍后再试"),
    VERIFY_CODE_ERROR("003", "验证码错误"),
    PAGESIZE_LIMIT_ERROR("004", "查询数据量，超过最大限制"),
    FILE_UPLOAD_ERROR("005", "文件上传失败"),
    USER_LOGIN_INVALID("008", "登录失效"),
    ACCOUNT_NOT_EXISTS("009", "账号不存在"),
    USER_ACCOUNT_PASS_ERROR("010", "账号或者密码错误"),
    //登录相关错误
    NOT_LOGGED("011", "您还没有登录！"),
    USER_IS_EXISTS("012", "账号已经存在！"),
    USER_IS_NULL("013", "账号为空！"),
    ACTIVITY_MOBILE_IN_BLACKLIST("014", "手机号码在黑名单中!"),
    USER_NOT_EXISTS("015", "用户不存在"),
    ROLE_HAS_USER_NOT_DELETE("016", "该角色有用户，不能删除！"),
    FORM_VALID_ERROR("017", "数据校验失败"),
    USER_INVALID_ERROR("018", "您的账号被冻结"),
    ADMIN_USER_NOT_DELETE("019", "公司管理员，不能删除！"),
    REFER_USER_NOT_EXISTS("020", "推荐人不存在"),
    REFER_USERADMIN_NOT_EDIT("021", "不允许编辑总后台管理员"),
    REFER_USER_NOT_PERMISSIONS("022", "您没有操作权限"),
    ORDER_ERROR("023", "订单异常，请确认重新提交"),
    ORDER_INVALID("024", "订单无效"),
    BANLANCE_LESS("025", "余额不足"),
    PAY_PASSWORD_ERROR("027", "请正确输入支付密码"),
    ADMIN_USER_NOT_CHANGE_TYPE("025", "公司管理员，不能更变类型！"),
    ADMIN_USER_IS_ONLY_ONE("026", "管理员类型账号只能有一个！"),
    APP_VERSION_CHECKED_NO_UPDATE("027", "没有检测到新版本！"),
    NORMAIL_BEAN_LESS("028", "普豆余量不足！"),
    ORDER_PAY_ERROR("029", "订单支付金额不正确！"),
    USER_REG_INVALID_ERROR("030", "您的账号审批被拒绝，请联系客服解决！"),
    CREDIT_PAY_NO_OPEN("031", "您的账号未开通信用支付！"),
    EXCEL_HEADER_ERRROR("032", "Excel表头校验失败！"),
    ORDER_OVERDUE_ERRROR("033", "您有未处理的逾期订单，请先处理逾期订单！"),
    ORDER_ALREADY_PAY("034", "您的订单已支付！"),
    COMPANY_RATE_ERRROR("035", "豆米信用未配置，请联系客户！"),
    ORDER_PAY_LINE_ERRROR("036", "您已选择线下支付！"),
    ACCOUNT_LOGIN_ERROR("037", "您的账户已在其他设备进行登录！"),
    ACCOUNT_ADDRESS_ERROR("038", "您输入的手机号不正确！"),
    ACCOUNT_ADDRESSID_ERROR("039", "您的收货地址不正确！"),
    ACCOUNT_INVOICE_ERROR("040", "您的发票类型不正确！"),
    ACCOUNT_DELIVERY_ERROR("041", "您的配送方式不正确！"),
    USER_REG_PENDING_ERROR("042", "您的账号状态为待审核，不能操作！"),
    USER_LOGIN_PHONE("043", "您输入的手机号有误，请重新输入！"),
    ORDER_AMOUNT_SMALL("044", "您的订单金额过少，请选用其他方式支付！"),






    // ==========================
    //       公共状态码
    // ==========================

    ERROR_DELETE_ADMIN_ROLE("100", "禁止删除管理员角色!"),
    ERROR_GET_SMS_CODE("101", "第三方短信验证码发送失败!"),
    ERROR_MINIO_REQUEST("102", "MINIO通讯失败!"),
    ERROR_UPLOAD_FILE_SIZE("103", "上传文件过大!"),
    ERROR_OLD_PASSWORD("104", "旧密码错误！"),
    ERROR_DELETE_ACTIVITY_TIME("105", "活动已生效禁止删除!"),
    ERROR_UPDATE_ACTIVITY_TIME("106", "活动已生效禁止修改!"),
    ERROR_ACTIVITY_NOT_EXISTS("107", "活动不存在!"),
    ERROR_SMS_CODE_NOT_EXISTS("108", "验证码已过时，请重新获取验证码!"),
    ERROR_SMS_CODE_SECCUSS("109", "获取验证码成功!"),
    ERROR_MOBILE_NOT_EXISTS("110", "手机号不存在!"),
    ERROR_DELETE_NOT_SELECT("111", "请选择删除的数据!"),
    ERROR_DELETE_NOT_SELECT_1("112", "该用户还有下线不能删除!"),
    ERROR_DELETE_NOT_SELECT_2("113", "该用户为销售经理还有管理的用户，不能删除!"),

    // ==========================
    //       业务状态码
    // ==========================
    ERROR_DELETE_PARAMS("200", "请求参数错误！"),
    ERROR_DELETE_MODULE_EXISTS_CHILD("201", "该菜单有子菜单，不能删除!"),
    ERROR_DELETE_GOODSCATEGORIES_EXISTS_CHILD("202", "该商品分类有子商品，不能删除!"),
    ERROR_UPDATE_GOODSCATEGORIES_EXISTS_CHILD("203", "该商品分类有子商品，不能移动至二级分类下!"),
    ERROR_CREATE_QRCODE("204", "生成二维码失败!"),
    ERROR_READ_QRCODE("205", "读取二维码失败!"),

    ERROR_NOT_DELETE_LOGIN_USER("206", "不能删除当前登录的账号!"),
    ERROR_NOT_DONGJIE_LOGIN_USER("207", "不允许冻结当前登录账号!"),



    ERROR_PERIODS_NOTFUND("301", "还款期数为空!"),


    HEADCOMPANY_NOT_DELETE("400", "总公司不能删除!"),
    SALE_MANAGER_EXIST_MEMBER("401", "销售经理存在下线!"),
    SALE_MANAGER_SET_ONLY_NORMAL_MEMBER("402", "只能设置事业合伙人的销售经理!"),
    SERVICE_DATA_NOT_EXISTS("403", "业务数据不存在"),
    ORDER_GOODS_ERROR_1("404", "定金优惠商品不能与非定金优惠商品一起下单！"),
    ORDER_GOODS_ERROR_2("405", "定金额度不足！"),
    ORDER_GOODS_ERROR_3("406", "购物车商品数量不能为0！"),
    ORDER_GOODS_ERROR_4("407", "提交的商品信息有误！"),
    ORDER_GOODS_ERROR_5("408", "不存在的订单数据！"),
    ORDER_GOODS_ERROR_6("409", "您购买的商品已经下架！"),
    ORDER_GOODS_ERROR_7("410", "订单不允许取消！"),
    ORDER_GOODS_ERROR_8("411", "当前订单状态不允许流转到完成！"),
    RECHARGE_MONEY_ERROR("412", "充值金额需大于0！"),


    ResultCode("", "");


    /**
     * 消息代码
     */
    private String code;

    /**
     * 消息内容
     */
    private String msg;


    /**
     * 枚举构造
     *
     * @param code 代码
     * @param msg  消息内容
     */
    CodeStatus(String code, String msg) {
        this.code = code;
        this.msg = msg;
    }


    /**
     * 获取消息
     *
     * @return String
     */
    public String getMsg() {
        return this.msg;
    }



    /**
     * 获取消息码
     *
     * @return String
     */
    public String getCode() {
        return this.code;
    }



    /**
     * 判断状态是否相同
     *
     * @param result 返回对象
     * @return
     */
    public boolean equalsStatus(MessageResult result) {
        if (result == null) {
            return false;
        }
        return this.code.equals(result.getCode());
    }

}
