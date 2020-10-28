package com.example.demo.service;

import com.example.demo.dto.TeamDto;
import com.example.demo.entityDao.Team;
import com.example.demo.entityDao.repository.TeamRepository;
import com.example.demo.mapper.TeamMapper;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

import static com.example.demo.mapper.TeamMapper.toTeamDto;
import static com.example.demo.mapper.TeamMapper.toTeamDao;
import static com.example.demo.mapper.TeamMapper.toTeamDtoList;

@Service
public class TeamServiceImpl implements TeamService {

    private TeamRepository teamRepository;

    @Autowired
    public TeamServiceImpl(TeamRepository teamRepository) {
        this.teamRepository = teamRepository;
    }

    @Override
    public TeamDto createNewTeam(TeamDto teamDto) {
        Team team = toTeamDao(teamDto);
        teamRepository.save(team);
        return toTeamDto(team);
    }

    @Override
    public List<TeamDto> getAllTeams() {
        return toTeamDtoList(teamRepository.findAll());
    }

    @Override
    public TeamDto getTeamById(Long id) {
        return toTeamDto(teamRepository.getOne(id));
    }

    @Override
    public TeamDto updateTeam(Long id, TeamDto teamDto) {
        Team team = teamRepository.findById(id).orElseThrow(RuntimeException::new);
        BeanUtils.copyProperties(teamDto, team);
        return toTeamDto(teamRepository.save(team));
    }

    @Override
    public void deleteTeam(Long id) {
        teamRepository.deleteById(id);
    }
}
