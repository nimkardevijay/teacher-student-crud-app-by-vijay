package com.studentteacher.repository;

import java.util.List;
import java.util.Set;

import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import com.studentteacher.entity.Student;

@Repository
public interface StudentRepository extends CrudRepository<Student, Long> {
    
    List<Student> findByName(String name); 
   
    @Query( nativeQuery=true , value="SELECT * FROM STUDENT S JOIN TEACHER T  ON S.TID=T.TID   WHERE T.TName= ?")
    Set<Student> findByTName(String TName); 
    
}
