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
    private String importedMaterials;
    private String salableMaterials;
    private String inventoryMaterials;
    private String damagedMaterials;
    private String startDay;
    private String endDay;

    public Supplies(Integer id, String code, String name, String importedMaterials, String salableMaterials, String inventoryMaterials, String damagedMaterials, String startDay, String endDay) {
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

    public Supplies() {
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

    public String getImportedMaterials() {
        return importedMaterials;
    }

    public void setImportedMaterials(String importedMaterials) {
        this.importedMaterials = importedMaterials;
    }

    public String getSalableMaterials() {
        return salableMaterials;
    }

    public void setSalableMaterials(String salableMaterials) {
        this.salableMaterials = salableMaterials;
    }

    public String getInventoryMaterials() {
        return inventoryMaterials;
    }

    public void setInventoryMaterials(String inventoryMaterials) {
        this.inventoryMaterials = inventoryMaterials;
    }

    public String getDamagedMaterials() {
        return damagedMaterials;
    }

    public void setDamagedMaterials(String damagedMaterials) {
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
