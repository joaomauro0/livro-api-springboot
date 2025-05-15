package com.exemplo.livros.controller;

import com.exemplo.livros.dto.LivroDTO;
import com.exemplo.livros.model.Livro;
import com.exemplo.livros.service.LivroService;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/livros")
public class LivroController {

    private final LivroService service;

    public LivroController(LivroService service) {
        this.service = service;
    }

    @PostMapping
    public ResponseEntity<LivroDTO> criar(@RequestBody Livro livro) {
        LivroDTO livroSalvo = service.salvar(livro);
        return new ResponseEntity<>(livroSalvo, HttpStatus.CREATED);
    }

    @GetMapping
    public ResponseEntity<List<LivroDTO>> listar() {
        List<LivroDTO> livros = service.listarTodos();
        return ResponseEntity.ok(livros);
    }

    @GetMapping("/{id}")
    public ResponseEntity<LivroDTO> getById(@PathVariable Long id) {
        LivroDTO livro = service.buscarPorId(id);
        return ResponseEntity.ok(livro);
    }

    @PutMapping("/{id}")
    public ResponseEntity<LivroDTO> atualizar(@PathVariable Long id, @RequestBody Livro livro) {
        LivroDTO atualizado = service.atualizar(id, livro);
        return ResponseEntity.ok(atualizado);
    }

    @DeleteMapping("/{id}")
    @ResponseStatus(HttpStatus.NO_CONTENT)
    public void excluir(@PathVariable Long id) {
        service.deletar(id);
    }
}
