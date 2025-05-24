package com.bridgelabz.addressbookapp.controller;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/addressbook")
public class AddressBookController {

	@Autowired
	private IAddressBookService addressBookService;

	@GetMapping("/get")
	public ResponseEntity<List<AddressBookData>> getAllContacts() {
	    return ResponseEntity.ok(addressBookService.getAllContacts());
	}

	@GetMapping("/get/{id}")
	public ResponseEntity<AddressBookData> getContactById(@PathVariable int id) {
	    return ResponseEntity.ok(addressBookService.getContactById(id));
	}

	@PostMapping("/create")
	public ResponseEntity<AddressBookData> createContact(@RequestBody AddressBookDTO dto) {
	    return ResponseEntity.ok(addressBookService.createContact(dto));
	}

	@PutMapping("/update/{id}")
	public ResponseEntity<AddressBookData> updateContact(@PathVariable int id, @RequestBody AddressBookDTO dto) {
	    return ResponseEntity.ok(addressBookService.updateContact(id, dto));
	}

	@DeleteMapping("/delete/{id}")
	public ResponseEntity<String> deleteContact(@PathVariable int id) {
	    addressBookService.deleteContact(id);
	    return ResponseEntity.ok("Deleted contact with id: " + id);
	}
