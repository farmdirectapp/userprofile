package com.receiptwallet.profile.request.model;

import java.util.List;

public class InputValidationMessage extends Response {
	private List<FieldValidationResult> validationResult;

	public InputValidationMessage(final int errorCode, final String message, boolean status) {
		super(errorCode, message, status);
	}

	public InputValidationMessage(List<FieldValidationResult> validationResult) {
		this.validationResult = validationResult;
	}

	public List<FieldValidationResult> getValidationResult() {
		return validationResult;
	}

	public void setValidationResult(List<FieldValidationResult> validationResult) {
		this.validationResult = validationResult;
	}

}
