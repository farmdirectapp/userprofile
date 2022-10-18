package com.receiptwallet.profile.service;

import java.util.List;

import com.receiptwallet.profile.entity.Address;

public interface AddressService {

	public void addAddress(Address address);

	public void updateAddress(Address address);

	public void deactivateAddress(String addressId);

	public List<Address> findAddressByAddressId(String addressId);

	public List<Address> findAddressByAddressIdAndProfileId(String addressId, String profileId);

}
