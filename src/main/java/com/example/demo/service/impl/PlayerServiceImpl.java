package com.example.demo.service.impl;


import com.example.demo.dto.PlayerDto;
import com.example.demo.entityDao.Player;
import com.example.demo.entityDao.repository.PlayerRepository;
import com.example.demo.handler.IdPlayerAlreadyExist;
import com.example.demo.handler.PlayerNotFoundException;
import com.example.demo.service.PlayerService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;


import static com.example.demo.mapper.PlayerMapper.*;

@Service
public class PlayerServiceImpl implements PlayerService {

    private static final Logger LOGGER = LoggerFactory.getLogger(PlayerServiceImpl.class);

    private PlayerRepository playerRepository;

    @Autowired
    public PlayerServiceImpl(PlayerRepository playerRepository) {
        this.playerRepository = playerRepository;
    }

    @Override
    public PlayerDto createNewPlayer(PlayerDto playerDto) throws IdPlayerAlreadyExist {
        LOGGER.info("Creating Player: {}", playerDto);
        Optional<Player> player1 = playerRepository.findById(playerDto.getId());
        if (player1.isPresent()) {
            throw new IdPlayerAlreadyExist("The player with id" + player1.get().getId() + "Already exists !");
        } else {
            Player player = toPlayerDao(playerDto);
        /* echivalent cu asta numa ca ii staica medota din mapper
        Player player = playerMapper.toPlayerDao(playerDto) */
            playerRepository.save(player);
            return toPlayerDto(player);
        }

    }

    @Override
    public List<PlayerDto> getAllPlayers() {
        LOGGER.info("Searching for all players. ");
        return toPlayerDtoList(playerRepository.findAll());
    }

    @Override
    public PlayerDto getPlayerById(Long id) throws PlayerNotFoundException {
        LOGGER.info("Searching for the player with id: {}:", id);
        return toPlayerDto(playerRepository.findById(id).orElseThrow(() -> new PlayerNotFoundException("Player with " + id + " Not found")));


    }

    @Override
    public PlayerDto updatePlayer(Long id, PlayerDto playerDto) throws PlayerNotFoundException {
        LOGGER.info("Updating player with id: {},with values:{}", id, playerDto);
        Player player = playerRepository.findById(id).orElseThrow(() -> new PlayerNotFoundException("Player " + id + " not found"));
        BeanUtils.copyProperties(playerDto, player);
        //sursa playerDto, target player
        return toPlayerDto(playerRepository.save(player));

    }

    @Override
    public void deletePlayer(Long id) throws PlayerNotFoundException {
        LOGGER.info("Deleting team with id: {}", id);
        Player player = playerRepository.findById(id).orElseThrow(() -> new PlayerNotFoundException("Player " + id + " not found"));
        playerRepository.deleteById(id);
    }
}
