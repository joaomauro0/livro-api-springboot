package com.exemplo.livros.controller;

import com.exemplo.livros.model.Livro;
import com.exemplo.livros.service.LivroService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import org.springframework.http.HttpStatus;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/livros") // <- ESSENCIAL!!!
public class LivroController {

    @Autowired
    private LivroService service;

    @PostMapping
    public Livro criar(@RequestBody Livro livro) {
        return service.salvar(livro);
    }

    @GetMapping
    public List<Livro> listar() {
        return service.listarTodos();
    }

    @PutMapping("/{id}")
    public Optional<Livro> atualizar(@PathVariable Long id, @RequestBody Livro livro) {
        return service.atualizar(id, livro);
    }

    @DeleteMapping("/{id}")
    @ResponseStatus(HttpStatus.NO_CONTENT) // <- ESSENCIAL!
    public void excluir(@PathVariable Long id) {
        service.deletar(id);
    }
}
