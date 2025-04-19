package com.bridgelabz.addressbook.dto;

import jakarta.validation.constraints.Digits;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Pattern;

public class AddressBookDTO {

    @Pattern(regexp = "^[A-Z][a-zA-Z//s]{2,}$", message = "Name must start with a capital letter and have atleast 3 letters")
    private String name;

   @NotBlank(message = "City must not be empty")
    private String city;

    @NotBlank(message = "State must not be empty")
    private String state;

    @NotNull(message = "Phone number must not be null")
    @Digits(integer = 10, fraction = 0, message = "Phone number mut be of 10 digits")
    private long phoneNumber;
}
