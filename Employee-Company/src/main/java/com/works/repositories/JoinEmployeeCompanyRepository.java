package com.works.repositories;

import com.works.models.JoinEmployeeCompany;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import java.util.List;

public interface JoinEmployeeCompanyRepository extends JpaRepository<JoinEmployeeCompany, Integer> {

    @Query(value = "SELECT e.employee_id,e.employee_name,e.employee_surname,e.email," +
            "c.company_id,c.company_name " +
            "FROM employee as e INNER JOIN company as c ON e.company_id=c.company_id",
            nativeQuery = true)
    List<JoinEmployeeCompany> getEmployee();
}