package com.bridgelabz.addressbook.repository;

import com.bridgelabz.addressbook.dto.AddressBookDTO;
import com.bridgelabz.addressbook.model.AddressBook;
import org.springframework.data.jpa.repository.JpaRepository;
import com.bridgelabz.addressbook.dto.AddressBookDTO;

import java.util.List;
import java.util.Optional;

public interface AddressBookRepository extends JpaRepository<AddressBook, Integer> {

    public List<AddressBook> findByCityIgnoreCase(String city);
    public List<AddressBook> findByStateIgnoreCase(String state);
    Optional<AddressBook> findByPhoneNumber(long phoneNumber);
}
