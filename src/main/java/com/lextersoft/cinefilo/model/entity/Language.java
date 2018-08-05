package com.lextersoft.cinefilo.model.entity;

import javax.persistence.*;

@Entity(name = "Language")
@Table(name = "IDIOMAS")
@NamedQueries(
        value = {
                @NamedQuery(name = "Language.getAll",
                        query = "select t from Language t"),
                @NamedQuery(name = "Language.getByName",
                        query = "select t from Language t where t.name like concat('%', :prm_name, '%')")
        }
)
public class Language {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "ID")
    Integer id;

    @Column(name = "NOMBRE", nullable = false)
    String name;

    public Language() {
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