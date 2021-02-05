package br.com.javanetflixmonolit.controller.dto;

import br.com.javanetflixmonolit.entity.Link;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.util.List;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class ArticleDto {
    private Long id;
    private String name;
    private List<TagsDto> tagsDtoList;
    private List<Link> linkList;
}
