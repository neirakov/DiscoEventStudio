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
        String query = "SELECT COUNT(*) AS cuenta FROM Usuarios WHERE idUsuario = ? AND contrasena = ?";
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
        throw new UnsupportedOperationException("Not supported yet."); // Generated from nbfs://nbhost/SystemFileSystem/Templates/Classes/Code/GeneratedMethodBody
    }
}
