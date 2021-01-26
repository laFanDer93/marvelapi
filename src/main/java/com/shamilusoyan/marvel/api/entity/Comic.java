package com.shamilusoyan.marvel.api.entity;


import com.fasterxml.jackson.annotation.*;
import lombok.Data;

import javax.persistence.*;
import java.util.ArrayList;
import java.util.List;

@Data
@Entity
@Table(name = "comics")
@JsonIdentityInfo(generator = ObjectIdGenerators.PropertyGenerator.class,property = "id")
public class Comic {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column(name = "id")
    private int id;

    @Column(name = "title")
    private String title;

    @Column(name = "description")
    private String description;

    @Column(name = "thumbnail")
    private String thumbnailURL;

    @ManyToMany(cascade = {CascadeType.MERGE, CascadeType.PERSIST, CascadeType.REFRESH, CascadeType.DETACH})
    @JoinTable(
            name = "characters_comics",
            joinColumns = @JoinColumn(name = "comic_id"),
            inverseJoinColumns = @JoinColumn(name = "character_id")
    )
    List<Character> characters;

    public Comic() {
    }

    public Comic(String title, String description, String thumbnailURL) {
        this.title = title;
        this.description = description;
        this.thumbnailURL = thumbnailURL;
    }

    public void addCharacterToComic(Character character) {
        if (characters == null) {
            characters = new ArrayList<>();
        }
        characters.add(character);
    }

    public static boolean hasNullField(Comic comic) {
        if (comic.characters == null
                | comic.description == null
                | comic.thumbnailURL == null
                | comic.title == null) {
            return true;
        }
        return false;
    }

}