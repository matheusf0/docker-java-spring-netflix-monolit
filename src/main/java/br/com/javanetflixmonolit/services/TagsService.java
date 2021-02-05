package br.com.javanetflixmonolit.services;

import br.com.javanetflixmonolit.controller.dto.TagsDto;
import br.com.javanetflixmonolit.entity.Tags;
import br.com.javanetflixmonolit.exceptions.NotFoundException;
import br.com.javanetflixmonolit.repository.TagsRepository;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
public class TagsService {

    @Autowired
    private TagsRepository tagsRepository;


    public void save(TagsDto tagsDto) {
        tagsRepository.save(new Tags(tagsDto.getId(), tagsDto.getName()));
    }

    private List<TagsDto> tagsMapper(List<Tags> all) {
        return all.parallelStream().map(t-> new ModelMapper().map(t,TagsDto.class))
                .collect(Collectors.toList());
    }

    public List<TagsDto> findAll() {
        return tagsMapper(tagsRepository.findAll());
    }

    public void delete(long id) {
        try{
            tagsRepository.deleteById(id);
        }catch (Exception e){
            throw new NotFoundException();
        }
    }
}
