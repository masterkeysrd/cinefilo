package com.lextersoft.cinefilo.model.entity;

import javax.persistence.*;
import java.io.Serializable;

@Entity(name = "Room")
@Table(name = "SALAS")
@NamedQueries(
        value = {
                @NamedQuery(name = "Room.getAll", query = "select t from Room t"),
                @NamedQuery(name = "Room.getByName", query = "select t from Room t where t.name like concat('', :prm_name ,'')")
        }
)
public class Room  implements Serializable {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "ID")
    private Integer id;


    @Column(name = "NOMBRE")
    private String name;

    @ManyToOne
    @JoinColumn(name = "CINE_ID", referencedColumnName = "ID")
    private Cinema cinema;

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

    public Cinema getCinema() {
        return cinema;
    }

    public void setCinema(Cinema cinema) {
        this.cinema = cinema;
    }
}
