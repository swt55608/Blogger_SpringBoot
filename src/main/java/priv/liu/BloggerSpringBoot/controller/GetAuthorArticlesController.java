package priv.liu.BloggerSpringBoot.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

import priv.liu.BloggerSpringBoot.repository.ArticleRepository;
import priv.liu.BloggerSpringBoot.repository.AuthorRepository;
import priv.liu.BloggerSpringBoot.entity.Article;
import priv.liu.BloggerSpringBoot.entity.Author;

@RestController
public class GetAuthorArticlesController {
	@Autowired
	ArticleRepository articleRepo;
	@Autowired
	AuthorRepository authorRepo;
	
	@GetMapping("/authors/{authorName}/articles")
	public List<Article> execute(@PathVariable String authorName) {
		Author author = authorRepo.findByAuthorName(authorName);
		return articleRepo.findAllByAuthor(author);
	}
}
