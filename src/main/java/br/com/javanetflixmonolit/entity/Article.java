package br.com.javanetflixmonolit.entity;

import lombok.*;

import javax.persistence.*;
import java.util.List;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Entity
public class Article {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String name;

    @ManyToMany(cascade = {CascadeType.ALL})
    private List<Tags> tagsList;
    @OneToMany(cascade = {CascadeType.ALL})
    private List<Link> linkList;
}
