package Run;

import Exceptions.OutOfRangeException;
import Exceptions.WithoutSpaceException;
import Handlers.Indexed_Handler;
import java.util.Scanner;
import java.util.logging.Level;
import java.util.logging.Logger;

public class Run {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        
        Scanner entrada = new Scanner(System.in);
        int option = 0;
        do {
            System.out.println("======= Menu =======");
            System.out.println("Ingrese una opción: ");
            System.out.println("1. Crear Disco");
            System.out.println("2. Crear Archivo");
            System.out.println("3. Espacio Disponible");
            System.out.println("4. Cuadros utilizados");
            System.out.println("5. Cuadros totales");
            System.out.println("6. Salir");
            option = entrada.nextInt();
            Indexed_Handler indexedHandler = new Indexed_Handler();
            switch (option) {
                case 1:
                    System.out.println("Ingrese el tamaño de la particion (Mb): ");
                    int size = entrada.nextInt();
                    System.out.println("Ingrese el tamaño de los bloques (Kb): ");
                    int blocksize = entrada.nextInt();
                    try {
                        indexedHandler.createPartition(size, blocksize);
                    } catch (OutOfRangeException ex) {
                        System.out.println(ex.getMessage());
                    }
                    break;
                case 2:
                    System.out.println("Ingrese el id del archivo: ");
                    int idFile = entrada.nextInt();
                    System.out.println("Ingrese el tamaño del archio (Kb): ");
                    int sizeFile = entrada.nextInt();
                    try {
                        indexedHandler.createFile(idFile, sizeFile);
                    } catch (WithoutSpaceException ex) {
                        Logger.getLogger(Run.class.getName()).log(Level.SEVERE, null, ex);
                    }
            
                    break;
                case 3:
                    System.out.println("Espacio Disponible: " + indexedHandler.freeSpace());
                    break;
                case 4:
                    break;
                case 5:
                    break;
                case 6:
                    break;
                default:
                    break;
            }
        } while(option!=6);        
    }
}
