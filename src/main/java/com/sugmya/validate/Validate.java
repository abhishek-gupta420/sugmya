package com.sugmya.validate;

import org.springframework.stereotype.Component;

@Component
public class Validate {

	public boolean isNameValid(String name) {
		return name != null && name.matches( "[A-Za-z\\s]*" );
	}
	
	public boolean isEmailValid(String email) {
		return email.equals("") ? true : email.matches("^[a-zA-Z0-9_+&*-]+(?:\\.[a-zA-Z0-9_+&*-]+)*@(?:[a-zA-Z0-9-]+\\.)+[a-zA-Z]{2,7}$");
	}
	
	public boolean isPhoneValid(String phoneNumber) {
		return phoneNumber.equals("") ? true : phoneNumber.matches("[0-9]{10}");
	}
	
	public boolean isAadharCardValid(String aadharCard) {
		return aadharCard.equals("") ? true : aadharCard.matches("[0-9]{12}");
	}
	
	
	public boolean isPincodeValid(String pincode) {
		return pincode.equals("") ? true : pincode.matches("[0-9]{6}");
	}
	
	public static void main(String[]args) {
		
		Validate validate=new Validate();
		System.out.print(validate.isNameValid("Kap il"));
	}
}
