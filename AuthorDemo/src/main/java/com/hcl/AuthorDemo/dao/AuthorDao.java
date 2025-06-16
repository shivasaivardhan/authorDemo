package com.hcl.AuthorDemo.dao;

import java.util.ArrayList;
import java.util.List;

import org.springframework.jdbc.core.namedparam.BeanPropertySqlParameterSource;
import org.springframework.jdbc.core.namedparam.NamedParameterJdbcTemplate;
import org.springframework.jdbc.core.namedparam.SqlParameterSource;
import org.springframework.stereotype.Repository;

import com.hcl.AuthorDemo.dto.AuthorDto;
import com.hcl.AuthorDemo.entity.Author;
import com.hcl.AuthorDemo.form.LoginForm;

import lombok.AllArgsConstructor;

@Repository
@AllArgsConstructor
public class AuthorDao {

	private final NamedParameterJdbcTemplate jdbcTemplate;

	private final String ADD_AUTHOR = "insert into author(name,age,gender,phoneNo,email,dob,password) values(:name,:age,:gender,:contactNo,:email,:dob,:password)";
	private final String ALL_AUTHORS = "select name,age,gender,phoneNo,email,dob,password from author";
	private final String LOGIN_AUTHOR = "select count(1) from author a where a.email=:email and a.password=:password";

	public void saveAuthor(Author author) {
		SqlParameterSource parameterSource = new BeanPropertySqlParameterSource(author);
		jdbcTemplate.update(ADD_AUTHOR, parameterSource);
	}

	public List<Author> getAllAuthors() {
		return jdbcTemplate.query(ALL_AUTHORS, (rs, n) -> {
			return Author.builder().name(rs.getString("name")).age(rs.getInt("age")).gender(rs.getString("gender"))
					.dob(rs.getDate("dob")).email(rs.getString("email")).contactNo(rs.getString("phoneno"))
					.password(rs.getString("password")).build();
		});

	}
	
	public boolean loginAuthor(LoginForm loginForm) {
		SqlParameterSource parameterSource = new BeanPropertySqlParameterSource(loginForm);
		Integer count= jdbcTemplate.queryForObject(LOGIN_AUTHOR, parameterSource, Integer.class);
		return count != null && count == 1;
	}
}
