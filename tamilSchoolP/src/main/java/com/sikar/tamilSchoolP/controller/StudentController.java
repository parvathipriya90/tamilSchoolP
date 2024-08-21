package com.sikar.tamilSchoolP.controller;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.List;
import java.util.Objects;


@RestController
public class StudentController{
//path parameter-> to identify your resource
// query parameter ->filter your resource
//CRUD
    List<Student> studentList = new ArrayList<>();

    @PostMapping("/student")
    String createStudent(@RequestBody Student student){
        studentList.add(student);
    return "student created";
}
   @GetMapping("/student/{id}")
   ResponseEntity<Student>  getStudent(@PathVariable Long id){
      for (int i=0;i<studentList.size();i++) {
          Student student = studentList.get(i);
          if (student.id == id) {
              return ResponseEntity.status(200).body(student);
          }
      }
      return ResponseEntity.status(404).body(null);
   }
    @GetMapping("/students")
    ResponseEntity<List<Student>>  getStudents(){
        return ResponseEntity.status(200).body(studentList);
            }
    @DeleteMapping("/student/{id}")
    ResponseEntity<String> deleteStudent(@PathVariable Long id){
        for (int i=0;i<studentList.size();i++) {
            Student student = studentList.get(i);
            if (student.id == id) {
                studentList.remove(student);
                return ResponseEntity.status(200).body("student removed:" + student.getName());
            }
        }
        return ResponseEntity.status(404).body("student not found with that id:" + id);
    }
    @PutMapping("/student")
    ResponseEntity<String> putStudent(@RequestBody Student student){
        for (int i=0;i<studentList.size();i++) {
            Student studentFromDB = studentList.get(i);
            if (student.id == studentFromDB.id) {
                studentList.set(i,student);
                return ResponseEntity.status(200).body("student updated:" + student.getName());
            }
        }
        return ResponseEntity.status(404).body("student not found with that id to update:" + student.id);
    }


@GetMapping("/student")
    String getStudent(){
        return "priya";
}
}
/*classDispatcherServlet{

requestMapper

requestMapper.set("/student",StudentController,getStudent,parameters)

}
*/
