package com.receiptwallet.profile.request.model;

import java.util.List;

import com.receiptwallet.profile.entity.Address;

public class AddressResponse extends Response {

	private List<Address> addressList;

	public AddressResponse() {
	}

	public AddressResponse(final int errorCode, final String message, boolean status) {
		super(errorCode, message, status);
	}

	public List<Address> getAddressList() {
		return addressList;
	}

	public void setAddressList(List<Address> addressList) {
		this.addressList = addressList;
	}

}
