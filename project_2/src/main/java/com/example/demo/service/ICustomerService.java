package com.example.demo.service;

import com.example.demo.entity.customer.Customer;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.repository.query.Param;

import java.util.List;
import java.util.Optional;

public interface ICustomerService {
    Page<Customer> getAll(Pageable pageable);

    Optional<Customer> findById(Integer id);
    //    DuongNT - customer list
    List<Customer> getAll1();
//
//    Optional<Customer> findById(Integer id);
//
//    //    DuongNT - search by name, email, phone, identify number
    Page<Customer> findCustomerByNameAndEmailAndPhoneAndIdentify(Pageable pageable,
                                                                 String name,
                                                                 String email,
                                                                 String phone,
                                                                 String identify_number);
    void deleteCustomer(Integer id);

    Page<Customer> findAllCustomerByKeyword(String keyword, Pageable pageable);
    Iterable<Customer> findAll();

    void save(Customer customer);
}
