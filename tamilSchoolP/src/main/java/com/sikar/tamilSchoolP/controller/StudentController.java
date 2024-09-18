package com.sikar.tamilSchoolP.controller;
import com.sikar.tamilSchoolP.model.Enrollment;
import com.sikar.tamilSchoolP.model.Student;
import com.sikar.tamilSchoolP.service.StudentService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
public class StudentController {
//path parameter-> to identify your resource
// query parameter ->filter your resource
////CRUD
////    List<Student> studentList = new ArrayList<>();

    @Autowired
    StudentService studentService;


    @PostMapping("/enroll")
    ResponseEntity<Void> enrollCourse(@RequestBody Enrollment enrollment) {
        studentService.enrollCourse(enrollment);
        return new ResponseEntity<>(HttpStatus.OK);
    }
    @PostMapping("/student")
    ResponseEntity<Student> createStudent(@RequestBody Student student) {
        return ResponseEntity.status(200).body(studentService.addStudent(student));
    }


    @GetMapping("/student/{id}")
    ResponseEntity<Student> getStudent(@PathVariable Long id) {
        return ResponseEntity.ok(studentService.getStudent(id));
    }

    @GetMapping("/students")
    ResponseEntity<Iterable<Student>> getStudents() {
        return ResponseEntity.status(200).body(studentService.getAllStudents());
    }

    @DeleteMapping("/student/{id}")
    ResponseEntity<String> deleteStudent(@PathVariable Long id) {
        if (studentService.deleteStudent(id)) {
            return ResponseEntity.status(HttpStatus.OK)
                    .body("student removed with id:" + id);
        } else {
            return ResponseEntity.status(HttpStatus.NOT_FOUND)
                    .body("student not found with that id:" + id);
        }
    }

    @PutMapping("/student")
    ResponseEntity<Student> putStudent(@RequestBody Student student) {
        Student updatedStudent = studentService.updateStudent(student.getId(), student);
        if ((updatedStudent != null)) {
            return ResponseEntity.ok(updatedStudent);
        } else {
            return ResponseEntity.status(HttpStatus.NOT_FOUND).body(null);
        }
    }
}

     //   @PutMapping("/student/{id}")
       // ResponseEntity<Student> updateStudent (@RequestBody Student student){
         //   Student updatedStudent = studentService.updateStudent(updatedStudent.getId());
           // if (updatedStudent != null) {
             //   return ResponseEntity.ok(updatedStudent);
            //} else {
              //  return ResponseEntity.status(HttpStatus.NOT_FOUND).body(null);
           // }

        //}

// for (int i=0;i<studentList.size();i++) {
//   Student student = studentList.get(i);
// if (student.getId() == id) {
//   studentList.remove(student);
// return ResponseEntity.status(200).body("student removed:" + student.getName());
//}
//  }

// for (int i=0;i<studentList.size();i++) {
//   Student studentFromDB = studentList.get(i);
// if (student.getId() == studentFromDB.getId()) {
//   studentList.set(i,student);
// return ResponseEntity.status(200).body("student updated:" + student.getName());
//}
//}
/*classDispatcherServlet{
//
//requestMapper
//
//requestMapper.set("/student",StudentController,getStudent,parameters)
//
//}
//*/
