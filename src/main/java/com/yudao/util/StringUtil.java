package com.yudao.util;

/**
 * @function: 字符串工具类
 * @author: lijun
 * @address: 杭州市 江干区 万达商业中心 1019
 * @date: 2019/8/21
 * @version:
 */
public class StringUtil {
    private StringUtil(){};

    /**
     * 如果字符串为空返回true
     * @param key
     * @return
     */
    public static boolean isEmpty(String key){
        return key == null || "".equalsIgnoreCase(key);
    }

    /**
     * 如果字符串不为空返回true
     * @param key
     * @return
     */
    public static boolean isNotEmpty(String key){
        return !isEmpty(key);
    }


    /**
     * 将传入的单词的首字母转小写
     * @param key
     * @return
     */
    public static String lowerFirst(String key){
        String first = key.substring(0,1);
        String lowerCase = first.toLowerCase();
        String returnStr = lowerCase+key.substring(1);
        return returnStr;
    }
}
