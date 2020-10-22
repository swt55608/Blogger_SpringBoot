package priv.liu.BloggerSpringBoot.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import priv.liu.BloggerSpringBoot.entity.Author;
import priv.liu.BloggerSpringBoot.repository.AuthorRepository;

@RestController
public class RegisterController {
	@Autowired
	AuthorRepository repo;
	
	@PostMapping("/register")
	public Author execute(@RequestBody Author author) {
		System.out.println(author.getAccount() + " " + author.getPassword() + " " + author.getAuthorName());
		if (isNullOrEmpty(author) || isRegistered(author)) {
			return null;
		} else {
			repo.save(author);
			return author;
		}
	}
	
	private boolean isNullOrEmpty(Author author) {
		String account = author.getAccount();
		String password = author.getPassword();
		String authorName = author.getAuthorName();
		return account == null || account.isEmpty() || 
				password == null || password.isEmpty() ||
				authorName == null || authorName.isEmpty();
	}
	
	private boolean isRegistered(Author author) {
		return repo.findByAccount(author.getAccount()) != null || repo.findByAuthorName(author.getAuthorName()) != null;
	}
}
