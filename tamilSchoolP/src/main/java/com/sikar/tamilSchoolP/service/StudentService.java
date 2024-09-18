package com.sikar.tamilSchoolP.service;

import com.sikar.tamilSchoolP.model.Enrollment;
import com.sikar.tamilSchoolP.model.Student;
import com.sikar.tamilSchoolP.repos.StudentRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.RequestEntity;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;
import org.springframework.web.reactive.function.client.WebClient;
import reactor.core.publisher.Mono;

import java.util.List;
import java.util.Optional;

@Service
public class StudentService {

    @Autowired
    StudentRepository studentRepository;

// @Autowired
    //CourseManagementFeignClient courseManagementFeignClient;

    @Autowired
    RestTemplate restTemplate;

    WebClient webClient= WebClient.builder().build();


    public void enrollCourse(Enrollment enrollment) {
        //   courseManagementFeignClient.enrollCourse(enrollment);
// Enrollment enrollment1= restTemplate
        //       .postForEntity("http://localhost:9090/enroll",enrollment,Enrollment.class)
        //     .getBody();
        ResponseEntity<Enrollment> enrollmentPacket= restTemplate
                .postForEntity("http://localhost:9090/enroll",enrollment,Enrollment.class);
        System.out.println("Enrollment packet received:" + enrollmentPacket.getBody());
        System.out.println("do some other work");


     //  Mono<Enrollment> enrollmentMono=webClient.post().uri("http://localhost:9090/enroll")
       //         .bodyValue(enrollment)
         //       .retrieve()
           //     .bodyToMono(Enrollment.class);
       //enrollmentMono.subscribe(System.out::println);
//
  //      System.out.println("do some other work");
    }

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
