package com.atshar.mybatisplugin.daofactoryimpl;

import java.util.List;

import org.apache.ibatis.exceptions.PersistenceException;
import org.apache.ibatis.session.SqlSession;
import org.apache.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;

import com.atshar.mybatisplugin.daofactory.DaoFactory;
import com.atshar.mybatisplugin.error.DataAccessError;
import com.atshar.mybatisplugin.utils.MybatisUtils;
import com.atshar.mybatisplugin.utils.PluginConstants;

/**
 * The Class DaoFactoryImpl.
 */
public class DaoFactoryImpl implements DaoFactory {

	/** The logger. */
	private static final Logger LOGGER = Logger.getLogger(DaoFactoryImpl.class);

	/** The mybatis utils. */
	@Autowired
	private MybatisUtils mybatisUtils;

	/*
	 * (non-Javadoc)
	 * 
	 * @see com.atshar.mybatisplugin.daofactory.DaoFactory#insertData(java.lang.
	 * Object, org.apache.ibatis.session.SqlSession)
	 */
	@Override
	public <T> void insertData(T data, SqlSession sqlSession) throws DataAccessError {
		try {
			if (LOGGER.isDebugEnabled()) {
				LOGGER.debug("Inserting Data:" + data);
			}
			sqlSession.insert(data.getClass().getSimpleName() + PluginConstants.INSERT_DATA, data);
			if (LOGGER.isInfoEnabled()) {
				LOGGER.info("Insert data successful");
			}
		} catch (final PersistenceException exception) {
			LOGGER.error("error while inserting data", exception);
			throw new DataAccessError(PluginConstants.ERROR_INSERT_DATA, exception);
		}

	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see
	 * com.atshar.mybatisplugin.daofactory.DaoFactory#getDataById(java.lang.
	 * Class, java.lang.String, org.apache.ibatis.session.SqlSession)
	 */
	@Override
	public <T> T getDataById(Class<T> object, String dataId, SqlSession sqlSession) throws DataAccessError {
		try {
			if (LOGGER.isDebugEnabled()) {
				LOGGER.debug("Getting data by id " + dataId);
			}
			return sqlSession.selectOne(object.getSimpleName() + PluginConstants.GET_DATA_BY_ID, dataId);
		} catch (final PersistenceException exception) {
			LOGGER.error("Exception while getting data", exception);
			throw new DataAccessError(PluginConstants.ERROR_FETCH_DATA, exception);
		}
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see com.atshar.mybatisplugin.daofactory.DaoFactory#getAllData(java.lang.
	 * Class, org.apache.ibatis.session.SqlSession)
	 */
	@Override
	public <T> List<T> getAllData(Class<T> object, SqlSession sqlSession) throws DataAccessError {
		try {
			if (LOGGER.isInfoEnabled()) {
				LOGGER.info("Getting all data from dao");
			}
			return sqlSession.selectList(object.getSimpleName() + PluginConstants.GET_ALL_DATA);
		} catch (final PersistenceException exception) {
			LOGGER.error("Exception while gettting all data", exception);
			throw new DataAccessError(PluginConstants.ERROR_FETCH_DATA, exception);
		}
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see com.atshar.mybatisplugin.daofactory.DaoFactory#updateData(java.lang.
	 * Object, org.apache.ibatis.session.SqlSession)
	 */
	@Override
	public <T> void updateData(T object, SqlSession sqlSession) throws DataAccessError {
		try {
			if (LOGGER.isInfoEnabled()) {
				LOGGER.info("Updating data " );
			}
			sqlSession.update(object.getClass().getSimpleName() + PluginConstants.UPDATE_DATA, object);
		} catch (final PersistenceException exception) {
			LOGGER.error("Exception while updating data ", exception);
			throw new DataAccessError(PluginConstants.ERROR_UPDATE_DATA, exception);
		}

	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see com.atshar.mybatisplugin.daofactory.DaoFactory#deleteData(java.lang.
	 * String, java.lang.Class, org.apache.ibatis.session.SqlSession)
	 */
	@Override
	public <T> void deleteData(String dataID, Class<T> object, SqlSession sqlSession) throws DataAccessError {
		try {
			if (LOGGER.isDebugEnabled()) {
				LOGGER.debug("Deleting data for  dataId:" + dataID);
			}
			sqlSession.delete(object.getSimpleName() + PluginConstants.DELETE_DATA, dataID);
		} catch (final PersistenceException exception) {
			LOGGER.error("Exception while deleting data ", exception);
			throw new DataAccessError(PluginConstants.ERROR_DELETE_DATA, exception);
		}

	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see com.atshar.mybatisplugin.daofactory.DaoFactory#openSession()
	 */
	@Override
	public SqlSession openSession() throws DataAccessError {
		try {
			if (LOGGER.isInfoEnabled()) {
				LOGGER.info("Opening session");
			}
			final SqlSession sqlSession = mybatisUtils.getSqlSessionFactory().openSession(true);
			if (LOGGER.isInfoEnabled()) {
				LOGGER.info("Opening session successful");
			}
			return sqlSession;
		} catch (final PersistenceException exception) {
			LOGGER.error("Exception while openeing session", exception);
			throw new DataAccessError(PluginConstants.ERROR_OPENING_SESSION, exception);
		}
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see
	 * com.atshar.mybatisplugin.daofactory.DaoFactory#closeSession(org.apache.
	 * ibatis.session.SqlSession)
	 */
	@Override
	public void closeSession(SqlSession sqlSession) throws DataAccessError {
		try {
			if (LOGGER.isInfoEnabled()) {
				LOGGER.info("Closing session ");
			}
			sqlSession.close();
			if (LOGGER.isInfoEnabled()) {
				LOGGER.info("Closing session");
			}
		} catch (final PersistenceException exception) {
			LOGGER.error("Exception while closing session in dao", exception);
			throw new DataAccessError(PluginConstants.ERROR_CLOSING_SESSION, exception);
		}

	}

	/**
	 * Sets mybatisUtils.
	 *
	 * @param mybatisUtils
	 */
	public void setMybatisUtils(MybatisUtils mybatisUtils) {
		this.mybatisUtils = mybatisUtils;
	}

}
