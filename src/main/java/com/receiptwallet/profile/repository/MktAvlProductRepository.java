package com.receiptwallet.profile.repository;

import com.receiptwallet.profile.entity.MktAvlProduct;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.data.mongodb.repository.MongoRepository;

public interface MktAvlProductRepository extends MongoRepository<MktAvlProduct, Long> {
	Logger logger = LoggerFactory.getLogger(MktAvlProductRepository.class);

}
