package com.codemyth.model;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Table;

@Entity
@Table(name= "Student")
public class Student {
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long studid;
	
	@Column(name="stud_name")
	private String stud_name;
	
	@Column(name="stud_age")
	private int stud_age;
	
	@Column(name="stud_city")
	private String stud_city;
	
	@Column(name="stud_email")
	private String stud_email;

	public Long getStudid() {
		return studid;
	}

	public void setStudid(Long studid) {
		this.studid = studid;
	}

	public String getStud_name() {
		return stud_name;
	}

	public void setStud_name(String stud_name) {
		this.stud_name = stud_name;
	}

	public int getStud_age() {
		return stud_age;
	}

	public void setStud_age(int stud_age) {
		this.stud_age = stud_age;
	}

	public String getStud_city() {
		return stud_city;
	}

	public void setStud_city(String stud_city) {
		this.stud_city = stud_city;
	}

	public String getStud_email() {
		return stud_email;
	}

	public void setStud_email(String stud_email) {
		this.stud_email = stud_email;
	}

	public Student(Long studid, String stud_name, int stud_age, String stud_city, String stud_email) {
		super();
		this.studid = studid;
		this.stud_name = stud_name;
		this.stud_age = stud_age;
		this.stud_city = stud_city;
		this.stud_email = stud_email;
	}
	public Student() {
		
	}
	

	@Override
	public String toString() {
		return "Student [studid=" + studid + ", stud_name=" + stud_name + ", stud_age=" + stud_age + ", stud_city="
				+ stud_city + ", stud_email=" + stud_email + "]";
	}
	
	
	
	
	
	
	
	

}
