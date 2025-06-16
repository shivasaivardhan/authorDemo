package com.hcl.AuthorDemo.entity;

import java.sql.Date;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class Author {

	private String name;
	private int age;
	private String gender;
	private Date dob;
	private String contactNo;
	private String email;
	private String password;
}
