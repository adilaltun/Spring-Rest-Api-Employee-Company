package com.works.models;

import lombok.Data;
import org.hibernate.validator.constraints.Length;

import javax.persistence.*;
import javax.validation.constraints.NotBlank;
import java.util.List;

@Data
@Entity
public class Company {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer companyId;

    @NotBlank(message = "Company name cannot be blank")
    @Length(min = 2 , max = 75 ,message = "Company name must be minimum 2 and maximum 75 character")
    private String companyName;

}
