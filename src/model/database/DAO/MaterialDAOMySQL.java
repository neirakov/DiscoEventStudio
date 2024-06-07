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
import model.database.Material;

/**
 *
 * @author neira
 */
public class MaterialDAOMySQL implements MaterialDAO {

    @Override
    public ArrayList<Material> mostrarMaterial() {
        ArrayList<Material> material = new ArrayList<>();
        String query = "SELECT * FROM Material;";
        try (Connection connection = ConexionBD.getConnection(); Statement stm = connection.createStatement();) {
            ResultSet resultSet = stm.executeQuery(query);
            while (resultSet.next()) {
                int idArticulo = resultSet.getInt("id_articulo");
                String nombreArticulo = resultSet.getString("nombre");
                String unidadesDisponibles = resultSet.getString("unidades_disponibles");
                String unidadesNoDisponibles = resultSet.getString("unidades_no_disponibles");
                Material articulo = new Material(idArticulo, nombreArticulo, unidadesDisponibles,unidadesNoDisponibles);
                material.add(articulo);
            }
        } catch (SQLException e) {
            e.printStackTrace(); 
        }
        return material;
 }

    @Override
    public void eliminarArticulo(int idArticulo) {
         String sql = "DELETE FROM Material WHERE id_articulo LIKE ?;";
        try {
            Connection connection = ConexionBD.getConnection();
            PreparedStatement pst = connection.prepareStatement(sql);
            pst.setInt(1, idArticulo);
            pst.executeUpdate();
            
        } catch (SQLException ex) {
            ex.printStackTrace();
        }
    }

    @Override
    public void agregarArticulo(Material articulo) {
        String sql = "INSERT INTO Material (nombre, unidades_disponibles, unidades_no_disponibles) VALUES (?, ?, ?)";
        try (Connection connection = ConexionBD.getConnection();
             PreparedStatement pst = connection.prepareStatement(sql)) {
            
            pst.setString(1, articulo.getNombreArticulo());
            pst.setString(2, articulo.getUnidadesDisponibles());
            pst.setString(3, articulo.getUnidadesNoDisponibles());
            pst.executeUpdate();
            
        } catch (SQLException ex) {
            ex.printStackTrace();
        }
    }
    
}
