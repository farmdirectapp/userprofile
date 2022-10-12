package com.receiptwallet.profile.controller;

import java.sql.Timestamp;
import java.time.ZonedDateTime;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

import javax.validation.Valid;

import com.receiptwallet.profile.common.Constants;
import com.receiptwallet.profile.entity.Address;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.validation.FieldError;
import org.springframework.web.bind.MethodArgumentNotValidException;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.receiptwallet.profile.model.AddressModel;
import com.receiptwallet.profile.request.model.AddressResponse;
import com.receiptwallet.profile.request.model.FieldValidationResult;
import com.receiptwallet.profile.request.model.InputValidationMessage;
import com.receiptwallet.profile.service.AddressService;

import io.swagger.annotations.ApiOperation;

@RestController
@RequestMapping("/V1/address")
public class AddressResource {

	@Autowired
	AddressService addressService;

	@PostMapping(consumes = "application/json", produces = "application/json")
	@ApiOperation(value = "Add new address for the profile.")
	public AddressResponse addAddress(@Valid @RequestBody AddressModel addressModel) {

		Address address = new Address();
		BeanUtils.copyProperties(addressModel, address);
		Timestamp currentTime = Timestamp.valueOf(ZonedDateTime.now(Constants.ZONEID_IST).toLocalDateTime());
		address.setCreatedTs(currentTime);
		address.setUpdatedTs(currentTime);
		addressService.addAddress(address);
		AddressResponse response = new AddressResponse();
		List<Address> addressList = new ArrayList<Address>();
		addressList.add(address);
		response.setAddressList(addressList);
		return response;
	}

	@PutMapping(consumes = "application/json", produces = "application/json")
	@ApiOperation(value = "Modify the existing address.")
	public AddressResponse updateAddress(@Valid @RequestBody AddressModel addressModel) {

		Address address = new Address();
		BeanUtils.copyProperties(addressModel, address);
		address.setUpdatedTs(Timestamp.valueOf(ZonedDateTime.now(Constants.ZONEID_IST).toLocalDateTime()));
		addressService.addAddress(address);
		AddressResponse response = new AddressResponse();
		List<Address> addressList = new ArrayList<Address>();
		addressList.add(address);
		response.setAddressList(addressList);
		return response;
	}

	@GetMapping("/byAddressId")
	@ApiOperation(value = "Find Address details by Address Id.")
	public AddressResponse findAddress(@RequestParam(value = "addressId", required = true) String addressId) {
		AddressResponse response = new AddressResponse();
		List<Address> address = addressService.findAddressByAddressId(addressId);
		if (address != null && address.size() > 0) {
			response.setAddressList(address);
			return response;
		} else {
			return new AddressResponse(400, "No data found for the given Address Id.", false);
		}
	}

	@GetMapping("/byAddressIdProfileId")
	@ApiOperation(value = "Find Address details by Address Id and Profile Id.")
	public AddressResponse findAddress(@RequestParam(value = "profileId", required = true) String profileId,
			@RequestParam(value = "addressId", required = true) String addressId) {
		AddressResponse response = new AddressResponse();

		List<Address> address = addressService.findAddressByAddressIdAndProfileId(addressId, profileId);
		if (address != null && address.size() > 0) {
			response.setAddressList(address);
			return response;
		} else {
			return new AddressResponse(400, "No data found for the given Address Id and Profile Id.", false);
		}
	}

	@ExceptionHandler(MethodArgumentNotValidException.class)
	public InputValidationMessage handleValidationExceptions(MethodArgumentNotValidException ex) {
		List<FieldValidationResult> validationResult = new ArrayList<FieldValidationResult>();
		InputValidationMessage validationMessage = null;
		List<FieldError> fieldError = ex.getBindingResult().getFieldErrors();

		Iterator iter = fieldError.iterator();
		if (iter != null) {
			validationMessage = new InputValidationMessage(400, "Input data validation error", false);
			while (iter.hasNext()) {
				FieldError objectError = (FieldError) iter.next();
				FieldValidationResult result = new FieldValidationResult(objectError.getField(),
						objectError.getDefaultMessage());
				validationResult.add(result);
			}
			validationMessage.setValidationResult(validationResult);
		}
		return validationMessage;
	}

}
