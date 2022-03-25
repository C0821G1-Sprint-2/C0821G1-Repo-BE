package com.example.demo.repository;

import com.example.demo.entity.equipment.Equipment;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

@Repository
public interface IEquipmentRepository extends JpaRepository<Equipment,Integer> {


    @Transactional
    @Modifying
    @Query(value = "insert into equipment(code,`name`,equipment_type_id,price,expired,supplier_id,image) " +
            " values (?1,?2,?3,?4,?5,?6,?7)", nativeQuery = true)
    void saveEquipment(String code, String name, Integer equipmentTypeId, String price,
                      String expired,Integer supplierId,String image);

    @Transactional
    @Modifying
    @Query(value = "update equipment as e " +
            "set e.code =?1,e.name =?2,e.equipment_type_id =?3" +
            ",e.price =?4,e.expired =?5,e.supplier_id = ?6, e.image= ?7 " +
            " where e.id =?8", nativeQuery = true)
    void editEquipment(String code, String name, Integer equipmentTypeId, String price,
                       String expired,Integer supplierId,String image, Integer id);

}
