package br.com.fiap.brindes.dto;

import jakarta.validation.constraints.NotBlank;

public class LojaRequest {
    @NotBlank(message = "O nome da loja não pode estar em branco")
    private String nome;

    public LojaRequest() {
    }

    public LojaRequest(String nome) {
        this.nome = nome;
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }
}


