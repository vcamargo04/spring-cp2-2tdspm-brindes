package br.com.fiap.brindes.dto;

import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;

//Vinicius Camargo RM99494

public class ProdutoRequest {
    @NotBlank(message = "O nome do produto não pode estar em branco")
    private String nome;

    @NotNull(message = "O ID da categoria não pode estar em branco")
    public Long categoriaId;

    public ProdutoRequest() {
    }

    public ProdutoRequest(String nome, Long categoriaId) {
        this.nome = nome;
        this.categoriaId = categoriaId;
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
