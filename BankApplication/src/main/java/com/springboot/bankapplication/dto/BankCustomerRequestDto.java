package com.springboot.bankapplication.dto;

import javax.persistence.Column;
import javax.validation.constraints.Email;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Pattern;
import javax.validation.constraints.Size;

public class BankCustomerRequestDto {

	@NotNull(message = "FirstName should not be null")
	@NotBlank(message = "FirstName should not be blank")
	@NotEmpty(message = "FirstName should not be empty")
	private String firstName;

	@NotNull(message = "LastName should not be null")
	@NotBlank(message = "LastName should not be blank")
	@NotEmpty(message = "LastName should not be empty")
	private String lastName;

	@Email(message = "Please provide a valid email address")
	@Pattern(regexp = ".+@.+\\..+", message = "Please provide a valid email address")
	@Column(unique = true)
	private String emailID;

	@Size(min = 0, max = 10)
	@Pattern(regexp = "(^$|[0-9]{10})", message = "Please provide a valid mobile no.")
	private String mobileNo;

	@NotNull(message = "Area should not be null")
	@NotBlank(message = "Area should not be blank")
	@NotEmpty(message = "Area should not be empty")
	private String area;

	@NotNull(message = "City should not be null")
	@NotBlank(message = "City should not be blank")
	@NotEmpty(message = "City should not be empty")
	private String city;

	@NotNull(message = "State should not be null")
	@NotBlank(message = "State should not be blank")
	@NotEmpty(message = "State should not be empty")
	private String state;

	@Size(max = 6, min = 6, message = "Please put valid pincode")
	private int pincode;

	@NotNull(message = "Account Type should not be null")
	@NotBlank(message = "Account Type should not be blank")
	@NotEmpty(message = "Account Type should not be empty")
	private String accountType;

	public BankCustomerRequestDto() {
		super();
		// TODO Auto-generated constructor stub
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

	public String getEmailID() {
		return emailID;
	}

	public void setEmailID(String emailID) {
		this.emailID = emailID;
	}

	public String getMobileNo() {
		return mobileNo;
	}

	public void setMobileNo(String mobileNo) {
		this.mobileNo = mobileNo;
	}

	public String getArea() {
		return area;
	}

	public void setArea(String area) {
		this.area = area;
	}

	public String getCity() {
		return city;
	}

	public void setCity(String city) {
		this.city = city;
	}

	public String getState() {
		return state;
	}

	public void setState(String state) {
		this.state = state;
	}

	public int getPincode() {
		return pincode;
	}

	public void setPincode(int pincode) {
		this.pincode = pincode;
	}

	public String getAccountType() {
		return accountType;
	}

	public void setAccountType(String accountType) {
		this.accountType = accountType;
	}

}
