package com.example.demo.controller;
import com.example.demo.entity.financial_statistics.Supplies;
import com.example.demo.service.ISuppliesService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@CrossOrigin("http://localhost:4200")
@RequestMapping(value = "/supplies")
public class SuppliesController {
    @Autowired
    ISuppliesService suppliesService;

    // Lanh
    @GetMapping(value = "/search")
    public ResponseEntity<Page<Supplies>> findAll( @RequestParam(defaultValue = "0") int page,
                                                   @RequestParam(defaultValue = "") String startDay,
                                                   @RequestParam(defaultValue = "") String endDay
    ) {
        Pageable pageable = PageRequest.of(page, 5);
        System.out.println("test" + startDay+ " =====> " + endDay);
        Page<Supplies> suppliesListSearch = suppliesService.findAll(pageable, startDay, endDay);
        System.out.println(suppliesListSearch);
        if (suppliesListSearch.isEmpty()) {
            return new ResponseEntity<>(HttpStatus.BAD_REQUEST);
        }
        return new ResponseEntity<>(suppliesListSearch, HttpStatus.OK);
    }

    @GetMapping(value= "/check")
    public ResponseEntity<Boolean> findAll(@RequestParam(defaultValue = "") String startDay,
                                                  @RequestParam(defaultValue = "") String endDay
    ) {
        Boolean check = this.suppliesService.checkDate(startDay,endDay);
        return new ResponseEntity<>(check, HttpStatus.OK);
    }
}
