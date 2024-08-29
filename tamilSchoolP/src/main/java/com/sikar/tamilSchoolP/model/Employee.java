package com.sikar.tamilSchoolP.model;

import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Entity
@Table(name="Employee_Table")
public class Employee {
    @Id
    private Integer employeeId;
    private String name;
    private String address;
}
