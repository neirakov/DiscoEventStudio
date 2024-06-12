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
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.logging.Level;
import java.util.logging.Logger;
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
                String fechaEvento = resultSet.getString("fecha_evento");
                String importeTotalConIVA = resultSet.getString("importe_total_con_iva");
                
                Evento evento = new Evento(idEvento,cliente,empleados,tipoPack,furgoneta,fotomaton,karaoke,proyeccion,fechaEvento,importeTotalConIVA);
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
    public boolean agregarEvento(Evento evento, int idEmpleado, int idEmpleado2) {
        boolean agregado = false;
        String sql = "INSERT INTO Eventos (id_cliente, id_furgoneta, tipo_evento, id_tipo_boda, id_tipo_fiesta, fecha_evento, fotomaton, karaoke, proyeccion, horas_extra_disco, horas_extra_fotomaton) VALUES (?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?)";
        
            try (Connection connection = ConexionBD.getConnection();
             PreparedStatement pst = connection.prepareStatement(sql,PreparedStatement.RETURN_GENERATED_KEYS)) {
             ClientesDAOMySQL cd = new ClientesDAOMySQL();
             
                pst.setInt(1,cd.obtenerIdClientePorNombre(evento.getCliente()) );
                pst.setInt(2, Integer.parseInt(evento.getFurgoneta()));
                pst.setString(3, evento.getTipoEvento());
                
                String tipoPack = evento.getTipoPack();
                switch(tipoPack){
                    case "Base" -> tipoPack = "1";
                    case "Pro" -> tipoPack = "2";
                    case "Diamante" -> tipoPack = "3";
                    case "Platino" -> tipoPack = "4";
                    default -> tipoPack = "NULL";
                }
                
                if(tipoPack.equals("NULL")){
                   pst.setString(4, tipoPack);
                }else{
                    pst.setInt(4, Integer.parseInt(tipoPack));
                }
               
                boolean proyeccion = Boolean.parseBoolean(evento.getProyeccion());
                boolean karaoke = Boolean.parseBoolean(evento.getKaraoke());
                boolean fotomaton = Boolean.parseBoolean(evento.getFotomaton());
                
                String fechaEvento = evento.getFechaEvento();
                SimpleDateFormat sdf = new SimpleDateFormat("dd/MM/yyyy");
                java.util.Date fechaFormateada = null;
            try {
                fechaFormateada = sdf.parse(fechaEvento);
            } catch (ParseException ex) {
                Logger.getLogger(EventosDAOMySQL.class.getName()).log(Level.SEVERE, null, ex);
            }
                java.sql.Date fechaSQL = new java.sql.Date(fechaFormateada.getTime());
                
                pst.setString(5, null);
                pst.setDate(6, fechaSQL);
                pst.setBoolean(7, fotomaton);
                pst.setBoolean(8, karaoke);
                pst.setBoolean(9, proyeccion);
                pst.setString(10, evento.getHorasExtraDisco());
                pst.setString(11, evento.getHorasExtraFotomaton());
                
                
                pst.executeUpdate(); 
                
                ResultSet idGenerado = pst.getGeneratedKeys();
                if(idGenerado.next()){
                    int idEventoGenerado = idGenerado.getInt(1);
                    agregarEmpleadoEvento(idEventoGenerado,idEmpleado);
                    if(idEmpleado2!=0){
                       agregarEmpleadoEvento(idEventoGenerado,idEmpleado2);
                    }
                }
                
                agregado = true;
             
        } catch (SQLException ex) {
            Logger.getLogger(EventosDAOMySQL.class.getName()).log(Level.SEVERE, null, ex);
        }
            return agregado;
    }

    @Override
    public void agregarEmpleadoEvento(int idEventoGenerado, int idEmpleado) {
        String sqlEmpleadosEvento = "INSERT INTO Empleados_Eventos (id_empleado, id_evento) VALUES (?, ?)";
        
        try (Connection connection = ConexionBD.getConnection();
         PreparedStatement pst = connection.prepareStatement(sqlEmpleadosEvento)) {
             ClientesDAOMySQL cd = new ClientesDAOMySQL();
             
             pst.setInt(1, idEmpleado);
             pst.setInt(2, idEventoGenerado);
             pst.executeUpdate();
        
        } catch (SQLException ex) {
            Logger.getLogger(EventosDAOMySQL.class.getName()).log(Level.SEVERE, null, ex);
        }
        
    }
    
}
