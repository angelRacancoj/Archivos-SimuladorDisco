/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package GUI.frontend.pantallas;

import Exceptions.ExistenceException;
import Exceptions.WithoutSpaceException;
import GUI.backend.MetodosInterfaz;
import GUI.frontend.PrincipalFrame;
import java.io.File;
import java.io.IOException;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JFrame;
import javax.swing.JOptionPane;

/**
 *
 * @author daniel
 */
public class ModificarArchivoFrame extends javax.swing.JFrame {

    /**
     * Creates new form ModificarArchivoFrame
     */
    PrincipalFrame frame;
    int partition;
    MetodosInterfaz metodosInterfaz;

    public ModificarArchivoFrame(PrincipalFrame frame, int partition) {
        this.partition = partition;
        initComponents();
        this.frame = frame;
        metodosInterfaz = new MetodosInterfaz();
    }

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jLabel1 = new javax.swing.JLabel();
        nombreFormattedTextField = new javax.swing.JFormattedTextField();
        jLabel2 = new javax.swing.JLabel();
        jScrollPane1 = new javax.swing.JScrollPane();
        textoTextArea = new javax.swing.JTextArea();
        saveChangesButton = new javax.swing.JButton();
        cancelarButton = new javax.swing.JButton();
        findFileButton = new javax.swing.JButton();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setTitle("Modificar Archivo");

        jLabel1.setText("Ingrese el ID:");

        nombreFormattedTextField.setFormatterFactory(new javax.swing.text.DefaultFormatterFactory(new javax.swing.text.NumberFormatter(new java.text.DecimalFormat("#########"))));

        jLabel2.setText("Texto:");

        textoTextArea.setColumns(20);
        textoTextArea.setRows(5);
        jScrollPane1.setViewportView(textoTextArea);

        saveChangesButton.setText("Guardar Cambios");
        saveChangesButton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                saveChangesButtonActionPerformed(evt);
            }
        });

        cancelarButton.setText("Cancelar");
        cancelarButton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                cancelarButtonActionPerformed(evt);
            }
        });

        findFileButton.setText("Buscar Archivo");
        findFileButton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                findFileButtonActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jScrollPane1, javax.swing.GroupLayout.Alignment.TRAILING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jLabel1)
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(nombreFormattedTextField, javax.swing.GroupLayout.PREFERRED_SIZE, 299, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(43, 43, 43)
                        .addComponent(findFileButton))
                    .addComponent(jLabel2))
                .addContainerGap(124, Short.MAX_VALUE))
            .addGroup(layout.createSequentialGroup()
                .addGap(78, 78, 78)
                .addComponent(saveChangesButton)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 165, Short.MAX_VALUE)
                .addComponent(cancelarButton)
                .addGap(142, 142, 142))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(47, 47, 47)
                .addComponent(jLabel1)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(nombreFormattedTextField, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(findFileButton))
                .addGap(36, 36, 36)
                .addComponent(jLabel2)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 270, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(saveChangesButton)
                    .addComponent(cancelarButton))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void saveChangesButtonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_saveChangesButtonActionPerformed
        try {
            File newFile = metodosInterfaz.Guardar(nombreFormattedTextField.getText(), textoTextArea.getText());

            switch (partition) {
                case 1:
                    frame.getContiguaP().modificarPrimerAjuste(newFile.getName(), String.valueOf((newFile.length() / 1024)));
                    break;
                case 2:
                    frame.getLinkedP().modifyFile(newFile);
                    break;
                case 3:
                    frame.getIndexP().modifyFile(Integer.getInteger(newFile.getName()), (int) (newFile.length() / 1024));
                    break;
                case 4:
//                    frame.getContiguaP().
                    break;
                case 5:
                    break;
                default:
                    JOptionPane.showMessageDialog(null, "\nOpcion de disco Incorrecta. ", "ADVERTENCIA!!!", JOptionPane.ERROR_MESSAGE);
                    break;
            }
            this.setVisible(false);
            frame.setVisible(true);
        } catch (IOException ex) {
            JOptionPane.showMessageDialog(null, "\nError al guardar el archivo. ", "ADVERTENCIA!!!", JOptionPane.ERROR_MESSAGE);
            System.out.println("en guardar el archivo");

        } catch (ExistenceException | WithoutSpaceException ex) {
            JOptionPane.showMessageDialog(null, "\nError: " + ex, "ADVERTENCIA!!!", JOptionPane.ERROR_MESSAGE);
        }
    }//GEN-LAST:event_saveChangesButtonActionPerformed

    private void cancelarButtonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_cancelarButtonActionPerformed
        // TODO add your handling code here:
        this.setVisible(false);
        frame.setVisible(true);
    }//GEN-LAST:event_cancelarButtonActionPerformed

    private void findFileButtonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_findFileButtonActionPerformed
        textoTextArea.setText(metodosInterfaz.AbrirBin());
    }//GEN-LAST:event_findFileButtonActionPerformed

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton cancelarButton;
    private javax.swing.JButton findFileButton;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JFormattedTextField nombreFormattedTextField;
    private javax.swing.JButton saveChangesButton;
    private javax.swing.JTextArea textoTextArea;
    // End of variables declaration//GEN-END:variables
}
