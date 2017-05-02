package com.atshar.mybatisplugin.utils;

import java.io.IOException;
import java.io.Reader;

import org.apache.ibatis.io.Resources;
import org.apache.ibatis.session.SqlSessionFactory;
import org.apache.ibatis.session.SqlSessionFactoryBuilder;
import org.apache.log4j.Logger;

/**
 * The Class MybatisUtils.
 */
public class MybatisUtils {

	/** The Constant LOGGER. */
	private static final Logger LOGGER = Logger.getLogger(MybatisUtils.class);
	/** The sql session factory. */
	private SqlSessionFactory sqlSessionFactory;

	/**
	 * Instantiates sqlSessionFactory.
	 *
	 * @param  config file name
	 */
	public MybatisUtils(final String configFileName) {
		LOGGER.trace("MybatisUtils #IN");
		try (Reader reader = Resources.getResourceAsReader(configFileName);) {

			sqlSessionFactory = new SqlSessionFactoryBuilder().build(reader);
			LOGGER.info("sql session factory created successfully.");
		} catch (final IOException e) {
			LOGGER.error("Configuration file load error", e);
		}
		LOGGER.trace("MybatisUtils #OUT");
	}

	/**
	 * Gets  sql session factory.
	 * 
	 * @return SqlSessionFactory
	 */
	public SqlSessionFactory getSqlSessionFactory() {
		return sqlSessionFactory;
	}

}
