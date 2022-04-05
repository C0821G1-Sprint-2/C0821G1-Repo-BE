package com.example.demo.repository;
import com.example.demo.entity.equipment.Equipment;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;

import org.springframework.data.jpa.repository.Query;

import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;
import java.util.List;
import java.util.Optional;

@Repository
public interface IEquipmentRepository extends JpaRepository<Equipment, Integer> {


    //NghiaDM
    @Query(value = "select * from equipment where delete_flag = false ", nativeQuery = true)
    Page<Equipment> findAllEquipment(Pageable pageable);

    //NghiaDM
    @Query(value =" select * from equipment \n" +
            " where equipment.equipment_type_id = ?1 and equipment.delete_flag = 0 ", nativeQuery = true)
    Page<Equipment> findEquipment(Pageable pageable, Integer equipmentTypeID);

    @Transactional
    @Modifying
    @Query(value = "insert into equipment(code,`name`,equipment_type_id,price,expired,supplier_id,image, delete_flag) " +
            " values (?1,?2,?3,?4,?5,?6,?7,?8)", nativeQuery = true)
    void saveEquipment(String code, String name, Integer equipmentTypeId, String price,
                      String expired,Integer supplierId,String image, Boolean deleteFlag);

    @Transactional
    @Modifying
    @Query(value = "update equipment as e " +
            "set e.code =?1,e.name =?2,e.equipment_type_id =?3" +
            ",e.price =?4,e.expired =?5,e.supplier_id = ?6, e.image= ?7 " +
            " where e.id =?8", nativeQuery = true)
    void editEquipment(String code, String name, Integer equipmentTypeId, String price,
                       String expired,Integer supplierId,String image, Integer id);

    @Transactional
    @Modifying
    @Query(value = "select * from equipment " +
            " where code = ?1", nativeQuery = true)
    List<Equipment> selectCode(String code);

    // Anh Tây xóa vật tư
    @Transactional
    @Modifying
    @Query(value = "update equipment set delete_flag = 1 where id = ?", nativeQuery = true)
    void deleteEquipment(Integer id);

    //    @Transactional
//    @Modifying
    @Query(value = "SELECT * FROM equipment WHERE equipment.id = ? and equipment.delete_flag = 0 ", nativeQuery = true)
    Optional<Equipment> findEquipmentById(Integer id);

    @Query(value = " select * from equipment \n" +
            " where (equipment.code like %?1% or equipment.expired like %?1% or equipment.name like %?1% or equipment.price like %?1%) and equipment.delete_flag = false " +
            " order by equipment.id desc ", nativeQuery = true,
            countQuery = " select count(*) from equipment \n " +
                    " where (equipment.code like %?1% or equipment.expired like %?1% or equipment.name like %?1% or equipment.price like %?1%) and equipment.delete_flag = false " +
                    " order by equipment.id desc ")
    Page<Equipment> findAllContractByKeyword(String keyword, @Param("page") Pageable pageable);


}
