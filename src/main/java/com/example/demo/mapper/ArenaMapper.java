package com.example.demo.mapper;

import com.example.demo.dto.ArenaDto;
import com.example.demo.entityDao.Arena;
import org.springframework.util.CollectionUtils;

import java.util.List;
import java.util.stream.Collectors;

import static java.util.Collections.emptyList;

public class ArenaMapper {

    public ArenaMapper() {
    }

    public static List<ArenaDto> from(final List<Arena> arenas) {
if(CollectionUtils.isEmpty(arenas))return emptyList();
    return arenas.stream().map(ArenaMapper::from).collect(Collectors.toList());
    }

   public static ArenaDto from(Arena arena) {
        ArenaDto arenaDto= new ArenaDto();
        arenaDto.setId(arena.getId());
        arenaDto.setName(arena.getName());
        arenaDto.setCapacity(arena.getCapacity());
        return arenaDto;
    }

    public static Arena from(ArenaDto arenaDto){
        Arena arena=new Arena();
        arena.setId(arenaDto.getId());
        arena.setName(arenaDto.getName());
        arena.setCapacity(arenaDto.getCapacity());
        return arena;
    }
}
