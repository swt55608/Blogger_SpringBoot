package priv.liu.BloggerSpringBoot.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

import priv.liu.BloggerSpringBoot.entity.Article;
import priv.liu.BloggerSpringBoot.entity.Author;
import priv.liu.BloggerSpringBoot.repository.ArticleRepository;
import priv.liu.BloggerSpringBoot.repository.AuthorRepository;

@RestController
public class DeleteArticleController {
	@Autowired
	ArticleRepository articleRepo;
	@Autowired
	AuthorRepository authorRepo;
	
	@DeleteMapping("/authors/{authorName}/articles/{articleTitle}")
	public void execute(@PathVariable String articleTitle, @PathVariable String authorName) {
		Author author = authorRepo.findByAuthorName(authorName);
		Article article = articleRepo.findByArticleTitleAndAuthorId(articleTitle, author.getId());
		if (article != null) {
			articleRepo.delete(article);
			System.out.println("deleted");
		} else {
			System.out.println("Deletion Denied1! There's no such article.");
		}
	}
}
