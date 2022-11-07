package com.works.models;

import lombok.Data;

import javax.persistence.Entity;
import javax.persistence.Id;

@Data
@Entity
public class JoinEmployeeCompany {

    @Id
    private Integer employeeId;
    private Integer companyId;

    private String employeeName;
    private String employeeSurname;
    private String email;
    private String companyName;

}
