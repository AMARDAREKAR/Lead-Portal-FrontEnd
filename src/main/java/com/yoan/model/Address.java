package com.yoan.model;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.validation.constraints.NotEmpty;
@Entity(name="address_tbl")
public class Address {
	
	@Id@GeneratedValue(strategy = GenerationType.IDENTITY)
	private int addressId;
	@NotEmpty(message= "should not be empty")
	private String country,state,city,zipcode;
	private String addressLine1,addressLine2;
	
	
	public Address() {
		super();
	}
	public Address(int addressId, @NotEmpty(message = "should not be empty") String country,
			@NotEmpty(message = "should not be empty") String state,
			@NotEmpty(message = "should not be empty") String city,
			@NotEmpty(message = "should not be empty") String zipcode, String addressLine1, String addressLine2) {
		super();
		this.addressId = addressId;
		this.country = country;
		this.state = state;
		this.city = city;
		this.zipcode = zipcode;
		this.addressLine1 = addressLine1;
		this.addressLine2 = addressLine2;
	}
	@Override
	public String toString() {
		return "Address [addressId=" + addressId + ", country=" + country + ", state=" + state + ", city=" + city
				+ ", zipcode=" + zipcode + ", addressLine1=" + addressLine1 + ", addressLine2=" + addressLine2 + "]";
	}
	public int getaddressId() {
		return addressId;
	}
	public void setaddressId(int addressId) {
		this.addressId = addressId;
	}
	public String getAddressLine1() {
		return addressLine1;
	}
	public void setAddressLine1(String addressLine1) {
		this.addressLine1 = addressLine1;
	}
	public String getAddressLine2() {
		return addressLine2;
	}
	public void setAddressLine2(String addressLine2) {
		this.addressLine2 = addressLine2;
	}
	public String getCountry() {
		return country;
	}
	public void setCountry(String country) {
		this.country = country;
	}
	public String getState() {
		return state;
	}
	public void setState(String state) {
		this.state = state;
	}
	public String getCity() {
		return city;
	}
	public void setCity(String city) {
		this.city = city;
	}
	public String getZipcode() {
		return zipcode;
	}
	public void setZipcode(String zipcode) {
		this.zipcode = zipcode;
	}
}
