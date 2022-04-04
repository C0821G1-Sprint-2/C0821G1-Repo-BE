package com.example.demo.service;

import com.example.demo.entity.financial_statistics.Financial;
import com.example.demo.entity.financial_statistics.Supplies;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

import java.util.List;

public interface ISuppliesService {
    Page<Supplies> findAll(Pageable pageable, String startDay, String endDay);
    List<Supplies> getAll();
}
