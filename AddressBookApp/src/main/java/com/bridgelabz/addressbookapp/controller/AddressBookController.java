package com.bridgelabz.addressbookapp.controller;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/addressbook")
public class AddressBookController {

    @GetMapping("/")
    public ResponseEntity<String> getWelcomeMessage() {
        return ResponseEntity.ok("Welcome to Address Book App!");
    }

    @GetMapping("/get")
    public ResponseEntity<String> getAddressBookData() {
        return ResponseEntity.ok("GET Request Success");
    }

    @GetMapping("/get/{id}")
    public ResponseEntity<String> getAddressById(@PathVariable int id) {
        return ResponseEntity.ok("GET by ID Success: " + id);
    }

    @PostMapping("/create")
    public ResponseEntity<String> createAddress(@RequestBody String addressData) {
        return ResponseEntity.ok("POST Request Success: " + addressData);
    }

    @PutMapping("/update")
    public ResponseEntity<String> updateAddress(@RequestBody String addressData) {
        return ResponseEntity.ok("PUT Request Success: " + addressData);
    }

    @DeleteMapping("/delete/{id}")
    public ResponseEntity<String> deleteAddress(@PathVariable int id) {
        return ResponseEntity.ok("DELETE Request Success: " + id);
    }
}
