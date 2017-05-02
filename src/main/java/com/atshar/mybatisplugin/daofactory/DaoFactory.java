package com.atshar.mybatisplugin.daofactory;

import java.util.List;

import org.apache.ibatis.session.SqlSession;

import com.atshar.mybatisplugin.error.DataAccessError;

/**
 * A factory class for database functionalities.
 */
public interface DaoFactory {

	/**
	 * Insert data.
	 *
	 * @param data to be inserted
	 * @param sqlSession 
	 * @throws DataAccessError 
	 */
	public <T> void insertData(T data, SqlSession sqlSession) throws DataAccessError;

	/**
	 * Gets the data by id.
	 *
	 * @param Data class
	 * @param dataId 
	 * @param sqlSession 
	 * @return fetched data
	 * @throws DataAccessError 
	 */
	public <T> T getDataById(Class<T> object, String dataId, SqlSession sqlSession) throws DataAccessError;

	/**
	 * Gets  all data matching criteria
	 *
	 * @param Data class
	 * @param sqlSession 
	 * @return fetched data
	 * @throws DataAccessError 
	 */
	public <T> List<T> getAllData(Class<T> object, SqlSession sqlSession) throws DataAccessError;

	/**
	 * Update data.
	 *
	 * @param Data class
	 * @param sqlSession 
	 * @throws DataAccessError 
	 */
	public <T> void updateData(T object, SqlSession sqlSession) throws DataAccessError;

	/**
	 * Delete data.
	 *
	 * @param id
	 * @param Data class
	 * @param sqlSession 
	 * @throws DataAccessError 
	 */
	public <T> void deleteData(String dataID, Class<T> object, SqlSession sqlSession) throws DataAccessError;

	/**
	 * Open session.
	 *
	 * @return sqlSession
	 * @throws DataAccessError 
	 */
	public SqlSession openSession() throws DataAccessError;

	/**
	 * Close session.
	 *
	 * @param sqlSession t
	 * @throws DataAccessError
	 */
	public void closeSession(SqlSession sqlSession) throws DataAccessError;
}
