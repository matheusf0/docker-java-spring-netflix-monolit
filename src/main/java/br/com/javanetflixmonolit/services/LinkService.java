package br.com.javanetflixmonolit.services;

import br.com.javanetflixmonolit.controller.dto.LinkDto;
import br.com.javanetflixmonolit.entity.Link;
import br.com.javanetflixmonolit.exceptions.NotFoundException;
import br.com.javanetflixmonolit.repository.LinkRepository;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
public class LinkService {

    @Autowired
    private LinkRepository linkRepository;

    public void save(LinkDto linkDto){
        Link link = new ModelMapper().map(linkDto, Link.class);
        System.out.println(link.toString());
        linkRepository.save(link);
    }

    public void delete(long id){
        try{
            linkRepository.deleteById(id);
        }catch (Exception e){
            throw new NotFoundException();
        }
    }

    private List<LinkDto> linkMapper(List<Link> all){
        return all.parallelStream()
                .map(l-> new ModelMapper()
                .map(l,LinkDto.class))
                .collect(Collectors.toList());
    }


    public List<LinkDto> findAll() {
        return linkMapper(linkRepository.findAll());
    }
}
