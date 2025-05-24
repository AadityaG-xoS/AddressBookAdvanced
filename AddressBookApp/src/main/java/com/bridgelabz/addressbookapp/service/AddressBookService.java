package com.bridgelabz.addressbookapp.service;

import com.bridgelabz.addressbookapp.dto.AddressBookDTO;
import com.bridgelabz.addressbookapp.model.AddressBookData;
import com.bridgelabz.addressbookapp.repository.AddressBookRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class AddressBookService implements IAddressBookService {

    @Autowired
    private AddressBookRepository addressBookRepository;

    @Override
    public AddressBookData createAddressBookData(AddressBookDTO addressBookDTO) {
        AddressBookData newContact = new AddressBookData(addressBookDTO);
        return addressBookRepository.save(newContact);
    }

    @Override
    public AddressBookData updateAddressBookData(int id, AddressBookDTO addressBookDTO) {
        AddressBookData existingData = addressBookRepository.findById(id)
            .orElseThrow(() -> new RuntimeException("AddressBook entry not found"));

        existingData.setName(addressBookDTO.getName());
        existingData.setAddress(addressBookDTO.getAddress());
        existingData.setCity(addressBookDTO.getCity());
        existingData.setState(addressBookDTO.getState());
        existingData.setZip(addressBookDTO.getZip());
        existingData.setPhoneNumber(addressBookDTO.getPhoneNumber());

        return addressBookRepository.save(existingData);
    }

    @Override
    public AddressBookData getAddressBookDataById(int id) {
        return addressBookRepository.findById(id)
            .orElseThrow(() -> new RuntimeException("AddressBook entry not found"));
    }

    @Override
    public List<AddressBookData> getAllAddressBookData() {
        return addressBookRepository.findAll();
    }

    @Override
    public void deleteAddressBookData(int id) {
        addressBookRepository.deleteById(id);
    }
}
