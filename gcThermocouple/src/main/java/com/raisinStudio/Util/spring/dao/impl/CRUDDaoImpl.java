package com.raisinStudio.Util.spring.dao.impl;

import java.beans.BeanInfo;
import java.beans.Introspector;
import java.beans.PropertyDescriptor;
import java.lang.reflect.Method;
import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.DataAccessException;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Repository;

import com.raisinStudio.Util.spring.dao.MapAndBean;
import com.raisinStudio.Util.spring.dao.intf.CRUDDao;

@Repository
public class CRUDDaoImpl implements CRUDDao {
	@Autowired
	private JdbcTemplate jdbcTemplate;

	@SuppressWarnings("unchecked")
	public List<Object> getAll(String tableName, Class<?> tempClass)
			throws DataAccessException {
		String sql = "SELECT * From " + tableName;
		return MapAndBean.transMapList2BeanList(jdbcTemplate.queryForList(sql),
				tempClass);
	}

	public Object getById(Integer id, String tableName, String idName,
			Class<?> tempClass) throws DataAccessException {
		String sql = "SELECT * From " + tableName + " where " + idName + "=?";
		return MapAndBean.transMap2Bean(jdbcTemplate.queryForMap(sql, id),
				tempClass);
	}

	public Object getById(Long id, String tableName, String idName,
			Class<?> tempClass) throws DataAccessException {
		String sql = "SELECT * From " + tableName + " where " + idName + "=?";
		return MapAndBean.transMap2Bean(jdbcTemplate.queryForMap(sql, id),
				tempClass);
	}

	@SuppressWarnings("unchecked")
	public List<Object> getbySQL(String sql, Class<?> tempClass)
			throws DataAccessException {
		return MapAndBean.transMapList2BeanList(jdbcTemplate.queryForList(sql),
				tempClass);
	}

	public void save(Object object, String tableName, Class<?> tempClass)
			throws DataAccessException {

		StringBuffer columnsString = new StringBuffer("");
		StringBuffer columnsMarkString = new StringBuffer("");
		List<Object> columnsObjectList = new ArrayList<Object>();
		try {
			BeanInfo beanInfo = Introspector.getBeanInfo(tempClass);
			PropertyDescriptor[] propertyDescriptors = beanInfo
					.getPropertyDescriptors();

			for (PropertyDescriptor property : propertyDescriptors) {

				String key = property.getName().toUpperCase();
				if (key.equalsIgnoreCase("CLASS")) {
					continue;
				}
				columnsString.append(key + ",");
				columnsMarkString.append("?,");
				Method getter = property.getReadMethod();
				columnsObjectList.add(getter.invoke(object));
			}
		} catch (Exception e) {
			System.out.println("transBean2Map Error " + e);
		}

		String sql = "INSERT INTO "
				+ tableName
				+ "("
				+ columnsString.substring(0, columnsString.length() - 1)
				+ ") VALUES("
				+ columnsMarkString
						.substring(0, columnsMarkString.length() - 1) + ")";
		jdbcTemplate.update(sql, columnsObjectList.toArray());

	}

	public void update(Object object, String tableName, Class<?> tempClass)
			throws DataAccessException {

	}

	public void deleteById(Integer id, String tableName, Class<?> tempClass)
			throws DataAccessException {

	}

}
