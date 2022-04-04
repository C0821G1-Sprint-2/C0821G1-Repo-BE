package com.example.demo.controller;

import com.example.demo.entity.financial_statistics.Financial;
import com.example.demo.entity.financial_statistics.Supplies;
import com.example.demo.service.ISuppliesService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.web.PageableDefault;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@CrossOrigin("http://localhost:4200")
@RequestMapping(value = "/supplies")
public class SuppliesController {
    @Autowired
    ISuppliesService suppliesService;

    // Lanh
    @GetMapping(value = "/search")
    public ResponseEntity<Page<Supplies>> findAll(@PageableDefault(value = 2) Pageable pageable,
                                                  @RequestParam(defaultValue = "") String startDay,
                                                  @RequestParam(defaultValue = "") String endDay
    ) {
        System.out.println("test");
        Page<Supplies> suppliesListSearch = suppliesService.findAll(pageable, startDay, endDay);
        System.out.println(suppliesListSearch);
        if (suppliesListSearch.isEmpty()) {
            return new ResponseEntity<>(HttpStatus.NO_CONTENT);
        }
        return new ResponseEntity<>(suppliesListSearch, HttpStatus.OK);
    }


}
