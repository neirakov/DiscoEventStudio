/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package model.database.DAO;
import java.sql.*;
import java.util.ArrayList;
import model.database.ConexionBD;
import model.database.Usuario;

/**
 *
 * @author neira
 */
public class UsuarioDAOMySQL implements UsuarioDAO {    
    @Override
    // Método para verificar si un usuario y contraseña son válidos
    public boolean verificarCredenciales(String nombreUsuario, String contrasena) {
        String query = "SELECT COUNT(*) AS cuenta FROM Usuarios WHERE usuario = ? AND contrasena = ?";
        try (Connection connection = ConexionBD.getConnection();
             PreparedStatement statement = connection.prepareStatement(query)) {
            statement.setString(1, nombreUsuario);
            statement.setString(2, contrasena);
            try (ResultSet resultSet = statement.executeQuery()) {
                if (resultSet.next()) {
                    int cuenta = resultSet.getInt("cuenta");
                    return cuenta > 0;
                }
            }
        } catch (SQLException e) {
            e.printStackTrace(); // Manejo adecuado de errores en la aplicación
        }
        return false; // Si algo sale mal, se asume que las credenciales no son válidas
    }

    @Override
    public ArrayList<Usuario> mostrarUsuarios() {
        ArrayList<Usuario> usuarios = new ArrayList<>();
        String query = "SELECT id_usuario,usuario,contrasena FROM Usuarios;";
        try (Connection connection = ConexionBD.getConnection(); Statement stm = connection.createStatement();) {
            ResultSet resultSet = stm.executeQuery(query);
            while (resultSet.next()) {
                int idUsuario = resultSet.getInt("id_usuario");
                String nombreUsuario = resultSet.getString("usuario");
                String contrasena = resultSet.getString("contrasena");
                Usuario usuario = new Usuario(idUsuario, nombreUsuario, contrasena);
                usuarios.add(usuario);
            }
        } catch (SQLException e) {
            e.printStackTrace(); // Manejo adecuado de errores en la aplicación
        }
        return usuarios;
    }

    @Override
    public void eliminarUsuario(int idUsuario) {
        String sql = "DELETE FROM Usuarios WHERE id_usuario LIKE ?;";
        try {
            Connection connection = ConexionBD.getConnection();
            //PreStatement stm = connection.createStatement();
            PreparedStatement pst = connection.prepareStatement(sql);
            pst.setInt(1, idUsuario);
            pst.executeUpdate();
            
        } catch (SQLException ex) {
            ex.printStackTrace();
        }
    }

    @Override
    public void agregarUsuario(Usuario usuario) {
        String sql = "INSERT INTO Usuarios (usuario, contrasena) VALUES (?, ?)";
        try (Connection connection = ConexionBD.getConnection();
             PreparedStatement pst = connection.prepareStatement(sql)) {
            
            pst.setString(1, usuario.getUsuario());
            pst.setString(2, usuario.getContrasena());
            pst.executeUpdate();
        } catch (SQLException ex) {
            ex.printStackTrace();
        }
    }
 }
