package br.unitins.topicos2.repository;

import java.util.List;

import br.unitins.topicos2.model.Racao;
import io.quarkus.hibernate.orm.panache.PanacheRepository;
import jakarta.enterprise.context.ApplicationScoped;

@ApplicationScoped
public class RacaoRepository implements PanacheRepository<Racao> {

    public List<Racao> findByNome(String nome) {
        if (nome == null)
            return null;
        return find("UPPER(nome) LIKE ?1 ", "%" + nome.toUpperCase() + "%").list();
    }

}
