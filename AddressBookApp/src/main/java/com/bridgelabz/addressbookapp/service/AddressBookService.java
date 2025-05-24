package com.bridgelabz.addressbookapp.service;

import com.bridgelabz.addressbookapp.dto.AddressBookDTO;
import com.bridgelabz.addressbookapp.model.AddressBookData;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class AddressBookService implements IAddressBookService {

    private final List<AddressBookData> contactList = new ArrayList<>();
    private int idCounter = 1;

    @Override
    public List<AddressBookData> getAllContacts() {
        return contactList;
    }

    @Override
    public AddressBookData getContactById(int id) {
        return contactList.stream()
                .filter(contact -> contact.getId() == id)
                .findFirst()
                .orElse(null);
    }

    @Override
    public AddressBookData createContact(AddressBookDTO dto) {
        AddressBookData newContact = new AddressBookData(
                idCounter++,
                dto.getName(), dto.getAddress(), dto.getCity(),
                dto.getState(), dto.getZip(), dto.getPhoneNumber());
        contactList.add(newContact);
        return newContact;
    }

    @Override
    public AddressBookData updateContact(int id, AddressBookDTO dto) {
        AddressBookData existingContact = getContactById(id);
        if (existingContact != null) {
            existingContact.setName(dto.getName());
            existingContact.setAddress(dto.getAddress());
            existingContact.setCity(dto.getCity());
            existingContact.setState(dto.getState());
            existingContact.setZip(dto.getZip());
            existingContact.setPhoneNumber(dto.getPhoneNumber());
        }
        return existingContact;
    }

    @Override
    public void deleteContact(int id) {
        contactList.removeIf(contact -> contact.getId() == id);
    }
}
