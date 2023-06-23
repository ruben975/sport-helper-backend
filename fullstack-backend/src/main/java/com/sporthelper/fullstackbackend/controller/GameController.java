package com.sporthelper.fullstackbackend.controller;

import com.sporthelper.fullstackbackend.exception.GameNotFoundException;
import com.sporthelper.fullstackbackend.model.Game;
import com.sporthelper.fullstackbackend.repository.GameRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@CrossOrigin(origins = {"*"})
public class GameController {

    @Autowired
    private GameRepository gameRepository;

    @GetMapping("/games")
    List<Game> getAllGames(){
        return gameRepository.findAll();
    }

    @GetMapping("/game/{id}")
    Game getGameById(@PathVariable Long id){
        return gameRepository.findById(id).orElseThrow(() -> new GameNotFoundException(id));
    }

    @PostMapping("/addGame")
    Game saveGame(@RequestBody Game newGame){
        return gameRepository.save(newGame);
    }

    @PutMapping("/updateGame/{id}")
    Game updateGame(@RequestBody Game newGame, @PathVariable Long id){
        return gameRepository.findById(id)
                .map(game -> {
                    game.setAdmin(newGame.getAdmin());
                    game.setDescription(newGame.getDescription());
                    game.setLocation(newGame.getLocation());
                    game.setSport_name(newGame.getSport_name());
                    game.setDate(newGame.getDate());
                    game.setPlayers(newGame.getPlayers());
                    game.setMax_players(newGame.getMax_players());
                    game.setInvited_players(newGame.getInvited_players());
                    return gameRepository.save(game);
                }).orElseThrow(() -> new GameNotFoundException(id));
    }

    @DeleteMapping("/deleteGame/{id}")
    String deleteGame(@PathVariable Long id){
        if(!gameRepository.existsById(id)){
            throw new GameNotFoundException(id);
        }
        gameRepository.deleteById(id);
        return "Game with id " + id + " has been deleted success";
    }

}