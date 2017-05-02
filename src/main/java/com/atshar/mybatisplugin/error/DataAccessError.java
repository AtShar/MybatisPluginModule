package com.atshar.mybatisplugin.error;

import org.apache.ibatis.exceptions.PersistenceException;

/**
 * The Class DataAccessError.
 */
public class DataAccessError extends Exception {

	/** The Constant serialVersionUID. */
	private static final long serialVersionUID = 1555738931937744089L;

	/** The error. */
	private String error;

	/** The caused by. */
	private Exception causedBy;

	/**
	 * Instantiates a new DataAccessError.
	 *
	 * @param error 
	 * @param exception 
	 */
	public DataAccessError(String error, PersistenceException exception) {
		this.error = error;
		this.causedBy = exception;
	}

	/**
	 * Gets the error.
	 *
	 * @return  error
	 */
	public String getError() {
		return error;
	}

	/**
	 * Sets the error.
	 *
	 * @param error 
	 */
	public void setError(String error) {
		this.error = error;
	}

	/**
	 * Gets the caused by.
	 *
	 * @return  causedBy
	 */
	public Exception getCausedBy() {
		return causedBy;
	}

	/**
	 * Sets the caused by.
	 *
	 * @param causedBy 
	 */
	public void setCausedBy(Exception causedBy) {
		this.causedBy = causedBy;
	}

}
