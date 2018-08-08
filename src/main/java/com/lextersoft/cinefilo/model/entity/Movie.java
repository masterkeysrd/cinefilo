package com.lextersoft.cinefilo.model.entity;

import javax.persistence.*;
import java.io.Serializable;
import java.util.Date;

@Entity(name = "Movie")
@Table(name = "PELICULAS")
@NamedQueries(
        value = {
                @NamedQuery(name = "Movie.getAll",
                        query = "select t from Movie t"),
                @NamedQuery(name = "Movie.getByTitle",
                        query = "select t from Movie t where t.name like concat('%', :prm_name, '%')"),
                @NamedQuery(name = "Movie.getPremieres",
                        query = "select t " +
                                "from Movie t " +
                                "where t.premiereDate > :prm_date"),
                @NamedQuery(name = "Movie.getBillboard",
                        query = "select distinct t " +
                                "from Movie t " +
                                "join Show s on (s.movie.id = t.id) " +
                                "where s.datefrom <= current_date " +
                                "and s.dateto >= current_date ")
        }
)
public class Movie implements Serializable {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "ID")
    private Integer id;

    @Column(name = "NOMBRE", nullable = false)
    private String name;

    @Column(name = "CALIFICACION", nullable = false)
    private float calification;

    @Column(name = "DIRECTOR", nullable = false)
    private String director;

    @Column(name = "FECHA_ESTRENO", nullable = false)
    @Temporal(TemporalType.DATE)
    private Date premiereDate;

    @Column(name = "ACTORES_PRINCIPALES", nullable = false)
    private String mainActors;

    @Column(name = "SINOPSIS", nullable = false)
    private String synopsis;

    @ManyToOne(optional = false)
    @JoinColumn(name = "GENERO_ID", referencedColumnName = "ID")
    private Genre genre;

    @ManyToOne(optional = false)
    @JoinColumn(name = "IDIOMA_ID", referencedColumnName = "ID")
    private Language language;

    @Column(name = "NOMBRE_IMAGEN")
    private String imageName;

    public Movie() {
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

    public float getCalification() {
        return calification;
    }

    public void setCalification(float calification) {
        this.calification = calification;
    }

    public String getDirector() {
        return director;
    }

    public void setDirector(String director) {
        this.director = director;
    }

    public Date getPremiereDate() {
        return premiereDate;
    }

    public void setPremiereDate(Date premiereDate) {
        this.premiereDate = premiereDate;
    }

    public String getMainActors() {
        return mainActors;
    }

    public void setMainActors(String mainActors) {
        this.mainActors = mainActors;
    }

    public String getSynopsis() {
        return synopsis;
    }

    public void setSynopsis(String synopsis) {
        this.synopsis = synopsis;
    }

    public Genre getGenre() {
        return genre;
    }

    public void setGenre(Genre genre) {
        this.genre = genre;
    }

    public Language getLanguage() {
        return language;
    }

    public void setLanguage(Language language) {
        this.language = language;
    }

    public String getImageName() {
        return imageName;
    }

    public void setImageName(String imageName) {
        this.imageName = imageName;
    }
}