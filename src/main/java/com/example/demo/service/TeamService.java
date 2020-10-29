package com.example.demo.service;

import com.example.demo.dto.TeamDto;
import com.example.demo.exceptions.IdAlreadyExists;
import com.example.demo.exceptions.TeamNotFoundException;

import java.util.List;

public interface TeamService {
    TeamDto createNewTeam(TeamDto teamDto);
    List<TeamDto> getAllTeams();
    TeamDto getTeamById(Long id) throws TeamNotFoundException;
    TeamDto updateTeam(Long id, TeamDto teamDto) throws TeamNotFoundException, IdAlreadyExists;
    void deleteTeam(Long id) throws TeamNotFoundException;
}
