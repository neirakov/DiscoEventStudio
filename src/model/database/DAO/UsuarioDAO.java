/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Interface.java to edit this template
 */
package model.database.DAO;

import java.util.ArrayList;
import model.database.Usuario;

/**
 *
 * @author neira
 */
public interface UsuarioDAO {
    boolean verificarCredenciales(String nombreUsuario, String contrasena);
    ArrayList<Usuario> mostrarUsuarios();
}
