package com.studentteacher.entity;

import java.util.List;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.OneToOne;
import javax.persistence.Table;

@Entity
@Table(name="TEACHER")

public class Teacher {
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private Long tid;
	private String tname; 
//	@OneToOne
//	private Student student;
//	@OneToMany
//	private List<Student> student;
//	
//	public void setStudent(List<Student> student) {
//		this.student = student;
//	}
	
//	public Student getStudent() {
//		return student;
//	}
//	public void setStudent(Student student) {
//		this.student = student;
//	}
	public String getTname() {
		return tname;
	}
	public Long getTid() {
		return tid;
	}

	public void setTid(Long tid) {
		this.tid = tid;
	}

	public void setTname(String tname) {
		this.tname = tname;
	}
//	public List<Student> getStudent() {
//		return student;
//	}
	
	

}
