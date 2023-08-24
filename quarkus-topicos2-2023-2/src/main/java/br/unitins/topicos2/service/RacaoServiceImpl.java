package br.unitins.topicos2.service;

import java.util.List;
import java.util.Set;
import java.util.stream.Collectors;

import br.unitins.topicos2.dto.RacaoDTO;
import br.unitins.topicos2.dto.RacaoResponseDTO;
import br.unitins.topicos2.model.Racao;
import br.unitins.topicos2.repository.RacaoRepository;
import jakarta.enterprise.context.ApplicationScoped;
import jakarta.inject.Inject;
import jakarta.transaction.Transactional;
import jakarta.validation.ConstraintViolation;
import jakarta.validation.ConstraintViolationException;
import jakarta.validation.Validator;
import jakarta.ws.rs.NotFoundException;

@ApplicationScoped
public class RacaoServiceImpl implements RacaoService {

    @Inject
    RacaoRepository racaoRepository;

    @Inject
    Validator validator;

    @Override
    public List<RacaoResponseDTO> getAll() {
        List<Racao> list = racaoRepository.listAll();
        return list.stream().map(e -> RacaoResponseDTO.valueOf(e)).collect(Collectors.toList());
    }

    @Override
    public RacaoResponseDTO findById(Long id) {
        Racao racao = racaoRepository.findById(id);
        if (racao == null)
            throw new NotFoundException("Ração não encontrada.");
        return RacaoResponseDTO.valueOf(racao);
    }

    @Override
    @Transactional
    public RacaoResponseDTO create(RacaoDTO racaoDTO) throws ConstraintViolationException {
        validar(racaoDTO);

        Racao entity = new Racao();
        entity.setNome(racaoDTO.nome());
        entity.setMarca(racaoDTO.marca());
        entity.setPreco(racaoDTO.preco());
        entity.setEstoque(racaoDTO.estoque());
        entity.setQuantidadeQuilos(racaoDTO.quantidadeQuilos());
        entity.setSabor(racaoDTO.sabor());
        entity.setAnimal(racaoDTO.animal());

        racaoRepository.persist(entity);

        return RacaoResponseDTO.valueOf(entity);
    }

    @Override
    @Transactional
    public RacaoResponseDTO update(Long id, RacaoDTO racaoDTO) throws ConstraintViolationException {
        validar(racaoDTO);

        Racao entity = racaoRepository.findById(id);

        entity.setNome(racaoDTO.nome());
        entity.setMarca(racaoDTO.marca());
        entity.setPreco(racaoDTO.preco());
        entity.setEstoque(racaoDTO.estoque());
        entity.setQuantidadeQuilos(racaoDTO.quantidadeQuilos());
        entity.setSabor(racaoDTO.sabor());
        entity.setAnimal(racaoDTO.animal());

        return RacaoResponseDTO.valueOf(entity);
    }

    private void validar(RacaoDTO racaoDTO) throws ConstraintViolationException {
        Set<ConstraintViolation<RacaoDTO>> violations = validator.validate(racaoDTO);
        if (!violations.isEmpty())
            throw new ConstraintViolationException(violations);

    }

    @Override
    @Transactional
    public void delete(Long id) {
        racaoRepository.deleteById(id);
    }

    @Override
    public List<RacaoResponseDTO> findByNome(String nome) {
        List<Racao> list = racaoRepository.findByNome(nome);
        return list.stream().map(e -> RacaoResponseDTO.valueOf(e)).collect(Collectors.toList());
    }

    @Override
    public long count() {
        return racaoRepository.count();
    }
}