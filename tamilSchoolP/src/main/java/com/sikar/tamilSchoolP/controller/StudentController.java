package com.sikar.tamilSchoolP.controller;

import com.sikar.tamilSchoolP.model.Student;
import com.sikar.tamilSchoolP.repos.StudentRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import java.util.Optional;


@RestController
public class StudentController{
//path parameter-> to identify your resource
// query parameter ->filter your resource
//CRUD
//    List<Student> studentList = new ArrayList<>();

    @Autowired
    StudentRepository studentRepository;
    @PostMapping("/student")
    String createStudent(@RequestBody Student student){
        studentRepository.save(student);
        return "student created";
}
   @GetMapping("/student/{id}")
   ResponseEntity<Student>  getStudent(@PathVariable Long id){
       Optional<Student> student= studentRepository.findById(id);
       return student.map(value -> ResponseEntity.status(HttpStatus.OK).body(value))
               .orElseGet(() -> ResponseEntity.status(HttpStatus.NOT_FOUND).body(null));
  //     for (int i=0;i<studentList.size();i++) {
    //       Student student = studentList.get(i);
      //     if (student.getId() == id) {
         //     return ResponseEntity.status(200).body(student);
          //}
      //}
   }
    @GetMapping("/students")
    ResponseEntity<Iterable<Student>>  getStudents(){
        return ResponseEntity.status(200).body(studentRepository.findAll());
            }
    @DeleteMapping("/student/{id}")
    ResponseEntity<String> deleteStudent(@PathVariable Long id) {
        Optional<Student> student = studentRepository.findById(id);
        if (student.isPresent()){
            studentRepository.deleteById(id);
        return ResponseEntity.status(HttpStatus.OK)
                .body("student removed:" + student.get().getName());
    }
    // for (int i=0;i<studentList.size();i++) {
         //   Student student = studentList.get(i);
           // if (student.getId() == id) {
             //   studentList.remove(student);
               // return ResponseEntity.status(200).body("student removed:" + student.getName());
            //}
      //  }
        return ResponseEntity.status(HttpStatus.NOT_FOUND).body("student not found with that id:" + id);
    }
    @PutMapping("/student")
    ResponseEntity<Student> putStudent(@RequestBody Student student){
        Optional<Student> studentFromDB=studentRepository.findById(student.getId());
        if(studentFromDB.isPresent()){
            //un wrapping
            Student student1  = studentFromDB.get();
            student1.setName(student.getName());
                studentRepository.save(student1);
                return ResponseEntity.ok(student1);
            }
       // for (int i=0;i<studentList.size();i++) {
         //   Student studentFromDB = studentList.get(i);
           // if (student.getId() == studentFromDB.getId()) {
             //   studentList.set(i,student);
               // return ResponseEntity.status(200).body("student updated:" + student.getName());
            //}
        //}
        return ResponseEntity.status(HttpStatus.NOT_FOUND).body(null);
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
