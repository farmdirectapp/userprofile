package com.receiptwallet.profile.service;

import java.util.List;

import com.receiptwallet.profile.entity.MktAvlProduct;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.receiptwallet.profile.repository.MktAvlProductRepository;

@Service
public class MktAvlProductServiceImpl implements MktAvlProductService {

	Logger logger = LoggerFactory.getLogger(MktAvlProductServiceImpl.class);

	private MktAvlProductRepository mktAvailProduct;

	@Autowired
	public MktAvlProductServiceImpl(MktAvlProductRepository mktAvailProduct) {
		this.mktAvailProduct = mktAvailProduct;
	}

	@Override
	public boolean addProduct(MktAvlProduct avlProduct) {
		this.mktAvailProduct.save(avlProduct);
		return true;
	}

	@Override
	public boolean deleteProduct(MktAvlProduct avlProduct) {
		this.mktAvailProduct.delete(avlProduct);
		return true;
	}

	@Override
	public List<MktAvlProduct> listMktAvilProductByGeoLocation(String geoLocation, int radious) {
		return null;
	}

	@Override
	public List<MktAvlProduct> listMktAvilProductByPin(String pin, int radious) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public List<MktAvlProduct> listMktAvilProductByCity(String city, int radious) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public List<MktAvlProduct> listMktAvilProductByState(String state, int radious) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public List<MktAvlProduct> listMktAvilProductByName(String name, String geoLocation, int radious) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public List<MktAvlProduct> listMktAvilProductByPin(String pin, String productName, int radious) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public List<MktAvlProduct> listMktAvilProductByCity(String city, String productName, int radious) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public List<MktAvlProduct> listMktAvilProductByState(String state, String productName, int radious) {
		// TODO Auto-generated method stub
		return null;
	}

}
