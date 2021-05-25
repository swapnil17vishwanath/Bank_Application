package com.springboot.bankapplication.entity;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToOne;
import javax.persistence.Table;
import javax.validation.constraints.NotNull;

import com.fasterxml.jackson.annotation.JsonIgnore;

@Entity
@Table(name = "Customer_Details")
public class BankCustomer {
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	@Column(name = "customer_id")
	@JsonIgnore
	private Long customerId;
	@NotNull
	private String firstName;
	@NotNull
	private String lastName;
	@NotNull
	private String emailID;
	@NotNull
	private String mobileNo;
	@NotNull
	private String area;
	@NotNull
	private String city;
	@NotNull
	private String state;
	@NotNull
	private int pincode;

	@OneToOne(mappedBy = "bankCustomer", cascade = CascadeType.ALL)
	private CustomerAccountDetails customerAccountDetails;

	public BankCustomer() {
		super();
		// TODO Auto-generated constructor stub
	}

	public BankCustomer(Long customerId, @NotNull String firstName, @NotNull String lastName, @NotNull String emailID,
			@NotNull String mobileNo, @NotNull String area, @NotNull String city, @NotNull String state,
			@NotNull int pincode, CustomerAccountDetails customerAccountDetails) {
		super();
		this.customerId = customerId;
		this.firstName = firstName;
		this.lastName = lastName;
		this.emailID = emailID;
		this.mobileNo = mobileNo;
		this.area = area;
		this.city = city;
		this.state = state;
		this.pincode = pincode;
		this.customerAccountDetails = customerAccountDetails;
	}

	public Long getCustomerId() {
		return customerId;
	}

	public void setCustomerId(Long customerId) {
		this.customerId = customerId;
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

	public CustomerAccountDetails getCustomerAccountDetails() {
		return customerAccountDetails;
	}

	public void setCustomerAccountDetails(CustomerAccountDetails customerAccountDetails) {
		this.customerAccountDetails = customerAccountDetails;
	}

	@Override
	public String toString() {
		return "BankCustomer [customerId=" + customerId + ", firstName=" + firstName + ", lastName=" + lastName
				+ ", emailID=" + emailID + ", mobileNo=" + mobileNo + ", area=" + area + ", city=" + city + ", state="
				+ state + ", pincode=" + pincode + ", customerAccountDetails=" + customerAccountDetails + "]";
	}

}
