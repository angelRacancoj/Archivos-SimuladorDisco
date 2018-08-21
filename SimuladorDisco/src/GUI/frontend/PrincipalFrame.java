/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package GUI.frontend;

import Constants.Constants;
import GUI.backend.MetodosInterfaz;
import GUI.frontend.pantallas.ConsultarArchivoFrame;
import GUI.frontend.pantallas.CrearArchivoFrame;
import GUI.frontend.pantallas.EliminarArchivoFrame;
import GUI.frontend.pantallas.ModificarArchivoFrame;
import java.io.File;
import javax.swing.JOptionPane;
import partitions.Linked;

/**
 *
 * @author daniel
 */
public class PrincipalFrame extends javax.swing.JFrame {

    /**
     * Creates new form principalFrame
     */
    MetodosInterfaz metodosInterfaz;
    boolean ajusteSeleccionado = false;
    int particion1Porcenaje;
    int particion2Porcenaje;
    int particion3Porcenaje;
    int memoria;
    Linked linkedP;
    Constants constantSD = new Constants();

    public PrincipalFrame(int particion1Porcenaje, int particion2Porcenaje, int particion3Porcenaje, int memoria, Linked linkedP) {

        this.metodosInterfaz = new MetodosInterfaz();
        this.particion1Porcenaje = particion1Porcenaje;
        this.particion2Porcenaje = particion2Porcenaje;
        this.particion3Porcenaje = particion3Porcenaje;
        this.memoria = memoria;
        initComponents();
        this.setLayout(null);
        mbrButton.setBounds(0, 0, 280, 300);

        int pixeles1 = (particion1Porcenaje / 100) * 1000;
        int pixeles2 = (particion2Porcenaje / 100) * 1000;
        int pixeles3 = (particion3Porcenaje / 100) * 1000;

        metodosInterfaz.EstablecerPorcentaje(particion1Porcenaje, particion2Porcenaje, particion3Porcenaje, particion1Button, particion2Button, particion3Button);

    }

    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        mbrButton = new javax.swing.JButton();
        particion1Button = new javax.swing.JButton();
        particion2Button = new javax.swing.JButton();
        particion3Button = new javax.swing.JButton();
        colorButton = new javax.swing.JButton();
        nombreParticionTextField = new javax.swing.JTextField();
        jLabel1 = new javax.swing.JLabel();
        jLabel2 = new javax.swing.JLabel();
        porcentajeParticionTextField = new javax.swing.JTextField();
        jLabel3 = new javax.swing.JLabel();
        memoriaParticionTextField = new javax.swing.JTextField();
        jLabel4 = new javax.swing.JLabel();
        jMenuBar1 = new javax.swing.JMenuBar();
        jMenu1 = new javax.swing.JMenu();
        jMenuItem1 = new javax.swing.JMenuItem();
        jMenu3 = new javax.swing.JMenu();
        jMenuItem2 = new javax.swing.JMenuItem();
        jMenuItem3 = new javax.swing.JMenuItem();
        jMenu4 = new javax.swing.JMenu();
        jMenu11 = new javax.swing.JMenu();
        primerAjusteMenuItem = new javax.swing.JMenuItem();
        mejorAjusteMenuItem = new javax.swing.JMenuItem();
        peorAjusteMenuItem = new javax.swing.JMenuItem();
        crearP1MenuItem = new javax.swing.JMenuItem();
        eliminarP1MenuItem = new javax.swing.JMenuItem();
        modificarP1MenuItem = new javax.swing.JMenuItem();
        consultarP1MenuItem = new javax.swing.JMenuItem();
        jMenu5 = new javax.swing.JMenu();
        crearP2MenuItem = new javax.swing.JMenuItem();
        eliminarP2MenuItem = new javax.swing.JMenuItem();
        modificarP2MenuItem = new javax.swing.JMenuItem();
        consultarP2MenuItem = new javax.swing.JMenuItem();
        jMenu6 = new javax.swing.JMenu();
        crearP3MenuItem = new javax.swing.JMenuItem();
        eliminarP3MenuItem = new javax.swing.JMenuItem();
        modificarP3MenuItem = new javax.swing.JMenuItem();
        consultarP3MenuItem = new javax.swing.JMenuItem();
        jMenu7 = new javax.swing.JMenu();
        jMenu2 = new javax.swing.JMenu();
        jMenuItem17 = new javax.swing.JMenuItem();
        jMenuItem18 = new javax.swing.JMenuItem();
        jMenu8 = new javax.swing.JMenu();
        reporteDirectorioMenuItem = new javax.swing.JMenuItem();
        reporteBloquesMenuItem = new javax.swing.JMenuItem();
        jMenu9 = new javax.swing.JMenu();
        jMenuItem21 = new javax.swing.JMenuItem();
        jMenuItem22 = new javax.swing.JMenuItem();
        jMenu10 = new javax.swing.JMenu();
        jMenuItem23 = new javax.swing.JMenuItem();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);

        mbrButton.setBackground(new java.awt.Color(255, 153, 153));
        mbrButton.setText("MBR");

        particion1Button.setBackground(new java.awt.Color(255, 153, 255));
        particion1Button.setText("Particion 1");
        particion1Button.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                particion1ButtonActionPerformed(evt);
            }
        });

        particion2Button.setBackground(new java.awt.Color(153, 204, 255));
        particion2Button.setText("Particion 2");
        particion2Button.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                particion2ButtonActionPerformed(evt);
            }
        });

        particion3Button.setBackground(new java.awt.Color(204, 255, 153));
        particion3Button.setText("Particion 3");
        particion3Button.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                particion3ButtonActionPerformed(evt);
            }
        });

        nombreParticionTextField.setEditable(false);
        nombreParticionTextField.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                nombreParticionTextFieldActionPerformed(evt);
            }
        });

        jLabel2.setText("Porcentaje de memoria");

        porcentajeParticionTextField.setEditable(false);

        jLabel3.setText("Memoria");

        memoriaParticionTextField.setEditable(false);
        memoriaParticionTextField.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                memoriaParticionTextFieldActionPerformed(evt);
            }
        });

        jLabel4.setText("MB");

        jMenu1.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Imagenes/5215.png"))); // NOI18N
        jMenu1.setText("Opciones");

        jMenuItem1.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Imagenes/1618.png"))); // NOI18N
        jMenuItem1.setText("Salir");
        jMenuItem1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jMenuItem1ActionPerformed(evt);
            }
        });
        jMenu1.add(jMenuItem1);

        jMenuBar1.add(jMenu1);

        jMenu3.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Imagenes/Database.png"))); // NOI18N
        jMenu3.setText("Opciones de Disco");

        jMenuItem2.setText("Montar disco");
        jMenuItem2.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jMenuItem2ActionPerformed(evt);
            }
        });
        jMenu3.add(jMenuItem2);

        jMenuItem3.setText("Reiniciar disco");
        jMenuItem3.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jMenuItem3ActionPerformed(evt);
            }
        });
        jMenu3.add(jMenuItem3);

        jMenuBar1.add(jMenu3);

        jMenu4.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Imagenes/Save.png"))); // NOI18N
        jMenu4.setText("Particion 1");

        jMenu11.setText("Asignacion de ajuste");

        primerAjusteMenuItem.setText("Primer ajuste");
        primerAjusteMenuItem.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                primerAjusteMenuItemActionPerformed(evt);
            }
        });
        jMenu11.add(primerAjusteMenuItem);

        mejorAjusteMenuItem.setText("Mejor ajuste");
        mejorAjusteMenuItem.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                mejorAjusteMenuItemActionPerformed(evt);
            }
        });
        jMenu11.add(mejorAjusteMenuItem);

        peorAjusteMenuItem.setText("Peor ajuste");
        peorAjusteMenuItem.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                peorAjusteMenuItemActionPerformed(evt);
            }
        });
        jMenu11.add(peorAjusteMenuItem);

        jMenu4.add(jMenu11);

        crearP1MenuItem.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Imagenes/New document.png"))); // NOI18N
        crearP1MenuItem.setText("Crear Archivo");
        crearP1MenuItem.setEnabled(false);
        crearP1MenuItem.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                crearP1MenuItemActionPerformed(evt);
            }
        });
        jMenu4.add(crearP1MenuItem);

        eliminarP1MenuItem.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Imagenes/Delete.png"))); // NOI18N
        eliminarP1MenuItem.setText("Eliminar Archivo");
        eliminarP1MenuItem.setEnabled(false);
        eliminarP1MenuItem.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                eliminarP1MenuItemActionPerformed(evt);
            }
        });
        jMenu4.add(eliminarP1MenuItem);

        modificarP1MenuItem.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Imagenes/save.png"))); // NOI18N
        modificarP1MenuItem.setText("Modificar Archivo");
        modificarP1MenuItem.setEnabled(false);
        modificarP1MenuItem.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                modificarP1MenuItemActionPerformed(evt);
            }
        });
        jMenu4.add(modificarP1MenuItem);

        consultarP1MenuItem.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Imagenes/reporte.png"))); // NOI18N
        consultarP1MenuItem.setText("Consultar Archivo");
        consultarP1MenuItem.setEnabled(false);
        consultarP1MenuItem.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                consultarP1MenuItemActionPerformed(evt);
            }
        });
        jMenu4.add(consultarP1MenuItem);

        jMenuBar1.add(jMenu4);

        jMenu5.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Imagenes/Save.png"))); // NOI18N
        jMenu5.setText("Particion 2");

        crearP2MenuItem.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Imagenes/New document.png"))); // NOI18N
        crearP2MenuItem.setText("Crear Archivo");
        crearP2MenuItem.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                crearP2MenuItemActionPerformed(evt);
            }
        });
        jMenu5.add(crearP2MenuItem);

        eliminarP2MenuItem.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Imagenes/Cancel.png"))); // NOI18N
        eliminarP2MenuItem.setText("Eliminar Archivo");
        eliminarP2MenuItem.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                eliminarP2MenuItemActionPerformed(evt);
            }
        });
        jMenu5.add(eliminarP2MenuItem);

        modificarP2MenuItem.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Imagenes/save.png"))); // NOI18N
        modificarP2MenuItem.setText("Modificar Archivo");
        modificarP2MenuItem.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                modificarP2MenuItemActionPerformed(evt);
            }
        });
        jMenu5.add(modificarP2MenuItem);

        consultarP2MenuItem.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Imagenes/reporte.png"))); // NOI18N
        consultarP2MenuItem.setText("Consultar Archivo");
        consultarP2MenuItem.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                consultarP2MenuItemActionPerformed(evt);
            }
        });
        jMenu5.add(consultarP2MenuItem);

        jMenuBar1.add(jMenu5);

        jMenu6.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Imagenes/Save.png"))); // NOI18N
        jMenu6.setText("Particion 3");

        crearP3MenuItem.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Imagenes/New document.png"))); // NOI18N
        crearP3MenuItem.setText("Crear Archivo");
        crearP3MenuItem.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                crearP3MenuItemActionPerformed(evt);
            }
        });
        jMenu6.add(crearP3MenuItem);

        eliminarP3MenuItem.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Imagenes/Delete.png"))); // NOI18N
        eliminarP3MenuItem.setText("Eliminar Archivo");
        eliminarP3MenuItem.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                eliminarP3MenuItemActionPerformed(evt);
            }
        });
        jMenu6.add(eliminarP3MenuItem);

        modificarP3MenuItem.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Imagenes/save.png"))); // NOI18N
        modificarP3MenuItem.setText("Modificar Archivo");
        modificarP3MenuItem.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                modificarP3MenuItemActionPerformed(evt);
            }
        });
        jMenu6.add(modificarP3MenuItem);

        consultarP3MenuItem.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Imagenes/reporte.png"))); // NOI18N
        consultarP3MenuItem.setText("Consultar Archivo");
        consultarP3MenuItem.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                consultarP3MenuItemActionPerformed(evt);
            }
        });
        jMenu6.add(consultarP3MenuItem);

        jMenuBar1.add(jMenu6);

        jMenu7.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Imagenes/Report.png"))); // NOI18N
        jMenu7.setText("Reportes");

        jMenu2.setText("Particion 1");

        jMenuItem17.setText("Estado de bloques");
        jMenu2.add(jMenuItem17);

        jMenuItem18.setText("Contenido de bloques");
        jMenu2.add(jMenuItem18);

        jMenu7.add(jMenu2);

        jMenu8.setText("Particion 2");

        reporteDirectorioMenuItem.setText("Reporte de directorio");
        reporteDirectorioMenuItem.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                reporteDirectorioMenuItemActionPerformed(evt);
            }
        });
        jMenu8.add(reporteDirectorioMenuItem);

        reporteBloquesMenuItem.setText("Reporte de bloques");
        reporteBloquesMenuItem.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                reporteBloquesMenuItemActionPerformed(evt);
            }
        });
        jMenu8.add(reporteBloquesMenuItem);

        jMenu7.add(jMenu8);

        jMenu9.setText("Particion 3");

        jMenuItem21.setText("Reporte de directorio");
        jMenu9.add(jMenuItem21);

        jMenuItem22.setText("Reporte de bloques ");
        jMenuItem22.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jMenuItem22ActionPerformed(evt);
            }
        });
        jMenu9.add(jMenuItem22);

        jMenu7.add(jMenu9);

        jMenu10.setText("MBR");

        jMenuItem23.setText("Informacion del MBR");
        jMenu10.add(jMenuItem23);

        jMenu7.add(jMenu10);

        jMenuBar1.add(jMenu7);

        setJMenuBar(jMenuBar1);

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(70, 70, 70)
                .addComponent(jLabel1)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
            .addGroup(layout.createSequentialGroup()
                .addGap(23, 23, 23)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addComponent(colorButton, javax.swing.GroupLayout.PREFERRED_SIZE, 58, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(mbrButton))
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(particion1Button, javax.swing.GroupLayout.PREFERRED_SIZE, 145, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(particion2Button, javax.swing.GroupLayout.PREFERRED_SIZE, 159, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(particion3Button, javax.swing.GroupLayout.DEFAULT_SIZE, 900, Short.MAX_VALUE))
                    .addGroup(layout.createSequentialGroup()
                        .addGap(127, 127, 127)
                        .addComponent(nombreParticionTextField, javax.swing.GroupLayout.PREFERRED_SIZE, 85, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(162, 162, 162)
                        .addComponent(porcentajeParticionTextField, javax.swing.GroupLayout.PREFERRED_SIZE, 89, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(262, 262, 262)
                        .addComponent(memoriaParticionTextField, javax.swing.GroupLayout.PREFERRED_SIZE, 86, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(jLabel4)
                        .addGap(0, 0, Short.MAX_VALUE))
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addComponent(jLabel2)
                        .addGap(261, 261, 261)
                        .addComponent(jLabel3)
                        .addGap(430, 430, 430))))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addComponent(jLabel1)
                        .addGap(227, 227, 227))
                    .addGroup(layout.createSequentialGroup()
                        .addGap(19, 19, 19)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(layout.createSequentialGroup()
                                .addComponent(mbrButton, javax.swing.GroupLayout.PREFERRED_SIZE, 300, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                            .addGroup(layout.createSequentialGroup()
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addComponent(particion2Button, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                    .addComponent(particion3Button, javax.swing.GroupLayout.DEFAULT_SIZE, 207, Short.MAX_VALUE)
                                    .addComponent(particion1Button, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                                .addGap(211, 211, 211)))))
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING, false)
                    .addComponent(colorButton, javax.swing.GroupLayout.PREFERRED_SIZE, 59, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addGroup(layout.createSequentialGroup()
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jLabel2)
                            .addComponent(jLabel3))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(nombreParticionTextField, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(porcentajeParticionTextField, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(memoriaParticionTextField, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jLabel4))))
                .addGap(23, 23, 23))
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void modificarP1MenuItemActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_modificarP1MenuItemActionPerformed
        ModificarArchivoFrame archivoFrame = new ModificarArchivoFrame(this, constantSD.PARTICION_CONTIGUA);
        archivoFrame.setVisible(true);
        this.setVisible(false);
    }//GEN-LAST:event_modificarP1MenuItemActionPerformed

    private void reporteBloquesMenuItemActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_reporteBloquesMenuItemActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_reporteBloquesMenuItemActionPerformed

    private void jMenuItem22ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jMenuItem22ActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_jMenuItem22ActionPerformed

    private void primerAjusteMenuItemActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_primerAjusteMenuItemActionPerformed
        crearP1MenuItem.setEnabled(true);
        eliminarP1MenuItem.setEnabled(true);
        consultarP1MenuItem.setEnabled(true);
        modificarP1MenuItem.setEnabled(true);
    }//GEN-LAST:event_primerAjusteMenuItemActionPerformed

    private void mejorAjusteMenuItemActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_mejorAjusteMenuItemActionPerformed
        crearP1MenuItem.setEnabled(true);
        eliminarP1MenuItem.setEnabled(true);
        consultarP1MenuItem.setEnabled(true);
        modificarP1MenuItem.setEnabled(true);
    }//GEN-LAST:event_mejorAjusteMenuItemActionPerformed

    private void peorAjusteMenuItemActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_peorAjusteMenuItemActionPerformed
        crearP1MenuItem.setEnabled(true);
        eliminarP1MenuItem.setEnabled(true);
        consultarP1MenuItem.setEnabled(true);
        modificarP1MenuItem.setEnabled(true);
    }//GEN-LAST:event_peorAjusteMenuItemActionPerformed

    private void crearP1MenuItemActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_crearP1MenuItemActionPerformed
        CrearArchivoFrame archivoInternalFrame = new CrearArchivoFrame(this, constantSD.PARTICION_CONTIGUA);
        archivoInternalFrame.setVisible(true);
        this.setVisible(false);
    }//GEN-LAST:event_crearP1MenuItemActionPerformed

    private void eliminarP1MenuItemActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_eliminarP1MenuItemActionPerformed
        EliminarArchivoFrame eliminarArchivoFrame = new EliminarArchivoFrame(this, constantSD.PARTICION_CONTIGUA);
        eliminarArchivoFrame.setVisible(true);
        this.setVisible(false);
    }//GEN-LAST:event_eliminarP1MenuItemActionPerformed

    private void crearP2MenuItemActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_crearP2MenuItemActionPerformed
        CrearArchivoFrame archivoInternalFrame = new CrearArchivoFrame(this, constantSD.PARTICION_ENLAZADA);
        archivoInternalFrame.setVisible(true);
        this.setVisible(false);
    }//GEN-LAST:event_crearP2MenuItemActionPerformed

    private void crearP3MenuItemActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_crearP3MenuItemActionPerformed
        CrearArchivoFrame archivoInternalFrame = new CrearArchivoFrame(this, constantSD.PARTICION_INDEXADA);
        archivoInternalFrame.setVisible(true);
        this.setVisible(false);
    }//GEN-LAST:event_crearP3MenuItemActionPerformed

    private void eliminarP2MenuItemActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_eliminarP2MenuItemActionPerformed
        EliminarArchivoFrame eliminarArchivoFrame = new EliminarArchivoFrame(this, constantSD.PARTICION_ENLAZADA);
        eliminarArchivoFrame.setVisible(true);
        this.setVisible(false);
    }//GEN-LAST:event_eliminarP2MenuItemActionPerformed

    private void eliminarP3MenuItemActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_eliminarP3MenuItemActionPerformed
        EliminarArchivoFrame eliminarArchivoFrame = new EliminarArchivoFrame(this, constantSD.PARTICION_INDEXADA);
        eliminarArchivoFrame.setVisible(true);
        this.setVisible(false);
    }//GEN-LAST:event_eliminarP3MenuItemActionPerformed

    private void modificarP2MenuItemActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_modificarP2MenuItemActionPerformed
        ModificarArchivoFrame archivoFrame = new ModificarArchivoFrame(this, constantSD.PARTICION_ENLAZADA);
        archivoFrame.setVisible(true);
        this.setVisible(false);
    }//GEN-LAST:event_modificarP2MenuItemActionPerformed

    private void modificarP3MenuItemActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_modificarP3MenuItemActionPerformed
        ModificarArchivoFrame archivoFrame = new ModificarArchivoFrame(this, constantSD.PARTICION_INDEXADA);
        archivoFrame.setVisible(true);
        this.setVisible(false);
    }//GEN-LAST:event_modificarP3MenuItemActionPerformed

    private void consultarP1MenuItemActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_consultarP1MenuItemActionPerformed
        ConsultarArchivoFrame consultarArchivoFrame = new ConsultarArchivoFrame(this);
        consultarArchivoFrame.setVisible(true);
        this.setVisible(false);
    }//GEN-LAST:event_consultarP1MenuItemActionPerformed

    private void consultarP2MenuItemActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_consultarP2MenuItemActionPerformed
        ConsultarArchivoFrame consultarArchivoFrame = new ConsultarArchivoFrame(this);
        consultarArchivoFrame.setVisible(true);
        this.setVisible(false);
    }//GEN-LAST:event_consultarP2MenuItemActionPerformed

    private void consultarP3MenuItemActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_consultarP3MenuItemActionPerformed
        ConsultarArchivoFrame consultarArchivoFrame = new ConsultarArchivoFrame(this);
        consultarArchivoFrame.setVisible(true);
        this.setVisible(false);
    }//GEN-LAST:event_consultarP3MenuItemActionPerformed

    private void jMenuItem2ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jMenuItem2ActionPerformed
        JOptionPane.showMessageDialog(null, "\nEl disco ya fue montado ", "ADVERTENCIA!!!", JOptionPane.INFORMATION_MESSAGE);

    }//GEN-LAST:event_jMenuItem2ActionPerformed

    private void jMenuItem3ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jMenuItem3ActionPerformed
        JOptionPane.showMessageDialog(null, "\nEl disco fue formateados. ", "ADVERTENCIA!!!", JOptionPane.INFORMATION_MESSAGE);

    }//GEN-LAST:event_jMenuItem3ActionPerformed

    private void nombreParticionTextFieldActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_nombreParticionTextFieldActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_nombreParticionTextFieldActionPerformed

    private void memoriaParticionTextFieldActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_memoriaParticionTextFieldActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_memoriaParticionTextFieldActionPerformed

    private void particion1ButtonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_particion1ButtonActionPerformed
        colorButton.setBackground(particion1Button.getBackground());
        nombreParticionTextField.setText(particion1Button.getText());
        porcentajeParticionTextField.setText(Integer.toString(particion1Porcenaje));
        memoriaParticionTextField.setText(String.valueOf(memoria * particion1Porcenaje * 0.01));
    }//GEN-LAST:event_particion1ButtonActionPerformed

    private void particion2ButtonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_particion2ButtonActionPerformed
        colorButton.setBackground(particion2Button.getBackground());
        nombreParticionTextField.setText(particion2Button.getText());
        porcentajeParticionTextField.setText(Integer.toString(particion2Porcenaje));
        memoriaParticionTextField.setText(String.valueOf(memoria * particion2Porcenaje * 0.01));
    }//GEN-LAST:event_particion2ButtonActionPerformed

    private void particion3ButtonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_particion3ButtonActionPerformed
        colorButton.setBackground(particion3Button.getBackground());
        nombreParticionTextField.setText(particion3Button.getText());
        porcentajeParticionTextField.setText(Integer.toString(particion3Porcenaje));
        memoriaParticionTextField.setText(String.valueOf(memoria * particion3Porcenaje * 0.01));
    }//GEN-LAST:event_particion3ButtonActionPerformed

    private void jMenuItem1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jMenuItem1ActionPerformed
        this.dispose();
    }//GEN-LAST:event_jMenuItem1ActionPerformed

    private void reporteDirectorioMenuItemActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_reporteDirectorioMenuItemActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_reporteDirectorioMenuItemActionPerformed

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton colorButton;
    private javax.swing.JMenuItem consultarP1MenuItem;
    private javax.swing.JMenuItem consultarP2MenuItem;
    private javax.swing.JMenuItem consultarP3MenuItem;
    private javax.swing.JMenuItem crearP1MenuItem;
    private javax.swing.JMenuItem crearP2MenuItem;
    private javax.swing.JMenuItem crearP3MenuItem;
    private javax.swing.JMenuItem eliminarP1MenuItem;
    private javax.swing.JMenuItem eliminarP2MenuItem;
    private javax.swing.JMenuItem eliminarP3MenuItem;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JMenu jMenu1;
    private javax.swing.JMenu jMenu10;
    private javax.swing.JMenu jMenu11;
    private javax.swing.JMenu jMenu2;
    private javax.swing.JMenu jMenu3;
    private javax.swing.JMenu jMenu4;
    private javax.swing.JMenu jMenu5;
    private javax.swing.JMenu jMenu6;
    private javax.swing.JMenu jMenu7;
    private javax.swing.JMenu jMenu8;
    private javax.swing.JMenu jMenu9;
    private javax.swing.JMenuBar jMenuBar1;
    private javax.swing.JMenuItem jMenuItem1;
    private javax.swing.JMenuItem jMenuItem17;
    private javax.swing.JMenuItem jMenuItem18;
    private javax.swing.JMenuItem jMenuItem2;
    private javax.swing.JMenuItem jMenuItem21;
    private javax.swing.JMenuItem jMenuItem22;
    private javax.swing.JMenuItem jMenuItem23;
    private javax.swing.JMenuItem jMenuItem3;
    private javax.swing.JButton mbrButton;
    private javax.swing.JMenuItem mejorAjusteMenuItem;
    private javax.swing.JTextField memoriaParticionTextField;
    private javax.swing.JMenuItem modificarP1MenuItem;
    private javax.swing.JMenuItem modificarP2MenuItem;
    private javax.swing.JMenuItem modificarP3MenuItem;
    private javax.swing.JTextField nombreParticionTextField;
    private javax.swing.JButton particion1Button;
    private javax.swing.JButton particion2Button;
    private javax.swing.JButton particion3Button;
    private javax.swing.JMenuItem peorAjusteMenuItem;
    private javax.swing.JTextField porcentajeParticionTextField;
    private javax.swing.JMenuItem primerAjusteMenuItem;
    private javax.swing.JMenuItem reporteBloquesMenuItem;
    private javax.swing.JMenuItem reporteDirectorioMenuItem;
    // End of variables declaration//GEN-END:variables

    public Linked getLinkedP() {
        return linkedP;
    }

    public void setLinkedP(Linked linkedP) {
        this.linkedP = linkedP;
    }

}
