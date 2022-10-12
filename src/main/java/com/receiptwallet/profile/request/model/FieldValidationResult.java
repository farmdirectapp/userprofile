package com.receiptwallet.profile.request.model;

public class FieldValidationResult {
	private String fieldName;
	private String message;

	public FieldValidationResult() {
	}

	public FieldValidationResult(String fieldName, String message) {
		this.fieldName = fieldName;
		this.message = message;
	}

	public String getFieldName() {
		return fieldName;
	}

	public void setFieldName(String fieldName) {
		this.fieldName = fieldName;
	}

	public String getMessage() {
		return message;
	}

	public void setMessage(String message) {
		this.message = message;
	}

}
