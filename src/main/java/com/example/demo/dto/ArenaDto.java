package com.example.demo.dto;

public class ArenaDto {

    private Long id;
    private String name;
    private Long capacity;

    public ArenaDto() {
    }

    public ArenaDto(Long id, String name, Long capacity) {
        this.id = id;
        this.name = name;
        this.capacity = capacity;
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

    public Long getCapacity() {
        return capacity;
    }

    public void setCapacity(Long capacity) {
        this.capacity = capacity;
    }
}
