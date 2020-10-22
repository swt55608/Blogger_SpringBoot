package priv.liu.BloggerSpringBoot.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import priv.liu.BloggerSpringBoot.entity.Article;
import priv.liu.BloggerSpringBoot.repository.ArticleRepository;

@RestController
public class GetAllArticlesController {
	@Autowired
	ArticleRepository repo;
	
	@GetMapping("/articles")
	public List<Article> execute() {
		return repo.findAll();
	}
}
