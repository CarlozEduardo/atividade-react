package com.loja.resources;

import com.loja.DTO.ClienteDTO;
import com.loja.DTO.VendaDTO;
import com.loja.DTO.VendaRequest;
import com.loja.entities.Produto;
import com.loja.entities.Registro;
import com.loja.services.RegistroServices;
import com.loja.services.VendaServices;
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

@Path("/venda")
@Produces(MediaType.APPLICATION_JSON)
@Consumes(MediaType.APPLICATION_JSON)
public class VendaResource {

    @Inject
    VendaServices vendaServices;

    @Inject
    RegistroServices registroServices;

    @POST
    @Path("/cadastrar")
    @Transactional
    @APIResponse(responseCode = "201", description = "Venda registrada!")
    public Response cadastrarVenda(VendaRequest vendaRequest) {
        Integer idVenda = vendaServices.cadastrarVenda(vendaRequest.getVendaDTO());
        registroServices.associarProdutoComVenda(idVenda, vendaRequest.getProdutos());

        return Response.status(Response.Status.CREATED).entity(vendaRequest).build();
    }
}
