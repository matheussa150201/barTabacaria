package com.barTabacaria.controller;

import com.barTabacaria.entity.Essencia;
import com.barTabacaria.repository.EssenciaRepository;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.server.ResponseStatusException;

@RestController
@RequestMapping("/api/essencia")
public class EssenciaController {

    private EssenciaRepository essenciaRepository;

    @PostMapping
    @ResponseStatus(HttpStatus.CREATED)
    public Essencia salvar(@RequestBody Essencia essencia) {
        return essenciaRepository.save(essencia);
    }

    @GetMapping("{id}")
    public Essencia acharPorId(@PathVariable Integer id) {
    return essenciaRepository
            .findById(id)
            .orElseThrow(() -> new ResponseStatusException(HttpStatus.NOT_FOUND));
    }

    @DeleteMapping("{id}")
    @ResponseStatus(HttpStatus.NO_CONTENT)
    public void deletar(@PathVariable Integer id) {
        essenciaRepository
                .findById(id)
                .map(essencia -> {
                    essenciaRepository.delete(essencia);
                    return Void.TYPE;
                })
                .orElseThrow(() -> new ResponseStatusException(HttpStatus.NOT_FOUND));
    }

    @PutMapping("{id}")
    @ResponseStatus(HttpStatus.CREATED)
    public void atualizar(@PathVariable Integer id, @RequestBody Essencia essenciaAtualizada) {
        essenciaRepository
                .findById(id)
                .map( essencia -> {
                    essenciaAtualizada.setId(essencia.getId());
                    return essenciaRepository.save(essenciaAtualizada);
                })
                .orElseThrow(() -> new ResponseStatusException(HttpStatus.NOT_FOUND));
    }

}
