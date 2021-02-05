package br.com.javanetflixmonolit.services;

import br.com.javanetflixmonolit.controller.dto.ArticleDto;
import br.com.javanetflixmonolit.entity.Article;
import br.com.javanetflixmonolit.exceptions.NotFoundException;
import br.com.javanetflixmonolit.repository.ArticleRepository;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;


import java.util.List;
import java.util.stream.Collectors;

@Service
public class ArticleService {

    @Autowired
    private ArticleRepository articleRepository;

    public void save(ArticleDto articleDto) {
        Article article = new ModelMapper().map(articleDto, Article.class);
        articleRepository.save(article);
    }

    public List<ArticleDto> findAll() {
        return  articleMapper(articleRepository.findAll());
    }

    private List<ArticleDto> articleMapper(List<Article> all) {
        return all.parallelStream().map(a-> new ModelMapper().map(a,ArticleDto.class)).collect(Collectors.toList());
    }

    public void delete(long id){
        try{
            articleRepository.deleteById(id);
        }catch (Exception e){
            throw new NotFoundException();
        }
    }

}
