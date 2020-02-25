package com.yoan.model;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.validation.constraints.Email;
import javax.validation.constraints.NotEmpty;

import org.hibernate.validator.constraints.URL;

@Entity(name="prospect_tbl")
public class Prospect {
	
	@Id@GeneratedValue(strategy = GenerationType.IDENTITY)
	private int prospectId;
	@NotEmpty(message= "should not be empty")
	private String firstName,lastName,jobTitle,jobLevel,jobDepartment;
	
	@NotEmpty(message= "should not be empty")
	@Email(message = "should be correct email format")
	private String email;
	@URL(message= "should be correct url format")@NotEmpty(message= "should not be empty")
	private String jobTitleLink;
	private long phoneNumber,directNumber;
	
	public Prospect() {
		super();
	}
	public Prospect(int prospectId, @NotEmpty(message = "should not be empty") String firstName,
			@NotEmpty(message = "should not be empty") String lastName,
			@NotEmpty(message = "should not be empty") String jobTitle,
			@NotEmpty(message = "should not be empty") String jobLevel,
			@NotEmpty(message = "should not be empty") String jobDepartment,
			@NotEmpty(message = "should not be empty") @Email(message = "should be correct email format") String email,
			@URL(message = "should be correct url format") @NotEmpty(message = "should not be empty") String jobTitleLink,
			long phoneNumber, long directNumber) {
		super();
		this.prospectId = prospectId;
		this.firstName = firstName;
		this.lastName = lastName;
		this.jobTitle = jobTitle;
		this.jobLevel = jobLevel;
		this.jobDepartment = jobDepartment;
		this.email = email;
		this.jobTitleLink = jobTitleLink;
		this.phoneNumber = phoneNumber;
		this.directNumber = directNumber;
	}
	@Override
	public String toString() {
		return "Prospect [prospectId=" + prospectId + ", firstName=" + firstName + ", lastName=" + lastName
				+ ", jobTitle=" + jobTitle + ", jobLevel=" + jobLevel + ", jobDepartment=" + jobDepartment + ", email="
				+ email + ", jobTitleLink=" + jobTitleLink + ", phoneNumber=" + phoneNumber + ", directNumber="
				+ directNumber + "]";
	}
	public String getJobLevel() {
		return jobLevel;
	}
	public void setJobLevel(String jobLevel) {
		this.jobLevel = jobLevel;
	}
	public String getJobDepartment() {
		return jobDepartment;
	}
	public void setJobDepartment(String jobDepartment) {
		this.jobDepartment = jobDepartment;
	}
	public int getprospectId() {
		return prospectId;
	}
	public void setprospectId(int prospectId) {
		this.prospectId = prospectId;
	}
	public String getFirstName() {
		return firstName;
	}
	public void setFirstName(String firstName) {
		this.firstName = firstName;
	}
	public String getLastName() {
		return lastName;
	}
	public void setLastName(String lastName) {
		this.lastName = lastName;
	}
	public String getEmail() {
		return email;
	}
	public void setEmail(String email) {
		this.email = email;
	}
	public String getJobTitle() {
		return jobTitle;
	}
	public void setJobTitle(String jobTitle) {
		this.jobTitle = jobTitle;
	}
	public String getJobTitleLink() {
		return jobTitleLink;
	}
	public void setJobTitleLink(String jobTitleLink) {
		this.jobTitleLink = jobTitleLink;
	}
	public long getPhoneNumber() {
		return phoneNumber;
	}
	public void setPhoneNumber(long phoneNumber) {
		this.phoneNumber = phoneNumber;
	}
	public long getDirectNumber() {
		return directNumber;
	}
	public void setDirectNumber(long directNumber) {
		this.directNumber = directNumber;
	}
}
