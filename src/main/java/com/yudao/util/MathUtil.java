package com.yudao.util;

/**
 * @Description
 * @Author lijun
 * @Address 江干区 万达商业中心
 * @Date 2019/10/12 0012 15:21
 * @Version
 */
public class MathUtil {


    private MathUtil(){}

    /**
     * 传入两个整型，相除后进一
     * @param divisor
     * @param dividend
     * @return
     */
    public static int ceil(int divisor,int dividend){
        return (int)Math.ceil(new Double(divisor)/new Double(dividend));
    }

    /**
     * 传入两个整型，相除后退一
     * @param divisor
     * @param dividend
     * @return
     */
    public static int floor(int divisor,int dividend){
        return (int) Math.floor(new Double(divisor)/new Double(dividend));
    }
}
