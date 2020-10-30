package com.example.demo.service;

import com.example.demo.dto.ArenaDto;
import com.example.demo.entityDao.Arena;
import com.example.demo.entityDao.repository.ArenaRepository;
import com.example.demo.mapper.ArenaMapper;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

import static com.example.demo.mapper.ArenaMapper.from;

@Service

public class ArenaServiceImpl implements ArenaService {

    private ArenaRepository arenaRepository;

    @Autowired
    public ArenaServiceImpl(ArenaRepository arenaRepository) {
        this.arenaRepository = arenaRepository;
    }

    @Override
    public ArenaDto createNewArena(ArenaDto arenaDto) {
        Arena arena = arenaRepository.save(from(arenaDto));
        return arenaDto;
    }

    @Override
    public List<ArenaDto> getAllArenas() {
        return from(arenaRepository.findAll());
    }

    @Override
    public ArenaDto findByID(Long id) {
        return from(arenaRepository.getOne(id));
    }

    @Override
    public ArenaDto updateArena(Long id, ArenaDto arenaDto) {
        Arena arena = arenaRepository.findById(id).orElseThrow(RuntimeException::new);
        BeanUtils.copyProperties(arenaDto, arena);
        return from(arenaRepository.save(arena));
    }

    @Override
    public void deleteArena(Long id) {
        arenaRepository.deleteById(id);

    }
}
