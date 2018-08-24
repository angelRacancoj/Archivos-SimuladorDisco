/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package asignacionContigua;

import java.util.ArrayList;

/**
 *
 * @author charly
 */
public class manejadorAsignacionContigua {

    asignacionContigua contigua;
    int tamanioBloques;
    ArrayList<mejorAjuste> listadoMejorAjuste = new ArrayList<>();
    ArrayList<mejorAjuste> listadoPeorAjuste = new ArrayList<>();

    public manejadorAsignacionContigua() {
    }

    public void crearParticion(String tamanioParticion, String tamanioBloque) {
        this.tamanioBloques = Integer.parseInt(tamanioBloque);
        int tamParticion = Integer.parseInt(tamanioParticion);
        int tamBloque = Integer.parseInt(tamanioBloque);
        contigua = new asignacionContigua(tamParticion, tamBloque);

    }

    public boolean consultarExistencia(String id) {
        boolean existe = false;
        for (int i = 0; i < contigua.getListadoBloque().size(); i++) {
            if (id.equalsIgnoreCase(String.valueOf(contigua.getListadoBloque().get(i).getId()))) {
                existe = true;
            }
        }
        return existe;
    }

    public boolean consultarEstado(String id) {
        boolean estado = false;
        for (int i = 0; i < contigua.getListadoBloque().size(); i++) {
            if (id.equalsIgnoreCase(String.valueOf(contigua.getListadoBloque().get(i).getId()))) {
                if (contigua.getListadoBloque().get(i).isEstado() == true) {
                    estado = true;
                }

            }
        }
        return estado;
    }

    public String[][] mostrarTabla() {
        String matris[][] = new String[contigua.getListadoBloque().size()][4];

        for (int i = 0; i < contigua.getListadoBloque().size(); i++) {
            String a = String.valueOf(contigua.getListadoBloque().get(i).getId());
            String c = String.valueOf(contigua.getListadoBloque().get(i).isEstado());
            String d = contigua.getListadoBloque().get(i).getArchivo();
            String e = String.valueOf(contigua.getListadoBloque().get(i).getData());
            String b;
            if (c.equals("false")) {
                b = "0";
            } else {
                b = "1";
            }

            matris[i][0] = a;
            matris[i][1] = b;
            matris[i][2] = d;
            matris[i][3] = e;
        }

        return matris;

    }

    public void primerAjuste(String nombreArchivo, String tamArchivo) {
        int cuadrosNecesarios = (Integer.parseInt(tamArchivo) / tamanioBloques);
        double sobrante = (Integer.parseInt(tamArchivo) % tamanioBloques);
        if (sobrante <= 0) {

        } else {
            cuadrosNecesarios++;
        }
        recorrerPrimerAjuste(nombreArchivo, cuadrosNecesarios, sobrante);

    }

    private void recorrerPrimerAjuste(String nombre, int cuadrosNecesarios, double sobrante) {
        int contador = 0;
        for (int i = 0; i < contigua.getListadoBloque().size(); i++) {
            if (contigua.getListadoBloque().get(i).isEstado() == false) {
                contador++;
                if (cuadrosNecesarios == contador) {
                    int inicio = 1 + (i - contador);
                    if (sobrante == 0.0) {
                        for (int j = 0; j < contador; j++) {
                            contigua.getListadoBloque().get(inicio + j).setArchivo(nombre);
                            contigua.getListadoBloque().get(inicio + j).setData(tamanioBloques);
                            contigua.getListadoBloque().get(inicio + j).setEstado(true);
                        }
                    } else {
                        for (int j = 0; j < contador - 1; j++) {
                            contigua.getListadoBloque().get(inicio + j).setArchivo(nombre);
                            contigua.getListadoBloque().get(inicio + j).setData(tamanioBloques);
                            contigua.getListadoBloque().get(inicio + j).setEstado(true);
                        }
                        contigua.getListadoBloque().get(i).setArchivo(nombre);
                        contigua.getListadoBloque().get(i).setData(sobrante);
                        contigua.getListadoBloque().get(i).setEstado(true);
                    }
                }
            } else {

            }
        }
    }

    /*
    public void buscarID(String id) {
        double tamanioTotal = 0;
        for (int i = 0; i < contigua.getListadoBloque().size(); i++) {
            if (id.equalsIgnoreCase(contigua.getListadoBloque().get(i).getArchivo())) {
                ventana.insertarID(contigua.getListadoBloque().get(i).getArchivo());
                tamanioTotal = tamanioTotal + contigua.getListadoBloque().get(i).getData();
            }
        }
        ventana.insertarTamanio(String.valueOf(tamanioTotal));
    }
     */
    public void modificarPrimerAjuste(String id, String tamanio) {
        eliminarArchivo(id);
        primerAjuste(id, tamanio);
    }

    public void mejorAjuste(String nombreArchivo, String tamArchivo) {
        int cuadrosNecesarios = (Integer.parseInt(tamArchivo) / tamanioBloques);
        double sobrante = (Integer.parseInt(tamArchivo) % tamanioBloques);
        if (sobrante <= 0) {

        } else {
            cuadrosNecesarios++;
        }
        recorrerMejorAjuste(nombreArchivo, cuadrosNecesarios, sobrante);

    }

    private void recorrerMejorAjuste(String nombre, int cuadrosNecesarios, double sobrante) {
        int contador = 0;
        for (int i = 0; i < contigua.getListadoBloque().size() - 1; i++) {
            if (contigua.getListadoBloque().get(i).isEstado() == false) {
                contador++;
                if (contigua.getListadoBloque().get(i + 1).isEstado() == true) {
                    int inicio = 1 + (i - contador);
                    mejorAjuste mejor = new mejorAjuste(inicio, contador);
                    listadoMejorAjuste.add(mejor);
                    contador = 0;
                }
            } else {
                //condicion para el ultimo elemento
            }
        }

        insertarMejorAjuste(nombre, cuadrosNecesarios, sobrante);
    }

    private void insertarMejorAjuste(String nombre, int cuadrosNecesarios, double sobrante) {

        if (sobrante == 0.0) {
            for (int i = 0; i < listadoMejorAjuste.size(); i++) {
                if (cuadrosNecesarios == listadoMejorAjuste.get(i).getNumeroCuadros()) {
                    for (int j = 0; j < cuadrosNecesarios - 1; j++) {
                        contigua.getListadoBloque().get(listadoMejorAjuste.get(i).getIndiceComienzo() + j).setArchivo(nombre);
                        contigua.getListadoBloque().get(listadoMejorAjuste.get(i).getIndiceComienzo() + j).setData(sobrante);
                        contigua.getListadoBloque().get(listadoMejorAjuste.get(i).getIndiceComienzo() + j).setEstado(true);
                    }
                    contigua.getListadoBloque().get(listadoMejorAjuste.get(i).getIndiceComienzo() + cuadrosNecesarios).setArchivo(nombre);
                    contigua.getListadoBloque().get(listadoMejorAjuste.get(i).getIndiceComienzo() + cuadrosNecesarios).setData(sobrante);
                    contigua.getListadoBloque().get(listadoMejorAjuste.get(i).getIndiceComienzo() + cuadrosNecesarios).setEstado(true);
                    i = listadoMejorAjuste.size();
                } else if (cuadrosNecesarios < listadoMejorAjuste.get(i).getNumeroCuadros()) {
                    for (int j = 0; j < cuadrosNecesarios - 1; j++) {
                        contigua.getListadoBloque().get(listadoMejorAjuste.get(i).getIndiceComienzo() + j).setArchivo(nombre);
                        contigua.getListadoBloque().get(listadoMejorAjuste.get(i).getIndiceComienzo() + j).setData(sobrante);
                        contigua.getListadoBloque().get(listadoMejorAjuste.get(i).getIndiceComienzo() + j).setEstado(true);
                    }
                    contigua.getListadoBloque().get(listadoMejorAjuste.get(i).getIndiceComienzo() + cuadrosNecesarios).setArchivo(nombre);
                    contigua.getListadoBloque().get(listadoMejorAjuste.get(i).getIndiceComienzo() + cuadrosNecesarios).setData(sobrante);
                    contigua.getListadoBloque().get(listadoMejorAjuste.get(i).getIndiceComienzo() + cuadrosNecesarios).setEstado(true);
                    i = listadoMejorAjuste.size();
                } else {
                    System.out.println("NO HAY ESPACIO PARA GUARDAR EL ARCHIVO 1");
                }
            }
        } else {
            for (int i = 0; i < listadoMejorAjuste.size(); i++) {
                if (cuadrosNecesarios == listadoMejorAjuste.get(i).getNumeroCuadros()) {
                    for (int j = 0; j < cuadrosNecesarios - 1; j++) {
                        contigua.getListadoBloque().get(listadoMejorAjuste.get(i).getIndiceComienzo() + j).setArchivo(nombre);
                        contigua.getListadoBloque().get(listadoMejorAjuste.get(i).getIndiceComienzo() + j).setData(tamanioBloques);
                        contigua.getListadoBloque().get(listadoMejorAjuste.get(i).getIndiceComienzo() + j).setEstado(true);
                    }
                    i = listadoMejorAjuste.size();
                } else if (cuadrosNecesarios < listadoMejorAjuste.get(i).getNumeroCuadros()) {
                    for (int j = 0; j < cuadrosNecesarios - 1; j++) {
                        contigua.getListadoBloque().get(listadoMejorAjuste.get(i).getIndiceComienzo() + j).setArchivo(nombre);
                        contigua.getListadoBloque().get(listadoMejorAjuste.get(i).getIndiceComienzo() + j).setData(tamanioBloques);
                        contigua.getListadoBloque().get(listadoMejorAjuste.get(i).getIndiceComienzo() + j).setEstado(true);
                    }
                    i = listadoMejorAjuste.size();
                } else {
                    System.out.println("NO HAY ESPACIO PARA GUARDAR EL ARCHIVO 2");
                }
            }
        }

    }

    public String[][] mostrarTabla2() {

        String matris[][] = new String[listadoMejorAjuste.size()][2];

        for (int i = 0; i < listadoMejorAjuste.size(); i++) {
            String a = String.valueOf(listadoMejorAjuste.get(i).getIndiceComienzo());
            String b = String.valueOf(listadoMejorAjuste.get(i).getNumeroCuadros());

            matris[i][0] = a;
            matris[i][1] = b;

        }

        return matris;

    }

    public void PeorAjuste(String nombreArchivo, String tamArchivo) {
        int cuadrosNecesarios = (Integer.parseInt(tamArchivo) / tamanioBloques);
        double sobrante = (Integer.parseInt(tamArchivo) % tamanioBloques);
        if (sobrante <= 0) {

        } else {
            cuadrosNecesarios++;
        }
        recorrerPeorAjuste(nombreArchivo, cuadrosNecesarios, sobrante);

    }

    private void recorrerPeorAjuste(String nombre, int cuadrosNecesarios, double sobrante) {
        int contador = 0;
        for (int i = 0; i < contigua.getListadoBloque().size() - 1; i++) {
            if (contigua.getListadoBloque().get(i).isEstado() == false) {
                contador++;
                if (contigua.getListadoBloque().get(i + 1).isEstado() == true) {
                    int inicio = 1 + (i - contador);
                    mejorAjuste mejor = new mejorAjuste(inicio, contador);
                    listadoPeorAjuste.add(mejor);
                    contador = 0;
                }
            } else {
                //condicion para el ultimo elemento
            }
        }

        insertarPeorAjuste(nombre, cuadrosNecesarios, sobrante);
    }

    private void insertarPeorAjuste(String nombre, int cuadrosNecesarios, double sobrante) {
        if (sobrante == 0.0) {

        } else {
            for (int i = 0; i < listadoPeorAjuste.size(); i++) {
                if (listadoPeorAjuste.get(i).getNumeroCuadros() > cuadrosNecesarios) {
                    for (int j = 0; j < cuadrosNecesarios - 1; j++) {
                        contigua.getListadoBloque().get(listadoMejorAjuste.get(i).getIndiceComienzo() + j).setArchivo(nombre);
                        contigua.getListadoBloque().get(listadoMejorAjuste.get(i).getIndiceComienzo() + j).setData(tamanioBloques);
                        contigua.getListadoBloque().get(listadoMejorAjuste.get(i).getIndiceComienzo() + j).setEstado(true);
                    }
                }
            }
        }
    }

    public void eliminarArchivo(String id) {

        for (int i = 0; i < contigua.getListadoBloque().size(); i++) {
            if (id.equalsIgnoreCase(contigua.getListadoBloque().get(i).getArchivo())) {
                contigua.getListadoBloque().get(i).setArchivo("NULL");
                contigua.getListadoBloque().get(i).setData(0.0);
                contigua.getListadoBloque().get(i).setEstado(false);
            }
        }

    }

    public String reporteUno(String id) {
        String reporte = "";
        String nombre = "";
        double tamanioTotal = 0;
        for (int i = 0; i < contigua.getListadoBloque().size(); i++) {
            if (id.equalsIgnoreCase(contigua.getListadoBloque().get(i).getArchivo())) {
                nombre = contigua.getListadoBloque().get(i).getArchivo();
                tamanioTotal = tamanioTotal + contigua.getListadoBloque().get(i).getData();
            }
        }
        reporte = reporte + "EL NOMBRE DEL ARCHIVO ES: " + nombre + " Y SU TAMANIO ES: " + tamanioTotal;
        return reporte;
    }

    public String reporteDos() {
        String reporte = "";

        for (int i = 0; i < contigua.getListadoBloque().size(); i++) {
            reporte = reporte + "EL ID DEL BLOQUE ES: " + contigua.getListadoBloque().get(i).getId()
                    + " , EL NOMBRE DEL ARCHIVO ES: " + contigua.getListadoBloque().get(i).getArchivo()
                    + " , Y EL TAMANIO ES DE: " + contigua.getListadoBloque().get(i).getData() + "\n";
        }

        return reporte;

    }

}
