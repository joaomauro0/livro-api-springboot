package com.exemplo.livros.service;

import com.exemplo.livros.dto.LivroDTO;
import com.exemplo.livros.exception.RecursoNaoEncontradoException;
import com.exemplo.livros.model.Livro;
import com.exemplo.livros.repository.LivroRepository;
import org.springframework.stereotype.Service;
import com.example.livros.exception.RecursoNaoEncontradoException;



import java.util.List;
import java.util.stream.Collectors;

@Service
public class LivroService {

    private final LivroRepository repository;

    public LivroService(LivroRepository repository) {
        this.repository = repository;
    }

    public LivroDTO salvar(Livro livro) {
        Livro salvo = repository.save(livro);
        return converterParaDTO(salvo);
    }

    public List<LivroDTO> listarTodos() {
        return repository.findAll()
                .stream()
                .map(this::converterParaDTO)
                .collect(Collectors.toList());
    }

    public LivroDTO buscarPorId(Long id) {
        Livro livro = repository.findById(id)
                .orElseThrow(() -> new RecursoNaoEncontradoException("Livro não encontrado"));
        return converterParaDTO(livro);
    }

    public LivroDTO atualizar(Long id, Livro livroAtualizado) {
        Livro livro = repository.findById(id)
                .orElseThrow(() -> new RecursoNaoEncontradoException("Livro não encontrado"));

        livro.setTitulo(livroAtualizado.getTitulo());
        livro.setAutor(livroAtualizado.getAutor());
        livro.setAnoPublicacao(livroAtualizado.getAnoPublicacao());

        return converterParaDTO(repository.save(livro));
    }

    public void deletar(Long id) {
        Livro livro = repository.findById(id)
                .orElseThrow(() -> new RecursoNaoEncontradoException("Livro não encontrado"));
        repository.delete(livro);
    }

    private LivroDTO converterParaDTO(Livro livro) {
        LivroDTO dto = new LivroDTO();
        dto.setId(livro.getId());
        dto.setTitulo(livro.getTitulo());
        dto.setAutor(livro.getAutor());
        dto.setAnoPublicacao(livro.getAnoPublicacao());
        return dto;
    }
}
