/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/GUIForms/JFrame.java to edit this template
 */
package Interface;

import Controller.Controller;
import Objects.ApplianceCategory;
import java.util.Vector;
import javax.swing.table.DefaultTableModel;

public class VGUConsultarCatElectrodomesticos extends javax.swing.JFrame {

    /**
     * Creates new form VMUConsultarEmpleados
     */
    private DefaultTableModel modeloTabla;
    public Controller controlador;
    
    public VGUConsultarCatElectrodomesticos(Controller controlador) {
        this.controlador = controlador;
        this.modeloTabla = new DefaultTableModel();
        initComponents();
        cargarData();
    }
    
    public void cargarData(){
        modeloTabla.addColumn("Nombre");
        modeloTabla.addColumn("Características");
        
        Vector<ApplianceCategory> categoriaElectrodomesticos = controlador.consultarCategoriaElectrodomesticos();
        modeloTabla.setRowCount(0);

        // Agregar filas con los datos de los clientes al modelo de la tabla
        for (ApplianceCategory categoriaElectrodomestico : categoriaElectrodomesticos) {
            Object[] fila = {categoriaElectrodomestico.getName(), categoriaElectrodomestico.getCharacteristics()};
            modeloTabla.addRow(fila);
        }
    
    }

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jScrollPane1 = new javax.swing.JScrollPane();
        jTable1 = new javax.swing.JTable();

        jTable1.setModel(modeloTabla);
        jScrollPane1.setViewportView(jTable1);

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jScrollPane1, javax.swing.GroupLayout.DEFAULT_SIZE, 388, Short.MAX_VALUE)
                .addContainerGap())
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jScrollPane1, javax.swing.GroupLayout.DEFAULT_SIZE, 288, Short.MAX_VALUE)
                .addContainerGap())
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JTable jTable1;
    // End of variables declaration//GEN-END:variables
}
