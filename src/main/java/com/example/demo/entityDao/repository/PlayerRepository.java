package com.example.demo.entityDao.repository;

import com.example.demo.entityDao.Player;
import org.springframework.data.jpa.repository.JpaRepository;

public interface PlayerRepository extends JpaRepository<Player,Long> {

}
