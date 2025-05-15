package com.exemplo.livros.model;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Entity
@Data
@NoArgsConstructor
@AllArgsConstructor
public class Livro {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String titulo;
    private String autor;
    private Integer anoPublicacao;
}

public void setId(Long id) {
 this.id = id;
}

public void setTitulo(String titulo) {
 this.titulo = titulo;
}

public void setAutor(String autor) {
 this.autor = autor;
}

public void setAnoPublicacao(Integer anoPublicacao) {
 this.anoPublicacao = anoPublicacao;
}
