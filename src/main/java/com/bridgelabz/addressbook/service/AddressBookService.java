package com.bridgelabz.addressbook.service;

import com.bridgelabz.addressbook.dto.AddressBookDTO;
import com.bridgelabz.addressbook.model.AddressBook;
import com.bridgelabz.addressbook.repository.AddressBookRepository;
import org.hibernate.sql.ast.tree.expression.Over;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class AddressBookService implements IAddressBookService {

    private static final Logger log = LoggerFactory.getLogger(AddressBookService.class);
    @Autowired
    private AddressBookRepository addressBookRepository;

    @Override
    public AddressBook createAddress(AddressBookDTO addressBookDTO){
        AddressBook newAddress = new AddressBook(addressBookDTO);
        log.debug("address data: {}", addressBookDTO);
        return addressBookRepository.save(newAddress);
    }

    @Override
    public List<AddressBook> getAllAddresses(){
        log.info("Fetching all addresses");
        return addressBookRepository.findAll();
    }

    @Override
    public AddressBook getAddressById(Integer id){
        log.info("Fetching address by Id: {}", id);
        return addressBookRepository.findById(id).orElseThrow(()-> new RuntimeException("Address not found with Id: " + id));
    }

    @Override
    public AddressBook updateAddress(Integer id, AddressBookDTO addressBookDTO){
        AddressBook existingAddress = addressBookRepository.findById(id).orElseThrow(()-> new RuntimeException("Address not found with Id: " + id));
        existingAddress.updateAddress(addressBookDTO);
        return addressBookRepository.save(existingAddress);
    }

    @Override
    public void deleteAddress(Integer id){
        log.info("Deleting address by Id: {}", id);
        addressBookRepository.deleteById(id);
    }

    @Override
    public List<AddressBook> getAddressByCity(String city){
        log.info("Fetching address by city: {}", city);
        return addressBookRepository.findByCityIgnoreCase(city);
    }

    @Override
    public List<AddressBook> getAddressByState(String state){
        log.info("Fetching address by state: {}", state);
        return addressBookRepository.findByStateIgnoreCase(state);
    }

    @Override
    public AddressBook getAddressByPhoneNumber(long phoneNumber){
       /* Optional<AddressBook> address = addressBookRepository.findAll().stream()
                .filter(a -> a.getPhoneNumber() == phoneNumber)
                .findFirst();

        return address.orElseThrow(() -> new RuntimeException("No address found with phone number: " + phoneNumber));
        */

        log.info("Fetching address by Phone Number: {}", phoneNumber);
        Optional<AddressBook> address = addressBookRepository.findByPhoneNumber(phoneNumber);
        return address.orElseThrow(() -> new RuntimeException("No address with this phone number: " + phoneNumber));
    }
}
