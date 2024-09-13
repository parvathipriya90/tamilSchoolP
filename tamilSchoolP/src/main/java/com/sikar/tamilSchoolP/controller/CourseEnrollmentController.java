package com.sikar.tamilSchoolP.controller;
import com.sikar.tamilSchoolP.model.Course;
import com.sikar.tamilSchoolP.model.Enrollment;
import com.sikar.tamilSchoolP.service.CourseEnrollmentService;
import com.sikar.tamilSchoolP.service.CourseManagementService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
public class CourseEnrollmentController {
    @Autowired
    CourseEnrollmentService courseEnrollmentService;

    @PostMapping("/enroll")
    ResponseEntity<Enrollment> enrollCourse(@RequestBody Enrollment enrollment) {
        return new ResponseEntity<>(courseEnrollmentService.enrollCourse(enrollment),HttpStatus.OK);
    }
}

