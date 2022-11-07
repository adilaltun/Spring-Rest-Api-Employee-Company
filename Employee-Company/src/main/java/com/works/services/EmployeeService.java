package com.works.services;

import com.works.models.Employee;
import com.works.models.JoinEmployeeCompany;
import com.works.repositories.EmployeeRepository;
import com.works.repositories.JoinEmployeeCompanyRepository;
import com.works.utils.REnum;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;
import java.util.Optional;

@Service
@RequiredArgsConstructor
public class EmployeeService {
    final EmployeeRepository employeeRepository;
    final JoinEmployeeCompanyRepository joinEmployeeCompanyRepository;
    //Employee Save
    public ResponseEntity save(Employee employee){
        Map<REnum,Object> hm = new LinkedHashMap<>();
        Optional<Employee> optionalEmployee = employeeRepository.findByEmailEqualsIgnoreCase(employee.getEmail());
        if (!optionalEmployee.isPresent()){
            Employee save = employeeRepository.save(employee);
            hm.put(REnum.status,true);
            hm.put(REnum.result,save);
            hm.put(REnum.message,"Employee saved");
        }else{
            hm.put(REnum.status,false);
            hm.put(REnum.message,"This email already valid");
        }

        return new ResponseEntity(hm, HttpStatus.OK);
    }

    //Employee List
    public ResponseEntity list(){
        Map<REnum,Object> hm = new LinkedHashMap<>();
        List<JoinEmployeeCompany> findAllEmployee = joinEmployeeCompanyRepository.getEmployee();
        hm.put(REnum.status,true);
        hm.put(REnum.message,"All employees are listed");
        hm.put(REnum.result,findAllEmployee);
        return new ResponseEntity(hm, HttpStatus.OK);
    }

    //Employee Delete
    public ResponseEntity delete(String id){
        Map<REnum,Object> hm = new LinkedHashMap<>();
        try {
            int integerId=Integer.parseInt(id);
            Optional<Employee> optionalEmployee = employeeRepository.findById(integerId);
            if (optionalEmployee.isPresent()){
                employeeRepository.deleteById(integerId);
                hm.put(REnum.status,true);
                hm.put(REnum.message,"Delete success");
            }else {
                hm.put(REnum.status,false);
                hm.put(REnum.message,"Delete fail");
                return new ResponseEntity(hm,HttpStatus.BAD_REQUEST);
            }
        }catch (Exception exception){
            hm.put(REnum.status,false);
            hm.put(REnum.message,exception.getMessage());
        }
        return new ResponseEntity(hm, HttpStatus.OK);
    }

    //Employee Update
    public ResponseEntity update(Employee employee){
        Map<REnum,Object> hm = new LinkedHashMap<>();
        Optional<Employee> optionalEmployee = employeeRepository.findById(employee.getEmployeeId());
        if (optionalEmployee.isPresent()){
            Employee employee1 = employeeRepository.saveAndFlush(employee);
            hm.put(REnum.status,true);
            hm.put(REnum.result,employee1);
            hm.put(REnum.message,"Update success");
        }else{
            hm.put(REnum.status,false);
            hm.put(REnum.message,"Update fail");
            return new ResponseEntity(hm,HttpStatus.BAD_REQUEST);
        }

        return new ResponseEntity(hm, HttpStatus.OK);
    }

}
