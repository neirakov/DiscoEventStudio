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
import model.database.DAO.FurgonetaDAO;
import model.database.DAO.FurgonetaDAOMySQL;
import model.database.Furgoneta;
import view.furgonetas.AddFurgonetaDialog;
import view.furgonetas.FurgonetasDialog;
import view.login.LoginJFrame;

/**
 *
 * @author neira
 */
public class FurgonetasController {
    private final FurgonetasDialog view;
    private final FurgonetaDAO furgonetasDAO;
    private final JFrame mainView;

    public FurgonetasController(FurgonetasDialog view) {
        this.view = view;
        this.mainView = new LoginJFrame();
        this.furgonetasDAO = new FurgonetaDAOMySQL();
        this.view.setAddFurgonetaActionListener(addFurgonetaListener());
        this.view.setEliminarFurgonetaActionListener(eliminarFurgonetaListener());
        this.view.setVolverFurgonetasActionListener(volverFurgonetasListener());
        cargarFurgonetas();
    }
    
    private void cargarFurgonetas() {
        ArrayList<Furgoneta> furgoneta = furgonetasDAO.mostrarFurgonetas();
        view.mostrarFurgonetas(furgoneta);
    }
    
    public void actualizarTablaFurgonetas(){
        ArrayList<Furgoneta> furgonetas = furgonetasDAO.mostrarFurgonetas();
        DefaultTableModel modeloTablaFurgonetas = (DefaultTableModel) view.getFurgonetasTabla().getModel();
        modeloTablaFurgonetas.setRowCount(0);
        for(Furgoneta furgoneta : furgonetas){
            modeloTablaFurgonetas.addRow(new Object[]{
                furgoneta.getIdFurgoneta(),
                furgoneta.getModeloFurgoneta(),
            });
        }   
    }  
    
    private ActionListener addFurgonetaListener(){
        ActionListener al = new ActionListener(){
            @Override
            public void actionPerformed(ActionEvent e) {
              AddFurgonetaDialog dialog = new AddFurgonetaDialog(mainView, true);
              AddFurgonetaController amc = new AddFurgonetaController(dialog,furgonetasDAO);
              view.dispose();
              dialog.setLocationRelativeTo(null);
              dialog.setVisible(true);
            }   
        };
        return al;
    }    
    
            private ActionListener eliminarFurgonetaListener(){
            ActionListener al = new ActionListener() {
                @Override
                public void actionPerformed(ActionEvent e) {
                    JTable tabla = view.getFurgonetasTabla();
                    int filaSeleccionada = tabla.getSelectedRow();

                if (filaSeleccionada != -1) {
                    int confirmacion = JOptionPane.showConfirmDialog(view, "¿Está seguro de que desea eliminar el vehiculo seleccionado?", "Eliminar vehiculo", JOptionPane.YES_NO_OPTION);
                    if (confirmacion == JOptionPane.YES_OPTION) {
                        int idFurgoneta = (int) tabla.getValueAt(filaSeleccionada, 0);
                        furgonetasDAO.eliminarFurgoneta(idFurgoneta);
                        actualizarTablaFurgonetas();
                    }
                } else {
                    JOptionPane.showMessageDialog(view, "Debe seleccionar un vehiculo para eliminar", "Error", JOptionPane.WARNING_MESSAGE);
                }
            }
        };
        return al;
        }
            
        private ActionListener volverFurgonetasListener(){
            ActionListener al = new ActionListener() {
                @Override
                public void actionPerformed(ActionEvent e) {
                    view.dispose();
                }
            };
            return al;
        }    
}
