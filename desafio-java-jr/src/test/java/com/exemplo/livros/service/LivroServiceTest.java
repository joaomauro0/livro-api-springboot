package com.exemplo.livros.service;

import com.example.livros.exception.RecursoNaoEncontradoException;
import com.exemplo.livros.dto.LivroDTO;
import com.exemplo.livros.model.Livro;
import com.exemplo.livros.repository.LivroRepository;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.*;

import java.util.Arrays;
import java.util.List;
import java.util.Optional;

import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.Mockito.*;

class LivroServiceTest {

    @Mock
    private LivroRepository livroRepository;

    @InjectMocks
    private LivroService livroService;

    @BeforeEach
    void setUp() {
        MockitoAnnotations.openMocks(this);
    }

    @Test
    void deveSalvarLivroComSucesso() {
        Livro livro = new Livro();
        livro.setTitulo("Dom Casmurro");
        livro.setAutor("Machado de Assis");
        livro.setAnoPublicacao(1899);

        Livro salvo = new Livro();
        salvo.setId(1L);
        salvo.setTitulo("Dom Casmurro");
        salvo.setAutor("Machado de Assis");
        salvo.setAnoPublicacao(1899);

        when(livroRepository.save(livro)).thenReturn(salvo);

        LivroDTO resultado = livroService.salvar(livro);

        assertEquals("Dom Casmurro", resultado.getTitulo());
        assertNotNull(resultado.getId());
        verify(livroRepository, times(1)).save(livro);
    }

    @Test
    void deveListarTodosOsLivros() {
        Livro l1 = new Livro();
        l1.setId(1L);
        l1.setTitulo("Livro A");
        l1.setAutor("Autor A");
        l1.setAnoPublicacao(2020);

        Livro l2 = new Livro();
        l2.setId(2L);
        l2.setTitulo("Livro B");
        l2.setAutor("Autor B");
        l2.setAnoPublicacao(2021);

        when(livroRepository.findAll()).thenReturn(Arrays.asList(l1, l2));

        List<LivroDTO> livros = livroService.listarTodos();

        assertEquals(2, livros.size());
        verify(livroRepository, times(1)).findAll();
    }

    @Test
    void deveBuscarPorIdComSucesso() {
        Livro livro = new Livro();
        livro.setId(1L);
        livro.setTitulo("1984");
        livro.setAutor("George Orwell");
        livro.setAnoPublicacao(1949);

        when(livroRepository.findById(1L)).thenReturn(Optional.of(livro));

        LivroDTO resultado = livroService.buscarPorId(1L);

        assertEquals("1984", resultado.getTitulo());
    }

    @Test
    void deveLancarExcecaoQuandoBuscarIdInexistente() {
        when(livroRepository.findById(99L)).thenReturn(Optional.empty());

        assertThrows(RecursoNaoEncontradoException.class, () -> livroService.buscarPorId(99L));
    }

    @Test
    void deveDeletarComSucesso() {
        Livro livro = new Livro();
        livro.setId(1L);
        livro.setTitulo("Livro X");
        livro.setAutor("Autor X");
        livro.setAnoPublicacao(2000);

        when(livroRepository.findById(1L)).thenReturn(Optional.of(livro));

        livroService.deletar(1L);

        verify(livroRepository).delete(livro);
    }
}
	