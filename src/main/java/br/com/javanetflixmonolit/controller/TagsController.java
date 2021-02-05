package br.com.javanetflixmonolit.controller;

import br.com.javanetflixmonolit.controller.dto.TagsDto;
import br.com.javanetflixmonolit.services.TagsService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/tags")
public class TagsController {

    @Autowired
    private TagsService tagsService;

    @ResponseStatus(HttpStatus.CREATED)
    @PutMapping("/create")
    public void create(@RequestBody TagsDto tagsDto){
        tagsService.save(tagsDto);
    }

    @GetMapping("/list")
    public ResponseEntity<List<TagsDto>> list(){
        return ResponseEntity.ok(tagsService.findAll());
    }


    @DeleteMapping("/delete/{id}")
    @ResponseStatus(HttpStatus.OK)
    public void delete(@PathVariable("id") long id){
        tagsService.delete(id);
    }
}
