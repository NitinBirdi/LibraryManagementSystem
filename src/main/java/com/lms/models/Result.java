package com.lms.models;

import org.apache.commons.lang3.StringUtils;

public class Result {

	private ResultStatus status = ResultStatus.FAILURE;
	private String message;

	public Result(String message) {
		super();
		if (StringUtils.isEmpty(message)) {
			status = ResultStatus.SUCCESS;
		}
		
		this.message = message;
	}

	/**
	 * @return the status
	 */
	public ResultStatus getStatus() {
		return status;
	}

	/**
	 * @param status
	 *            the status to set
	 */
	public void setStatus(ResultStatus status) {
		this.status = status;
	}

	/**
	 * @return the messageSb
	 */
	public String getMessage() {
		return message;
	}

	/**
	 * @param messageSb
	 *            the messageSb to set
	 */
	public void setMessage(String message) {
		this.message = message;
	}

}
