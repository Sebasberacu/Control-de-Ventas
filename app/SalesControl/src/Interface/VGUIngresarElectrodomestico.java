/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/GUIForms/JFrame.java to edit this template
 */
package Interface;

import Controller.Controller;
import Objects.ApplianceCategory;
import Objects.Appliance;
import Objects.Employee;
import Objects.Branch;
import java.util.ArrayList;
import java.util.Vector;
import javax.swing.DefaultComboBoxModel;
import javax.swing.JOptionPane;

/**/
public class VGUIngresarElectrodomestico extends javax.swing.JFrame {

    /**
     * Creates new form VGUIngresarElectrodomestico
     */
    DefaultComboBoxModel<String> modelCategoria;
    DefaultComboBoxModel<String> modelEmpleado;
    DefaultComboBoxModel<String> modelSucursal;
    
    public Controller controlador;
    public VGUIngresarElectrodomestico(Controller controlador) {
        this.controlador = controlador;
        this.modelCategoria = new DefaultComboBoxModel<>();
        this.modelEmpleado = new DefaultComboBoxModel<>();
        this.modelSucursal = new DefaultComboBoxModel<>();
        initComponents();
        setComboBoxes();
    }
    
    public void setComboBoxes(){
        Vector<ApplianceCategory> categoriasElectrodomesticos = controlador.consultarCategoriaElectrodomesticos();
        ArrayList<Employee> empleados = controlador.consultarEmpleados();
        Vector<Branch> sucursales = controlador.consultarSucursales();
                
        for (ApplianceCategory categoriaElectrodomestico : categoriasElectrodomesticos){
            modelCategoria.addElement(categoriaElectrodomestico.getName());
        }
        for (Employee empleado: empleados){
            modelEmpleado.addElement(empleado.getName());
        }
        for (Branch sucursal : sucursales){
            modelSucursal.addElement(sucursal.getName());
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

        lblDescripcion = new javax.swing.JLabel();
        inptDescripcion = new javax.swing.JTextField();
        lblDescripcion1 = new javax.swing.JLabel();
        lblDescripcion2 = new javax.swing.JLabel();
        lblDescripcion3 = new javax.swing.JLabel();
        inptCategoria = new javax.swing.JComboBox<>();
        inptEmpleado = new javax.swing.JComboBox<>();
        inptSucursal = new javax.swing.JComboBox<>();
        btnAceptar = new javax.swing.JButton();
        btnCerrar = new javax.swing.JButton();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);

        lblDescripcion.setText("Descripción:");

        lblDescripcion1.setText("Categoría:");

        lblDescripcion2.setText("Empleado:");

        lblDescripcion3.setText("Sucursal:");

        inptCategoria.setModel(modelCategoria);

        inptEmpleado.setModel(modelEmpleado
        );

        inptSucursal.setModel(modelSucursal);

        btnAceptar.setText("Aceptar");
        btnAceptar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnAceptarActionPerformed(evt);
            }
        });

        btnCerrar.setText("Cerrar");
        btnCerrar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnCerrarActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(26, 26, 26)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(btnAceptar)
                        .addGap(18, 18, 18)
                        .addComponent(btnCerrar))
                    .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                        .addComponent(lblDescripcion3)
                        .addComponent(lblDescripcion2)
                        .addComponent(lblDescripcion1)
                        .addComponent(lblDescripcion)
                        .addComponent(inptDescripcion)
                        .addComponent(inptCategoria, 0, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addComponent(inptEmpleado, 0, 308, Short.MAX_VALUE)
                        .addComponent(inptSucursal, 0, 308, Short.MAX_VALUE)))
                .addContainerGap(66, Short.MAX_VALUE))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(21, 21, 21)
                .addComponent(lblDescripcion)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(inptDescripcion, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(lblDescripcion1)
                .addGap(5, 5, 5)
                .addComponent(inptCategoria, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18)
                .addComponent(lblDescripcion2)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(inptEmpleado, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18)
                .addComponent(lblDescripcion3)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(inptSucursal, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(btnAceptar)
                    .addComponent(btnCerrar))
                .addContainerGap(20, Short.MAX_VALUE))
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void btnAceptarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnAceptarActionPerformed
        // TODO add your handling code here:
        String descripcion = inptDescripcion.getText();
        ApplianceCategory categoria = controlador.consultarCategoriaElectrodomestico((String)inptCategoria.getSelectedItem());
        Employee empleado = controlador.consultarEmpleado((String)inptEmpleado.getSelectedItem());
        Branch sucursal = controlador.consultarSucursal((String)inptSucursal.getSelectedItem());
        
        if (categoria == null) categoria = new ApplianceCategory();
        if (empleado == null) empleado = new Employee("","","","");
        if (sucursal == null) sucursal = new Branch();
        
        
        Appliance nuevoElectrodomestico = new Appliance(descripcion, categoria, empleado, sucursal);
        if (controlador.ingresarElectrodomestico(nuevoElectrodomestico)){
            JOptionPane.showMessageDialog(this, "Electrodoméstico ingresado con éxito.", "Éxito", JOptionPane.INFORMATION_MESSAGE);
        } else {
            JOptionPane.showMessageDialog(this, "No fue posible ingresar el electrodoméstico. Puede deberse a que pertenece a otro catálogo.", "Error", JOptionPane.ERROR_MESSAGE);
        }
        this.setVisible(false);        

    }//GEN-LAST:event_btnAceptarActionPerformed

    private void btnCerrarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnCerrarActionPerformed
        // TODO add your handling code here:
        this.setVisible(false);        
    }//GEN-LAST:event_btnCerrarActionPerformed


    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton btnAceptar;
    private javax.swing.JButton btnCerrar;
    private javax.swing.JComboBox<String> inptCategoria;
    private javax.swing.JTextField inptDescripcion;
    private javax.swing.JComboBox<String> inptEmpleado;
    private javax.swing.JComboBox<String> inptSucursal;
    private javax.swing.JLabel lblDescripcion;
    private javax.swing.JLabel lblDescripcion1;
    private javax.swing.JLabel lblDescripcion2;
    private javax.swing.JLabel lblDescripcion3;
    // End of variables declaration//GEN-END:variables
}
