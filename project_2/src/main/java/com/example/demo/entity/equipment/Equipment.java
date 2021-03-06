package com.example.demo.entity.equipment;

import com.example.demo.entity.cart.Cart;
import com.fasterxml.jackson.annotation.JsonBackReference;

import javax.persistence.*;
import java.util.List;

@Entity
public class Equipment {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;
    private String code;
    private String name;
    private String price;
    private String expired;
    private String status;
    private Boolean deleteFlag;
    private String image;

    @ManyToOne
//    @JoinColumn(name = "id", nullable = false)
    private EquipmentType equipmentType;

    @ManyToOne
    private Introduce introduce;

    @ManyToOne
    private TechnicalInformation technicalInformation;

    @ManyToOne
    private Description descriptions;

    @ManyToOne
    private Certifications certifications;


    @ManyToOne
//    @JoinColumn(name = "id", nullable = false)
    private Supplier supplier;

    @OneToMany(mappedBy = "equipment")
    @JsonBackReference
    private List<Cart> carts;

    public Equipment() {
    }

    public List<Cart> getCarts() {
        return carts;
    }

    public void setCarts(List<Cart> carts) {
        this.carts = carts;
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

    public String getPrice() {
        return price;
    }

    public void setPrice(String price) {
        this.price = price;
    }

    public String getExpired() {
        return expired;
    }

    public void setExpired(String expired) {
        this.expired = expired;
    }

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }

    public Boolean getDeleteFlag() {
        return deleteFlag;
    }

    public void setDeleteFlag(Boolean deleteFlag) {
        this.deleteFlag = deleteFlag;
    }

    public String getImage() {
        return image;
    }

    public void setImage(String image) {
        this.image = image;
    }

    public EquipmentType getEquipmentType() {
        return equipmentType;
    }

    public void setEquipmentType(EquipmentType equipmentType) {
        this.equipmentType = equipmentType;
    }

    public Supplier getSupplier() {
        return supplier;
    }

    public void setSupplier(Supplier supplier) {
        this.supplier = supplier;
    }

    public Introduce getIntroduce() {
        return introduce;
    }

    public void setIntroduce(Introduce introduce) {
        this.introduce = introduce;
    }

    public TechnicalInformation getTechnicalInformation() {
        return technicalInformation;
    }

    public void setTechnicalInformation(TechnicalInformation technicalInformation) {
        this.technicalInformation = technicalInformation;
    }

    public Description getDescriptions() {
        return descriptions;
    }

    public void setDescriptions(Description descriptions) {
        this.descriptions = descriptions;
    }

    public Certifications getCertifications() {
        return certifications;
    }

    public void setCertifications(Certifications certifications) {
        this.certifications = certifications;
    }
}
