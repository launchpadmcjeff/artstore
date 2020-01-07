package jm.model;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;

import org.hibernate.validator.constraints.Email;

@Entity
public class Address {
	@Id
	@GeneratedValue
	private long id;
	
	@Override
	public String toString() {
		return "Address::[id=" + id + ", email=" + email + ", givenName=" + givenName + ", familyName=" + familyName
				+ ", organization=" + organization + ", addressLine1=" + addressLine1 + ", addressLine2=" + addressLine2
				+ ", addressLevel2=" + addressLevel2 + ", addressLevel1=" + addressLevel1 + ", postalCode=" + postalCode
				+ ", telNational=" + telNational + "]";
	}
	@Email 
	String email;
	
	private String givenName;
	private String familyName;
	private String organization;
	private String addressLine1;
	private String addressLine2;
	private String addressLevel2;
	private String addressLevel1;
	private String postalCode;
	private String telNational;
	
	public String getEmail() {
		return email;
	}
	public void setEmail(String email) {
		this.email = email;
	}
	public String getGivenName() {
		return givenName;
	}
	public void setGivenName(String givenName) {
		this.givenName = givenName;
	}
	public String getFamilyName() {
		return familyName;
	}
	public void setFamilyName(String familyName) {
		this.familyName = familyName;
	}
	public String getOrganization() {
		return organization;
	}
	public void setOrganization(String organization) {
		this.organization = organization;
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
	public String getAddressLevel2() {
		return addressLevel2;
	}
	public void setAddressLevel2(String addressLevel2) {
		this.addressLevel2 = addressLevel2;
	}
	public String getAddressLevel1() {
		return addressLevel1;
	}
	public void setAddressLevel1(String addressLevel1) {
		this.addressLevel1 = addressLevel1;
	}
	public String getPostalCode() {
		return postalCode;
	}
	public void setPostalCode(String postalCode) {
		this.postalCode = postalCode;
	}
	public String getTelNational() {
		return telNational;
	}
	public void setTelNational(String telNational) {
		this.telNational = telNational;
	}

}
