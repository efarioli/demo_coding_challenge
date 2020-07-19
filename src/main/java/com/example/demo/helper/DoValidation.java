package com.example.demo.helper;

import com.example.demo.controller.Form;

import java.util.HashMap;

import static com.example.demo.helper.Validators.*;
import static com.example.demo.helper.Validators.isTelephoneNumberValid;

public class DoValidation {
    public static HashMap<String, String> doValidation(Form form){
        HashMap<String,String> errors = new HashMap<>();
        if ( !isValidEmailAddress(form.getEmail())){
            errors.put("email", "Email has not the correct format:");
        }
        System.out.println(!isStringAtLeastTwoChar(form.getLastName()));

        if ( !isTitleValid(form.getTitle())){
            errors.put("title", "Title format is not correct: Ex Mr, Mrs, Miss");
        }
        System.out.println("getFirstName" + !isStringAtLeastTwoChar(form.getFirstName()));
        if ( !isStringAtLeastTwoChar(form.getFirstName())){
            errors.put("firstName", "First Name has to be at least 2 characters");
        }
        System.out.println("getlasName" + !isStringAtLeastTwoChar(form.getLastName()));
        if ( !isStringAtLeastTwoChar(form.getLastName())){

            errors.put("lastName", "Last Name has to be at least 2 characters");
        }
        if ( !isStringAtLeastTwoChar(form.getAddressLine1())){
            errors.put("addressLine1", "Address Line 1 has to be at least 2 characters");
        }
        if ( !isStringAtLeastTwoChar(form.getCity())){
            errors.put("city", "City has to be at least 2 characters");
        }
        if ( !isPostCodeValid(form.getPostcode())){
            errors.put("postCode", "Postcode Has to have the correct format");
        }
        if ( !isTelephoneNumberValid(form.getPhoneNumber())){
            errors.put("phoneNumber", "Phone Has to have the correct format");
        }
        return errors;

    }
}
