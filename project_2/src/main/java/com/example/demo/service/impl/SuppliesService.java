package com.example.demo.service.impl;
import com.example.demo.entity.financial_statistics.Supplies;
import com.example.demo.repository.ISuppliesRepository;
import com.example.demo.service.ISuppliesService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class SuppliesService implements ISuppliesService {
    @Autowired
    ISuppliesRepository suppliesRepository;
    @Override
    public Page<Supplies> findAll(Pageable pageable, String startDay, String endDay) {
        return suppliesRepository.searchSupplies(pageable,startDay,endDay);
    }

    @Override
    public List<Supplies> getAll() {
        return suppliesRepository.findAll();
    }
}
