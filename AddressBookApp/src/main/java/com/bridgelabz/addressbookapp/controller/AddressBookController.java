package com.bridgelabz.addressbookapp.controller;

import com.bridgelabz.addressbookapp.dto.AddressBookDTO;
import com.bridgelabz.addressbookapp.model.AddressBookData;
import com.bridgelabz.addressbookapp.service.IAddressBookService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/addressbook")
public class AddressBookController {

    private static final Logger LOGGER = LoggerFactory.getLogger(AddressBookController.class);

    private final IAddressBookService addressBookService;

    @Autowired
    public AddressBookController(IAddressBookService addressBookService) {
        this.addressBookService = addressBookService;
    }

    @GetMapping("/")
    public ResponseEntity<String> getWelcomeMessage() {
        LOGGER.info("GET /addressbook/ - Welcome message requested.");
        return ResponseEntity.ok("Welcome to Address Book App!");
    }

    @GetMapping("/get")
    public ResponseEntity<List<AddressBookData>> getAllContacts() {
        LOGGER.info("GET /addressbook/get - Fetching all contacts.");
        List<AddressBookData> contacts = addressBookService.getAllAddressBookData();
        return ResponseEntity.ok(contacts);
    }

    @GetMapping("/get/{id}")
    public ResponseEntity<AddressBookData> getContactById(@PathVariable int id) {
        LOGGER.info("GET /addressbook/get/{} - Fetching contact by ID.", id);
        AddressBookData contact = addressBookService.getAddressBookDataById(id);
        return ResponseEntity.ok(contact);
    }

    @PostMapping("/create")
    public ResponseEntity<AddressBookData> createContact(@RequestBody AddressBookDTO dto) {
        LOGGER.info("POST /addressbook/create - Creating contact: {}", dto);
        AddressBookData newContact = addressBookService.createAddressBookData(dto);
        return ResponseEntity.ok(newContact);
    }

    @PutMapping("/update/{id}")
    public ResponseEntity<AddressBookData> updateContact(@PathVariable int id, @RequestBody AddressBookDTO dto) {
        LOGGER.info("PUT /addressbook/update/{} - Updating contact with data: {}", id, dto);
        AddressBookData updatedContact = addressBookService.updateAddressBookData(id, dto);
        return ResponseEntity.ok(updatedContact);
    }

    @DeleteMapping("/delete/{id}")
    public ResponseEntity<String> deleteContact(@PathVariable int id) {
        LOGGER.info("DELETE /addressbook/delete/{} - Deleting contact.", id);
        addressBookService.deleteAddressBookData(id);
        return ResponseEntity.ok("Contact deleted with id: " + id);
    }
}
