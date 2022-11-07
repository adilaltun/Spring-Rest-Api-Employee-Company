package com.works.models;

import lombok.Data;
import org.hibernate.validator.constraints.Length;

import javax.persistence.*;
import javax.validation.constraints.Email;
import javax.validation.constraints.NotBlank;
import java.util.List;

@Data
@Entity
public class Employee {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer employeeId;

    @NotBlank(message = "Employee name cannot be blank")
    @Length(min = 2 , max = 75 ,message = "Employee name must be minimum 2 and maximum 75 character")
    private String employeeName;

    @NotBlank(message = "Employee surname cannot be blank")
    @Length(min = 2 , max = 75 ,message = "Employee surname must be minimum 2 and maximum 75 character")
    private String employeeSurname;

    @Email(message = "This email format is not correct.")
    private String email;

    private String password;

    private Integer companyId;

}
