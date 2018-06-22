/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ws;

import com.google.gson.Gson;
import java.util.ArrayList;
import java.util.List;
import javax.ws.rs.core.Context;
import javax.ws.rs.core.UriInfo;
import javax.ws.rs.Consumes;
import javax.ws.rs.Produces;
import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.ws.rs.PUT;
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
    @Path("usuario")
    @Produces("application/json")
    public String getUsuario() {
        Usuario usuario = new Usuario();
        usuario.setEmail("l.assis@eddydata.com.br");
        usuario.setLogin("l.assis");
        usuario.setSenha("123");
        usuario.setPerfil("Administrador");
        
        Gson g = new Gson(); //biblioteca da Google para conversão de objeto para json
        return g.toJson(usuario);
    }
    
    @GET()
    @Path("usuario/list")
    @Produces("application/json")
    public String getAllUsuarios() {
        List<Usuario> lista = new ArrayList<Usuario>();
        
        Usuario usuario = new Usuario();
        usuario.setEmail("l.assis@eddydata.com.br");
        usuario.setLogin("l.assis");
        usuario.setSenha("123");
        usuario.setPerfil("Administrador");
        
        lista.add(usuario);
        
        usuario = new Usuario();
        usuario.setEmail("t.martos@eddydata.com.br");
        usuario.setLogin("t.martos");
        usuario.setSenha("321");
        usuario.setPerfil("Desenvolvedor");
        
        lista.add(usuario);
        
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
