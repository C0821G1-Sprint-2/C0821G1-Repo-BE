package com.example.demo.controller;

import com.example.demo.entity.financial_statistics.Financial;
import com.example.demo.service.impl.FinancialServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
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

    // Lanh
    @GetMapping(value = "/search")
    public ResponseEntity<Page<Financial>> findAll(
            @RequestParam(defaultValue = "0") int page,
            @RequestParam(defaultValue = "") String month,
            @RequestParam(defaultValue = "") String year
    ) {
        Pageable pageable = PageRequest.of(page, 10);
        System.out.println("test");
        Page<Financial> financialsListSearch = financialService.findAll(pageable, month,
                year);
        System.out.println(financialsListSearch);
        if (financialsListSearch.isEmpty()) {
            return new ResponseEntity<>(HttpStatus.BAD_REQUEST);
        }
        return new ResponseEntity<>(financialsListSearch, HttpStatus.OK);

    }
}
