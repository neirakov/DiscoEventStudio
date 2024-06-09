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
import model.database.Cliente;
import model.database.ConexionBD;

/**
 *
 * @author neira
 */
public class ClientesDAOMySQL implements ClientesDAO {

    @Override
    public ArrayList<Cliente> mostrarClientes() {
        ArrayList<Cliente> clientes = new ArrayList<>();
        String query = "SELECT * FROM Clientes;";
        try (Connection connection = ConexionBD.getConnection(); Statement stm = connection.createStatement();) {
            ResultSet resultSet = stm.executeQuery(query);
            while (resultSet.next()) {
                int idCliente = resultSet.getInt("id_cliente");
                String CIF = resultSet.getString("CIF");
                String nombreCliente = resultSet.getString("nombre");
                String direccion = resultSet.getString("direccion");
                String telefono = resultSet.getString("telefono");
                Cliente cliente = new Cliente(idCliente, CIF, nombreCliente,direccion,telefono);
                clientes.add(cliente);
            }
        } catch (SQLException e) {
            e.printStackTrace(); 
        }
        return clientes;
 }

    @Override
    public void eliminarCliente(int idCliente) {
         String sql = "DELETE FROM Clientes WHERE id_cliente LIKE ?;";
        try {
            Connection connection = ConexionBD.getConnection();
            PreparedStatement pst = connection.prepareStatement(sql);
            pst.setInt(1, idCliente);
            pst.executeUpdate();
            
        } catch (SQLException ex) {
            ex.printStackTrace();
        }
    }

    @Override
    public void agregarCliente(Cliente cliente) {
        String sql = "INSERT INTO Clientes (CIF, nombre, direccion, telefono) VALUES (?, ?, ?,?)";
        try (Connection connection = ConexionBD.getConnection();
             PreparedStatement pst = connection.prepareStatement(sql)) {
            
            pst.setString(1, cliente.getCIF());
            pst.setString(2, cliente.getNombre());
            pst.setString(3, cliente.getDireccion());
            pst.setString(4, cliente.getTelefono());
            pst.executeUpdate();
            
        } catch (SQLException ex) {
            ex.printStackTrace();
        }
    }
    
}
