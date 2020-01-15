package com.yudao.util;

import java.lang.reflect.Field;
import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;
import java.util.LinkedHashMap;

/**
 * @function:  任务的工具类
 * @author: lijun
 * @address: 杭州市 江干区 万达商业中心 1019
 * @date: 2019/8/24
 * @version:
 */
public class TaskUtil {

    private TaskUtil(){}

    /**
     * 将map中的数据封装在对象里面
     * @param clazz    反射的结果类
     * @param hashMap  存放着反射对象中对应字段的value
     * @param <T>
     * @return
     */
    public static <T> T convertObject(Class<T> clazz,Object hashMap){
        T t = null;
        try {
            t = clazz.newInstance();
            //获取全部的属性
            Method[] methods = clazz.getMethods();
            //将对象转化为集合
            LinkedHashMap<String, Object> otherData = (LinkedHashMap<String, Object>) hashMap;
            for (int i =0; i < methods.length; i++){
                if(methods[i].getName().startsWith("set")){
                    //截取属性名
                    String attrName = methods[i].getName().substring("set".length());
                    attrName = StringUtil.lowerFirst(attrName);
                    Object o = otherData.get(attrName);
                    //如果获得的是一个对象，那么继续进行调用递归的反射
                    if(o!=null && o.getClass() == LinkedHashMap.class){
                        Field field = clazz.getDeclaredField(attrName);
                        o = convertObject(field.getType(),o);
                    }
                    Class<?> parameterType = methods[i].getParameterTypes()[0];
                    if(o != null && parameterType == Integer.class){
                        methods[i].invoke(t,new Integer(o.toString()));
                    }else if(o != null && parameterType == Boolean.class){
                        methods[i].invoke(t,(Boolean)o);
                    }else{
                        methods[i].invoke(t,o);
                    }
                }
            }
        } catch (InstantiationException e) {
            e.printStackTrace();
        } catch (IllegalAccessException e) {
            e.printStackTrace();
        } catch (InvocationTargetException e) {
            e.printStackTrace();
        } catch (NoSuchFieldException e) {
            e.printStackTrace();
        }
        return t;
    }

    /**
     * 根据key的值  获取map里面value
      * @param key
     * @param hashMap
     * @return
     */
    public static Object getValueByKey(String key,Object hashMap){
        LinkedHashMap map = (LinkedHashMap)hashMap;
        return map.get(key);
    }


}
