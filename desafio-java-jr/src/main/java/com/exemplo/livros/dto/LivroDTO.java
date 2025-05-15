package com.exemplo.livros.dto;

import lombok.Data;

@Data
public class LivroDTO {

    private Long id;
    private String titulo;
    private String autor;
    private Integer anoPublicacao;

   
    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getTitulo1() {
        return titulo;
    }

    public void setTitulo(String titulo) {
        this.titulo = titulo;
    }

    public String getAutor() {
        return autor;
    }

    public void setAutor(String autor) {
        this.autor = autor;
    }

    public Integer getAnoPublicacao() {
        return anoPublicacao;
    }

    public void setAnoPublicacao(Integer anoPublicacao) {
        this.anoPublicacao = anoPublicacao;
    }

	public Object getTitulo() {
		// TODO Auto-generated method stub
		return null;
	}
}
