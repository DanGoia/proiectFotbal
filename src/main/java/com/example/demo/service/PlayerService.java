package com.example.demo.service;


import com.example.demo.dto.PlayerDto;
import com.example.demo.handler.IdPlayerAlreadyExist;
import com.example.demo.handler.PlayerNotFoundException;

import java.util.List;

public interface PlayerService {

    PlayerDto createNewPlayer(PlayerDto playerDto) throws IdPlayerAlreadyExist;

    List<PlayerDto> getAllPlayers();

    PlayerDto getPlayerById(Long id) throws PlayerNotFoundException;

    PlayerDto updatePlayer(Long id, PlayerDto playerDto) throws PlayerNotFoundException, IdPlayerAlreadyExist;

    void deletePlayer(Long id) throws PlayerNotFoundException;

}
