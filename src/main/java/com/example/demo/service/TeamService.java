package com.example.demo.service;

import com.example.demo.dto.TeamDto;

import java.util.List;

public interface TeamService {
    TeamDto createNewTeam(TeamDto teamDto);
    List<TeamDto> getAllTeams();
    TeamDto getTeamById(Long id);
    TeamDto updateTeam(Long id, TeamDto teamDto);
    void deleteTeam(Long id);
}
