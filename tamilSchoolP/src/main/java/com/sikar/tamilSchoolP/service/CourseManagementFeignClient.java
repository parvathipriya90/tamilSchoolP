package com.sikar.tamilSchoolP.service;

import com.sikar.tamilSchoolP.model.Enrollment;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;

@FeignClient(url="http://localhost:9090",name = "CourseManagement")
public interface CourseManagementFeignClient {
    @PostMapping("/enroll")
    ResponseEntity<Enrollment> enrollCourse(@RequestBody Enrollment enrollment);
}
