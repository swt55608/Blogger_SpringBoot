package priv.liu.BloggerSpringBoot.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import priv.liu.BloggerSpringBoot.entity.Author;
import priv.liu.BloggerSpringBoot.repository.AuthorRepository;

@RestController
public class LoginController {
	@Autowired
	AuthorRepository repo;
	
	@PostMapping("/login")
	public Author execute(@RequestBody Author author) {
		return repo.findByAuthorAccountPassword(author.getAccount(), author.getPassword());
	}
}
