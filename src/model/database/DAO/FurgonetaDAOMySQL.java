/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package model.database.DAO;
import java.sql.*;
import java.util.ArrayList;
import model.database.ConexionBD;
import model.database.Furgoneta;


/**
 *
 * @author neira
 */
public class FurgonetaDAOMySQL implements FurgonetaDAO {    

    @Override
    public ArrayList<Furgoneta> mostrarFurgonetas() {
        ArrayList<Furgoneta> furgonetas = new ArrayList<>();
        String query = "SELECT * FROM Furgonetas;";
        try (Connection connection = ConexionBD.getConnection(); Statement stm = connection.createStatement();) {
            ResultSet resultSet = stm.executeQuery(query);
            while (resultSet.next()) {
                int idFurgoneta = resultSet.getInt("id_furgoneta");
                String modeloFurgoneta = resultSet.getString("modelo");
                Furgoneta furgoneta = new Furgoneta(idFurgoneta, modeloFurgoneta);
                furgonetas.add(furgoneta);
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return furgonetas;
    }

    @Override
    public void eliminarFurgoneta(int idFurgoneta) {
        String sql = "DELETE FROM Furgonetas WHERE id_furgoneta LIKE ?;";
        try {
            Connection connection = ConexionBD.getConnection();
            PreparedStatement pst = connection.prepareStatement(sql);
            pst.setInt(1, idFurgoneta);
            pst.executeUpdate();
            
        } catch (SQLException ex) {
            ex.printStackTrace();
        }
    }

    @Override
    public void agregarFurgoneta(Furgoneta furgoneta) {
        String sql = "INSERT INTO Furgonetas (modelo) VALUES (?)";
        try (Connection connection = ConexionBD.getConnection();
             PreparedStatement pst = connection.prepareStatement(sql)) {
            
            pst.setString(1, furgoneta.getModeloFurgoneta());
            pst.executeUpdate();
        } catch (SQLException ex) {
            ex.printStackTrace();
        }
    }
    
 }
