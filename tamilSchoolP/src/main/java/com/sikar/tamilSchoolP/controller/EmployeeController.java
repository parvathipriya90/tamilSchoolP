
package com.sikar.tamilSchoolP.controller;

import com.sikar.tamilSchoolP.service.EmployeeService;
import com.sikar.tamilSchoolP.model.Student;
import com.sikar.tamilSchoolP.repos.EmployeeRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import com.sikar.tamilSchoolP.model.Employee;

import java.util.List;
import java.util.Optional;

@RestController
public class EmployeeController {
    private  EmployeeService employeeService;

    @Autowired
   EmployeeController(EmployeeService employeeService) {
       this.employeeService=employeeService;
   }
   @PostMapping("/createEmployee")
    public Employee createEmployee(@RequestBody Employee emp) {
         return  employeeService.add(emp);
    }
    @GetMapping("/officeEmp/{id}")
    public Employee getEmployee(@PathVariable Long id)
    {
        return employeeService.getData(id);
    }

    @GetMapping("/officeEmp/id")
    public List<Employee> getAllEmployees()
    {
        return employeeService.getAllData();
    }

    @PutMapping("/officeEmp")
    public Employee updateValues(@RequestBody Employee emp)
    {
        return employeeService.updateData(emp);
    }

    @DeleteMapping("/officeEmp/{id}")
    public String deleteValues(@PathVariable Long id)
    {
        return employeeService.deleteData(id);
    }


}





























//package com.sikar.tamilSchoolP.controller;
//
//import com.sikar.tamilSchoolP.model.Employee;
//import com.sikar.tamilSchoolP.model.Student;
//import com.sikar.tamilSchoolP.repos.EmployeeRepository;
//import org.springframework.beans.factory.annotation.Autowired;
//import org.springframework.http.HttpStatus;
//import org.springframework.http.ResponseEntity;
//import org.springframework.web.bind.annotation.*;
//
//import java.util.Optional;
//
//@RestController
//public class EmployeeController {
//    @Autowired
//    EmployeeService  employeeService;
//
//
//    @PostMapping("/employee")
//    public String createEmployee(@RequestBody Employee employee){
//        EmployeeRepository.addData(employee);
//        return "employee created";
//    }
// //   @GetMapping("/officeEmp/{id}")
////    public List<Employee> getValues(@PathVariable Integer id) {
////        return employeeService.getData(id);
////    }
//    @GetMapping("/employee/{id}")
//    public List<Employee> getEmployee(@PathVariable Long id){
//        return employeeService.getEmployee(id);
//    }
//    @GetMapping("/employees")
//    ResponseEntity<Iterable<Employee>>  getEmployees(){
//        return ResponseEntity.status(200).body(employeeRepository.findAll());
//    }
//    @DeleteMapping("/student/{id}")
//    ResponseEntity<String> deleteStudent(@PathVariable Long Id) {
//        Optional<Employee> employee = employeeRepository.findById(id);
//        if (employee.isPresent()){
//            employeeRepository.deleteById(id);
//            return ResponseEntity.status(HttpStatus.OK)
//                    .body("employee removed:" + employee.get().getName());
//        }
//        return ResponseEntity.status(HttpStatus.NOT_FOUND).body("employee not found with that id:" + id);
//    }
//    @PutMapping("/employee")
//    ResponseEntity<Employee> putEmployee(@RequestBody Employee employee){
//        Optional<Employee> employeeFromDB=employeeRepository.findById(employee.getId());
//        if(employeeFromDB.isPresent()){
//            //un wrapping
//            Employee employee1  = employeeFromDB.get();
//            employee1.setName(employee.getName());
//            employeeRepository.save(employee1);
//            return ResponseEntity.ok(employee1);
//        }
//        return ResponseEntity.status(HttpStatus.NOT_FOUND).body(null);
//    }
//
//
//}
//
////@RestController
////public class EmployeeController {
////    @Autowired
////    EmployeeService employeeService;
////
////    @PostMapping("/createEmployee")
////    public String addValues(@RequestBody Employee emp) {
////        employeeService.addData(emp);
////        return "employee list added";
////    }
////    @GetMapping("/officeEmp/{id}")
////    public List<Employee> getValues(@PathVariable Integer id) {
////        return employeeService.getData(id);
////    }
////
////    @GetMapping("/officeEmp/id")
////    public Optional<Employee> getAllValues() {
////        return employeeService.getData(id);
////    }
////
////    @PutMapping("/officeEmp")
////    public Employee updateValues(@RequestBody Employee emp) {
////        return employeeService.updateData(emp);
////    }
////
////    @DeleteMapping("/officeEmp/{id}")
////    public string deleteValues(@PathVariable Integer id) {
////        return employeeService.deleteData(id);
////    }
////}
////
