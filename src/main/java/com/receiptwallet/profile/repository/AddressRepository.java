package com.receiptwallet.profile.repository;

import java.util.List;

import com.receiptwallet.profile.entity.Address;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.data.mongodb.repository.MongoRepository;

public interface AddressRepository extends MongoRepository<Address, Long> {
	Logger logger = LoggerFactory.getLogger(AddressRepository.class);

	public List<Address> findAllByAddressIdAndProfileId(final String addressId, final String profileId);

	public List<Address> findAllByAddressId(final String addressId);

}
