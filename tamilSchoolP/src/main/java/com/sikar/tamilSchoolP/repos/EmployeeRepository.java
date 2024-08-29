package com.sikar.tamilSchoolP.repos;

import com.sikar.tamilSchoolP.model.Employee;
import org.springframework.data.jpa.repository.JpaRepository;

public interface EmployeeRepository extends JpaRepository<Employee,Integer> {

}
