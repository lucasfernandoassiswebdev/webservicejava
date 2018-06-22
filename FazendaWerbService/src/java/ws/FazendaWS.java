/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ws;

import com.google.gson.Gson;
import com.sun.org.glassfish.gmbal.ParameterNames;
import dao.UsuarioDAO;
import java.util.ArrayList;
import java.util.List;
import javax.ws.rs.core.Context;
import javax.ws.rs.core.UriInfo;
import javax.ws.rs.Consumes;
import javax.ws.rs.Produces;
import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.ws.rs.PUT;
import javax.ws.rs.PathParam;
import modelo.Usuario;

/**
 * REST Web Service
 *
 * @author lucas
 */
@Path("fazenda")
public class FazendaWS {

    @Context
    private UriInfo context;

    /**
     * Creates a new instance of FazendaWS
     */
    public FazendaWS() {
    }

    /**
     * Retrieves representation of an instance of ws.FazendaWS
     *
     * @return an instance of java.lang.String
     */
    @GET
    @Produces("text/html")
    public String getJson() {
        return "<h1>meu primeiro webservice restfull</h1>";
    }

    @GET()
    @Path("usuario/{login}")
    @Produces("application/json")
    public String getUsuario(@PathParam("login") String login) {
        Usuario usuario = new Usuario();
        usuario.setLogin(login);
        
        UsuarioDAO dao = new UsuarioDAO();
        usuario = dao.buscar(usuario);
        
        Gson g = new Gson(); //biblioteca da Google para conversão de objeto para json
        return g.toJson(usuario);
    }

    @GET()
    @Path("usuario/all")
    @Produces("application/json")
    public String getAllUsuarios() {
        List<Usuario> lista;

        UsuarioDAO dao = new UsuarioDAO();
        lista = dao.listar();

        Gson g = new Gson();
        return g.toJson(lista);
    }

    /**
     * PUT method for updating or creating an instance of FazendaWS
     *
     * @param content representation for the resource
     * @return an HTTP response with content of the updated or created resource.
     */
    @PUT
    @Consumes("application/json")
    public void putJson(String content) {
    }
}
