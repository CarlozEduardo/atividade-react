package com.loja.resources;

import com.loja.entities.Produto;
import com.loja.services.ProdutoServices;
import jakarta.inject.Inject;
import jakarta.transaction.Transactional;
import jakarta.ws.rs.Consumes;
import jakarta.ws.rs.POST;
import jakarta.ws.rs.Path;
import jakarta.ws.rs.Produces;
import jakarta.ws.rs.core.MediaType;
import jakarta.ws.rs.core.Response;
import org.eclipse.microprofile.openapi.annotations.responses.APIResponse;

import java.util.List;

@Path("/produto")
@Produces(MediaType.APPLICATION_JSON)
@Consumes(MediaType.APPLICATION_JSON)
public class ProdutoResource {

    @Inject
    ProdutoServices produtoServices;

    @POST
    @Path("/cadastrar")
    @Transactional
    @APIResponse(responseCode = "201", description = "Produto cadastrado com sucesso!")
    public Response cadastrarProduto(List<Produto> produtos) {
        produtoServices.cadastrarProduto(produtos);
        return Response.status(Response.Status.CREATED).entity(produtos).build();
    }
}
