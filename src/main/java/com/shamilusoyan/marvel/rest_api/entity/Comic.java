package com.shamilusoyan.marvel.rest_api.entity;


import com.fasterxml.jackson.annotation.*;
import com.fasterxml.jackson.databind.jsonschema.JsonSerializableSchema;

import javax.persistence.*;
import java.util.ArrayList;
import java.util.List;
import java.util.Objects;

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

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public String getThumbnailURL() {
        return thumbnailURL;
    }

    public void setThumbnailURL(String thumbnailURL) {
        this.thumbnailURL = thumbnailURL;
    }

    public List<Character> getCharacters() {
        return characters;
    }

    public void setCharacters(List<Character> characters) {
        this.characters = characters;
    }

    @Override
    public String toString() {
        return "Comic{" +
                "id=" + id +
                ", title='" + title + '\'' +
                ", description='" + description + '\'' +
                ", thumbnailURL='" + thumbnailURL + '\'' +
                '}';
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof Comic)) return false;
        Comic comic = (Comic) o;
        return getTitle().equals(comic.getTitle()) &&
                getDescription().equals(comic.getDescription()) &&
                getThumbnailURL().equals(comic.getThumbnailURL());
    }

    @Override
    public int hashCode() {
        return Objects.hash(getTitle(), getDescription(), getThumbnailURL());
    }
}

