package org.scau.mall.utils;

import java.beans.BeanInfo;
import java.beans.Introspector;
import java.beans.PropertyDescriptor;
import java.lang.reflect.Field;
import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;


public class BeanUtil {
    private static Logger logger = LoggerFactory.getLogger(BeanUtil.class);
    public static final char UNDERLINE='_';

	public static List<Object> getBeanPropertyValues(Object obj) throws IllegalArgumentException, IllegalAccessException{
		List<Object> list = new ArrayList<Object>();
		Field[] fields = obj.getClass().getFields();
		for(int index=0; index<fields.length; index++){
			list.add(fields[index].get(obj));
		}
		return list;
	}
	
	/**
	 * 将对象数据转化为map输出，属性名驼峰转下划线
	 * @param obj
	 * @return
	 * @throws IllegalAccessException
	 * @throws IllegalArgumentException
	 * @throws InvocationTargetException
	 * @throws NoSuchMethodException
	 * @throws SecurityException
	 */
	public static Map<String, Object> camelToUnderline4Object(Object obj) throws IllegalAccessException, IllegalArgumentException, InvocationTargetException, NoSuchMethodException, SecurityException {
	    Class<?> clazz = obj.getClass();
	    Field[] fields = clazz.getDeclaredFields();
	    if(fields.length <= 0){
	        return null;
	    }
	    Map<String, Object> map = new HashMap<String, Object>(fields.length);
	    for(Field field : fields){
	        String fieldName = field.getName();
	        Object value = clazz.getDeclaredMethod(assembleGetMethod(fieldName), null).invoke(obj, null);
	        map.put(camelToUnderline(fieldName), value);
	    }
        return map;
	}
	
	public static String assembleGetMethod(String fieldName){
	    StringBuilder sb = new StringBuilder(fieldName.length()+3);
	    return sb.append("get").append(Character.toUpperCase(fieldName.charAt(0))).append(fieldName.substring(1)).toString();
	}
	
    public static String camelToUnderline(String param){
        if (param==null||"".equals(param.trim())){
            return "";
        }
        int len=param.length();
        StringBuilder sb=new StringBuilder(len);
        for (int i = 0; i < len; i++) {
            char c=param.charAt(i);
            if (Character.isUpperCase(c)){
                sb.append(UNDERLINE);
                sb.append(Character.toLowerCase(c));
            }else{
                sb.append(c);
            }
        }
        return sb.toString();
    }
    
    public static String underlineToCamel(String param){
        if (param==null||"".equals(param.trim())){
            return "";
        }
        int len=param.length();
        StringBuilder sb=new StringBuilder(len);
        for (int i = 0; i < len; i++) {
            char c=param.charAt(i);
            if (c==UNDERLINE){
               if (++i<len){
                   sb.append(Character.toUpperCase(param.charAt(i)));
               }
            }else{
                sb.append(c);
            }
        }
        return sb.toString();
    }
    
    public static void copyFields(Object source, Object target, String... fields) {
        List<String> fieldList = null;
        if (fields != null && fields.length > 0) {
            fieldList = Arrays.asList(fields);
        }
        Map<String, Object> sourceMap = new HashMap<String, Object>();
        try {
            BeanInfo srcInfo = Introspector.getBeanInfo(source.getClass());
            for (PropertyDescriptor pd : srcInfo.getPropertyDescriptors()) {
                Method reader = pd.getReadMethod();
                if (reader == null || reader.invoke(source) == null) {
                    continue;
                }
                String name = pd.getName();
                // 默认继承Object类的属性，过滤掉
                if ("class".equals(name)) {
                    continue;
                }
                if (fieldList == null) {
                    sourceMap.put(name, reader.invoke(source));
                } else {
                    if (fieldList.contains(name)) {
                        sourceMap.put(name, reader.invoke(source));
                    }
                }
            }
            BeanInfo targetInfo = Introspector.getBeanInfo(target.getClass());
            for (PropertyDescriptor pd : targetInfo.getPropertyDescriptors()) {
                Method writer = pd.getWriteMethod();
                String name = pd.getName();
                if (sourceMap.containsKey(name)) {
                    Object obj = sourceMap.get(name);
                    Class<?> clazz = pd.getPropertyType();
                    if (clazz.isAssignableFrom(String.class)) {
                        if (!(obj instanceof String)) {
                            obj = obj.toString();
                        }
                    }
                    writer.invoke(target, obj);
                }
            }
        } catch (Exception e) {
            logger.error("copyFields error!", e);
        }
    }
    
    public static void main(String[] args) throws IllegalAccessException, IllegalArgumentException, InvocationTargetException, NoSuchMethodException, SecurityException {
        /*XmOrders order = new XmOrders();
        order.setAgentUserNo("11111");
        order.setOrderStatus(1);
        order.setCreatedAt(new Date());
        System.out.println(camelToUnderline4Object(order));*/
    }
    
    
}
