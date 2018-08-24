/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package bloques;

/**
 *
 * @author charly
 */
public class bloqueContiguo extends Block{

    private String archivo;
    private double data;
    private boolean estado; 
    
    public bloqueContiguo(int id, String archivo, double data, boolean estado, int tamanio) {
        super(id, tamanio);
        this.archivo = archivo;
        this.data = data;
        this.estado = estado;
    }

    public String getArchivo() {
        return archivo;
    }

    public void setArchivo(String archivo) {
        this.archivo = archivo;
    }

    public double getData() {
        return data;
    }

    public void setData(double data) {
        this.data = data;
    }

    public boolean isEstado() {
        return estado;
    }

    public void setEstado(boolean estado) {
        this.estado = estado;
    }
    
    
    
    
    
    
    
    
    
}
