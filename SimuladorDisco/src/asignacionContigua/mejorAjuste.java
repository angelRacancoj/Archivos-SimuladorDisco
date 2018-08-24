/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package asignacionContigua;

/**
 *
 * @author charly
 */
public class mejorAjuste {

    private int numeroCuadros;
    private int indiceComienzo;

    public mejorAjuste(int indiceComienzo, int numeroCuadros) {
        this.numeroCuadros = numeroCuadros;
        this.indiceComienzo = indiceComienzo;
    }

    public int getNumeroCuadros() {
        return numeroCuadros;
    }

    public void setNumeroCuadros(int numeroCuadros) {
        this.numeroCuadros = numeroCuadros;
    }

    public int getIndiceComienzo() {
        return indiceComienzo;
    }

    public void setIndiceComienzo(int indiceComienzo) {
        this.indiceComienzo = indiceComienzo;
    }

}
