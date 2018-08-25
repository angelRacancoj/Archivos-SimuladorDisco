/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package GUI.frontend.pantallas;

import Exceptions.ExistenceException;
import GUI.backend.MetodosInterfaz;
import GUI.frontend.PrincipalFrame;
import java.io.IOException;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JFrame;
import javax.swing.JOptionPane;

/**
 *
 * @author daniel
 */
public class ReportesFrame1 extends javax.swing.JFrame {

    MetodosInterfaz metodosInterfaz;
    PrincipalFrame frame;
    int partition;

    public ReportesFrame1(PrincipalFrame frame, int partition) {
        this.frame = frame;
        this.partition = partition;
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

        jButton2 = new javax.swing.JButton();
        jScrollPane1 = new javax.swing.JScrollPane();
        jTextArea1 = new javax.swing.JTextArea();
        jButton1 = new javax.swing.JButton();
        cancelarButton = new javax.swing.JButton();
        jScrollPane2 = new javax.swing.JScrollPane();
        reporteTextArea = new javax.swing.JTextArea();

        jButton2.setText("jButton2");

        jTextArea1.setColumns(20);
        jTextArea1.setRows(5);
        jScrollPane1.setViewportView(jTextArea1);

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);

        jButton1.setText("Ver Reporte");
        jButton1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton1ActionPerformed(evt);
            }
        });

        cancelarButton.setText("Volver al menu principal");
        cancelarButton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                cancelarButtonActionPerformed(evt);
            }
        });

        reporteTextArea.setColumns(20);
        reporteTextArea.setRows(5);
        jScrollPane2.setViewportView(reporteTextArea);

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(jButton1)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 244, Short.MAX_VALUE)
                        .addComponent(cancelarButton))
                    .addComponent(jScrollPane2))
                .addContainerGap())
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jScrollPane2, javax.swing.GroupLayout.DEFAULT_SIZE, 279, Short.MAX_VALUE)
                .addGap(18, 18, 18)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jButton1)
                    .addComponent(cancelarButton))
                .addContainerGap())
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void jButton1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton1ActionPerformed
        switch (partition) {
            case 1:
//                    frame.getContiguaP().primerAjuste(newFile.getName(), String.valueOf(newFile.length() / 1024));
//                     textoTextArea.setText(frame.getContiguaP().);
                break;
            case 2:
                this.reporteTextArea.setText(frame.getLinkedP().getReporte1());
                break;
            case 3:
                reporteTextArea.setText(frame.getIndexP().directoryReport());
//                    frame.getIndexP().createFile(Integer.valueOf(newFile.getName()), (int) newFile.length());
                break;
            case 4:
//                    frame.getContiguaP().
                break;
            case 5:
//                    frame.getContiguaP().
                break;
            default:
                JOptionPane.showMessageDialog(null, "\nOpcion de disco Incorrecta. ", "ADVERTENCIA!!!", JOptionPane.ERROR_MESSAGE);
                break;

        }
    }//GEN-LAST:event_jButton1ActionPerformed

    private void cancelarButtonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_cancelarButtonActionPerformed
        this.setVisible(false);
        frame.setVisible(true);
    }//GEN-LAST:event_cancelarButtonActionPerformed

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton cancelarButton;
    private javax.swing.JButton jButton1;
    private javax.swing.JButton jButton2;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JScrollPane jScrollPane2;
    private javax.swing.JTextArea jTextArea1;
    private javax.swing.JTextArea reporteTextArea;
    // End of variables declaration//GEN-END:variables
}
