package com.bridgelabz.addressbookapp.service;

import com.bridgelabz.addressbookapp.dto.AddressBookDTO;
import com.bridgelabz.addressbookapp.model.AddressBookData;

import java.util.List;

public interface IAddressBookService {
    List<AddressBookData> getAllContacts();
    AddressBookData getContactById(int id);
    AddressBookData createContact(AddressBookDTO addressBookDTO);
    AddressBookData updateContact(int id, AddressBookDTO addressBookDTO);
    void deleteContact(int id);
}
