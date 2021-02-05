package br.com.javanetflixmonolit.repository;

import br.com.javanetflixmonolit.entity.Tags;
import org.springframework.data.jpa.repository.JpaRepository;

public interface TagsRepository extends JpaRepository<Tags, Long> {
}
