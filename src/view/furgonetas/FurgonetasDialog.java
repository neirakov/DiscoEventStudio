/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/GUIForms/JDialog.java to edit this template
 */
package view.furgonetas;

import java.awt.event.ActionListener;
import java.util.ArrayList;
import javax.swing.JTable;
import javax.swing.table.DefaultTableModel;
import model.database.Furgoneta;

/**
 *
 * @author neira
 */
public class FurgonetasDialog extends javax.swing.JDialog {

    /**
     * Creates new form PersonalDialog
     */
    public FurgonetasDialog(java.awt.Frame parent, boolean modal) {
        super(parent, modal);
        initComponents();
    }

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jPanel1 = new javax.swing.JPanel();
        jLabel1 = new javax.swing.JLabel();
        jScrollPane2 = new javax.swing.JScrollPane();
        tablaFurgonetas = new javax.swing.JTable();
        btnAddFurgoneta = new javax.swing.JButton();
        btnEliminarFurgoneta = new javax.swing.JButton();
        btnVolverFurgonetas = new javax.swing.JButton();

        setDefaultCloseOperation(javax.swing.WindowConstants.DISPOSE_ON_CLOSE);
        setTitle("Personal");

        jPanel1.setBackground(new java.awt.Color(17, 53, 96));

        jLabel1.setFont(new java.awt.Font("Segoe UI", 1, 20)); // NOI18N
        jLabel1.setForeground(new java.awt.Color(255, 255, 255));
        jLabel1.setText("Gestión de vehiculos");

        tablaFurgonetas.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {null, null},
                {null, null},
                {null, null},
                {null, null}
            },
            new String [] {
                "ID Vehiculo", "Modelo"
            }
        ) {
            boolean[] canEdit = new boolean [] {
                false, false
            };

            public boolean isCellEditable(int rowIndex, int columnIndex) {
                return canEdit [columnIndex];
            }
        });
        jScrollPane2.setViewportView(tablaFurgonetas);

        btnAddFurgoneta.setBackground(new java.awt.Color(251, 234, 136));
        btnAddFurgoneta.setFont(new java.awt.Font("Segoe UI", 1, 12)); // NOI18N
        btnAddFurgoneta.setForeground(new java.awt.Color(17, 53, 96));
        btnAddFurgoneta.setIcon(new javax.swing.ImageIcon(getClass().getResource("/resources/images/plus-5-32.png"))); // NOI18N
        btnAddFurgoneta.setText("Añadir Vehiculo");
        btnAddFurgoneta.setHorizontalAlignment(javax.swing.SwingConstants.LEFT);

        btnEliminarFurgoneta.setBackground(new java.awt.Color(251, 234, 136));
        btnEliminarFurgoneta.setFont(new java.awt.Font("Segoe UI", 1, 12)); // NOI18N
        btnEliminarFurgoneta.setForeground(new java.awt.Color(17, 53, 96));
        btnEliminarFurgoneta.setIcon(new javax.swing.ImageIcon(getClass().getResource("/resources/images/x-mark-4-32.png"))); // NOI18N
        btnEliminarFurgoneta.setText("Eliminar Vehiculo");
        btnEliminarFurgoneta.setHorizontalAlignment(javax.swing.SwingConstants.LEFT);

        btnVolverFurgonetas.setBackground(new java.awt.Color(251, 234, 136));
        btnVolverFurgonetas.setFont(new java.awt.Font("Segoe UI", 1, 12)); // NOI18N
        btnVolverFurgonetas.setForeground(new java.awt.Color(17, 53, 96));
        btnVolverFurgonetas.setIcon(new javax.swing.ImageIcon(getClass().getResource("/resources/images/volver32.png"))); // NOI18N
        btnVolverFurgonetas.setText("Volver");
        btnVolverFurgonetas.setHorizontalAlignment(javax.swing.SwingConstants.LEFT);

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addGap(12, 12, 12)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addComponent(jLabel1)
                        .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addComponent(jScrollPane2, javax.swing.GroupLayout.DEFAULT_SIZE, 595, Short.MAX_VALUE)
                        .addGap(18, 18, 18)
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                            .addComponent(btnEliminarFurgoneta, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addComponent(btnVolverFurgonetas, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addComponent(btnAddFurgoneta, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                        .addGap(16, 16, 16))))
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jLabel1)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jScrollPane2, javax.swing.GroupLayout.PREFERRED_SIZE, 312, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addComponent(btnAddFurgoneta, javax.swing.GroupLayout.PREFERRED_SIZE, 37, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(18, 18, 18)
                        .addComponent(btnEliminarFurgoneta, javax.swing.GroupLayout.PREFERRED_SIZE, 37, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(18, 18, 18)
                        .addComponent(btnVolverFurgonetas, javax.swing.GroupLayout.PREFERRED_SIZE, 37, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addContainerGap(19, Short.MAX_VALUE))
        );

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(jPanel1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    /**
     * @param args the command line arguments
     * @return 
     */
    
    public void setAddFurgonetaActionListener(ActionListener listener){
        this.btnAddFurgoneta.addActionListener(listener);
    }
    
    public void setEliminarFurgonetaActionListener(ActionListener listener){
        this.btnEliminarFurgoneta.addActionListener(listener);
    }
    
    public void setVolverFurgonetasActionListener(ActionListener listener){
        this.btnVolverFurgonetas.addActionListener(listener);
    }
   
    public JTable getFurgonetasTabla(){
        return tablaFurgonetas;
    }
    
    public void mostrarFurgonetas(ArrayList<Furgoneta> furgonetas) {
        DefaultTableModel modeloTabla = (DefaultTableModel) tablaFurgonetas.getModel();
       
        modeloTabla.setRowCount(0);

        for (Furgoneta furgoneta : furgonetas) {
            Object[] fila = {furgoneta.getIdFurgoneta(),furgoneta.getModeloFurgoneta()};
            modeloTabla.addRow(fila);
        }

        tablaFurgonetas.setSelectionMode(javax.swing.ListSelectionModel.SINGLE_SELECTION);
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton btnAddFurgoneta;
    private javax.swing.JButton btnEliminarFurgoneta;
    private javax.swing.JButton btnVolverFurgonetas;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JScrollPane jScrollPane2;
    private javax.swing.JTable tablaFurgonetas;
    // End of variables declaration//GEN-END:variables
}
