package com.sikar.tamilSchoolP.service;

import com.sikar.tamilSchoolP.model.Student;
import com.sikar.tamilSchoolP.repos.StudentRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class StudentService {

    @Autowired
    StudentRepository StudentRepo;

    public Student addStudent(Student emp) {
        return StudentRepo.save(emp);
    }

    public List<Student> getAllStudents() {
        return StudentRepo.findAll();
    }

    public Student getStudent(Long id) {
        if (StudentRepo.existsById(id)) {
            return StudentRepo.findById(id).get();
        }
        return null;
    }
        public Student updateStudent(Long id, Student student) {
        // upsert -> insert or update
        return StudentRepo.save(student);
    }

    public Boolean  deleteStudent(Long id) {
        if (StudentRepo.existsById(id)) {
            StudentRepo.deleteById(id);
            return true;
        } else {
            throw new RuntimeException("Student not found for the id " + id);
        }

    }
    }
//package com.sikar.tamilSchoolP.service;
//
//import com.sikar.tamilSchoolP.model.Student;
//import com.sikar.tamilSchoolP.repos.StudentRepository;
//import com.sikar.tamilSchoolP.repos.StudentRepository;
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
//        StudentRepository StudentRepository;
//
//        @Autowired
//       StudentService(StudentRepository StudentRepository){
//            this.StudentRepository=StudentRepository;
//
//        }
//    public Student getStudent(Long id) {
//
//        Optional<Student> Student = StudentRepository.findById(id);
//        if (Student.isPresent()) {
//            return Student.get();
//        }
//        return null;
//    }
//}
