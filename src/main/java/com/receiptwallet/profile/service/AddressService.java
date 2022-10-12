package com.receiptwallet.profile.service;

import java.util.List;

import com.receiptwallet.profile.entity.Address;

public interface AddressService {
	public boolean addAddress(Address address);

	public boolean updateAddress(Address address);

	public boolean deactivateAddress(String addressId);

	public List<Address> findAddressByAddressId(String addressId);

	public List<Address> findAddressByAddressIdAndProfileId(String addressId, String profileId);

}
