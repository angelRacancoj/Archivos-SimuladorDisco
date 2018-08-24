/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package asignacionContigua;

import bloques.bloqueContiguo;
import java.util.ArrayList;

/**
 *
 * @author charly
 */
public class asignacionContigua {

    private int tamanioParticion;
    private int tamanioBloque;

    ArrayList<bloqueContiguo> listadoBloque = new ArrayList<bloqueContiguo>();

    public asignacionContigua() {
    }

    public asignacionContigua(int tamanioParticion, int tamanioBloque) {
        this.tamanioParticion = tamanioParticion;
        this.tamanioBloque = tamanioBloque;
        crearBloques(tamanioParticion, tamanioBloque);
    }

    public int getTamanioParticion() {
        return tamanioParticion;
    }

    public void setTamanioParticion(int tamanioParticion) {
        this.tamanioParticion = tamanioParticion;
    }

    public int getTamanioBloque() {
        return tamanioBloque;
    }

    public void setTamanioBloque(int tamanioBloque) {
        this.tamanioBloque = tamanioBloque;
    }

    public ArrayList<bloqueContiguo> getListadoBloque() {
        return listadoBloque;
    }

    public void setListadoBloque(ArrayList<bloqueContiguo> listadoBloque) {
        this.listadoBloque = listadoBloque;
    }

    public void crearBloques(int tamParticion, int tamBloques) {
        int numeroBloquesTotales = (tamParticion / tamBloques);

        for (int i = 0; i < numeroBloquesTotales; i++) {
            bloqueContiguo bloque = new bloqueContiguo(i, "NULL", 0, false, tamBloques);
            listadoBloque.add(bloque);
            System.out.println("BLOQUE CON ID: " + bloque.getId());
        }
        System.out.println("NUMERO DE BLOQUES: " + numeroBloquesTotales);

    }

}
