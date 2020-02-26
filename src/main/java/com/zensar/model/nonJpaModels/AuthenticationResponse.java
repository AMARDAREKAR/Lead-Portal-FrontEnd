package com.zensar.model.nonJpaModels;

public class AuthenticationResponse{

	private final String jwt;
    private String firstName,lastName,designation;
    private int employeeId;

    public AuthenticationResponse(String jwt, String firstName, String lastName, String designation,int employeeId) {
		super();
		this.jwt = jwt;
		this.firstName = firstName;
		this.lastName = lastName;
		this.designation = designation;
		this.setEmployeeId(employeeId);
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
	public String getDesignation() {
		return designation;
	}
	public void setDesignation(String designation) {
		this.designation = designation;
	}
    public String getJwt() {
        return jwt;
    }
	public int getEmployeeId() {
		return employeeId;
	}
	public void setEmployeeId(int employeeId) {
		this.employeeId = employeeId;
	}
}