package com.exemplo.livros.controller;

import com.exemplo.livros.LivroApiApplication;
import com.exemplo.livros.model.Livro;
import com.fasterxml.jackson.databind.ObjectMapper;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.http.MediaType;
import org.springframework.test.web.servlet.MockMvc;

import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.*;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.*;

@SpringBootTest(classes = LivroApiApplication.class)
@AutoConfigureMockMvc
class LivroControllerTest {

    @Autowired
    private MockMvc mockMvc;

    @Autowired
    private ObjectMapper objectMapper;

    @Test
    void deveCadastrarLivro() throws Exception {
        Livro livro = new Livro("Dom Casmurro", "Machado de Assis", 1899);

        mockMvc.perform(post("/livros")
                        .contentType(MediaType.APPLICATION_JSON)
                        .content(objectMapper.writeValueAsString(livro)))
                .andExpect(status().isOk())
                .andExpect(jsonPath("$.titulo").value("Dom Casmurro"))
                .andExpect(jsonPath("$.autor").value("Machado de Assis"))
                .andExpect(jsonPath("$.anoPublicacao").value(1899));
    }

    @Test
    void deveListarLivros() throws Exception {
        mockMvc.perform(get("/livros"))
                .andExpect(status().isOk());
    }

    @Test
    void deveAtualizarLivro() throws Exception {
        Livro livro = new Livro("Livro Original", "Autor", 2000);

        String response = mockMvc.perform(post("/livros")
                        .contentType(MediaType.APPLICATION_JSON)
                        .content(objectMapper.writeValueAsString(livro)))
                .andExpect(status().isOk())
                .andReturn().getResponse().getContentAsString();

        Livro criado = objectMapper.readValue(response, Livro.class);
        criado.setTitulo("Livro Atualizado");

        mockMvc.perform(put("/livros/" + criado.getId())
                        .contentType(MediaType.APPLICATION_JSON)
                        .content(objectMapper.writeValueAsString(criado)))
                .andExpect(status().isOk())
                .andExpect(jsonPath("$.titulo").value("Livro Atualizado"));
    }

    @Test
    void deveExcluirLivro() throws Exception {
        Livro livro = new Livro("Livro para excluir", "Autor", 2023);

        String response = mockMvc.perform(post("/livros")
                        .contentType(MediaType.APPLICATION_JSON)
                        .content(objectMapper.writeValueAsString(livro)))
                .andExpect(status().isOk())
                .andReturn().getResponse().getContentAsString();

        Livro criado = objectMapper.readValue(response, Livro.class);

        mockMvc.perform(delete("/livros/" + criado.getId()))
                .andExpect(status().isNoContent());
    }
}
