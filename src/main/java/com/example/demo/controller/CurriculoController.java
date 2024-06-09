package com.example.demo.controller;

import com.example.demo.model.Curriculo;
import com.example.demo.service.CurriculoService;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;
import java.util.UUID;

@RestController
@RequestMapping("/curriculos")
public class CurriculoController {

    private final CurriculoService curriculoService;

    @Autowired
    public CurriculoController(CurriculoService curriculoService) {
        this.curriculoService = curriculoService;
    }

    @PostMapping
    public Curriculo createCurriculo(@RequestBody Curriculo curriculo) {
        Curriculo createdCurriculo = curriculoService.createCurriculo(curriculo);
        return curriculoService.createCurriculo(curriculo);
    }

    @GetMapping
    public List<Curriculo> getAllCurriculos() {
        List<Curriculo> curriculos = curriculoService.getAllCurriculos();
        return curriculoService.getAllCurriculos();
    }

    @GetMapping("/{id}")
    public Optional<Curriculo> getCurriculoById(@PathVariable UUID id) {
        return curriculoService.getCurriculoById(id);
    }

    @PutMapping("/{id}")
    public Optional<Curriculo> updateCurriculo(@RequestBody Curriculo curriculo, @PathVariable UUID id) {
        return curriculoService.updateCurriculo(curriculo,id);
    }

    @DeleteMapping("/{id}")
    public Boolean deleteCurriculo(@PathVariable UUID id) {
        return curriculoService.deletarCurriculo(id);
    }
}