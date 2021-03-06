/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Capa_Cliente;

import Capa_Negocio.clsAmbiente;
import java.util.ArrayList;
import javax.swing.JOptionPane;
import javax.swing.table.DefaultTableModel;

/**
 *
 * @author User
 */
public class jd_BuscarAmbiente extends javax.swing.JDialog {

    boolean buscando = false;
    /**
     * Creates new form jd_BuscarAmbiente
     */
    public jd_BuscarAmbiente(java.awt.Frame parent, boolean modal) {
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
        jScrollPane1 = new javax.swing.JScrollPane();
        tblAmbientes = new javax.swing.JTable();
        jLabel2 = new javax.swing.JLabel();
        txtBuscarAmbientes = new javax.swing.JTextField();
        jLabel1 = new javax.swing.JLabel();

        setDefaultCloseOperation(javax.swing.WindowConstants.DISPOSE_ON_CLOSE);

        jPanel1.setBackground(new java.awt.Color(88, 111, 124));

        tblAmbientes.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {},
                {},
                {},
                {}
            },
            new String [] {

            }
        ));
        tblAmbientes.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                tblAmbientesMouseClicked(evt);
            }
        });
        jScrollPane1.setViewportView(tblAmbientes);

        jLabel2.setText("Ingrese nombre:");

        txtBuscarAmbientes.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyReleased(java.awt.event.KeyEvent evt) {
                txtBuscarAmbientesKeyReleased(evt);
            }
        });

        jLabel1.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        jLabel1.setText("Buscar Ambientes");

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addGap(16, 16, 16)
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 443, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addGroup(jPanel1Layout.createSequentialGroup()
                                .addComponent(jLabel2)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                                .addComponent(txtBuscarAmbientes, javax.swing.GroupLayout.PREFERRED_SIZE, 353, javax.swing.GroupLayout.PREFERRED_SIZE))))
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addGap(157, 157, 157)
                        .addComponent(jLabel1)))
                .addContainerGap(16, Short.MAX_VALUE))
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel1Layout.createSequentialGroup()
                .addGap(29, 29, 29)
                .addComponent(jLabel1)
                .addGap(18, 18, 18)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel2)
                    .addComponent(txtBuscarAmbientes, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(18, 18, 18)
                .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 196, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(14, Short.MAX_VALUE))
        );

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jPanel1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addContainerGap())
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jPanel1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addContainerGap())
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void txtBuscarAmbientesKeyReleased(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_txtBuscarAmbientesKeyReleased
        // TODO add your handling code here:
        try {
            if (!txtBuscarAmbientes.getText().equals("")) {
                clsAmbiente objA = new clsAmbiente();
                ArrayList<clsAmbiente> busqueda = objA.buscar(txtBuscarAmbientes.getText());
                if (busqueda.size() > 0) {
                    DefaultTableModel modelo = new DefaultTableModel();
                    modelo.addColumn("Código");
                    modelo.addColumn("Nombre");
                    modelo.addColumn("Descripción");
                    modelo.addColumn("Estado");
                    tblAmbientes.setModel(modelo);

                    busqueda.forEach(a -> {
                        modelo.addRow(new Object[]{
                            a.getId(),
                            a.getNombre(),
                            a.getDescripcion(),
                            a.getEstado()});
                    });
                } else {
                    JOptionPane.showMessageDialog(this, "No se encontró ambiente");
                }
            } else {
                JOptionPane.showMessageDialog(this, "Ingrese un nombre válido");
                txtBuscarAmbientes.requestFocus();
            }
        } catch (Exception e) {
            JOptionPane.showMessageDialog(this, "Error al buscar Ambiente");
        }
    }//GEN-LAST:event_txtBuscarAmbientesKeyReleased

    private void tblAmbientesMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_tblAmbientesMouseClicked
        // TODO add your handling code here:
        if(!txtBuscarAmbientes.equals("")){
           try {
                dispose();
            } catch (Exception e) {
            JOptionPane.showMessageDialog(rootPane, e.getMessage());
            } 
        } 
         
    }//GEN-LAST:event_tblAmbientesMouseClicked

    
    public int getCod(){
        try {
            return Integer.parseInt(String.valueOf(tblAmbientes.getValueAt(tblAmbientes.getSelectedRow(), 0)));
        } catch (Exception e) {
            JOptionPane.showMessageDialog(rootPane, e.getMessage());
        }
        return -1;
    }
    
    public String getNom(){
        try {
            return (tblAmbientes.getValueAt(tblAmbientes.getSelectedRow(), 1)).toString();
        } catch (Exception e) {
            JOptionPane.showMessageDialog(rootPane, e.getMessage());
        }
        return "";
    }
    
    
    /**
     * @param args the command line arguments
     */
    

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JTable tblAmbientes;
    private javax.swing.JTextField txtBuscarAmbientes;
    // End of variables declaration//GEN-END:variables
}
