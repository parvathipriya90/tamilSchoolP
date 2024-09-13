package com.sikar.tamilSchoolP.service;

import com.sikar.tamilSchoolP.exceptions.EmployeeNotFoundException;
import com.sikar.tamilSchoolP.model.Employee;
import com.sikar.tamilSchoolP.repos.EmployeeRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class EmployeeService {

    @Autowired
    EmployeeRepository employeeRepo;

    public Employee add(Employee emp){
        return employeeRepo.save(emp);
    }
    public List<Employee> getAllData(){
        return employeeRepo.findAll();
    }

    public Employee getData(Long id) {
        if (employeeRepo.existsById(id)) {
            return employeeRepo.findById(id).get();
        } else {
            throw new EmployeeNotFoundException("Employee not found for the id" + id);
        }
    }
    public Employee updateData(Employee emp){

        // upsert -> insert or update
        return employeeRepo.save(emp);
    }

    public String deleteData(Long id){
        if(employeeRepo.existsById(id)) {
            employeeRepo.deleteById(id);
            return "Deleted Successufully for the id " + id;
        }else {
            throw new RuntimeException ("Employee not found for the id:" + id);
        }
    }

}
//package com.sikar.tamilSchoolP.service;
//
//import com.sikar.tamilSchoolP.model.Student;
//import com.sikar.tamilSchoolP.repos.EmployeeRepository;
//import com.sikar.tamilSchoolP.repos.StudentRepository;
//import org.springframework.beans.factory.annotation.Autowired;
//import org.springframework.stereotype.Service;
//
//import java.util.Optional;
//
//@Service
//
//public class EmployeeService {
//
//
//        EmployeeRepository employeeRepository;
//
//        @Autowired
//       EmployeeService(EmployeeRepository employeeRepository){
//            this.employeeRepository=employeeRepository;
//
//        }
//    public Employee getEmployee(Long id) {
//
//        Optional<Employee> employee = employeeRepository.findById(id);
//        if (employee.isPresent()) {
//            return employee.get();
//        }
//        return null;
//    }
//}
