package com.zensar.model;

import java.util.Date;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;
import javax.validation.constraints.Size;

import org.springframework.format.annotation.DateTimeFormat;

@Entity
@Table(name="employee_tbl")	
public class Employee {	 
	@Id
	private int employeeId;		
	@Size(min = 3, max = 14,message="Min 3 characters required")
	private String firstName,lastName,designation;
	private String password;
	private int enabledFlag,createdBy,modifiedBy;
	@Temporal(TemporalType.TIMESTAMP)@DateTimeFormat(pattern = "dd-MM-yyyy HH:mm:ss")
	private Date createdDate,modifiedDate;

	public Employee() {
		super();
	}
	public Employee(int employeeId, @Size(min = 3, max = 14, message = "Min 3 characters required") String firstName,
			@Size(min = 3, max = 14, message = "Min 3 characters required") String lastName,
			@Size(min = 3, max = 14, message = "Min 3 characters required") String designation, String password,
			int enabledFlag, int createdBy, int modifiedBy, Date createdDate, Date modifiedDate) {
		super();
		this.employeeId = employeeId;
		this.firstName = firstName;
		this.lastName = lastName;
		this.designation = designation;
		this.password = password;
		this.enabledFlag = enabledFlag;
		this.createdBy = createdBy;
		this.modifiedBy = modifiedBy;
		this.createdDate = createdDate;
		this.modifiedDate = modifiedDate;
	}
	@Override
	public String toString() {
		return "Employee [employeeId=" + employeeId + ", firstName=" + firstName + ", lastName=" + lastName
				+ ", designation=" + designation + ", password=" + password + ", enabledFlag=" + enabledFlag
				+ ", createdBy=" + createdBy + ", modifiedBy=" + modifiedBy + ", createdDate=" + createdDate
				+ ", modifiedDate=" + modifiedDate + "]";
	}
	public int getEnabledFlag() {
		return enabledFlag;
	}
	public void setEnabledFlag(int enabledFlag) {
		this.enabledFlag = enabledFlag;
	}
	public int getCreatedBy() {
		return createdBy;
	}
	public void setCreatedBy(int createdBy) {
		this.createdBy = createdBy;
	}
	public int getModifiedBy() {
		return modifiedBy;
	}
	public void setModifiedBy(int modifiedBy) {
		this.modifiedBy = modifiedBy;
	}
	public Date getCreatedDate() {
		return createdDate;
	}
	public void setCreatedDate(Date createdDate) {
		this.createdDate = createdDate;
	}
	public Date getModiefiedDate() {
		return modifiedDate;
	}
	public void setModifiedDate(Date modifiedDate) {
		this.modifiedDate = modifiedDate;
	}
	public String getFirstName() {
		return firstName;
	}
	public void setFirstName(String firstname) {
		this.firstName = firstname;
	}
	public String getLastName() {
		return lastName;
	}
	public void setLastName(String lastname) {
		this.lastName = lastname;
	}
	public String getDesignation() {
		return designation;
	}
	public void setDesignation(String designation) {
		this.designation = designation;
	}
	public String getPassword() {
		return password;
	}
	public void setPassword(String password) {
		this.password = password;
	}
	public int getEmployeeId() {
		return employeeId;
	}
	public void setEmployeeId(int employeeId) {
		this.employeeId = employeeId;
	}
}