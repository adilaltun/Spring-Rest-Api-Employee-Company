package com.works.controllers;

import com.works.models.Company;
import com.works.services.CompanyService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/company")
@RequiredArgsConstructor
public class CompanyController {

    final CompanyService companyService;

    @PostMapping("/save")
    public ResponseEntity save(@RequestBody Company company){
        return companyService.save(company);
    }

    @GetMapping("/list")
    public ResponseEntity list(){
        return companyService.list();
    }

    @DeleteMapping("/delete/{id}")
    public ResponseEntity delete(@PathVariable String id){
        return companyService.delete(id);
    }

    @PutMapping("/update")
    public ResponseEntity update(@RequestBody Company company){
        return companyService.update(company);
    }

}
