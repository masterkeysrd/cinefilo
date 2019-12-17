package com.lextersoft.cinefilo.domain;

import javax.persistence.*;

@Entity(name = "Genre")
@Table(name = "GENEROS")
public class Genre {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "ID")
    Integer id;

    @Column(name = "NOMBRE", nullable = false)
    String name;

    public Genre() {
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }
}
