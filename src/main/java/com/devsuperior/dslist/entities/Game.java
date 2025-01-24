package com.devsuperior.dslist.entities;

import java.util.Objects;

import jakarta.persistence.*;

@Entity // Usado para configurar a classe java para que ela seja equivalente a tabela do BD e também faz com que o spring leia essa entidade sem precisar declarar
@Table(name = "tb_game") // Nome da tabela
public class Game {
    @Id // Configurando o ID para ser a chave primária do banco
    @GeneratedValue(strategy = GenerationType.IDENTITY) // Deixando o ID como autoincrement
    private Long id;
    private String title;

    @Column(name = "game_year") // Customizando o nome da coluna no banco
    private Integer year;
    private String genre;
    private String platforms;
    private Double score;
    private String imgUrl;

    @Column(columnDefinition = "TEXT")
    private String shortDescription; // OBS: O JPA reconhece o camelCase e na criação do banco troca por "_"

    @Column(columnDefinition = "TEXT") // Passando a coluna para TEXT, pois o JPA reconhece como VARCHAR(255) e não caberia o texto todo
    private String longDescription;

    public Game() {
    }

    public Game(Long id, String title, Integer year, String genre, String platforms, Double score, String shortDescription, String imgUrl, String longDescription) {
        this.id = id;
        this.title = title;
        this.year = year;
        this.genre = genre;
        this.shortDescription = shortDescription;
        this.platforms = platforms;
        this.score = score;
        this.imgUrl = imgUrl;
        this.longDescription = longDescription;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getImgUrl() {
        return imgUrl;
    }

    public void setImgUrl(String imgUrl) {
        this.imgUrl = imgUrl;
    }

    public Integer getYear() {
        return year;
    }

    public void setYear(Integer year) {
        this.year = year;
    }

    public String getGenre() {
        return genre;
    }

    public void setGenre(String genre) {
        this.genre = genre;
    }

    public String getPlatforms() {
        return platforms;
    }

    public void setPlatform(String platforms) {
        this.platforms = platforms;
    }

    public double getScore() {
        return score;
    }

    public void setScore(double score) {
        this.score = score;
    }

    public String getShortDescription() {
        return shortDescription;
    }

    public void setShortDescription(String shortDescription) {
        this.shortDescription = shortDescription;
    }

    public String getLongDescription() {
        return longDescription;
    }

    public void setLongDescription(String longDescription) {
        this.longDescription = longDescription;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Game game = (Game) o;
        return Objects.equals(id, game.id);
    }

    @Override
    public int hashCode() {
        return Objects.hashCode(id);
    }
}
