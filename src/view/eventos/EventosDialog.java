/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/GUIForms/JDialog.java to edit this template
 */
package view.eventos;

import java.awt.event.ActionListener;
import java.util.ArrayList;
import javax.swing.JTable;
import javax.swing.table.DefaultTableModel;
import model.database.Evento;

/**
 *
 * @author neira
 */
public class EventosDialog extends javax.swing.JDialog {

    /**
     * Creates new form PersonalDialog
     */
    public EventosDialog(java.awt.Frame parent, boolean modal) {
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
        tablaEventos = new javax.swing.JTable();
        btnAddEmpleado = new javax.swing.JButton();
        btnEliminarEmpleado = new javax.swing.JButton();
        btnVolver = new javax.swing.JButton();

        setDefaultCloseOperation(javax.swing.WindowConstants.DISPOSE_ON_CLOSE);
        setTitle("Personal");

        jPanel1.setBackground(new java.awt.Color(17, 53, 96));

        jLabel1.setFont(new java.awt.Font("Segoe UI", 1, 20)); // NOI18N
        jLabel1.setForeground(new java.awt.Color(255, 255, 255));
        jLabel1.setText("Gestión de eventos");

        tablaEventos.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {null, null, null, null, null, null, null, null, null, null},
                {null, null, null, null, null, null, null, null, null, null},
                {null, null, null, null, null, null, null, null, null, null},
                {null, null, null, null, null, null, null, null, null, null}
            },
            new String [] {
                "ID Evento", "Cliente", "Empleados", "Tipo Pack", "Furgoneta", "Fotomaton", "Karaoke", "Proyección", "Fecha", "Importe con IVA "
            }
        ) {
            boolean[] canEdit = new boolean [] {
                false, false, false, false, false, false, false, false, false, false
            };

            public boolean isCellEditable(int rowIndex, int columnIndex) {
                return canEdit [columnIndex];
            }
        });
        jScrollPane2.setViewportView(tablaEventos);

        btnAddEmpleado.setBackground(new java.awt.Color(251, 234, 136));
        btnAddEmpleado.setFont(new java.awt.Font("Segoe UI", 1, 12)); // NOI18N
        btnAddEmpleado.setForeground(new java.awt.Color(17, 53, 96));
        btnAddEmpleado.setIcon(new javax.swing.ImageIcon(getClass().getResource("/resources/images/plus-5-32.png"))); // NOI18N
        btnAddEmpleado.setText("Añadir Evento");
        btnAddEmpleado.setHorizontalAlignment(javax.swing.SwingConstants.LEFT);

        btnEliminarEmpleado.setBackground(new java.awt.Color(251, 234, 136));
        btnEliminarEmpleado.setFont(new java.awt.Font("Segoe UI", 1, 12)); // NOI18N
        btnEliminarEmpleado.setForeground(new java.awt.Color(17, 53, 96));
        btnEliminarEmpleado.setIcon(new javax.swing.ImageIcon(getClass().getResource("/resources/images/x-mark-4-32.png"))); // NOI18N
        btnEliminarEmpleado.setText("Eliminar Evento");
        btnEliminarEmpleado.setHorizontalAlignment(javax.swing.SwingConstants.LEFT);

        btnVolver.setBackground(new java.awt.Color(251, 234, 136));
        btnVolver.setFont(new java.awt.Font("Segoe UI", 1, 12)); // NOI18N
        btnVolver.setForeground(new java.awt.Color(17, 53, 96));
        btnVolver.setIcon(new javax.swing.ImageIcon(getClass().getResource("/resources/images/volver32.png"))); // NOI18N
        btnVolver.setText("Volver");
        btnVolver.setHorizontalAlignment(javax.swing.SwingConstants.LEFT);

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
                        .addComponent(jScrollPane2, javax.swing.GroupLayout.DEFAULT_SIZE, 1011, Short.MAX_VALUE)
                        .addGap(18, 18, 18)
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                            .addComponent(btnEliminarEmpleado, javax.swing.GroupLayout.DEFAULT_SIZE, 184, Short.MAX_VALUE)
                            .addComponent(btnVolver, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addComponent(btnAddEmpleado, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
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
                        .addComponent(btnAddEmpleado, javax.swing.GroupLayout.PREFERRED_SIZE, 37, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(18, 18, 18)
                        .addComponent(btnEliminarEmpleado, javax.swing.GroupLayout.PREFERRED_SIZE, 37, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(18, 18, 18)
                        .addComponent(btnVolver, javax.swing.GroupLayout.PREFERRED_SIZE, 37, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addContainerGap(45, Short.MAX_VALUE))
        );

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel1, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
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
    
    public void setAddEventoActionListener(ActionListener listener){
        this.btnAddEmpleado.addActionListener(listener);
    }
    
    public void setEliminarEventoActionListener(ActionListener listener){
        this.btnEliminarEmpleado.addActionListener(listener);
    }
    
    public void setVolverEventosActionListener(ActionListener listener){
        this.btnVolver.addActionListener(listener);
    }
   
    public JTable getEventosTabla(){
        return tablaEventos;
    }
    
    public void mostrarEventos(ArrayList<Evento> eventos) {
        DefaultTableModel modeloTabla = (DefaultTableModel) tablaEventos.getModel();
       
        modeloTabla.setRowCount(0);

        for (Evento evento : eventos) {
            Object[] fila = {evento.getIdEvento(),evento.getCliente(),evento.getTipoPack(),evento.getEmpleados(),evento.getFurgoneta(),evento.getFotomaton(),evento.getKaraoke(),evento.getProyeccion(),evento.getFechaEvento(),evento.getImporteTotalConIVA()};
            modeloTabla.addRow(fila);
        }
        
        tablaEventos.setSelectionMode(javax.swing.ListSelectionModel.SINGLE_SELECTION);
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton btnAddEmpleado;
    private javax.swing.JButton btnEliminarEmpleado;
    private javax.swing.JButton btnVolver;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JScrollPane jScrollPane2;
    private javax.swing.JTable tablaEventos;
    // End of variables declaration//GEN-END:variables
}
