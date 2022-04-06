package com.example.demo.entity.financial_statistics;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

@Entity
public class Financial {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;
    private String year;
    private String month;
    private Double grossRevenue;
    private Double totalExpenditure;
    private Double revenue;
    private Double sell;
    private Double manufacture;
    private Double importGoods;
    private Double payCustomer;
    private Double cancel;

    public Financial() {
    }

    public Double getSell() {
        return sell;
    }

    public void setSell(Double sell) {
        this.sell = sell;
    }

    public Double getManufacture() {
        return manufacture;
    }

    public void setManufacture(Double manufacture) {
        this.manufacture = manufacture;
    }

    public Double getImportGoods() {
        return importGoods;
    }

    public void setImportGoods(Double importGoods) {
        this.importGoods = importGoods;
    }

    public Double getPayCustomer() {
        return payCustomer;
    }

    public void setPayCustomer(Double payCustomer) {
        this.payCustomer = payCustomer;
    }

    public Double getCancel() {
        return cancel;
    }

    public void setCancel(Double cancel) {
        this.cancel = cancel;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getYear() {
        return year;
    }

    public void setYear(String year) {
        this.year = year;
    }

    public String getMonth() {
        return month;
    }

    public void setMonth(String month) {
        this.month = month;
    }

    public Double getGrossRevenue() {
        return grossRevenue;
    }

    public void setGrossRevenue(Double grossRevenue) {
        this.grossRevenue = grossRevenue;
    }

    public Double getTotalExpenditure() {
        return totalExpenditure;
    }

    public void setTotalExpenditure(Double totalExpenditure) {
        this.totalExpenditure = totalExpenditure;
    }

    public Double getRevenue() {
        return revenue;
    }

    public void setRevenue(Double revenue) {
        this.revenue = revenue;
    }
}
