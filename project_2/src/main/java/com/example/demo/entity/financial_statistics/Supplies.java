package com.example.demo.entity.financial_statistics;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

@Entity
public class Supplies {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;
    private String code;
    private String name;
    private Integer importedMaterials;
    private Integer salableMaterials;
    private Integer inventoryMaterials;
    private Integer damagedMaterials;
    private String startDay;
    private String endDay;

    public Supplies() {
    }

    public Supplies(Integer id, String code, String name, Integer importedMaterials, Integer salableMaterials,
                    Integer inventoryMaterials, Integer damagedMaterials, String startDay, String endDay) {
        this.id = id;
        this.code = code;
        this.name = name;
        this.importedMaterials = importedMaterials;
        this.salableMaterials = salableMaterials;
        this.inventoryMaterials = inventoryMaterials;
        this.damagedMaterials = damagedMaterials;
        this.startDay = startDay;
        this.endDay = endDay;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getCode() {
        return code;
    }

    public void setCode(String code) {
        this.code = code;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Integer getImportedMaterials() {
        return importedMaterials;
    }

    public void setImportedMaterials(Integer importedMaterials) {
        this.importedMaterials = importedMaterials;
    }

    public Integer getSalableMaterials() {
        return salableMaterials;
    }

    public void setSalableMaterials(Integer salableMaterials) {
        this.salableMaterials = salableMaterials;
    }

    public Integer getInventoryMaterials() {
        return inventoryMaterials;
    }

    public void setInventoryMaterials(Integer inventoryMaterials) {
        this.inventoryMaterials = inventoryMaterials;
    }

    public Integer getDamagedMaterials() {
        return damagedMaterials;
    }

    public void setDamagedMaterials(Integer damagedMaterials) {
        this.damagedMaterials = damagedMaterials;
    }

    public String getStartDay() {
        return startDay;
    }

    public void setStartDay(String startDay) {
        this.startDay = startDay;
    }

    public String getEndDay() {
        return endDay;
    }

    public void setEndDay(String endDay) {
        this.endDay = endDay;
    }
}
