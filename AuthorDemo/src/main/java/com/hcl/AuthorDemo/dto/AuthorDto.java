package com.hcl.AuthorDemo.dto;

import java.sql.Date;
import java.time.LocalDate;

import lombok.Data;

@Data
public class AuthorDto {
	private String name;
	private int age;
	private String gender;
	private Date dob;
	private String contactNo;
	private String email;	
	private String password;
}
