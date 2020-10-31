package com.example.demo.controller;


import com.example.demo.dto.PlayerDto;
import com.example.demo.service.PlayerService;
import io.swagger.v3.oas.annotations.OpenAPIDefinition;
import io.swagger.v3.oas.annotations.tags.Tag;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/players")
@OpenAPIDefinition
@Tag(name = "Players")
public class PlayerController {

    private PlayerService playerService;

    @Autowired
    public PlayerController(PlayerService playerService) {
        this.playerService = playerService;
    }

    @PostMapping
    @ResponseStatus(HttpStatus.CREATED)
    public ResponseEntity<PlayerDto> addNewPlayer(@RequestBody PlayerDto playerDto) {
        return ResponseEntity.status(HttpStatus.OK).body(playerService.createNewPlayer(playerDto));
    }

    @GetMapping
    @ResponseStatus(HttpStatus.OK)
    public ResponseEntity<List<PlayerDto>> getAllPlayers() {
        return ResponseEntity.status(HttpStatus.OK).body(playerService.getAllPlayers());
    }

    @GetMapping("/{id}")
    @ResponseStatus(HttpStatus.OK)
    //@ExceptionHandler(ExceptionHandling.PlayerNotFoundException.class)
    public ResponseEntity<PlayerDto> getPlayerById(@PathVariable Long id) {
        return ResponseEntity.status(HttpStatus.OK).body(playerService.getPlayerById(id));
    }

    @PutMapping("/{id}")
    @ResponseStatus(HttpStatus.CREATED)
    public ResponseEntity<PlayerDto> updatePlayer(@PathVariable Long id, @RequestBody PlayerDto playerDto) {
        return ResponseEntity.status(HttpStatus.OK).body(playerService.updatePlayer(id, playerDto));
    }

    @DeleteMapping("/{id}")
    @ResponseStatus(HttpStatus.CREATED)
    public void deletePlayer(@PathVariable Long id) {
        playerService.deletePlayer(id);
    }

}
