package com.example.demo.entity.financial_statistics;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

@Entity
public class FinancialStatistics {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;
    private String year;
    private String month;
    private String activity;
    private Double value;
    private Double grossRevenue;
    private Double totalExpenditure;
    private Double revenue;

    public FinancialStatistics() {
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

    public String getActivity() {
        return activity;
    }

    public void setActivity(String activity) {
        this.activity = activity;
    }

    public Double getValue() {
        return value;
    }

    public void setValue(Double value) {
        this.value = value;
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
