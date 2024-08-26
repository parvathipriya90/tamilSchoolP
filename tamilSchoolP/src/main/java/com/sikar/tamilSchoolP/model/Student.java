package com.sikar.tamilSchoolP.model;
import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import lombok.*;

import java.io.Serializable;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Entity
@Table(name = "StudentTable")
public class Student implements Serializable {
    @Id
    private Long id;
    private String name;
    private int age;
    private String dept;
    private int sem;
}
