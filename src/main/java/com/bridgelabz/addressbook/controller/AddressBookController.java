package com.bridgelabz.addressbook.controller;

import com.bridgelabz.addressbook.dto.AddressBookDTO;
import com.bridgelabz.addressbook.dto.ResponseDTO;
import com.bridgelabz.addressbook.model.AddressBook;
import com.bridgelabz.addressbook.service.AddressBookService;
import jakarta.validation.Valid;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@Slf4j
@RequestMapping("/addressbook")
public class AddressBookController {

    @Autowired
    private AddressBookService addressBookService;

    // Create address
    @PostMapping("/create")
    public ResponseEntity<ResponseDTO> createAddress(@ Valid @ RequestBody AddressBookDTO addressBookDTO){
        log.info("Creating address with name : {}", addressBookDTO.getName());
        AddressBook address = addressBookService.createAddress(addressBookDTO);
        ResponseDTO responseDTO = new ResponseDTO("Address created successfully", address);
        log.info("Employee created successfully with Id: {}", address.getId());
        return new ResponseEntity<>(responseDTO, HttpStatus.CREATED);
    }

    @GetMapping("/all")
    public ResponseEntity<ResponseDTO> getAllAddresses(){
        log.info("Fetching all addresses...");
        List<AddressBook> addresses = addressBookService.getAllAddresses();
        ResponseDTO responseDTO = new ResponseDTO("List of all addresses: ", addresses);
        log.info("Fetched {} addresses ", addresses.size());
        return new ResponseEntity<>(responseDTO, HttpStatus.OK);
    }

    @GetMapping("/{id}")
    public ResponseEntity<ResponseDTO> getAddressById(@PathVariable Integer id){
        log.info("Fetching address with Id : {}", id);
        AddressBook address = addressBookService.getAddressById(id);
        ResponseDTO responseDTO = new ResponseDTO("Address found by id: ", address);
        log.info("Address found: {}", address.getId());
        return new ResponseEntity<>(responseDTO, HttpStatus.FOUND);
    }

    @PutMapping("/addressbook/{id}")
    public ResponseEntity<ResponseDTO> updateAddress(@PathVariable Integer id, @Valid @RequestBody AddressBookDTO addressBookDTO){
        log.info("Updating address with ID: {}", id);
        AddressBook address = addressBookService.updateAddress(id, addressBookDTO);
        ResponseDTO responseDTO = new ResponseDTO("AddressBook updated successfully", address);
        log.info("Employee Updated Successfully with ID: {}", address.getId());
        return new ResponseEntity<>(responseDTO, HttpStatus.OK);
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<ResponseDTO> deleteAddress(@PathVariable Integer id){
        log.info("Deleting address with ID: {}", id);
        addressBookService.deleteAddress(id);
        ResponseDTO responseDTO = new ResponseDTO("Address deleted successfully", id);
        log.info("Address Deleted Successfully with ID: {}", id);
        return new ResponseEntity<>(responseDTO, HttpStatus.OK);
    }

    @GetMapping("/city/{city}")
    public ResponseEntity<ResponseDTO> getAddressByCity(@PathVariable String city){
        log.info("Fetching address by city: {}", city);
        List<AddressBook> addressBooks = addressBookService.getAddressByCity(city);
        ResponseDTO responseDTO = new ResponseDTO("List of addresses: ", addressBooks);
        log.info("Address found by city: {}", city);
        return new ResponseEntity<>(responseDTO, HttpStatus.OK);
    }

    @GetMapping("/state/{state}")
    public ResponseEntity<ResponseDTO> getAddressByState(@PathVariable String state){
        log.info("Fetching address by state: {}", state);
        List<AddressBook> addressBooks = addressBookService.getAddressByState(state);
        ResponseDTO responseDTO = new ResponseDTO("List of addresses: ", addressBooks);
        log.info("Address found by state: {}", state);
        return new ResponseEntity<>(responseDTO, HttpStatus.OK);
    }

    @GetMapping("/phone/{phoneNumber}")
    public ResponseEntity<ResponseDTO> getAddressByPhoneNumber(@PathVariable long phoneNumber){
        log.info("Address found by Phone Number: {}", phoneNumber);
        AddressBook addressBook = addressBookService.getAddressByPhoneNumber(phoneNumber);
        ResponseDTO responseDTO = new ResponseDTO("Address found with phone number: " , + phoneNumber);
        log.info("Address found by Phone Number: {}", phoneNumber);
        return new ResponseEntity<>(responseDTO, HttpStatus.OK);
    }

}
