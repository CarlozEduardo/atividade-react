package com.loja;

import com.loja.entidades.Cliente;
import jakarta.inject.Inject;
import jakarta.ws.rs.*;
import jakarta.ws.rs.core.MediaType;
import jakarta.ws.rs.core.Response;

import java.net.URI;

@Path("/loja")
@Produces(MediaType.APPLICATION_JSON)
@Consumes(MediaType.APPLICATION_JSON)
public class ClienteResource {

    @Inject
    ClienteServices clienteServices;

    @GET
    @Path("/login")
    public Response autentificarUsuario(@QueryParam("email") String email, @QueryParam("senha") String senha) {
        Cliente cliente = clienteServices.autentificarUsuario(email, senha);
        return Response.ok(cliente).build();
    }

    @POST
    @Path("/cadastrar/{usuario}")
    public Response cadastrarUsuario(@QueryParam("usuario") Cliente usuario) {
        clienteServices.cadastrarUsuario(usuario);
        return Response.created(URI.create("Cadastro realizado!")).build();
    }
}