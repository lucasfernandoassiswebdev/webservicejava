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
import javax.ws.rs.DELETE;
import javax.ws.rs.Produces;
import javax.ws.rs.GET;
import static javax.ws.rs.HttpMethod.POST;
import javax.ws.rs.POST;
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
//    @GET
//    @Produces("text/html")
//    public String get() {
//        return "<h1>meu primeiro webservice restfull</h1>";
//    }
    @GET()
    @Path("usuario/{login}")
    @Produces("application/json")
    public String get(@PathParam("login") String login) {
        Usuario usuario = new Usuario();
        usuario.setLogin(login);

        UsuarioDAO dao = new UsuarioDAO();
        usuario = dao.get(usuario);

        Gson g = new Gson(); //biblioteca da Google para conversão de objeto para json
        return g.toJson(usuario);
    }

    @GET()
    @Path("usuario/todos")
    @Produces("application/json")
    public String get() {
        List<Usuario> lista;

        UsuarioDAO dao = new UsuarioDAO();
        lista = dao.get();

        Gson g = new Gson();
        return g.toJson(lista);
    }

    @POST
    @Consumes({"application/json"})
    @Path("Usuario/inserir")
    public boolean post(String content) {
        Gson g = new Gson();
        Usuario u = (Usuario) g.fromJson(content, Usuario.class);
        UsuarioDAO dao = new UsuarioDAO();
        return dao.post(u);
    }

    @PUT
    @Consumes("application/json")
    @Path("usuario/alterar")
    public void put(String content) {
        Gson g = new Gson();
        Usuario u = (Usuario) g.fromJson(content, Usuario.class);
        UsuarioDAO dao = new UsuarioDAO();
        dao.put(u);
    }

    @DELETE
    @Path("usuario/excluir/{login}")
    public boolean delete(@PathParam("login") String login) {
        Usuario u = new Usuario();
        u.setLogin(login);

        UsuarioDAO dao = new UsuarioDAO();
        u = dao.get(u);

        return dao.delete(u);
    }
}
