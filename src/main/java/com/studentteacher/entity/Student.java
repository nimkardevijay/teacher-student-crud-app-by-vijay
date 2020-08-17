package com.studentteacher.entity;


import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.OneToOne;
import javax.validation.constraints.NotBlank;

@Entity
public class Student {
     
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private long id;   
    
    @NotBlank(message = "Roll no is mandatory")
    @Column(name = "rollno")
    private String rollno;
    
    @NotBlank(message = "Name is mandatory")
    @Column(name = "name")
    private String name;  

	@NotBlank(message = "Email is mandatory")
    @Column(name = "email")
    private String email;

    @Column(name = "phone_no")
    private long phoneNo; 
    
    @OneToOne(cascade = {CascadeType.ALL})
    @JoinColumn(name = "tid")
    private Teacher teacher;
    
    public Teacher getTeacher() {
		return teacher;
	}

	public void setTeacher(Teacher teacher) {
		this.teacher = teacher;
	}

	public Student() {}

    public Student(String name, String email) {
        this.name = name;
        this.email = email;
    }

    public void setId(long id) {
        this.id = id;
    }
    
    public long getId() {
        return id;
    }
    
    public void setName(String name) {
        this.name = name;
    }
    
    public void setEmail(String email) {
        this.email = email;
    }

    public String getName() {
        return name;
    }
    
    
    public String getRollno() {
		return rollno;
	}

	public void setRollno(String rollno) {
		this.rollno = rollno;
	}

    public String getEmail() {
        return email;
    }

	public long getPhoneNo() {
		return phoneNo;
	}

	public void setPhoneNo(long phoneNo) {
		this.phoneNo = phoneNo;
	}
}