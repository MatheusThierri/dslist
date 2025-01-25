package com.devsuperior.dslist.projections;

public interface GameMinProjection {
    // Interface utilizada para declarar os atributos que estão sendo usados para a consulta no SQL que está na classe GameRepository;
    Long getId();
    String getTitle();
    Integer getGameYear();
    String getImgUrl();
    String getShortDescription();
    Integer getPosition();
}
