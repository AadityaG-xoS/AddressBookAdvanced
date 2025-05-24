package com.bridgelabz.addressbookapp.dto;

import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.Pattern;
import jakarta.validation.constraints.Size;

public class AddressBookDTO {

    @NotBlank(message = "Name cannot be blank")
    @Size(min = 2, max = 30, message = "Name should be 2 to 30 characters long")
    public String name;

    @NotBlank(message = "Address is required")
    public String address;

    @Pattern(regexp = "^(Male|Female|Other)$", message = "Gender must be Male, Female, or Other")
    public String gender;

    @Pattern(regexp = "^[6-9]\\d{9}$", message = "Phone number must be a 10-digit number starting with 6-9")
    public String phone;

    @Pattern(regexp = "^[A-Za-z\\s]+$", message = "City must contain only letters and spaces")
    public String city;

    @Pattern(regexp = "^[A-Za-z\\s]+$", message = "State must contain only letters and spaces")
    public String state;

    @Pattern(regexp = "^\\d{6}$", message = "Zip must be a 6-digit number")
    public String zip;
}
