package com.example.demo.service.impl;
import com.example.demo.entity.financial_statistics.Supplies;
import com.example.demo.repository.ISuppliesRepository;
import com.example.demo.service.ISuppliesService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;

@Service
public class SuppliesService implements ISuppliesService {
    @Autowired
    ISuppliesRepository suppliesRepository;
    @Override
    public Page<Supplies> findAll(Pageable pageable, String startDay, String endDay) {
        return suppliesRepository.searchSupplies(pageable,startDay,endDay);
    }

    @Override
    public Boolean checkDate(String startDay, String endDay) {
        SimpleDateFormat simpleDateFormat = new SimpleDateFormat("yyyy-MM-dd");
        try {
            Date start = simpleDateFormat.parse(startDay);
            Date end = simpleDateFormat.parse(endDay);

            if (start.after(end)){
                return true;
            }
        } catch (ParseException e) {
            e.printStackTrace();
            return false;
        }
        return false;
    }
}
