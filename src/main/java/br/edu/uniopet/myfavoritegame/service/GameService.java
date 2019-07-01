package br.edu.uniopet.myfavoritegame.service;

import br.edu.uniopet.myfavoritegame.domain.Game;
import br.edu.uniopet.myfavoritegame.repository.GameRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.DataIntegrityViolationException;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
public class GameService {

    @Autowired
    private GameRepository repository;

    public Game find(Integer id) {
        Game obj = repository.findById(id).orElse(null);
        return obj;

    }

    /**
     * Insere um Game via json
     * @param obj
     * @return
     */
    @Transactional
    public Game insert(Game obj) {
        obj.setId(null);
        obj = repository.save(obj);
        return obj;
    }

    /**
     * Update de um Game
     * @param obj
     * @return
     */
    public Game update(Game obj) {
        Game newObj = find(obj.getId());
        updateData(newObj, obj);
        return repository.save(newObj);
    }

    /**
     * Deleta uma Cliente
     * @param id
     */
    public void delete(Integer id) {
        find(id);
        try {
            repository.deleteById(id);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    private void updateData(Game newObj, Game obj) {
        newObj.setNome(obj.getNome());
        newObj.setImage(obj.getImage());
    }
}
