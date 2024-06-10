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
import model.database.Evento;
import model.database.ReadSQL;

/**
 *
 * @author neira
 */
public class EventosDAOMySQL implements EventosDAO {

    @Override
    public ArrayList<Evento> mostrarEventos() {
        ArrayList<Evento> eventos = new ArrayList<>();
        String query = ReadSQL.read("src/resources/Querys/ConsultaEvento.sql");
        try (Connection connection = ConexionBD.getConnection(); Statement stm = connection.createStatement();) {
            ResultSet resultSet = stm.executeQuery(query);
            while (resultSet.next()) {
                int idEvento = resultSet.getInt("id_evento");
                String cliente = resultSet.getString("cliente");
                String tipoPack = resultSet.getString("tipo_pack");
                String empleados = resultSet.getString("empleados");
                String furgoneta = resultSet.getString("furgoneta");
                String fotomaton = resultSet.getString("fotomaton");
                String karaoke = resultSet.getString("karaoke");
                String proyeccion = resultSet.getString("proyeccion");
                String importeTotalConIVA = resultSet.getString("importe_total_con_iva");
                
                Evento evento = new Evento(idEvento,cliente,empleados,tipoPack,furgoneta,fotomaton,karaoke,proyeccion,importeTotalConIVA);
                eventos.add(evento);
            }
        } catch (SQLException e) {
            e.printStackTrace(); 
        }
        return eventos;
    }

    @Override
    public void eliminarEvento(int idEvento) {
        String sql = "DELETE FROM Eventos WHERE id_evento LIKE ?;";
            try {
                Connection connection = ConexionBD.getConnection();
                PreparedStatement pst = connection.prepareStatement(sql);
                pst.setInt(1, idEvento);
                pst.executeUpdate();
            
            } catch (SQLException ex) {
                ex.printStackTrace();
            }
        }

    @Override
    public void agregarEvento(Evento evento) {
        throw new UnsupportedOperationException("Not supported yet."); // Generated from nbfs://nbhost/SystemFileSystem/Templates/Classes/Code/GeneratedMethodBody
    }
    
}
