package com.works.repositories;

import com.works.models.Employee;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;

public interface EmployeeRepository extends JpaRepository<Employee, Integer> {

    //email kontrolü için.
    Optional<Employee> findByEmailEqualsIgnoreCase(String email);

}