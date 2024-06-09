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
import model.database.DAO.MaterialDAO;
import model.database.DAO.MaterialDAOMySQL;
import model.database.Material;
import view.login.LoginJFrame;
import view.material.AddMaterialDialog;
import view.material.MaterialDialog;

/**
 *
 * @author neira
 */
public class MaterialController {
    private final MaterialDialog view;
    private final MaterialDAO materialDAO;
    private final JFrame mainView;

    public MaterialController(MaterialDialog view) {
        this.view = view;
        this.mainView = new LoginJFrame();
        this.materialDAO = new MaterialDAOMySQL(); 
        this.view.setAddArticuloActionListener(addArticuloListener());
        this.view.setEliminarArticuloActionListener(eliminarArticuloListener());
        this.view.setVolverMaterialActionListener(volverMaterialListener());
        cargarMaterial();
    }
    
    private void cargarMaterial() {
        ArrayList<Material> articulo = materialDAO.mostrarCliente();
        view.mostrarMaterial(articulo);
    }
    
    public void actualizarTablaMaterial(){
        ArrayList<Material> material = materialDAO.mostrarCliente();
        DefaultTableModel modeloTablaPersonal = (DefaultTableModel) view.getMaterialTabla().getModel();
        modeloTablaPersonal.setRowCount(0);
        for(Material articulo : material){
            modeloTablaPersonal.addRow(new Object[]{
                articulo.getIdArticulo(),
                articulo.getNombreArticulo(),
                articulo.getUnidadesDisponibles(),
                articulo.getUnidadesNoDisponibles()
            });
        }   
    }  
    
    private ActionListener addArticuloListener(){
        ActionListener al = new ActionListener(){
            @Override
            public void actionPerformed(ActionEvent e) {
              AddMaterialDialog dialog = new AddMaterialDialog(mainView, true);
              AddMaterialController amc = new AddMaterialController(dialog,materialDAO);
              view.dispose();
              dialog.setLocationRelativeTo(null);
              dialog.setVisible(true);
            }   
        };
        return al;
    }    
    
            private ActionListener eliminarArticuloListener(){
            ActionListener al = new ActionListener() {
                @Override
                public void actionPerformed(ActionEvent e) {
                    JTable tabla = view.getMaterialTabla();
                    int filaSeleccionada = tabla.getSelectedRow();

                if (filaSeleccionada != -1) {
                    int confirmacion = JOptionPane.showConfirmDialog(view, "¿Está seguro de que desea eliminar el articulo seleccionado?", "Eliminar articulo", JOptionPane.YES_NO_OPTION);
                    if (confirmacion == JOptionPane.YES_OPTION) {
                        int idArticulo = (int) tabla.getValueAt(filaSeleccionada, 0);
                        materialDAO.eliminarArticulo(idArticulo);
                        actualizarTablaMaterial();
                    }
                } else {
                    JOptionPane.showMessageDialog(view, "Debe seleccionar un articulo para eliminar", "Error", JOptionPane.WARNING_MESSAGE);
                }
            }
        };
        return al;
        }
            
        private ActionListener volverMaterialListener(){
            ActionListener al = new ActionListener() {
                @Override
                public void actionPerformed(ActionEvent e) {
                    view.dispose();
                }
            };
            return al;
        }    
}
