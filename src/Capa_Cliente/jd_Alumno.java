/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Capa_Cliente;

import static Capa_Cliente.jd_Docente.dcFechaNacimiento;
import Capa_Negocio.clsAlumno;
import Capa_Negocio.clsAmbiente;
import javax.swing.JOptionPane;
import java.sql.Date;
import java.util.ArrayList;
import javax.management.ObjectName;
import javax.swing.JTable;
import javax.swing.table.DefaultTableModel;

/**
 *
 * @author USER
 */
public class jd_Alumno extends javax.swing.JFrame {

    /**
     * Creates new form frm_Alumno
     */
    public jd_Alumno() {
        initComponents();
        btn_darBaja.enableInputMethods(false);
        btn_modificar.enableInputMethods(false);
        btn_limpiar.enableInputMethods(false);
        cbo_estado.enable(false);
    }
    Character estado;
    //Boolean bandera;

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jPanel2 = new javax.swing.JPanel();
        btn_nuevo = new javax.swing.JButton();
        btn_modificar = new javax.swing.JButton();
        btn_limpiar = new javax.swing.JButton();
        btn_darBaja = new javax.swing.JButton();
        btn_buscarDni = new javax.swing.JButton();
        jLabel2 = new javax.swing.JLabel();
        txt_apellido = new javax.swing.JTextField();
        jLabel3 = new javax.swing.JLabel();
        btn_salir = new javax.swing.JButton();
        jLabel5 = new javax.swing.JLabel();
        jLabel6 = new javax.swing.JLabel();
        dc_fechaNacimiento = new com.toedter.calendar.JDateChooser();
        jLabel7 = new javax.swing.JLabel();
        txt_nombre = new javax.swing.JTextField();
        jLabel8 = new javax.swing.JLabel();
        jLabel4 = new javax.swing.JLabel();
        txt_direccion = new javax.swing.JTextField();
        txt_correo = new javax.swing.JTextField();
        txt_dni = new javax.swing.JTextField();
        cbo_estado = new javax.swing.JComboBox<>();
        jScrollPane1 = new javax.swing.JScrollPane();
        tbl_alumno = new javax.swing.JTable();
        jPanel1 = new javax.swing.JPanel();
        jLabel9 = new javax.swing.JLabel();
        txt_nombreApellido = new javax.swing.JTextField();
        btn_buscarNombreApellido = new javax.swing.JButton();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setTitle("Mantenimiento de alumno");
        setSize(new java.awt.Dimension(800, 500));
        addWindowListener(new java.awt.event.WindowAdapter() {
            public void windowActivated(java.awt.event.WindowEvent evt) {
                formWindowActivated(evt);
            }
        });

        jPanel2.setBackground(new java.awt.Color(88, 111, 124));
        jPanel2.setBorder(new javax.swing.border.SoftBevelBorder(javax.swing.border.BevelBorder.RAISED, null, null, java.awt.Color.darkGray, java.awt.Color.darkGray));
        jPanel2.setForeground(new java.awt.Color(34, 116, 165));

        btn_nuevo.setFont(new java.awt.Font("Tahoma", 1, 13)); // NOI18N
        btn_nuevo.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Recursos/nuevo.png"))); // NOI18N
        btn_nuevo.setText("Nuevo");
        btn_nuevo.setBorder(new javax.swing.border.SoftBevelBorder(javax.swing.border.BevelBorder.RAISED));
        btn_nuevo.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btn_nuevoActionPerformed(evt);
            }
        });

        btn_modificar.setFont(new java.awt.Font("Tahoma", 1, 13)); // NOI18N
        btn_modificar.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Recursos/modificar.png"))); // NOI18N
        btn_modificar.setText("Modificar");
        btn_modificar.setBorder(new javax.swing.border.SoftBevelBorder(javax.swing.border.BevelBorder.RAISED));
        btn_modificar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btn_modificarActionPerformed(evt);
            }
        });

        btn_limpiar.setFont(new java.awt.Font("Tahoma", 1, 13)); // NOI18N
        btn_limpiar.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Recursos/limpiar.png"))); // NOI18N
        btn_limpiar.setText("Limpiar");
        btn_limpiar.setBorder(new javax.swing.border.SoftBevelBorder(javax.swing.border.BevelBorder.RAISED));
        btn_limpiar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btn_limpiarActionPerformed(evt);
            }
        });

        btn_darBaja.setFont(new java.awt.Font("Tahoma", 1, 13)); // NOI18N
        btn_darBaja.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Recursos/darBaja.png"))); // NOI18N
        btn_darBaja.setText("Dar Baja");
        btn_darBaja.setBorder(new javax.swing.border.SoftBevelBorder(javax.swing.border.BevelBorder.RAISED));
        btn_darBaja.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btn_darBajaActionPerformed(evt);
            }
        });

        btn_buscarDni.setFont(new java.awt.Font("Tahoma", 1, 13)); // NOI18N
        btn_buscarDni.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Recursos/buscarMan.png"))); // NOI18N
        btn_buscarDni.setBorder(new javax.swing.border.SoftBevelBorder(javax.swing.border.BevelBorder.RAISED));
        btn_buscarDni.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btn_buscarDniActionPerformed(evt);
            }
        });

        jLabel2.setFont(new java.awt.Font("Verdana", 0, 14)); // NOI18N
        jLabel2.setForeground(new java.awt.Color(244, 244, 249));
        jLabel2.setText("Correo:");

        txt_apellido.setPreferredSize(new java.awt.Dimension(30, 22));

        jLabel3.setFont(new java.awt.Font("Verdana", 0, 14)); // NOI18N
        jLabel3.setForeground(new java.awt.Color(244, 244, 249));
        jLabel3.setText("Apellidos:");

        btn_salir.setFont(new java.awt.Font("Tahoma", 1, 13)); // NOI18N
        btn_salir.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Recursos/cerrar_mantenimiento.png"))); // NOI18N
        btn_salir.setText("Salir");
        btn_salir.setBorder(new javax.swing.border.SoftBevelBorder(javax.swing.border.BevelBorder.RAISED));
        btn_salir.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btn_salirActionPerformed(evt);
            }
        });

        jLabel5.setFont(new java.awt.Font("Verdana", 0, 14)); // NOI18N
        jLabel5.setForeground(new java.awt.Color(244, 244, 249));
        jLabel5.setText("DNI:");

        jLabel6.setFont(new java.awt.Font("Verdana", 0, 14)); // NOI18N
        jLabel6.setForeground(new java.awt.Color(244, 244, 249));
        jLabel6.setText("<html> Fecha de</br> nacimiento: </html>");

        dc_fechaNacimiento.setPreferredSize(new java.awt.Dimension(30, 22));

        jLabel7.setFont(new java.awt.Font("Verdana", 0, 14)); // NOI18N
        jLabel7.setForeground(new java.awt.Color(244, 244, 249));
        jLabel7.setText("Nombre:");

        txt_nombre.setPreferredSize(new java.awt.Dimension(30, 22));

        jLabel8.setFont(new java.awt.Font("Verdana", 0, 14)); // NOI18N
        jLabel8.setForeground(new java.awt.Color(244, 244, 249));
        jLabel8.setText("Estado:");

        jLabel4.setFont(new java.awt.Font("Verdana", 0, 14)); // NOI18N
        jLabel4.setForeground(new java.awt.Color(244, 244, 249));
        jLabel4.setText("Dirección:");

        txt_direccion.setPreferredSize(new java.awt.Dimension(30, 22));

        txt_correo.setPreferredSize(new java.awt.Dimension(30, 22));

        txt_dni.setPreferredSize(new java.awt.Dimension(30, 22));

        cbo_estado.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "Activo", "Inactivo" }));

        javax.swing.GroupLayout jPanel2Layout = new javax.swing.GroupLayout(jPanel2);
        jPanel2.setLayout(jPanel2Layout);
        jPanel2Layout.setHorizontalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel2Layout.createSequentialGroup()
                .addGap(27, 27, 27)
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                        .addComponent(jLabel7, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addComponent(jLabel5, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addComponent(jLabel3, javax.swing.GroupLayout.PREFERRED_SIZE, 130, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addComponent(jLabel6, javax.swing.GroupLayout.PREFERRED_SIZE, 98, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(txt_apellido, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addGroup(jPanel2Layout.createSequentialGroup()
                        .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(jPanel2Layout.createSequentialGroup()
                                .addComponent(txt_dni, javax.swing.GroupLayout.PREFERRED_SIZE, 140, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addGap(18, 18, 18)
                                .addComponent(btn_buscarDni, javax.swing.GroupLayout.PREFERRED_SIZE, 82, javax.swing.GroupLayout.PREFERRED_SIZE))
                            .addComponent(txt_nombre, javax.swing.GroupLayout.PREFERRED_SIZE, 404, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(dc_fechaNacimiento, javax.swing.GroupLayout.PREFERRED_SIZE, 140, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGap(0, 0, Short.MAX_VALUE)))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                        .addComponent(jLabel4, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.PREFERRED_SIZE, 130, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addComponent(jLabel2, javax.swing.GroupLayout.PREFERRED_SIZE, 130, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addComponent(jLabel8, javax.swing.GroupLayout.PREFERRED_SIZE, 130, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(18, 18, 18)
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING, false)
                        .addComponent(txt_correo, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addComponent(txt_direccion, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.PREFERRED_SIZE, 334, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addComponent(cbo_estado, javax.swing.GroupLayout.PREFERRED_SIZE, 202, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(21, 21, 21))
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel2Layout.createSequentialGroup()
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(btn_nuevo, javax.swing.GroupLayout.PREFERRED_SIZE, 130, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(btn_modificar, javax.swing.GroupLayout.PREFERRED_SIZE, 130, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(btn_darBaja, javax.swing.GroupLayout.PREFERRED_SIZE, 130, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(btn_limpiar, javax.swing.GroupLayout.PREFERRED_SIZE, 130, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(btn_salir, javax.swing.GroupLayout.PREFERRED_SIZE, 130, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(225, 225, 225))
        );
        jPanel2Layout.setVerticalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel2Layout.createSequentialGroup()
                .addContainerGap(40, Short.MAX_VALUE)
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                        .addGroup(jPanel2Layout.createSequentialGroup()
                            .addGap(1, 1, 1)
                            .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                .addGroup(jPanel2Layout.createSequentialGroup()
                                    .addComponent(jLabel4, javax.swing.GroupLayout.PREFERRED_SIZE, 25, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                                    .addComponent(jLabel2, javax.swing.GroupLayout.PREFERRED_SIZE, 25, javax.swing.GroupLayout.PREFERRED_SIZE))
                                .addGroup(jPanel2Layout.createSequentialGroup()
                                    .addGap(76, 76, 76)
                                    .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                                        .addComponent(jLabel8, javax.swing.GroupLayout.PREFERRED_SIZE, 25, javax.swing.GroupLayout.PREFERRED_SIZE)
                                        .addComponent(cbo_estado, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE)))))
                        .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel2Layout.createSequentialGroup()
                            .addComponent(txt_direccion, javax.swing.GroupLayout.PREFERRED_SIZE, 25, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                            .addComponent(txt_correo, javax.swing.GroupLayout.PREFERRED_SIZE, 25, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addGap(40, 40, 40)))
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel2Layout.createSequentialGroup()
                        .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel2Layout.createSequentialGroup()
                                .addGap(15, 15, 15)
                                .addComponent(txt_dni, javax.swing.GroupLayout.PREFERRED_SIZE, 25, javax.swing.GroupLayout.PREFERRED_SIZE))
                            .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                .addGroup(jPanel2Layout.createSequentialGroup()
                                    .addGap(15, 15, 15)
                                    .addComponent(jLabel5, javax.swing.GroupLayout.PREFERRED_SIZE, 25, javax.swing.GroupLayout.PREFERRED_SIZE))
                                .addComponent(btn_buscarDni, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.PREFERRED_SIZE, 40, javax.swing.GroupLayout.PREFERRED_SIZE)))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jLabel7, javax.swing.GroupLayout.PREFERRED_SIZE, 25, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(txt_nombre, javax.swing.GroupLayout.PREFERRED_SIZE, 25, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jLabel3, javax.swing.GroupLayout.PREFERRED_SIZE, 25, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(txt_apellido, javax.swing.GroupLayout.PREFERRED_SIZE, 25, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                            .addComponent(dc_fechaNacimiento, javax.swing.GroupLayout.PREFERRED_SIZE, 25, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jLabel6, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))))
                .addGap(66, 66, 66)
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(btn_modificar, javax.swing.GroupLayout.PREFERRED_SIZE, 40, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(btn_nuevo, javax.swing.GroupLayout.PREFERRED_SIZE, 40, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(btn_darBaja, javax.swing.GroupLayout.PREFERRED_SIZE, 40, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(btn_salir, javax.swing.GroupLayout.PREFERRED_SIZE, 40, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(btn_limpiar, javax.swing.GroupLayout.PREFERRED_SIZE, 40, javax.swing.GroupLayout.PREFERRED_SIZE)))
        );

        tbl_alumno.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null}
            },
            new String [] {
                "Title 1", "Title 2", "Title 3", "Title 4"
            }
        ));
        tbl_alumno.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                tbl_alumnoMouseClicked(evt);
            }
        });
        jScrollPane1.setViewportView(tbl_alumno);

        jPanel1.setBackground(new java.awt.Color(88, 111, 124));
        jPanel1.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 0, 0)));
        jPanel1.setForeground(new java.awt.Color(34, 116, 165));

        jLabel9.setFont(new java.awt.Font("Verdana", 0, 14)); // NOI18N
        jLabel9.setForeground(new java.awt.Color(244, 244, 249));
        jLabel9.setText("Nombres o Apellidos:");

        txt_nombreApellido.setPreferredSize(new java.awt.Dimension(30, 22));

        btn_buscarNombreApellido.setFont(new java.awt.Font("Tahoma", 1, 13)); // NOI18N
        btn_buscarNombreApellido.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Recursos/buscarMan.png"))); // NOI18N
        btn_buscarNombreApellido.setBorder(new javax.swing.border.SoftBevelBorder(javax.swing.border.BevelBorder.RAISED));
        btn_buscarNombreApellido.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btn_buscarNombreApellidoActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jLabel9, javax.swing.GroupLayout.DEFAULT_SIZE, 173, Short.MAX_VALUE)
                .addGap(87, 87, 87)
                .addComponent(txt_nombreApellido, javax.swing.GroupLayout.PREFERRED_SIZE, 677, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(btn_buscarNombreApellido, javax.swing.GroupLayout.PREFERRED_SIZE, 82, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(141, 141, 141))
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addComponent(btn_buscarNombreApellido, javax.swing.GroupLayout.PREFERRED_SIZE, 27, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jLabel9, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addComponent(txt_nombreApellido, javax.swing.GroupLayout.PREFERRED_SIZE, 25, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGap(10, 10, 10))))
        );

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jPanel2, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(jPanel1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(jScrollPane1, javax.swing.GroupLayout.Alignment.TRAILING))
                .addContainerGap())
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jPanel2, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jPanel1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 9, Short.MAX_VALUE)
                .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 288, javax.swing.GroupLayout.PREFERRED_SIZE))
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void btn_nuevoActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btn_nuevoActionPerformed
        try {

            if (btn_nuevo.getText().equals("Nuevo")) {
                limpiarControles();
                btn_limpiar.enableInputMethods(true);
                btn_modificar.enableInputMethods(false);
                btn_darBaja.enableInputMethods(false);
                txt_dni.requestFocus();
                cbo_estado.enable(true);
                btn_nuevo.setText("Guardar");
            } else {
                if (!txt_dni.getText().equalsIgnoreCase(" ") && !txt_nombre.getText().equalsIgnoreCase(" ") && !txt_apellido.getText().equalsIgnoreCase(" ") && !dc_fechaNacimiento.equals(null) && !txt_direccion.getText().equalsIgnoreCase(" ") && !txt_correo.getText().equalsIgnoreCase(" ")) {
                    btn_nuevo.setText("Nuevo");
                    clsAlumno objA = new clsAlumno();
                    objA.setId(clsAlumno.generarCodigo());
                    objA.setDni(txt_dni.getText());
                    objA.setNombre(txt_nombre.getText());
                    objA.setApellido(txt_apellido.getText());
                    objA.setFecha_nacimiento(new java.sql.Date(dcFechaNacimiento.getDate().getTime()));
                    objA.setDireccion(txt_direccion.getText());
                    objA.setCorreo(txt_correo.getText());
                    if (cbo_estado.getSelectedItem().equals("Activo")) {
                        estado = 'A';
                    } else {
                        estado = 'I';
                    }
                    objA.setEstado(Character.toString(estado));
                    objA.registrar();
                    cbo_estado.enable(false);
                    limpiarControles();
                    JOptionPane.showMessageDialog(this, "Alumno registrado correctamente");
                } else {
                    JOptionPane.showMessageDialog(this, "Debes completar todos los campos");
                }
                /*btn_nuevo.setText("Nuevo");
                clsAlumno objA = new clsAlumno();
                objA.setId(clsAlumno.generarCodigo());
                objA.setDni(txt_dni.getText());
                objA.setNombre(txt_nombre.getText());
                objA.setApellido(txt_apellido.getText());
                objA.setFecha_nacimiento(new java.sql.Date(dcFechaNacimiento.getDate().getTime()));
                objA.setDireccion(txt_direccion.getText());
                objA.setCorreo(txt_correo.getText());
                if (cbo_estado.getSelectedItem().equals("Activo")) {
                    estado = 'A';
                } else {
                    estado = 'I';
                }
                objA.setEstado(Character.toString(estado));
                objA.registrar();
                limpiarControles();
                JOptionPane.showMessageDialog(this, "Alumno registrado correctamente");*/
            }
        } catch (Exception e) {
            JOptionPane.showMessageDialog(this, e.getMessage() + " Error al agregar Alumno");
        }
    }//GEN-LAST:event_btn_nuevoActionPerformed

    private void btn_modificarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btn_modificarActionPerformed
        try {
            clsAlumno objA = new clsAlumno();
            if (!txt_dni.getText().equalsIgnoreCase("") && !txt_nombre.getText().equalsIgnoreCase("") && !txt_apellido.getText().equalsIgnoreCase("") && !dc_fechaNacimiento.equals(null) && !txt_direccion.getText().equalsIgnoreCase("") && !txt_correo.getText().equalsIgnoreCase("")) {
                objA.setDni(txt_dni.getText());
                objA.setNombre(txt_nombre.getText());
                objA.setApellido(txt_apellido.getText());
                objA.setFecha_nacimiento(new java.sql.Date(dcFechaNacimiento.getDate().getTime()));
                objA.setCorreo(txt_correo.getText());
                objA.modificarPorDni(objA);
                JOptionPane.showMessageDialog(this, "Alumno modificado correctamente");
            } else {
                JOptionPane.showMessageDialog(this, "Existen campos en blanco, vuelve a intentarlo");
            }
            limpiarTabla(tbl_alumno);
           
        } catch (Exception ex) {
            JOptionPane.showMessageDialog(this, "Error al modificar alumno");
        }
    }//GEN-LAST:event_btn_modificarActionPerformed

    private void btn_buscarNombreApellidoActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btn_buscarNombreApellidoActionPerformed
        try {
            if (!txt_nombreApellido.getText().equals("")) {
                ArrayList<clsAlumno> busqueda = clsAlumno.buscarPorNombre(txt_nombreApellido.getText());
                if (busqueda.size() > 0) {
                    DefaultTableModel modelo = new DefaultTableModel();
                    modelo.addColumn("Id");
                    modelo.addColumn("Nombre");
                    modelo.addColumn("Apellido");
                    modelo.addColumn("DNI");
                    modelo.addColumn("Estado");
                    tbl_alumno.setModel(modelo);
                    //tbl_alumno.getColumnModel().getColumn(0).setResizable(false);
                    busqueda.forEach(a -> {
                        modelo.addRow(new Object[]{
                            a.getDni(),
                            a.getNombre(),
                            a.getApellido(),
                            a.getEstado()});
                    });
                } else {
                    JOptionPane.showMessageDialog(this, "No se encontró alumno");
                }
            } else {
                JOptionPane.showMessageDialog(this, "Ingrese un nombre válido");
                txt_nombre.requestFocus();
            }
        } catch (Exception e) {
            JOptionPane.showMessageDialog(this, "Error al buscar alumno");
        }


    }//GEN-LAST:event_btn_buscarNombreApellidoActionPerformed

    private void tbl_alumnoMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_tbl_alumnoMouseClicked
        String codigo = String.valueOf(tbl_alumno.getValueAt(tbl_alumno.getSelectedRow(), 0));
        llenarCampos(Integer.parseInt(codigo));
        btn_modificar.enableInputMethods(true);
        btn_darBaja.enableInputMethods(true);
    }//GEN-LAST:event_tbl_alumnoMouseClicked

    private void btn_buscarDniActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btn_buscarDniActionPerformed
        try {
             if(!txt_dni.getText().equalsIgnoreCase("")){
                clsAlumno objA = clsAlumno.buscarPorDni(txt_dni.getText());
                objA.setNombre(txt_nombre.getText());
                objA.setApellido(txt_apellido.getText());
                objA.setFecha_nacimiento(new java.sql.Date(dcFechaNacimiento.getDate().getTime()));
                objA.setDireccion(txt_direccion.getText());
                objA.setCorreo(txt_correo.getText());
                if (cbo_estado.getSelectedItem().equals("Activo")) {
                    estado = 'A';
                } else {
                    estado = 'I';
                }
                objA.setEstado(Character.toString(estado));
                btn_modificar.enableInputMethods(true);
                btn_darBaja.enableInputMethods(true);
                limpiarTabla(tbl_alumno);
             }else{
                 JOptionPane.showMessageDialog(this, "El campo dni se encuentra en blanco, vuelva a intentarlo");
             }
        } catch (Exception ex) {
            JOptionPane.showMessageDialog(this, "Error al modificar alumno");
        }
    }//GEN-LAST:event_btn_buscarDniActionPerformed

    private void btn_darBajaActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btn_darBajaActionPerformed
        try {
            if(!txt_dni.getText().equalsIgnoreCase("")){
                clsAlumno.darBajaPorDni(txt_dni.getText());
                limpiarTabla(tbl_alumno);
                JOptionPane.showMessageDialog(this, "Alumno modificado correctamente");
            }else{
                JOptionPane.showMessageDialog(this, "El campo dni se encuentra en blanco, vuelva a intentarlo");
            }
        } catch (Exception ex) {
            JOptionPane.showMessageDialog(this, "Error al modificar alumno");
        }
    }//GEN-LAST:event_btn_darBajaActionPerformed

    private void btn_limpiarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btn_limpiarActionPerformed
        limpiarControles();
        btn_darBaja.enableInputMethods(false);
        btn_modificar.enableInputMethods(false);
        btn_limpiar.enableInputMethods(false);
    }//GEN-LAST:event_btn_limpiarActionPerformed

    private void btn_salirActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btn_salirActionPerformed
        this.dispose();
    }//GEN-LAST:event_btn_salirActionPerformed

    private void formWindowActivated(java.awt.event.WindowEvent evt) {//GEN-FIRST:event_formWindowActivated
        limpiarControles();
        txt_dni.requestFocus();

    }//GEN-LAST:event_formWindowActivated
    private void limpiarControles() {
        txt_dni.setText("");
        txt_nombre.setText("");
        txt_apellido.setText("");
        dc_fechaNacimiento.setDate(null);
        txt_direccion.setText("");
        txt_correo.setText("");
        cbo_estado.setSelectedIndex(-1);
        txt_dni.requestFocus();
        limpiarTabla(tbl_alumno);
    }

    private void llenarCampos(int id) {
        try {
            String estadoCombo;
            clsAlumno objA = clsAlumno.buscar(id);
            txt_dni.setText(objA.getDni());
            txt_nombre.setText(objA.getNombre());
            txt_apellido.setText(objA.getApellido());
            dcFechaNacimiento.setDate(objA.getFecha_nacimiento());
            txt_direccion.setText(objA.getDireccion());
            txt_correo.setText(objA.getEstado());
            if (objA.getEstado().equals("A")) {
                estadoCombo = "Activo";
            } else {
                estadoCombo = "Inactivo";
            }
            cbo_estado.setSelectedItem(estadoCombo);
        } catch (Exception ex) {
            JOptionPane.showMessageDialog(this, "Error al buscar Alumno");
        }
    }

    public void limpiarTabla(JTable tabla) {
        try {
            DefaultTableModel modelo = (DefaultTableModel) tabla.getModel();
            int filas = tabla.getRowCount();
            for (int i = 0; filas > i; i++) {
                modelo.removeRow(0);
            }
        } catch (Exception e) {
            JOptionPane.showMessageDialog(null, "Error al limpiar la tabla");
        }
    }
    /**
     * @param args the command line arguments
     */


    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton btn_buscarDni;
    private javax.swing.JButton btn_buscarNombreApellido;
    private javax.swing.JButton btn_darBaja;
    private javax.swing.JButton btn_limpiar;
    private javax.swing.JButton btn_modificar;
    private javax.swing.JButton btn_nuevo;
    private javax.swing.JButton btn_salir;
    public static javax.swing.JComboBox<String> cbo_estado;
    private com.toedter.calendar.JDateChooser dc_fechaNacimiento;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JLabel jLabel6;
    private javax.swing.JLabel jLabel7;
    private javax.swing.JLabel jLabel8;
    private javax.swing.JLabel jLabel9;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JPanel jPanel2;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JTable tbl_alumno;
    private javax.swing.JTextField txt_apellido;
    private javax.swing.JTextField txt_correo;
    private javax.swing.JTextField txt_direccion;
    private javax.swing.JTextField txt_dni;
    private javax.swing.JTextField txt_nombre;
    private javax.swing.JTextField txt_nombreApellido;
    // End of variables declaration//GEN-END:variables
}
