package com.works.controllers;

import com.works.models.Employee;
import com.works.services.EmployeeService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/employee")
@RequiredArgsConstructor
public class EmployeeController {
    final EmployeeService employeeService;

    @PostMapping("/save")
    public ResponseEntity save(@RequestBody Employee employee){
        return employeeService.save(employee);
    }

    @GetMapping("/list")
    public ResponseEntity list(){
        return employeeService.list();
    }

    @DeleteMapping("/delete/{id}")
    public ResponseEntity delete(@PathVariable String id){
        return employeeService.delete(id);
    }

    @PutMapping("/update")
    public ResponseEntity update(@RequestBody Employee employee){
        return employeeService.update(employee);
    }

}
