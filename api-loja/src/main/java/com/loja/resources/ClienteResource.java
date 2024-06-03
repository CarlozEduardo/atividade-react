package com.loja.resources;

import com.loja.entities.Produto;
import com.loja.services.ClienteServices;
import com.loja.DTO.ClienteDTO;
import com.loja.entities.Cliente;
import jakarta.inject.Inject;
import jakarta.transaction.Transactional;
import jakarta.ws.rs.*;
import jakarta.ws.rs.core.MediaType;
import jakarta.ws.rs.core.Response;
import org.eclipse.microprofile.openapi.annotations.enums.SchemaType;
import org.eclipse.microprofile.openapi.annotations.media.Content;
import org.eclipse.microprofile.openapi.annotations.media.Schema;
import org.eclipse.microprofile.openapi.annotations.responses.APIResponse;

import java.util.List;


@Path("/loja")
@Produces(MediaType.APPLICATION_JSON)
@Consumes(MediaType.APPLICATION_JSON)
public class ClienteResource {

    @Inject
    ClienteServices clienteServices;

    @GET
    @Path("/login")
    @APIResponse(responseCode = "200",
            content = @Content(mediaType = MediaType.APPLICATION_JSON,
                    schema = @Schema(
                            implementation = Cliente.class,
                            type = SchemaType.ARRAY)))
    public Response autentificarUsuario(@QueryParam("email") String email, @QueryParam("senha") String senha) {
        Cliente cliente = clienteServices.autentificarUsuario(email, senha);
        return Response.status(Response.Status.OK).entity(cliente).build();
    }

    @POST
    @Path("/cadastrar")
    @Transactional
    @APIResponse(responseCode = "201", description = "Usuário cadastrado com sucesso!")
    public Response cadastrarUsuario(ClienteDTO clienteDTO) {
        clienteServices.cadastrarUsuario(clienteDTO);
        return Response.status(Response.Status.CREATED).entity(clienteDTO).build();
    }
}