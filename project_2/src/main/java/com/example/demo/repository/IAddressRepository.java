package com.example.demo.repository;

import com.example.demo.entity.cart.Address;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface IAddressRepository extends JpaRepository<Address,Integer> {
}
