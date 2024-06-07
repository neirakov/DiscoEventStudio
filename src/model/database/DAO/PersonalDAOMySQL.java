/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package model.database.DAO;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import model.database.ConexionBD;
import model.database.Personal;

/**
 *
 * @author neira
 */
public class PersonalDAOMySQL implements PersonalDAO {

    @Override
    public ArrayList<Personal> mostrarPersonal() {
        ArrayList<Personal> personalLista = new ArrayList<>();
        String query = "SELECT * FROM Empleados;";
        try (Connection connection = ConexionBD.getConnection(); Statement stm = connection.createStatement();) {
            ResultSet resultSet = stm.executeQuery(query);
            while (resultSet.next()) {
                int idEmpleado = resultSet.getInt("id_empleado");
                String nombreEmpleado = resultSet.getString("nombre");
                String apellidosEmpleado = resultSet.getString("apellidos");
                String direccionEmpleado = resultSet.getString("direccion");
                String telefonoEmpleado = resultSet.getString("telefono");
                Personal personal = new Personal(idEmpleado, nombreEmpleado, apellidosEmpleado,direccionEmpleado,telefonoEmpleado);
                personalLista.add(personal);
                System.out.println(personal);
            }
        } catch (SQLException e) {
            e.printStackTrace(); 
        }
        return personalLista;
    }

    @Override
    public void eliminarEmpleado(int idEmpleado) {
        throw new UnsupportedOperationException("Not supported yet."); // Generated from nbfs://nbhost/SystemFileSystem/Templates/Classes/Code/GeneratedMethodBody
    }

    @Override
    public void agregarEmpleado(Personal personal) {
        String sql = "INSERT INTO Empleados (nombre, apellidos, direccion, telefono) VALUES (?, ?, ?, ?)";
        try (Connection connection = ConexionBD.getConnection();
             PreparedStatement pst = connection.prepareStatement(sql)) {
            
            pst.setString(1, personal.getNombre());
            pst.setString(2, personal.getApellidos());
            pst.setString(3, personal.getDireccion());
            pst.setString(4, personal.getTelefono());
            pst.executeUpdate();
        } catch (SQLException ex) {
            ex.printStackTrace();
        }
    }
    
}
