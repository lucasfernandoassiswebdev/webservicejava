/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package dao;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;
import modelo.Usuario;

/**
 *
 * @author marcelosiedler
 */
public class UsuarioDAO {

    public UsuarioDAO() {

    }

    public List<Usuario> get() {
        String sql = "SELECT * FROM usuario";
        List<Usuario> retorno = new ArrayList<Usuario>();

        PreparedStatement pst = Conexao.getPreparedStatement(sql);

        try {

            ResultSet res = pst.executeQuery();
            while (res.next()) {
                Usuario usuario = new Usuario();
                usuario.setLogin(res.getString("login"));
                usuario.setSenha(res.getString("senha"));
                usuario.setEmail(res.getString("email"));
                usuario.setPerfil(res.getString("perfil"));

                retorno.add(usuario);
            }
        } catch (SQLException ex) {
            Logger.getLogger(UsuarioDAO.class.getName()).log(Level.SEVERE, null, ex);
        }

        return retorno;
    }

    public Usuario get(Usuario usuario) {
        String sql = "SELECT * FROM usuario where login=?";
        Usuario retorno = null;

        PreparedStatement pst = Conexao.getPreparedStatement(sql);

        try {
            pst.setString(1, usuario.getLogin());
            ResultSet res = pst.executeQuery();

            if (res.next()) {
                retorno = new Usuario();
                retorno.setLogin(res.getString("login"));
                retorno.setSenha(res.getString("senha"));
                retorno.setEmail(res.getString("email"));
                retorno.setPerfil(res.getString("perfil"));

            }
        } catch (SQLException ex) {
            Logger.getLogger(UsuarioDAO.class.getName()).log(Level.SEVERE, null, ex);

        }

        return retorno;
    }
    
    public boolean post(Usuario usuario) {
        String sql = "INSERT INTO usuario(login,senha,perfil,email) VALUES(?,?,?,?)";
        Boolean retorno = false;
        PreparedStatement pst = Conexao.getPreparedStatement(sql);

        try {
            pst.setString(1, usuario.getLogin());
            pst.setString(2, usuario.getSenha());
            pst.setString(3, usuario.getPerfil());
            pst.setString(4, usuario.getEmail());

            if (pst.executeUpdate() > 0) {
                retorno = true;
            }
        } catch (SQLException ex) {
            Logger.getLogger(UsuarioDAO.class.getName()).log(Level.SEVERE, null, ex);
            retorno = false;
        }

        return retorno;
    }

    public boolean put(Usuario usuario) {
        String sql = "UPDATE usuario set senha=?,perfil=?,email=? where login=?";
        Boolean retorno = false;
        PreparedStatement pst = Conexao.getPreparedStatement(sql);

        try {
            pst.setString(1, usuario.getSenha());
            pst.setString(2, usuario.getPerfil());
            pst.setString(3, usuario.getEmail());
            pst.setString(4, usuario.getLogin());
            if (pst.executeUpdate() > 0) {
                retorno = true;
            }
        } catch (SQLException ex) {
            Logger.getLogger(UsuarioDAO.class.getName()).log(Level.SEVERE, null, ex);
            retorno = false;
        }

        return retorno;
    }

    public boolean delete(Usuario usuario) {
        String sql = "DELETE FROM usuario where login=?";
        Boolean retorno = false;
        PreparedStatement pst = Conexao.getPreparedStatement(sql);

        try {

            pst.setString(1, usuario.getLogin());
            if (pst.executeUpdate() > 0) {
                retorno = true;
            }
        } catch (SQLException ex) {
            Logger.getLogger(UsuarioDAO.class.getName()).log(Level.SEVERE, null, ex);
            retorno = false;
        }

        return retorno;
    }
}
