package com.gaoyang.controller;

import org.springframework.stereotype.Component;
import org.springframework.validation.Errors;
import org.springframework.validation.ValidationUtils;
import org.springframework.validation.Validator;

import com.gaoyang.pojo.UClient;


@Component
public class ValidatorSignUser implements Validator {
	
	public boolean supports(Class aClass)
    {
        return aClass.equals(UClient.class);
    }

    public void validate(Object obj, Errors errors)
    {
        UClient user = (UClient) obj;

        ValidationUtils.rejectIfEmptyOrWhitespace(errors, "userEMail", "error.invalid.userEMail", "User-EMail Required");
        ValidationUtils.rejectIfEmptyOrWhitespace(errors, "userFirstName", "error.invalid.FirstName", "User-EMail Required");
        ValidationUtils.rejectIfEmptyOrWhitespace(errors, "userLastName", "error.invalid.userLastName", "User-EMail Required");
        ValidationUtils.rejectIfEmptyOrWhitespace(errors, "userPassword", "error.invalid.userPassword", "User-EMail Required");
    }

}
