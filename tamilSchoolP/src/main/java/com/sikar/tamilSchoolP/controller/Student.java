package com.sikar.tamilSchoolP.controller;

import lombok.Data;
import lombok.Getter;
import lombok.Setter;

import java.io.Serializable;

@Data
@Getter
@Setter
public class Student implements Serializable {
    Long id;
    String name;
    int age;
    String dept;
    int sem;
}
