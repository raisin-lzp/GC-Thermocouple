package com.raisinStudio.Util.spring.dao;

import java.beans.BeanInfo;
import java.beans.Introspector;
import java.beans.PropertyDescriptor;
import java.lang.reflect.Method;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class MapAndBean {
	public static Object transMap2BeanUseUpperCase(Map<String, Object> map,
			Class<?> tempClass) {

		try {
			Object obj = tempClass.newInstance();
			
			BeanInfo beanInfo = Introspector.getBeanInfo(tempClass);
			PropertyDescriptor[] propertyDescriptors = beanInfo
					.getPropertyDescriptors();

			for (PropertyDescriptor property : propertyDescriptors) {
				String key = property.getName().toUpperCase();

				if (map.containsKey(key)) {
					Object value = map.get(key);
					Method setter = property.getWriteMethod();
					setter.invoke(obj, value);
				}

			}
			return obj;
		} catch (Exception e) {
			System.out.println(e.toString());
			return null;
		}

	}
	
	public static Object transMap2Bean(Map<String, Object> map,
			Class<?> tempClass) {

		try {
			Object obj = tempClass.newInstance();
			
			BeanInfo beanInfo = Introspector.getBeanInfo(tempClass);
			PropertyDescriptor[] propertyDescriptors = beanInfo
					.getPropertyDescriptors();

			for (PropertyDescriptor property : propertyDescriptors) {
				String key = property.getName();

				if (map.containsKey(key)) {
					Object value = map.get(key);
					Method setter = property.getWriteMethod();
					setter.invoke(obj, value);
				}

			}
			return obj;
		} catch (Exception e) {
			System.out.println(e.toString());
			return null;
		}

	}

	public static List transMapList2BeanList(List<Map<String, Object>> list,
			Class<?> tempClass) {
		List<Object> returnList = new ArrayList<Object>();
		for (Map<String, Object> tempMap : list) {
			returnList.add(transMap2Bean(tempMap, tempClass));
		}
		return returnList;
	}

	public static Map<String, Object> transBean2Map(Object obj) {

		if (obj == null) {
			return null;
		}
		Map<String, Object> map = new HashMap<String, Object>();
		try {
			BeanInfo beanInfo = Introspector.getBeanInfo(obj.getClass());
			PropertyDescriptor[] propertyDescriptors = beanInfo
					.getPropertyDescriptors();
			for (PropertyDescriptor property : propertyDescriptors) {
				String key = property.getName();

				if (!key.equals("class")) {
					Method getter = property.getReadMethod();
					Object value = getter.invoke(obj);

					map.put(key, value);
				}

			}
		} catch (Exception e) {
			System.out.println("transBean2Map Error " + e);
		}

		return map;

	}
}
