package br.unitins.topicos2.service;

import java.util.List;

import br.unitins.topicos2.dto.RacaoDTO;
import br.unitins.topicos2.dto.RacaoResponseDTO;

public interface RacaoService {

        // recursos basicos
        List<RacaoResponseDTO> getAll();

        RacaoResponseDTO findById(Long id);

        RacaoResponseDTO create(RacaoDTO dto);

        RacaoResponseDTO update(Long id, RacaoDTO dto);

        void delete(Long id);

        // recursos extras
        List<RacaoResponseDTO> findByNome(String nome);

        long count();

}