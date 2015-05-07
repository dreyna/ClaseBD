/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package intefaces;

import dto.Usuario;
import java.util.List;

/**
 *
 * @author alum.fial1
 */
public interface UsuarioInterface {
    public int validarUser(String user, String pass);
    public int verificarUser(String user);
    public List<Usuario> listarUser();
    public List<Usuario> buscarUser(String user);
    public boolean registrarUser(Usuario u);
    public boolean modificarUser(Usuario u);
    public boolean eliminarUser(int id);
    
}
