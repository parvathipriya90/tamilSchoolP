package com.sikar.tamilSchoolP.service;

import com.sikar.tamilSchoolP.model.Student;
import com.sikar.tamilSchoolP.repos.StudentRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class StudentService {

    @Autowired
    StudentRepository studentRepository;

    public Student addStudent(Student student) {
        return studentRepository.save(student);
    }

    public List<Student> getAllStudents() {
        return studentRepository.findAll();
    }

    public Student getStudent(Long id) {
        Optional<Student> student=studentRepository.findById(id);
        if(student.isPresent()){
            return student.get();
        }
        //if (studentRepository.existsById(id)) {
          //  return studentRepository.findById(id).get();
        //}
        return null;
    }
        public Student updateStudent(Long id, Student student) {
            Optional<Student> studentFromDB = studentRepository.findById(id);
            if (studentFromDB.isPresent()) {
                Student student1 = studentFromDB.get();
                student1.setName(student.getName());
                studentRepository.save(student1);

                // upsert -> insert or update
                return student1;
            } else {
                return null;
            }
        }
    public Boolean  deleteStudent(Long id) {
        Optional<Student> student=studentRepository.findById(id);
                if (student.isPresent()) {
            studentRepository.deleteById(id);
            return true;
        } else {
            throw new RuntimeException("Student not found for the id " + id);
        }

    }
    }
//package com.sikar.tamilSchoolP.service;
//
//import com.sikar.tamilSchoolP.model.Student;
//import com.sikar.tamilSchoolP.repos.studentRepositorysitory;
//import com.sikar.tamilSchoolP.repos.studentRepositorysitory;
//import org.springframework.beans.factory.annotation.Autowired;
//import org.springframework.stereotype.Service;
//
//import java.util.Optional;
//
//@Service
//
//public class StudentService {
//
//
//        studentRepositorysitory studentRepositorysitory;
//
//        @Autowired
//       StudentService(studentRepositorysitory studentRepositorysitory){
//            this.studentRepositorysitory=studentRepositorysitory;
//
//        }
//    public Student getStudent(Long id) {
//
//        Optional<Student> Student = studentRepositorysitory.findById(id);
//        if (Student.isPresent()) {
//            return Student.get();
//        }
//        return null;
//    }
//}
