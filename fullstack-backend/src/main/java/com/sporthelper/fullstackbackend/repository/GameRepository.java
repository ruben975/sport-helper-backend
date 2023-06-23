package com.sporthelper.fullstackbackend.repository;

import com.sporthelper.fullstackbackend.model.Game;
import org.springframework.data.jpa.repository.JpaRepository;

public interface GameRepository extends JpaRepository<Game, Long> {
}
