/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package controller;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;
import javax.swing.JFrame;
import javax.swing.JOptionPane;
import javax.swing.JTable;
import javax.swing.table.DefaultTableModel;
import model.database.DAO.EventosDAO;
import model.database.DAO.EventosDAOMySQL;
import model.database.Evento;
import view.clientes.AddClienteDialog;
import view.eventos.AddEventoDialog;
import view.eventos.EventosDialog;
import view.login.LoginJFrame;


/* FALTA COMPLETAR METODOS PARA AÑADIR/ELIMINAR/VOLVER Y REVISAR QUE CARGUE LA QUERY DESDE EL ARCHIVO DE LA CONSULTA Y MUESTRE */

/**
 *
 * @author neira
 */
public class EventosController {
    private final EventosDialog view;
    private final EventosDAO eventosDAO;
    private final JFrame mainView;

    public EventosController(EventosDialog view) {
        this.view = view;
        this.mainView = new LoginJFrame();
        this.eventosDAO = new EventosDAOMySQL();
        this.view.setAddEventoActionListener(addEventoListener());
        /*this.view.setEliminarEventoActionListener(eliminarEventoListener());*/
        this.view.setVolverEventosActionListener(volverEventosActionListener());
        cargarEventos();
    }
    
        private void cargarEventos() {
        ArrayList<Evento> eventos = eventosDAO.mostrarEventos();
        view.mostrarEventos(eventos);
    }
        
        public void actualizarTablaEventos(){
        ArrayList<Evento> eventos = eventosDAO.mostrarEventos();
        DefaultTableModel modeloTablaPersonal = (DefaultTableModel) view.getEventosTabla().getModel();
        modeloTablaPersonal.setRowCount(0);
        for(Evento evento : eventos){
            modeloTablaPersonal.addRow(new Object[]{
                evento.getIdEvento(),
                evento.getCliente(),
                evento.getEmpleados(),
                evento.getTipoEvento(),
                evento.getTipoPack(),
                evento.getDescripcionPack(),
                evento.getImportePack(),
                evento.getFurgoneta(),
                evento.getFotomaton(),
                evento.getKaraoke(),
                evento.getProyeccion(),
                evento.getImporteBaseFotomaton(),
                evento.getImporteBaseKaraoke(),
                evento.getImporteBaseProyeccion(),
                evento.getHorasExtraDisco(),
                evento.getHorasExtraFotomaton(),
                evento.getImporteHorasExtraFotomaton(),
                evento.getImporteTotal(),
                evento.getImporteIVA(),
                evento.getImporteTotalConIVA()
            });
        }   
    }  
        
       private ActionListener addEventoListener(){
        ActionListener al = new ActionListener(){
            @Override
            public void actionPerformed(ActionEvent e) {
              AddEventoDialog dialog = new AddEventoDialog(mainView, true);
              AddEventoController aec = new AddEventoController(dialog,eventosDAO);
              view.dispose();
              dialog.setLocationRelativeTo(null);
              dialog.setVisible(true);
            }   
        };
        return al;
    }    
        
        /*private ActionListener eliminarClienteListener(){
            ActionListener al = new ActionListener() {
                @Override
                public void actionPerformed(ActionEvent e) {
                    JTable tabla = view.getClientesTabla();
                    int filaSeleccionada = tabla.getSelectedRow();

                if (filaSeleccionada != -1) {
                    int confirmacion = JOptionPane.showConfirmDialog(view, "¿Está seguro de que desea eliminar el cliente seleccionado?", "Eliminar cliente", JOptionPane.YES_NO_OPTION);
                    if (confirmacion == JOptionPane.YES_OPTION) {
                        int idCliente = (int) tabla.getValueAt(filaSeleccionada, 0);
                        clientesDAO.eliminarCliente(idCliente);
                        actualizarTablaClientes();
                    }
                } else {
                    JOptionPane.showMessageDialog(view, "Debe seleccionar un cliente para eliminar", "Error", JOptionPane.WARNING_MESSAGE);
                }
            }
        };
        return al;
        } */
        
        private ActionListener volverEventosActionListener(){
        ActionListener al = new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                view.dispose();
            }
        };
        return al;
    } 
}
