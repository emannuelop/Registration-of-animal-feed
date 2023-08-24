package br.unitins.topicos2.dto;

import jakarta.validation.constraints.Min;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;

public record RacaoDTO(
        @NotBlank(message = "Campo nome não pode estar vazio") 
        String nome,

        @NotBlank(message = "Campo marca não pode estar vazio") 
        String marca,

        @NotNull(message = "Campo preço não pode estar vazio") 
        @Min(1) 
        Double preco,

        @NotNull(message = "Campo estoque não pode estar vazio")
        @Min(0)
        Integer estoque,

        @NotNull(message = "Campo quantidade de quilos não pode estar vazio") 
        Double quantidadeQuilos,

        @NotBlank(message = "Campo sabor não pode estar vazio") 
        String sabor,

        @NotBlank(message = "Campo animal não pode estar vazio") 
        String animal) {
}
