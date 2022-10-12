package com.receiptwallet.profile.service;

import java.sql.Timestamp;
import java.time.ZonedDateTime;
import java.util.List;

import com.receiptwallet.profile.common.Constants;
import com.receiptwallet.profile.entity.Address;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.receiptwallet.profile.repository.AddressRepository;

@Service
public class AddressServiceImpl implements AddressService {

	private AddressRepository addressRepo;

	@Autowired
	public AddressServiceImpl(AddressRepository addressRepo) {
		this.addressRepo = addressRepo;
	}

	@Override
	public boolean addAddress(Address address) {
		Timestamp currentTime = Timestamp.valueOf(ZonedDateTime.now(Constants.ZONEID_IST).toLocalDateTime());
		address.setCreatedTs(currentTime);
		address.setUpdatedTs(currentTime);
		address.setAddressType(Constants.PRIMARY_ADDRESS);
		address.setAddressId(null);
		this.addressRepo.save(address);
		return true;
	}

	@Override
	public boolean updateAddress(Address address) {
		address.setUpdatedTs(Timestamp.valueOf(ZonedDateTime.now(Constants.ZONEID_IST).toLocalDateTime()));
		this.addressRepo.save(address);
		return false;
	}

	@Override
	public boolean deactivateAddress(String addressId) {
		// TODO Auto-generated method stub
		return false;
	}

	@Override
	public List<Address> findAddressByAddressId(String addressId) {
		return this.addressRepo.findAllByAddressId(addressId);
	}

	@Override
	public List<Address> findAddressByAddressIdAndProfileId(String addressId, String profileId) {
		return this.addressRepo.findAllByAddressIdAndProfileId(addressId, profileId);
	}

}
