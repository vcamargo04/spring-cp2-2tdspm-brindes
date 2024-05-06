package br.com.fiap.brindes.dto;

import jakarta.validation.constraints.NotBlank;

public class CategoriaRequest {
    @NotBlank(message = "O nome da categoria não pode estar em branco")
    private String nome;

    public CategoriaRequest() {
    }

    public CategoriaRequest(String nome) {
        this.nome = nome;
    }

    public String getNome() {
        return nome;
    }
    // Vinicius de Araújo Camargo rm99494
    public void setNome(String nome) {
        this.nome = nome;
    }
}
