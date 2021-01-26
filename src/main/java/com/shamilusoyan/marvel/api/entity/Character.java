package com.shamilusoyan.marvel.api.entity;


import com.fasterxml.jackson.annotation.*;
import lombok.Data;

import javax.persistence.*;
import java.util.ArrayList;
import java.util.List;

@Data
@Entity
@Table(name = "characters")
@JsonIdentityInfo(generator = ObjectIdGenerators.PropertyGenerator.class,property = "id")
public class Character {


    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column(name = "id")
    private int id;

    @Column(name = "name")
    private String name;

    @Column(name = "description")
    private String description;

    @Column(name = "thumbnail")
    private String thumbnailURL;

    @ManyToMany(cascade = {CascadeType.MERGE, CascadeType.PERSIST, CascadeType.REFRESH, CascadeType.DETACH})
    @JoinTable(
            name = "characters_comics",
            joinColumns = @JoinColumn(name = "character_id"),
            inverseJoinColumns = @JoinColumn(name = "comic_id")
    )
    List<Comic> comics;

    public Character() {
    }

    public Character(String name, String description, String thumbnailURL) {
        this.name = name;
        this.description = description;
        this.thumbnailURL = thumbnailURL;
    }

    public void addComicToCharacter(Comic comic) {
        if (comics == null) {
            comics = new ArrayList<>();
        }
        comics.add(comic);
    }


    public static boolean hasNullField(Character characters) {
        if (characters.description == null
                | characters.name == null
                | characters.thumbnailURL == null) {
            return true;
        }
        return false;
    }
    }