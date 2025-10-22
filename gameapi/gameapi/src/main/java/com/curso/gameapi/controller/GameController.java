package com.curso.gameapi.controller;

import com.curso.gameapi.dto.GameMapper;
import com.curso.gameapi.dto.GameRequest;
import com.curso.gameapi.dto.GameResponse;
import com.curso.gameapi.models.Game;
import com.curso.gameapi.repository.GameRepository;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.tags.Tag;
import jakarta.validation.Valid;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.net.URI;
import java.time.Year;
import java.util.List;

import static java.util.stream.Collectors.toList;

@RestController
@RequestMapping("/api/games")
@Tag(name = "Games", description = "CRUD de Games")
public class GameController {

    private final GameRepository repository;

    public GameController(GameRepository repository) {
        this.repository = repository;
    }

    @Operation(summary = "Lista todos os games")
    @GetMapping
    public List<GameResponse> list() {
        return repository.findAll().stream()
                .map(GameMapper::toResponse)
                .collect(toList());
    }

    @Operation(summary = "Cria um novo game")
    @PostMapping
    public ResponseEntity<GameResponse> create(@Valid @RequestBody GameRequest request) {
        Game saved = repository.save(GameMapper.toEntity(request));
        URI location = URI.create("/api/games/" + saved.getIdGame());
        return ResponseEntity.created(location).body(GameMapper.toResponse(saved));
    }

    @Operation(summary = "Atualiza um game existente")
    @PutMapping("/{id}")
    public ResponseEntity<GameResponse> update(@PathVariable Integer id, @Valid @RequestBody GameRequest request) {
        return repository.findById(id)
                .map(existingGame -> {
                    existingGame.setTitulo(request.titulo());
                    existingGame.setEditora(request.editora());
                    existingGame.setGenero(request.genero());
                    existingGame.setAnoLancamento(Year.of(request.anoLancamento()));

                    Game updatedGame = repository.save(existingGame);
                    return ResponseEntity.ok(GameMapper.toResponse(updatedGame));
                })
                .orElse(ResponseEntity.notFound().build());
    }

    @Operation(summary = "Exclui um game existente")
    @DeleteMapping("/{id}")
    public ResponseEntity<Void> delete(@PathVariable Integer id) {
        if (!repository.existsById(id)) {
            return ResponseEntity.notFound().build();
        }
        repository.deleteById(id);
        return ResponseEntity.noContent().build();
    }
}