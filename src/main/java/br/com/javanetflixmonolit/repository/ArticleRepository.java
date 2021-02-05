package br.com.javanetflixmonolit.repository;

import br.com.javanetflixmonolit.entity.Article;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ArticleRepository extends JpaRepository<Article, Long> {
}
