package com.sikar.tamilSchoolP.service;

import com.sikar.tamilSchoolP.exceptions.CourseNotFoundException;
import com.sikar.tamilSchoolP.model.Course;
import com.sikar.tamilSchoolP.model.Enrollment;
import com.sikar.tamilSchoolP.repos.CourseEnrollmentRepository;
import com.sikar.tamilSchoolP.repos.CourseManagementRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
public class CourseEnrollmentService {

    @Autowired
    CourseEnrollmentRepository courseEnrollmentRepository;

    public Enrollment enrollCourse(Enrollment enrollment)
    {
        return courseEnrollmentRepository.save(enrollment);
    }
  //  public List<Enrollment> getCourseEnrollments(Long studentId){
    //    Optional<Course> course=courseEnrollmentRepository.findById(id);

      //  if(course.isPresent())
        //{
          //  return course.get();
        //}
        //throw new CourseNotFoundException("course not found for the id " + id);
    //}
}
