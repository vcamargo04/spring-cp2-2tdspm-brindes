package br.com.fiap.brindes.dto;

import jakarta.validation.constraints.NotBlank;

public class LojaResponse {
    private Long id;
    
    @NotBlank(message = "O nome da loja não pode estar em branco")
    private String nome;

    public LojaResponse() {
    }

    public LojaResponse(Long id, String nome) {
        this.id = id;
        this.nome = nome;
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
}
