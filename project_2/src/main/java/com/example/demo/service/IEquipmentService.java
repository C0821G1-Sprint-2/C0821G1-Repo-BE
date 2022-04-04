package com.example.demo.service;
import com.example.demo.entity.equipment.Equipment;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

import java.util.Date;
import java.util.List;
import java.util.Optional;


public interface IEquipmentService {

    void addEquipment(Equipment equipment);
    void editEquipment(Equipment equipment);
    Equipment findById(Integer id);
    Optional<Equipment> findEquipmentById(Integer id);
    Page<Equipment> findAllEquipmentByKeyword(String keyword , Pageable pageable);
    void deleteEquipment(Integer id);
    List<Equipment> findList();
    boolean checkCode(String code);
    boolean checkDate(String expired);
    public static void chec(){

    };

}
