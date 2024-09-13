package com.sikar.tamilSchoolP.repos;

import com.sikar.tamilSchoolP.model.Enrollment;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface CourseEnrollmentRepository extends JpaRepository<Enrollment,Long> {
  //  @Modifying
    //@Query("update StudentTable st set st.name=?2 where st.id=?1")
    //HQA-> hibernet query language
    //void updateName(Long id,String firstname);

}
