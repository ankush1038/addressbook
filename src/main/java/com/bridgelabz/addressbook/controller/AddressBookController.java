package com.bridgelabz.addressbook.controller;

import com.bridgelabz.addressbook.dto.AddressBookDTO;
import com.bridgelabz.addressbook.dto.ResponseDTO;
import com.bridgelabz.addressbook.model.AddressBook;
import com.bridgelabz.addressbook.service.AddressBookService;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.RequestEntity;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/addressbook")
public class AddressBookController {

    @Autowired
    private AddressBookService addressBookService;

    // Create address
    @PostMapping("/create")
    public ResponseEntity<ResponseDTO> createAddress(@ Valid @ RequestBody AddressBookDTO addressBookDTO){
        AddressBook address = addressBookService.createAddress(addressBookDTO);
        ResponseDTO responseDTO = new ResponseDTO("Address created successfully", address);
        return new ResponseEntity<>(responseDTO, HttpStatus.CREATED);
    }

    @GetMapping("/all")
    public ResponseEntity<ResponseDTO> getAllAddresses(){
        List<AddressBook> addresses = addressBookService.getAllAddresses();
        ResponseDTO responseDTO = new ResponseDTO("List of all addresses: ", addresses);
        return new ResponseEntity<>(responseDTO, HttpStatus.OK);
    }

    @GetMapping("/{id}")
    public ResponseEntity<ResponseDTO> getAddressById(@PathVariable Integer id){
        AddressBook address = addressBookService.getAddressById(id);
        ResponseDTO responseDTO = new ResponseDTO("Address found by id: ", address);
        return new ResponseEntity<>(responseDTO, HttpStatus.FOUND);
    }

    @PutMapping("/addressbook/{id}")
    public ResponseEntity<ResponseDTO> updateAddress(@PathVariable Integer id, @Valid @RequestBody AddressBookDTO addressBookDTO){
        AddressBook address = addressBookService.updateAddress(id, addressBookDTO);
        ResponseDTO responseDTO = new ResponseDTO("AddressBook updated successfully", address);
        return new ResponseEntity<>(responseDTO, HttpStatus.OK);
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<ResponseDTO> deleteAddress(@PathVariable Integer id){
        addressBookService.deleteAddress(id);
        ResponseDTO responseDTO = new ResponseDTO("Address deleted successfully", id);
        return new ResponseEntity<>(responseDTO, HttpStatus.OK);
    }

    @GetMapping("/city/{city}")
    public ResponseEntity<ResponseDTO> getAddressByCity(@PathVariable String city){
        List<AddressBook> addressBooks = addressBookService.getAddressByCity(city);
        ResponseDTO responseDTO = new ResponseDTO("List of addresses: ", addressBooks);
        return new ResponseEntity<>(responseDTO, HttpStatus.OK);
    }

    @GetMapping("/state/{state}")
    public ResponseEntity<ResponseDTO> getAddressByState(@PathVariable String state){
        List<AddressBook> addressBooks = addressBookService.getAddressByState(state);
        ResponseDTO responseDTO = new ResponseDTO("List of addresses: ", addressBooks);
        return new ResponseEntity<>(responseDTO, HttpStatus.OK);
    }

    @GetMapping("/phone/{phoneNumber}")
    public ResponseEntity<ResponseDTO> getAddressByPhoneNumber(@PathVariable long phoneNumber){
        AddressBook addressBook = addressBookService.getAddressByPhoneNumber(phoneNumber);
        ResponseDTO responseDTO = new ResponseDTO("Address found with phone number: " , + phoneNumber);
        return new ResponseEntity<>(responseDTO, HttpStatus.OK);
    }

}
