package com.example.demo.entityDao;

import javax.persistence.*;
import java.time.LocalDate;
import java.util.Objects;
import static javax.persistence.GenerationType.SEQUENCE;


@Entity
@Table(name = "TEAMS")
public class Team {
    @Id
    @GeneratedValue(strategy = SEQUENCE, generator = "teams_sequence_generator")
    @SequenceGenerator(name = "teams_sequence_generator", sequenceName = "TEAMS_SEQUENCE", allocationSize = 1)
    private Long id;
    @Column(name = "NAME")
    private String name;
    @Column(name = "TROPHIES")
    private Integer trophies;
    @Column(name = "FOUNDED_DATE")
    private LocalDate foundedDate;

    public Team() {
    }

    public Team(Long id, String name, Integer trophies, LocalDate foundedDate) {
        this.id = id;
        this.name = name;
        this.trophies = trophies;
        this.foundedDate = foundedDate;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Integer getTrophies() {
        return trophies;
    }

    public void setTrophies(Integer trophies) {
        this.trophies = trophies;
    }

    public LocalDate getFoundedDate() {
        return foundedDate;
    }

    public void setFoundedDate(LocalDate foundedDate) {
        this.foundedDate = foundedDate;
    }

    @Override
    public int hashCode() {
        return Objects.hash(id, name, trophies, foundedDate);
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Team team = (Team) o;
        return Objects.equals(id, team.id) &&
                Objects.equals(name, team.name) &&
                Objects.equals(trophies, team.trophies) &&
                Objects.equals(foundedDate, team.foundedDate);
    }
}
