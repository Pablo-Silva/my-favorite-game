package br.edu.uniopet.myfavoritegame.controller;

import br.edu.uniopet.myfavoritegame.domain.Game;
import br.edu.uniopet.myfavoritegame.repository.GameRepository;
import br.edu.uniopet.myfavoritegame.service.GameService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.Collection;
import java.util.stream.Collectors;

@RestController
@RequestMapping(value = "/games")
public class GameController {

    @Autowired
    private GameRepository gameRepository;

    @Autowired
    private GameService service;

    public GameController(GameRepository gameRepository){
        this.gameRepository = gameRepository;
    }

    /**
     * List Game por id.
     * @param id
     * @return
     */
    @RequestMapping(value = "/{id}", method = RequestMethod.GET)
    public ResponseEntity<Game> find(@PathVariable Integer id) {
        Game obj = service.find(id);
        return ResponseEntity.ok().body(obj);
    }

    /**
     * Metodo que lista todos os games.
     * @return
     */
    @GetMapping("/list-games")
    @CrossOrigin(origins = "http://localhost:4200")
    public Collection<Game> getGames(){
        return gameRepository.findAll();
    }

    /**
     * Insere um Game via json
     * @param obj
     * @return
     */
    @Transactional
    public Game insert(Game obj) {
        obj.setId(null);
        obj = service.insert(obj);
        return obj;
    }

    /**
     * Update de um Game
     * @param obj
     * @param id
     * @return
     */
    @RequestMapping(value = "/{id}", method = RequestMethod.PUT)
    public ResponseEntity<Void> update(@Valid @RequestBody Game obj, @PathVariable Integer id) {
        Game objGame = service.find(id);
        objGame.setId(id);
        objGame = service.update(obj);
        return ResponseEntity.noContent().build();
    }

    /**
     * Deleta um Game
     *
     * @param id
     * @return
     */
    @RequestMapping(value = "/{id}", method = RequestMethod.DELETE)
    public ResponseEntity<Void> delete(@PathVariable Integer id) {
        service.delete(id);
        return ResponseEntity.noContent().build();
    }
}
