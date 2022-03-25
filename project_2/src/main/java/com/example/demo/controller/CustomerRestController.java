package com.example.demo.controller;

import com.example.demo.entity.customer.Customer;
import com.example.demo.service.impl.CustomerServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.web.PageableDefault;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.Optional;

@RestController
@CrossOrigin("http://localhost:4200")
@RequestMapping(value = "/customer")
public class CustomerRestController {
    @Autowired
    private CustomerServiceImpl customerService;

    /**
     * created by DuongNT
     * method getAllCustomer with pageable
     *
     * @param pageable
     * @return
     */
    @GetMapping(value = "list")
    public ResponseEntity<Page<Customer>> showListCustomer(@PageableDefault(value = 5) Pageable pageable) {
        Page<Customer> customers = this.customerService.getAll(pageable);
        if (customers.isEmpty()) {
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }
        return new ResponseEntity<>(customers, HttpStatus.OK);
    }
    //          DuongNT- detail customer
    @GetMapping(value = "{id}")
    public ResponseEntity<Customer> getDetailCustomer(@PathVariable Integer id) {
        Optional<Customer> customerObj = this.customerService.findById(id);
        if (!customerObj.isPresent()) {
            return new ResponseEntity<>(HttpStatus.BAD_REQUEST);
        }
        return new ResponseEntity<>((Customer) customerObj.get(), HttpStatus.OK);
    }

    //    DuongNT- delete customer
    @DeleteMapping(value = "delete/{id}")
    public ResponseEntity<Customer> deleteCustomer(@PathVariable("id") Integer id) {
        Optional<Customer> customerObj = this.customerService.findById(id);
        if (!customerObj.isPresent()) {
            return new ResponseEntity<>(HttpStatus.BAD_REQUEST);
        }
        this.customerService.deleteCustomer(id);
        return new ResponseEntity<>(HttpStatus.OK);
    }

    //   DuongNT - search by name, email, phone, identify number
    @GetMapping(value = "search")
    public ResponseEntity<Page<Customer>> searchCustomer(
            @PageableDefault(value = 5) Pageable pageable,
            @RequestParam(defaultValue = "") String customer_name,
            @RequestParam(defaultValue = "") String customer_email,
            @RequestParam(defaultValue = "") String customer_phone,
            @RequestParam(defaultValue = "") String customer_identify_number
    ) {
        Page<Customer> customersNewPage = customerService.findCustomerByNameAndEmailAndPhoneAndIdentify
                (pageable, customer_name, customer_email, customer_phone, customer_identify_number);

        if (customersNewPage.isEmpty()) {
            return new ResponseEntity<>(HttpStatus.NO_CONTENT);
        }
        return new ResponseEntity<>(customersNewPage, HttpStatus.OK);

    }
}