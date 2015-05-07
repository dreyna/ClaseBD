/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package dao;

import dto.Usuario;
import factory.Conexion;
import intefaces.UsuarioInterface;
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

/**
 *
 * @author alum.fial1
 */
public class UsuarioDAO implements UsuarioInterface{
    private Connection cx;
    private Statement st;
    private ResultSet rs;
    private String sql="";
    @Override
    public int validarUser(String user, String pass) {
        int x = 0;
       sql ="select *from usuario where usuario='"+
               user+"' and "+"clave='"+pass+"'";
        try {
            cx = Conexion.getConexion();
            st = cx.createStatement();
            rs = st.executeQuery(sql);
            while(rs.next()){
                x=1;
            }            
        } catch (SQLException e) {
            
        }
        return x;
    }

    @Override
    public int verificarUser(String user) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public List<Usuario> listarUser() {
        List<Usuario> lista = new ArrayList<>();
        sql = "select *from usuario";
        try {
            cx = Conexion.getConexion();
            st = cx.createStatement();
            rs = st.executeQuery(sql);
            while(rs.next()){
                Usuario u = new Usuario();
                u.setIduser(rs.getInt("idusuario"));
                u.setNombres(rs.getString("nombres"));
                u.setApellidos(rs.getString("apellidos"));
                u.setUser(rs.getString("usuario"));
                u.setPass(rs.getString("clave"));
                u.setEstado(rs.getString("Estado"));
                lista.add(u);
            }
        } catch (SQLException e) {
        }
        
       return lista;
    }

    @Override
    public List<Usuario> buscarUser(String user) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public boolean registrarUser(Usuario u) {
        boolean op = false;
        sql="insert into usuario(idusuario, nombres, apellidos, usuario, "
            + "clave, Estado) values(null,'"+u.getNombres()
            +"', '"+u.getApellidos()
            +"', '"+u.getUser()
            +"', '"+u.getPass()
            +"', '"+u.getEstado()+"')";
        try {
            cx = Conexion.getConexion();
            st = cx.createStatement();
            st.executeUpdate(sql);
            op=true;
        } catch (Exception e) {
        }
        return op;
    }

    @Override
    public boolean modificarUser(Usuario u) {
        boolean op = false;
        sql="update usuario set nombres='"+u.getNombres()
            +"', apellidos='"+u.getApellidos()
            +"', usuario='"+u.getUser()
            +"', clave='"+u.getPass()
            +"', Estado='"+u.getEstado()
            +"' where idusuario="+u.getIduser();
         try {
            cx = Conexion.getConexion();
            st = cx.createStatement();
            st.executeUpdate(sql);
            op=true;
        } catch (Exception e) {
        }
        return op;
        
    }

    @Override
    public boolean eliminarUser(int id) {
        boolean op = false;
        sql = "delete from usuario where idusuario = "+id;
         try {
            cx = Conexion.getConexion();
            st = cx.createStatement();
            st.executeUpdate(sql);
            op=true;
        } catch (Exception e) {
        }
        return op;
        
    }
    
}
