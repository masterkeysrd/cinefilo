package com.lextersoft.cinefilo.model.entity;

import javax.persistence.*;

@Entity(name = "Genre")
@Table(name = "GENEROS")
@NamedQueries(
        {
                @NamedQuery(name = "Genre.getById",
                        query = "select t from Genre t where t.id = :prm_id"),
                @NamedQuery(name = "Genre.getAll",
                        query = "select t from Genre t"),
                @NamedQuery(name = "Genre.getByName",
                        query = "select t from Genre t where t.name like concat('%', :prm_name, '%')")
        }
)
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
