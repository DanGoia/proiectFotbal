package com.example.demo.service;

import com.example.demo.dto.ArenaDto;

import java.util.List;
import java.util.Optional;

public interface ArenaService {

    ArenaDto createNewArena(ArenaDto arenaDto);
    List<ArenaDto> getAllArenas();
    ArenaDto findByID(Long id);
    ArenaDto updateArena(Long id,ArenaDto arenaDto);
    void deleteArena(Long id);

}
