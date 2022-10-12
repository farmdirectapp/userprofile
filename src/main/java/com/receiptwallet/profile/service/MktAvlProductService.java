package com.receiptwallet.profile.service;

import java.util.List;

import com.receiptwallet.profile.entity.MktAvlProduct;

public interface MktAvlProductService {

	public boolean addProduct(MktAvlProduct avlProduct);

	public boolean deleteProduct(MktAvlProduct avlProduct);

	public List<MktAvlProduct> listMktAvilProductByGeoLocation(String geoLocation, int radious);

	public List<MktAvlProduct> listMktAvilProductByPin(String pin, int radious);

	public List<MktAvlProduct> listMktAvilProductByCity(String city, int radious);

	public List<MktAvlProduct> listMktAvilProductByState(String state, int radious);

	public List<MktAvlProduct> listMktAvilProductByName(String name, String geoLocation, int radious);

	public List<MktAvlProduct> listMktAvilProductByPin(String pin, String productName, int radious);

	public List<MktAvlProduct> listMktAvilProductByCity(String city, String productName, int radious);

	public List<MktAvlProduct> listMktAvilProductByState(String state, String productName, int radious);

}
