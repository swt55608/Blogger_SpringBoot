package priv.liu.BloggerSpringBoot.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import priv.liu.BloggerSpringBoot.entity.Article;
import priv.liu.BloggerSpringBoot.entity.Author;
import priv.liu.BloggerSpringBoot.repository.ArticleRepository;
import priv.liu.BloggerSpringBoot.repository.AuthorRepository;

@RestController
public class EditArticleController {
	@Autowired
	ArticleRepository articleRepo;
	@Autowired
	AuthorRepository authorRepo;
	
	@PutMapping("/authors/{authorName}/articles/{articleTitle}")
	public void execute(@RequestBody Article newArticle, @PathVariable String articleTitle, @PathVariable String authorName) {
		if(isNullOrEmpty(newArticle) || isArticleTitleExistExceptItself(newArticle, articleTitle)) {
			System.out.println("edited failure");
		} else {
			Author author = authorRepo.findByAuthorName(authorName);
			Article toEditArticle = articleRepo.findByArticleTitleAndAuthorId(articleTitle, author.getId());
			if (toEditArticle != null) {
				toEditArticle.setTitle(newArticle.getTitle());
				if (newArticle.getContents() == null)
					toEditArticle.setContents("");
				else
					toEditArticle.setContents(newArticle.getContents());
				articleRepo.save(toEditArticle);
				System.out.println("edited success");	
			}
		}
	}
	
	private boolean isNullOrEmpty(Article newArticle) {
		return newArticle.getTitle() == null || newArticle.getTitle().isEmpty();
	}
	
	private boolean isArticleTitleExistExceptItself(Article newArticle, String oldArticleTitle) {
		return !(newArticle.getTitle().equals(oldArticleTitle)) && 
				articleRepo.findByArticleTitle(newArticle.getTitle()) != null;
	}
}
