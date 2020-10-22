package priv.liu.BloggerSpringBoot.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import priv.liu.BloggerSpringBoot.entity.Article;
import priv.liu.BloggerSpringBoot.entity.Author;
import priv.liu.BloggerSpringBoot.repository.ArticleRepository;
import priv.liu.BloggerSpringBoot.repository.AuthorRepository;

@RestController
public class CreateArticleController {
	@Autowired
	private ArticleRepository articleRepo;
	@Autowired
	private AuthorRepository authorRepo;
	
	@PostMapping("/authors/{authorName}/articles")
	public Article execute(@RequestBody Article article, @PathVariable String authorName) {
		Article ret;
		if (isNullOrEmpty(article, authorName) || isExist(article)) {
			ret = null;
		} else {
			if (article.getContents() == null)
				article.setContents("");
			Author author = authorRepo.findByAuthorName(authorName);
			article.setAuthor(author);
			articleRepo.save(article);
			ret = article;	
		}
		return ret;
	}
	
	private boolean isNullOrEmpty(Article article, String authorName) {
		return article.getTitle() == null || article.getTitle().isEmpty() || 
				authorName == null || authorName.isEmpty();
	}
	
	private boolean isExist(Article article) {
		return articleRepo.findByArticleTitle(article.getTitle()) != null;
	}
}
