package com.lextersoft.cinefilo.domain;

import javax.persistence.*;
import java.io.Serializable;

@Entity(name = "Cinema")
@Table(name = "CINES")
@NamedQueries(
        value = {
                @NamedQuery(name = "Ciname.getById",
                        query = "select t from Cinema t where t.id = :prm_id"),
                @NamedQuery(name = "Cinema.getAll",
                        query = "select t from Cinema t"),
                @NamedQuery(name = "Cinema.getByName",
                        query = "select t from Cinema t where t.name like concat('%', :prm_name, '%')"),
                @NamedQuery(name = "Cinema.getWithShows",
                        query = "select t " +
                                "from Cinema t " +
                                "join Room r on r.cinema.id = t.id " +
                                "join Show s on s.room.id = r.id " +
                                "where :prm_date between s.datefrom and s.dateto " +
                                "and s.movie.id = :prm_movie")
        }
)
public class Cinema implements Serializable {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "ID")
    private Integer id;

    @Column(name = "NOMBRE")
    private String name;

    @Column(name = "DIRECCION")
    private String address;

    @Column(name = "TELEFONO")
    private String phone;

    @Column(name = "DESCRIPCION")
    private String description;

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

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    public String getPhone() {
        return phone;
    }

    public void setPhone(String phone) {
        this.phone = phone;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }
}
