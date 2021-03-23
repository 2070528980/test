package com.example.shiro.common.utils;

import java.math.BigDecimal;

/**
 * Created by 敲代码的卡卡罗特
 */
public class BigDecimalUtil {

    private BigDecimalUtil() {

    }


    /**
     * 加法
     * @param v1  参数1
     * @param v2 参数2
     * @return 结果
     */
    public static BigDecimal add(double v1, double v2) {
        BigDecimal b1 = new BigDecimal(Double.toString(v1));
        BigDecimal b2 = new BigDecimal(Double.toString(v2));
        return b1.add(b2);
    }

    /**
     * 减法
     * @param v1  参数1
     * @param v2 参数2
     * @return 结果
     */
    public static BigDecimal sub(double v1, double v2) {
        BigDecimal b1 = new BigDecimal(Double.toString(v1));
        BigDecimal b2 = new BigDecimal(Double.toString(v2));
        return b1.subtract(b2);
    }


    /**
     * 乘法
     * @param v1  参数1
     * @param v2 参数2
     * @return 结果
     */
    public static BigDecimal mul(double v1, double v2) {
        BigDecimal b1 = new BigDecimal(Double.toString(v1));
        BigDecimal b2 = new BigDecimal(Double.toString(v2));
        return b1.multiply(b2);
    }

    /**
     * 除法
     * @param v1  参数1
     * @param v2 参数2
     * @return 结果
     */
    public static BigDecimal div(double v1, double v2) {
        BigDecimal b1 = new BigDecimal(Double.toString(v1));
        BigDecimal b2 = new BigDecimal(Double.toString(v2));
        return b1.divide(b2, 2, BigDecimal.ROUND_HALF_UP);//四舍五入,保留2位小数

        //除不尽的情况
    }
}


