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
        String query = "SELECT * FROM Usuarios;";
        try (Connection connection = ConexionBD.getConnection(); PreparedStatement statement = connection.prepareStatement(query); ResultSet resultSet = statement.executeQuery()) {
            while (resultSet.next()) {
                int idUsuario = resultSet.getInt("id_usuario");
                String nombreUsuario = resultSet.getString("nombre_usuario");
                String contrasena = resultSet.getString("contrasena");
                Usuario usuario = new Usuario(idUsuario, nombreUsuario, contrasena);
                usuarios.add(usuario);
            }
        } catch (SQLException e) {
            e.printStackTrace(); // Manejo adecuado de errores en la aplicación
        }
        return usuarios;
    }
}
