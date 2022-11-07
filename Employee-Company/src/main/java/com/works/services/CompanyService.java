package com.works.services;

import com.works.models.Company;
import com.works.repositories.CompanyRepository;
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
public class CompanyService {

    final CompanyRepository companyRepository;

    //Company Save
    public ResponseEntity save(Company company){
        Map<REnum,Object> hm = new LinkedHashMap<>();
            Company save = companyRepository.save(company);
            hm.put(REnum.status,true);
            hm.put(REnum.result,save);
            hm.put(REnum.message,"Company has been saved.");
        return new ResponseEntity(hm, HttpStatus.OK);
    }

    //Company List
    public ResponseEntity list (){
        Map<REnum,Object> hm = new LinkedHashMap<>();
        List<Company> allCompany = companyRepository.findAll();
        hm.put(REnum.status,true);
        hm.put(REnum.message,"All company are listed.");
        hm.put(REnum.result,allCompany);
        return new ResponseEntity(hm, HttpStatus.OK);
    }

    //Company Delete
    public ResponseEntity delete(String id){
        Map<REnum,Object> hm = new LinkedHashMap<>();
        try {
            int integerId=Integer.parseInt(id);
            Optional<Company> optionalCompany = companyRepository.findById(integerId);
            if (optionalCompany.isPresent()){
                companyRepository.deleteById(integerId);
                hm.put(REnum.status,true);
                hm.put(REnum.message,"Delete success");
            }else {
                hm.put(REnum.status,false);
                hm.put(REnum.message,"Delete fail");
                return new ResponseEntity(hm,HttpStatus.BAD_REQUEST);
            }
        }catch (Exception exception){
            hm.put(REnum.status,false);
            hm.put(REnum.error,exception.getMessage());
        }
        return new ResponseEntity(hm, HttpStatus.OK);
    }

    //Company Update
    public ResponseEntity update(Company company){
        Map<REnum,Object> hm = new LinkedHashMap<>();
        Optional<Company> optionalCompany = companyRepository.findById(company.getCompanyId());
        if (optionalCompany.isPresent()){
            Company company1 = companyRepository.saveAndFlush(company);
            hm.put(REnum.status,true);
            hm.put(REnum.message,"Update success");
            hm.put(REnum.result,company1);
        }else {
            hm.put(REnum.status,false);
            hm.put(REnum.message,"Update fail. Not found company with this id.");
            return new ResponseEntity(hm,HttpStatus.BAD_REQUEST);
        }
        return new ResponseEntity(hm, HttpStatus.OK);
    }
}
