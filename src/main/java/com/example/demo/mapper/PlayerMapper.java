package com.example.demo.mapper;

import com.example.demo.dto.PlayerDto;
import com.example.demo.entityDao.Player;


import java.util.List;
import java.util.stream.Collectors;

public class PlayerMapper {

    public PlayerMapper() {
    }

    public static List<PlayerDto> toPlayerDtoList(final List<Player> players) {
        return players.stream().map(PlayerMapper::toPlayerDto).collect(Collectors.toList());
    }


    public static PlayerDto toPlayerDto(Player player) {
        //din entity in dto
        PlayerDto playerDto = new PlayerDto();
        playerDto.setId(player.getId());
        playerDto.setName(player.getName());
        playerDto.setPosition(player.getPosition());
        playerDto.setBirthDate(player.getBirthDate());
        return playerDto;
    }


    public static Player toPlayerDao(PlayerDto playerDto) {
        //din dto in entity
        Player player = new Player();
        player.setId(playerDto.getId());
        player.setName(playerDto.getName());
        player.setPosition(playerDto.getPosition());
        player.setBirthDate(playerDto.getBirthDate());
        return player;
    }



}
