package com.lextersoft.cinefilo.model.entity;

import com.fasterxml.jackson.annotation.JsonFormat;

import javax.persistence.*;
import java.io.Serializable;
import java.math.BigDecimal;
import java.time.LocalTime;
import java.util.Date;

@Entity(name = "Show")
@Table(name = "FUNCIONES")
@NamedQueries(
        value = {
                @NamedQuery(name = "Show.getAll",
                        query = "select t from Show t"),
                @NamedQuery(name = "Show.getByRoom",
                        query = "select t from Show t where t.room.id = :prm_room"),
                @NamedQuery(name = "Show.getByMovie",
                        query = "select t from Show t " +
                                "where t.movie.id = :prm_movie"),
                @NamedQuery(name = "Show.getByMovieAndCinema",
                            query = "select s from Show s " +
                                    "where s.room.cinema.id = :prm_cinema " +
                                    "and s.movie.id = :prm_movie " +
                                    "and s.datefrom <= :prm_date " +
                                    "and s.dateto >= :prm_date"),
                @NamedQuery(name = "Show.getByRoomAndMovie",
                        query = "select t from Show t " +
                                "where t.room.id = :prm_room " +
                                "and t.movie.id = :prm_movie"),
                @NamedQuery(name = "Show.getByCinema",
                        query = "select t from Show t " +
                                "where t.room.cinema.id = :prm_cinema " +
                                "and t.datefrom >= current_date " +
                                "and t.dateto <= current_date ")
        }
)
public class Show implements Serializable {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "ID")

    private Integer id;

    @ManyToOne
    @JoinColumn(name = "SALA_ID", referencedColumnName = "ID")
    private Room room;

    @ManyToOne
    @JoinColumn(name = "PELICULA_ID", referencedColumnName = "ID")
    private Movie movie;

    @Column(name = "FECHA_DESDE", nullable = false)
    @Temporal(TemporalType.DATE)
    private Date datefrom;

    @Column(name = "FECHA_HASTA", nullable = false)
    @Temporal(TemporalType.DATE)
    private Date dateto;

    @Column(name = "HORA_INICIO")
    @JsonFormat(pattern = "k:mm")
    private LocalTime startHour;

    @Column(name = "COSTO")
    private BigDecimal cost;

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public Room getRoom() {
        return room;
    }

    public void setRoom(Room room) {
        this.room = room;
    }

    public Movie getMovie() {
        return movie;
    }

    public void setMovie(Movie movie) {
        this.movie = movie;
    }

    public Date getDatefrom() {
        return datefrom;
    }

    public void setDatefrom(Date datefrom) {
        this.datefrom = datefrom;
    }

    public Date getDateto() {
        return dateto;
    }

    public void setDateto(Date dateto) {
        this.dateto = dateto;
    }

    public LocalTime getStartHour() {
        return startHour;
    }

    public void setStartHour(LocalTime startHour) {
        this.startHour = startHour;
    }

    public BigDecimal getCost() {
        return cost;
    }

    public void setCost(BigDecimal cost) {
        this.cost = cost;
    }
}
