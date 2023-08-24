package br.unitins.topicos2.dto;

import br.unitins.topicos2.model.Racao;

public record RacaoResponseDTO(
        Long id,
        String nome,
        String marca,
        Double preco,
        Integer estoque,
        Double quantidadeQuilos,
        String sabor,
        String animal) {

    public static RacaoResponseDTO valueOf(Racao racao) {
        return new RacaoResponseDTO(
            racao.getId(),
            racao.getNome(),
            racao.getMarca(),
            racao.getPreco(),
            racao.getEstoque(),
            racao.getQuantidadeQuilos(),
            racao.getSabor(),
            racao.getAnimal());
    }

}
