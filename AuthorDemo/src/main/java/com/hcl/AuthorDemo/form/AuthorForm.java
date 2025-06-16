package com.hcl.AuthorDemo.form;

import java.sql.Date;
import java.time.LocalDate;

import org.hibernate.validator.constraints.Length;
import org.hibernate.validator.constraints.NotEmpty;

import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.Max;
import jakarta.validation.constraints.Min;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Past;
import lombok.Data;

@Data
public class AuthorForm {

	@NotBlank
	private String name;
	@Max(value = 68)
	@Min(value = 18)	
	@NotNull
	private int age;
	@NotBlank
	private String gender;
	@Past
	private Date dob;
	@NotBlank
	@Length(min = 10,max = 10)
	private String contactNo;
	@Email
	@NotBlank
	private String email;
	@NotBlank
	@Length(min = 8)
	private String password;


}
