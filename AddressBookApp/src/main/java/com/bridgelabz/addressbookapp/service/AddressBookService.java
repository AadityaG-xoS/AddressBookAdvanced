package com.bridgelabz.addressbookapp.service;

import com.bridgelabz.addressbookapp.dto.AddressBookDTO;
import com.bridgelabz.addressbookapp.model.AddressBookData;
import com.bridgelabz.addressbookapp.repository.AddressBookRepository;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class AddressBookService implements IAddressBookService {

    private static final Logger LOGGER = LoggerFactory.getLogger(AddressBookService.class);

    private final AddressBookRepository addressBookRepository;

    @Autowired
    public AddressBookService(AddressBookRepository addressBookRepository) {
        this.addressBookRepository = addressBookRepository;
    }

    @Override
    public List<AddressBookData> getAllAddressBookData() {
        LOGGER.info("Fetching all contacts from database.");
        return addressBookRepository.findAll();
    }

    @Override
    public AddressBookData getAddressBookDataById(int id) {
        LOGGER.info("Fetching contact by ID: {}", id);
        return addressBookRepository.findById(id)
                .orElseThrow(() -> new RuntimeException("Contact not found for ID: " + id));
    }

    @Override
    public AddressBookData createAddressBookData(AddressBookDTO dto) {
        AddressBookData contact = new AddressBookData(dto);
        LOGGER.info("Saving new contact: {}", contact);
        return addressBookRepository.save(contact);
    }

    @Override
    public AddressBookData updateAddressBookData(int id, AddressBookDTO dto) {
        LOGGER.info("Updating contact ID: {} with data: {}", id, dto);
        AddressBookData contact = this.getAddressBookDataById(id);
        contact.updateContact(dto);
        return addressBookRepository.save(contact);
    }

    @Override
    public void deleteAddressBookData(int id) {
        LOGGER.info("Deleting contact ID: {}", id);
        AddressBookData contact = this.getAddressBookDataById(id);
        addressBookRepository.delete(contact);
    }
}
