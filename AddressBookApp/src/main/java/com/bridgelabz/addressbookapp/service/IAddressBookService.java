package com.bridgelabz.addressbookapp.service;

import com.bridgelabz.addressbookapp.dto.AddressBookDTO;
import com.bridgelabz.addressbookapp.model.AddressBookData;

import java.util.List;

public interface IAddressBookService {

    AddressBookData createAddressBookData(AddressBookDTO addressBookDTO);

    AddressBookData updateAddressBookData(int id, AddressBookDTO addressBookDTO);

    AddressBookData getAddressBookDataById(int id);

    List<AddressBookData> getAllAddressBookData();

    void deleteAddressBookData(int id);
}
