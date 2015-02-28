package com.raisinStudio.Util.spring.dao.intf;

import java.util.List;

import org.springframework.dao.DataAccessException;

public interface CRUDDao {
	List<Object> getAll(String tableName, Class<?> tempClass)
			throws DataAccessException;

	Object getById(java.lang.Integer id, String tableName, Class<?> tempClass)
			throws DataAccessException;

	List<Object> getbyString(String stringData, String columnName,
			String tableName, Class<?> tempClass) throws DataAccessException;

	void save(Object object, String tableName, Class<?> tempClass)
			throws DataAccessException;

	void update(Object object, String tableName, Class<?> tempClass)
			throws DataAccessException;

	void deleteById(java.lang.Integer id, String tableName, Class<?> tempClass)
			throws DataAccessException;
}
