package br.unitins.topicos2.resource;

import java.util.List;

import org.jboss.logging.Logger;

import br.unitins.topicos2.application.Result;
import br.unitins.topicos2.dto.RacaoDTO;
import br.unitins.topicos2.dto.RacaoResponseDTO;
import br.unitins.topicos2.service.RacaoService;
import jakarta.inject.Inject;
import jakarta.validation.ConstraintViolationException;
import jakarta.ws.rs.Consumes;
import jakarta.ws.rs.DELETE;
import jakarta.ws.rs.GET;
import jakarta.ws.rs.POST;
import jakarta.ws.rs.PUT;
import jakarta.ws.rs.Path;
import jakarta.ws.rs.PathParam;
import jakarta.ws.rs.Produces;
import jakarta.ws.rs.core.MediaType;
import jakarta.ws.rs.core.Response;
import jakarta.ws.rs.core.Response.Status;

@Path("/racoes")
@Consumes(MediaType.APPLICATION_JSON)
@Produces(MediaType.APPLICATION_JSON)
public class RacaoResource {

    @Inject
    RacaoService racaoService;

    private static final Logger LOG = Logger.getLogger(RacaoResource.class);

    @GET
    public List<RacaoResponseDTO> getAll() {
        LOG.info("Buscando todas as rações.");
        LOG.debug("ERRO DE DEBUG.");
        return racaoService.getAll();
    }

    @GET
    @Path("/{id}")
    public RacaoResponseDTO findById(@PathParam("id") Long id) {
        return racaoService.findById(id);
    }

    @POST
    public Response insert(RacaoDTO dto) {
        LOG.infof("Inserindo uma ração: %s", dto.nome());
        Result result = null;
        try {
            RacaoResponseDTO racao = racaoService.create(dto);
            LOG.infof("Ração (%d) criada com sucesso.", racao.id());
            return Response.status(Status.CREATED).entity(racao).build();
        } catch (ConstraintViolationException e) {
            LOG.error("Erro ao incluir uma ração.");
            LOG.debug(e.getMessage());
            result = new Result(e.getConstraintViolations());
        } catch (Exception e) {
            LOG.fatal("Erro sem identificacao: " + e.getMessage());
            result = new Result(e.getMessage(), false);
        }
        return Response.status(Status.NOT_FOUND).entity(result).build();

    }

    @PUT
    @Path("/{id}")
    public Response update(@PathParam("id") Long id, RacaoDTO dto) {
        try {
            RacaoResponseDTO racao = racaoService.update(id, dto);
            return Response.ok(racao).build();
        } catch (ConstraintViolationException e) {
            Result result = new Result(e.getConstraintViolations());
            return Response.status(Status.NOT_FOUND).entity(result).build();
        }
    }

    @DELETE
    @Path("/{id}")
    public Response delete(@PathParam("id") Long id) {
        racaoService.delete(id);
        return Response.status(Status.NO_CONTENT).build();
    }

    @GET
    @Path("/count")
    public long count() {
        return racaoService.count();
    }

    @GET
    @Path("/search/{nome}")
    public List<RacaoResponseDTO> search(@PathParam("nome") String nome) {
        return racaoService.findByNome(nome);

    }
}
