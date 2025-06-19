package com.hcl.AuthorDemo.service;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.hcl.AuthorDemo.dao.AuthorDao;
import com.hcl.AuthorDemo.dto.AuthorDto;
import com.hcl.AuthorDemo.entity.Author;
import com.hcl.AuthorDemo.form.LoginForm;

import ch.qos.logback.core.joran.util.beans.BeanUtil;
import lombok.AllArgsConstructor;

@Service
public class AuthorService {

	@Autowired
	private AuthorDao authorDao;

	public void saveAuthor(AuthorDto authorDto) {
		Author author = new Author();
		BeanUtils.copyProperties(authorDto, author);
		authorDao.saveAuthor(author);
	}

	public List<AuthorDto> getAllAuthors() {
		List<AuthorDto> authorDtos = new ArrayList<AuthorDto>();
		for (Author author : authorDao.getAllAuthors()) {
			AuthorDto authorDto = new AuthorDto();
			BeanUtils.copyProperties(author, authorDto);
			authorDtos.add(authorDto);
		}
		return authorDtos;
	}

	public boolean loginAuthor(LoginForm loginForm) {
		return authorDao.loginAuthor(loginForm);
	}
}
