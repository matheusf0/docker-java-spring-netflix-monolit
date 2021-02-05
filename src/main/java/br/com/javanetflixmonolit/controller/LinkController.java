package br.com.javanetflixmonolit.controller;

import br.com.javanetflixmonolit.controller.dto.LinkDto;
import br.com.javanetflixmonolit.services.LinkService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/link")
public class LinkController {

    @Autowired
    private LinkService linkService;

    @ResponseStatus(HttpStatus.CREATED)
    @PutMapping("/create")
    public void create(@RequestBody LinkDto linkDto){
        linkService.save(linkDto);
    }

    @DeleteMapping("/delete/{id}")
    @ResponseStatus(HttpStatus.OK)
    public void delete(@PathVariable("id") long id){
        linkService.delete(id);
    }

    @GetMapping("/list")
    public ResponseEntity<List<LinkDto>> list(){
        return ResponseEntity.ok(linkService.findAll());
    }
}

