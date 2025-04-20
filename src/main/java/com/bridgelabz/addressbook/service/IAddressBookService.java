package com.bridgelabz.addressbook.service;

import com.bridgelabz.addressbook.dto.AddressBookDTO;
import com.bridgelabz.addressbook.model.AddressBook;

import java.util.List;

public interface IAddressBookService {
    AddressBook createAddress(AddressBookDTO addressBookDTO);
    List<AddressBook> getAllAddresses();
    AddressBook getAddressById(Integer id);
    AddressBook updateAddress(Integer id, AddressBookDTO addressbookDTO);
    void deleteAddress(Integer id);
    List<AddressBook> getAddressByCity(String city);
    List<AddressBook> getAddressByState(String State);
    AddressBook getAddressByPhoneNumber(long phoneNumber);
}
