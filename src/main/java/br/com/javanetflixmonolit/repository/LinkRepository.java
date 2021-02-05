package br.com.javanetflixmonolit.repository;

import br.com.javanetflixmonolit.entity.Link;
import org.springframework.data.jpa.repository.JpaRepository;

public interface LinkRepository extends JpaRepository<Link, Long> {
}
