package com.yoan.model;


import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.OneToOne;
import javax.validation.Valid;
import javax.validation.constraints.NotEmpty;

import org.hibernate.validator.constraints.URL;

@Entity(name = "company_tbl")
public class Company {
	
	@Id@GeneratedValue(strategy = GenerationType.IDENTITY)
	private int companyId;
	@NotEmpty(message= "should not be empty")
	private String companyName,industryType,employeeSize,domain;
	private String sicCode,naicsCode,revenueSize;
	@URL@NotEmpty(message= "should not be empty")
	private String employeeSizeLink,industryTypeLink;
	@URL
	private String revenueSizeLink,sicCodeLink,naicsCodeLink;
	@OneToOne(cascade=CascadeType.ALL)
	@JoinColumn(name="addressId")
	@Valid
	private Address address;
		
	public Company() {
		super();
	}
	public Company(int companyId, @NotEmpty(message = "should not be empty") String companyName,
			@NotEmpty(message = "should not be empty") String industryType,
			@NotEmpty(message = "should not be empty") String employeeSize,
			@NotEmpty(message = "should not be empty") String domain, String sicCode, String naicsCode,
			String revenueSize, @URL @NotEmpty(message = "should not be empty") String employeeSizeLink,
			@URL @NotEmpty(message = "should not be empty") String industryTypeLink, @URL String revenueSizeLink,
			@URL String sicCodeLink, @URL String naicsCodeLink, @Valid Address address) {
		super();
		this.companyId = companyId;
		this.companyName = companyName;
		this.industryType = industryType;
		this.employeeSize = employeeSize;
		this.domain = domain;
		this.sicCode = sicCode;
		this.naicsCode = naicsCode;
		this.revenueSize = revenueSize;
		this.employeeSizeLink = employeeSizeLink;
		this.industryTypeLink = industryTypeLink;
		this.revenueSizeLink = revenueSizeLink;
		this.sicCodeLink = sicCodeLink;
		this.naicsCodeLink = naicsCodeLink;
		this.address = address;
	}
	
	@Override
	public String toString() {
		return "Company [companyId=" + companyId + ", companyName=" + companyName + ", industryType=" + industryType
				+ ", employeeSize=" + employeeSize + ", domain=" + domain + ", sicCode=" + sicCode + ", naicsCode="
				+ naicsCode + ", revenueSize=" + revenueSize + ", employeeSizeLink=" + employeeSizeLink
				+ ", industryTypeLink=" + industryTypeLink + ", revenueSizeLink=" + revenueSizeLink + ", sicCodeLink="
				+ sicCodeLink + ", naicsCodeLink=" + naicsCodeLink + ", address=" + address + "]";
	}
	public String getDomain() {
		return domain;
	}
	public void setDomain(String domain) {
		this.domain = domain;
	}
	public Address getAddress() {
		return address;
	}
	public void setAddress(Address address) {
		this.address = address;
	}
	public int getcompanyId() {
		return companyId;
	}
	public void setcompanyId(int companyId) {
		this.companyId = companyId;
	}
	public String getCompanyName() {
		return companyName;
	}
	public void setCompanyName(String companyName) {
		this.companyName = companyName;
	}
	public String getEmployeeSize() {
		return employeeSize;
	}
	public void setEmployeeSize(String employeeSize) {
		this.employeeSize = employeeSize;
	}
	public String getIndustryType() {
		return industryType;
	}
	public void setIndustryType(String industryType) {
		this.industryType = industryType;
	}

	public String getSicCode() {
		return sicCode;
	}
	public void setSicCode(String sicCode) {
		this.sicCode = sicCode;
	}
	public String getNaicsCode() {
		return naicsCode;
	}
	public void setNaicsCode(String naicsCode) {
		this.naicsCode = naicsCode;
	}
	public String getRevenueSize() {
		return revenueSize;
	}
	public void setRevenueSize(String revenueSize) {
		this.revenueSize = revenueSize;
	}
	public String getEmployeeSizeLink() {
		return employeeSizeLink;
	}
	public void setEmployeeSizeLink(String employeeSizeLink) {
		this.employeeSizeLink = employeeSizeLink;
	}
	public String getRevenueSizeLink() {
		return revenueSizeLink;
	}
	public void setRevenueSizeLink(String revenueSizeLink) {
		this.revenueSizeLink = revenueSizeLink;
	}
	public String getIndustryTypeLink() {
		return industryTypeLink;
	}
	public void setIndustryTypeLink(String industryTypeLink) {
		this.industryTypeLink = industryTypeLink;
	}
	public String getSicCodeLink() {
		return sicCodeLink;
	}
	public void setSicCodeLink(String sicCodeLink) {
		this.sicCodeLink = sicCodeLink;
	}
	public String getNaicsCodeLink() {
		return naicsCodeLink;
	}
	public void setNaicsCodeLink(String naicsCodeLink) {
		this.naicsCodeLink = naicsCodeLink;
	}
}
