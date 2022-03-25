package com.example.demo.repository;

import com.example.demo.entity.equipment.Equipment;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

@Repository
public interface IEquipmentRepository extends JpaRepository<Equipment,Integer> {


//    NghiaDM
    @Query(value = "select * from equipment where delete_flag = false ", nativeQuery = true)
    Page<Equipment> findAllEquipment(Pageable pageable);

}
