package com.studentteacher.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
//import org.springframework.data.repository.CrudRepository;
import org.springframework.data.jpa.repository.Query;

import com.studentteacher.entity.Student;
import com.studentteacher.entity.Teacher;

public interface TeacherRepository extends JpaRepository<Teacher, Long>{
	List<Teacher> findByTname(String tname);
	List<Teacher> findDistinctByTnameNotIn(List<String> names);
//	@Query( nativeQuery=true , value="SELECT * FROM TEACHER T JOIN STUDENT S  ON S.ID=T.TID   WHERE T.TName= ?1")
//    List<Student> findByTName(String TName); 
	
	
	
}
