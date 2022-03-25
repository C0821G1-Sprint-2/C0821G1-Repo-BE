package com.example.demo.controller;

import com.example.demo.entity.financial_statistics.Financial;
import com.example.demo.service.impl.FinancialServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.web.PageableDefault;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@CrossOrigin("http://localhost:4200")
@RequestMapping(value = "/financial")
public class FinancialController {
    @Autowired
    FinancialServiceImpl financialService;

    // Tìm kiếm nhân viên
    @GetMapping(value = "/search")
    public ResponseEntity<Page<Financial>> findAll(@PageableDefault(value = 2) Pageable pageable,
                                                                                            @RequestParam(defaultValue = "") String month,
                                                                                            @RequestParam(defaultValue = "") String year
    ) {
        System.out.println("test");
        Page<Financial> financialsListSearch = financialService.findAll(pageable, month,
                year);
        System.out.println(financialsListSearch);
        if (financialsListSearch.isEmpty()) {
            return new ResponseEntity<>(HttpStatus.NO_CONTENT);
        }
        return new ResponseEntity<>(financialsListSearch, HttpStatus.OK);
    }
}
