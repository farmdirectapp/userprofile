package com.receiptwallet.profile.request.model;

import com.receiptwallet.profile.common.ErrorCode;

public class Response {

	private int errorCode;
	private String errorMessage;
	private boolean status;

	public static final Response SUCESS = new Response(ErrorCode.SUCESS, "SUCESS", true);
	public static final Response FAILURE = new Response(ErrorCode.FAILURE, "Operation failed", false);
	public static final Response BAD_REQUEST = new Response(ErrorCode.BAD_REQUEST, "Bad request", false);

	public Response() {
		this.errorCode = ErrorCode.SUCESS;
		this.errorMessage = "SUCESS";
		this.status = true;
	}

	public Response(final int errorCode, final String message, boolean status) {
		this.errorCode = errorCode;
		this.errorMessage = message;
		this.status = status;
	}

	/**
	 * @return the errorCode
	 */
	public int getErrorCode() {
		return errorCode;
	}

	/**
	 * @param errorCode
	 *            the errorCode to set
	 */
	public void setErrorCode(int errorCode) {
		this.errorCode = errorCode;
	}

	/**
	 * @return the errorMessage
	 */
	public String getErrorMessage() {
		return errorMessage;
	}

	/**
	 * @param errorMessage
	 *            the errorMessage to set
	 */
	public void setErrorMessage(String errorMessage) {
		this.errorMessage = errorMessage;
	}

	public boolean isStatus() {
		return status;
	}

	public void setStatus(boolean status) {
		this.status = status;
	}

}
