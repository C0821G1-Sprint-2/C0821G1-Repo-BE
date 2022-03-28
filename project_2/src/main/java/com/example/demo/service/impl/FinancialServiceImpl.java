package com.example.demo.service.impl;

import com.example.demo.entity.financial_statistics.Financial;
import com.example.demo.repository.IFinancialRepository;
import com.example.demo.service.IFinancialService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

@Service
public class FinancialServiceImpl implements IFinancialService {
    @Autowired
    IFinancialRepository financialRepository;

    @Override
    public Page<Financial> findAll(Pageable pageable, String month, String year) {
        return financialRepository.search(pageable,month,year);
    }
}
