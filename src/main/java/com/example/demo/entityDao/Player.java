package com.example.demo.entityDao;

import javax.persistence.*;
import java.time.LocalDate;
import java.util.Objects;

import static javax.persistence.GenerationType.SEQUENCE;



@Entity
@Table(name = "PLAYERS")
public class Player {
    @Id
    @GeneratedValue(strategy = SEQUENCE, generator = "players_sequence_generator")
    @SequenceGenerator(name = "players_sequence_generator", sequenceName = "PLAYERS_SEQUENCE", allocationSize = 1)
    private Long id;
    @Column(name = "NAME")
    private String name;
    @Column(name = "POSITION")
    private String position;
    @Column(name = "BIRTH_DATE")
    private LocalDate birthDate;//data nasterii [an luna zi]

    public Player() {
    }


    public Player(Long id, String name, String position, LocalDate birthDate) {
        this.id = id;
        this.name = name;
        this.position = position;
        this.birthDate = birthDate;
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

    public String getPosition() {
        return position;
    }

    public void setPosition(String position) {
        this.position = position;
    }

    public LocalDate getBirthDate() {
        return birthDate;
    }

    public void setBirthDate(LocalDate birthDate) {
        this.birthDate = birthDate;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Player player = (Player) o;
        return Objects.equals(id, player.id) &&
                Objects.equals(name, player.name) &&
                Objects.equals(position, player.position) &&
                Objects.equals(birthDate, player.birthDate);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id, name, position, birthDate);
    }
}
