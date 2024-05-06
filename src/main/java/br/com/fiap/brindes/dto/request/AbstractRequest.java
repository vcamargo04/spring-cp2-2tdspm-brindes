package br.com.fiap.brindes.dto.request;

import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Positive;

public record AbstractRequest (
        @Positive(message = "O ID É INVALIDO")
        @NotNull(message = "O ID É OBRIGATORIO")
        Long id
) {

}