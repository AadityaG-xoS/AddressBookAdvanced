package com.bridgelabz.addressbookapp.model;

import jakarta.persistence.*;
import lombok.Data;
import lombok.NoArgsConstructor;

@Entity
@Table(name = "address_book")
@Data
@NoArgsConstructor
public class AddressBookData {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private int id;

    private String name;
    private String address;
    private String city;
    private String state;
    private String zip;
    private String phoneNumber;

    // Constructor for mapping DTO to Entity
    public AddressBookData(AddressBookDTO dto) {
        this.name = dto.getName();
        this.address = dto.getAddress();
        this.city = dto.getCity();
        this.state = dto.getState();
        this.zip = dto.getZip();
        this.phoneNumber = dto.getPhoneNumber();
    }
}
