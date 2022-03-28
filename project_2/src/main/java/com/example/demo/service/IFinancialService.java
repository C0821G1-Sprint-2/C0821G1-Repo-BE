package com.example.demo.service;

import com.example.demo.entity.financial_statistics.Financial;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

public interface IFinancialService {
Page<Financial> findAll(Pageable pageable,String month,String year);
}
