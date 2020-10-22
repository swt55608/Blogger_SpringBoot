package priv.liu.BloggerSpringBoot.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import priv.liu.BloggerSpringBoot.entity.Article;
import priv.liu.BloggerSpringBoot.entity.Author;

public interface ArticleRepository extends JpaRepository<Article, Integer> {
	public List<Article> findAllByAuthor(Author author);
	@Query("FROM Article WHERE title=?1")
	public Article findByArticleTitle(String articleTitle);
	@Query("FROM Article WHERE title=?1 AND author_id=?2")
	public Article findByArticleTitleAndAuthorId(String articleTitle, int author_id);
}
