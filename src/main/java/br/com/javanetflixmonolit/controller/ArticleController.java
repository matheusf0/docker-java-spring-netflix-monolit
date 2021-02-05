package br.com.javanetflixmonolit.controller;

import br.com.javanetflixmonolit.controller.dto.ArticleDto;
import br.com.javanetflixmonolit.services.ArticleService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/articles")
public class ArticleController {

    @Autowired
    private ArticleService articleService;

    @ResponseStatus(HttpStatus.CREATED)
    @PutMapping("/create")
    public void create(@RequestBody ArticleDto articleDto){
        articleService.save(articleDto);
    }

    @RequestMapping("/list")
    public ResponseEntity<List<ArticleDto>> list(){
        return ResponseEntity.ok(articleService.findAll());
    }

    @DeleteMapping("/delete/{id}")
    @ResponseStatus(HttpStatus.OK)
    public void delete(@PathVariable("id") long id){
        articleService.delete(id);
    }
}
