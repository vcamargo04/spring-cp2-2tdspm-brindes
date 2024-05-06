package br.com.fiap.brindes.dto;

import jakarta.validation.constraints.NotBlank;

public class ProdutoResponse {
    public Long id;
    
    @NotBlank(message = "O nome do produto não pode estar em branco")
    public String nome;

    public Long categoriaId;

    public ProdutoResponse() {
    }

    public ProdutoResponse(Long id, String nome, Long categoriaId) {
        this.id = id;
        this.nome = nome;
        this.categoriaId = categoriaId;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public Long getCategoriaId() {
        return categoriaId;
    }

    public void setCategoriaId(Long categoriaId) {
        this.categoriaId = categoriaId;
    }
}
