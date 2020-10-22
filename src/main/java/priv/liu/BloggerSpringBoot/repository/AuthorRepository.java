package priv.liu.BloggerSpringBoot.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import priv.liu.BloggerSpringBoot.entity.Author;

public interface AuthorRepository extends JpaRepository<Author, Integer> {
	public Author findByAccount(String account);
	public Author findByAuthorName(String authorName);
	@Query("FROM Author WHERE account=?1 AND password=?2")
	public Author findByAuthorAccountPassword(String account, String password);
}
