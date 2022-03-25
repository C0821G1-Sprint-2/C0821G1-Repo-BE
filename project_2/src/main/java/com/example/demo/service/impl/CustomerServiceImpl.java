package com.example.demo.service.impl;

import com.example.demo.entity.customer.Customer;
import com.example.demo.repository.ICustomerRepository;
import com.example.demo.service.ICustomerService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;


@Service
public class CustomerServiceImpl implements ICustomerService {
    @Autowired
    private ICustomerRepository customerRepository;

    @Override
    public Page<Customer> getAll(Pageable pageable) {
//        return customerRepository.findAll(pageable);
        return customerRepository.findAllCustomer(pageable);
    }

    @Override
    public List<Customer> getAll1() {
        return this.customerRepository.findAll();
    }

    @Override
    public Optional<Customer> findById(Integer id) {
        return customerRepository.findById(id);
    }

    //    DuongNT - search by name, email, phone, identify number
    @Override
    public Page<Customer> findCustomerByNameAndEmailAndPhoneAndIdentify(Pageable pageable,
                                                                        String customer_name,
                                                                        String customer_email,
                                                                        String customer_phone,
                                                                        String customer_identify_number) {
        return customerRepository.getByCustomerNameAndCustomerEmailAndCustomerPhoneAndCustomerIdentifyNumber
                (pageable, customer_name, customer_email, customer_phone, customer_identify_number);
    }

    //    DuongNT - delete customer
    @Override
    public void deleteCustomer(Integer id) {
        customerRepository.deleteCustomer(id);
    }

    //    DuongNT - customer list


}
