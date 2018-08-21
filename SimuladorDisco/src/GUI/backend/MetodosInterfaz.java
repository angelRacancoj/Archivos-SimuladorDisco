/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package GUI.backend;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.File;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import javax.swing.JButton;
import javax.swing.JFileChooser;
import javax.swing.JOptionPane;
import javax.swing.JSlider;
import javax.swing.JTextField;
import javax.swing.filechooser.FileNameExtensionFilter;

/**
 *
 * @author daniel
 */
public class MetodosInterfaz {

    public MetodosInterfaz() {
    }

    public void AgregarValor_TextField(JSlider slider, JTextField field) {
        field.setText(Integer.toString(slider.getValue()));
    }

    public void verificarPorcentaje(JSlider slider1, JTextField field1, JSlider slider2, JTextField field2, JSlider slider3, JTextField field3) {
        int valor1 = slider1.getValue();
        int valor2 = slider2.getValue();
        int valor3 = slider3.getValue();

        if (valor1 < 100) {

            if ((valor1 + valor3) > 100) {
                slider3.setValue(100 - valor1);
                field1.setText(Integer.toString(slider1.getValue()));
                field2.setText(Integer.toString(slider2.getValue()));
                field3.setText(Integer.toString(slider3.getValue()));
            } else {

                slider2.setValue(100 - (valor1 + valor3));
                field1.setText(Integer.toString(slider1.getValue()));
                field2.setText(Integer.toString(slider2.getValue()));
                field3.setText(Integer.toString(slider3.getValue()));
            }
        } else {
            slider2.setValue(0);
            slider3.setValue(0);
            field1.setText(Integer.toString(slider1.getValue()));
            field2.setText(Integer.toString(slider2.getValue()));
            field3.setText(Integer.toString(slider3.getValue()));
        }

    }

    public void CambiarTamano(JButton button) {
        button.setBounds(0, 0, 100, 300);
    }

    public void EstablecerPorcentaje(int particion1Porcenaje, int particion2Porcenaje, int particion3Porcenaje, JButton button1, JButton button2, JButton button3) {
        double prueba1 = particion1Porcenaje * 0.01;
        double prueba2 = particion2Porcenaje * 0.01;
        double prueba3 = particion3Porcenaje * 0.01;
        int pixeles1 = (int) (prueba1 * 1000);
        int pixeles2 = (int) (prueba2 * 1000);
        int pixeles3 = (int) (prueba3 * 1000);
        button1.setBounds(300, 0, pixeles1, 300);
        button2.setBounds(300 + pixeles1, 0, pixeles2, 300);
        button3.setBounds(300 + pixeles1 + pixeles2, 0, pixeles3, 300);

    }

    /**
     * This method create a file, base in the text and name set to the new file
     *
     * @param nombre
     * @param cadena
     * @return
     * @throws IOException
     */
    public File Guardar(String nombre, String cadena) throws IOException {
        long size = 0;
        File file = null;
        if (nombre.replaceAll(" ", "").replaceAll("\t", "").isEmpty() && cadena != null) {
            //AgregarNombreAlArchivoSalida(nombre);

            file = new File(nombre + ".bin");
            FileWriter fileWriter = new FileWriter(file);
            BufferedWriter bufferedWriter = new BufferedWriter(fileWriter);
            bufferedWriter.write(cadena);
            bufferedWriter.close();
            fileWriter.close();
            size = file.getTotalSpace();

            JOptionPane.showMessageDialog(null, "\nEl archivo se a guardado correctamente. ", "ADVERTENCIA!!!", JOptionPane.WARNING_MESSAGE);

        } else {
            JOptionPane.showMessageDialog(null, "\nLLene todos los campos. ", "ADVERTENCIA!!!", JOptionPane.WARNING_MESSAGE);
        }
        // System.out.println(fileChooser2.getSelectedFile());
        return file;
    }

    private JFileChooser fileChooser;
    private File archivo;

    /**
     * This method implement the File Chooser to get the file, then read the
     * file to get the text
     *
     * @return
     */
    public String AbrirBin() {

        String aux = "";
        String texto = "";
        String direccion = "";
        try {
            // llamamos el metodo que permite cargar la ventana
            fileChooser = new JFileChooser();
            FileNameExtensionFilter filtro = new FileNameExtensionFilter(".bin", "bin");
            fileChooser.setFileFilter(filtro);
            fileChooser.showOpenDialog(fileChooser);
            archivo = fileChooser.getSelectedFile();
            fileChooser.addChoosableFileFilter(filtro);

            // recorremos el archivo, lo leemos para plasmarlo en el area de
            // texto
            int status = 0;
            if (archivo != null) {
                if (archivo.getName().endsWith("bin")) {
                    if (fileChooser != null) {
                        FileReader archivos = new FileReader(archivo);

                        BufferedReader lee = new BufferedReader(archivos);
                        while ((aux = lee.readLine()) != null) {
                            texto += aux + "\n";
                            // existe = true;
                            direccion = archivo.getAbsolutePath();
                        }
                        lee.close();
                        archivos.close();
                    }
                } else {
                    JOptionPane.showMessageDialog(null, "ERROR", "Solo se acepta formato pnt", 0);
                }
            }
            if (status == JFileChooser.CANCEL_OPTION) {
                JOptionPane.showMessageDialog(null, "No eligio ningun archivo", "Error", 0);
            }
        } catch (IOException ex) {
            JOptionPane.showMessageDialog(null, ex + ""
                    + "\nNo se ha encontrado el archivo", "ADVERTENCIA!!!",
                    JOptionPane.WARNING_MESSAGE);
        }

        return texto;
    }

}
