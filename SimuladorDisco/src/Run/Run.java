package Run;

import Exceptions.ExistenceException;
import Exceptions.OutOfRangeException;
import Exceptions.WithoutSpaceException;
import Handlers.Indexed_Handler;
import java.util.Scanner;

public class Run {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        
        Scanner entrada = new Scanner(System.in);
        int option = 0;
        Indexed_Handler indexedHandler = new Indexed_Handler();
        do {
            System.out.println("======= Menu =======");
            System.out.println("Ingrese una opción: ");
            System.out.println("1. Crear Disco");
            System.out.println("2. Crear Archivo");
            System.out.println("3. Reporte Directorio");
            System.out.println("4. Reporte Bloques");
            System.out.println("5. Formatear Partición");
            System.out.println("6. Consultar Archivo");
            System.out.println("7. Salir");
            option = entrada.nextInt();
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
                    } catch (WithoutSpaceException | ExistenceException ex) {
                        System.out.println(ex.getMessage());
                    }
                    break;
                case 3:
                    System.out.println(indexedHandler.directoryReport());
                    break;
                case 4:
                    System.out.println("Ingrese la cantidad de bloques a visualizar: ");
                    int blocks = entrada.nextInt();
            
                    try {
                        System.out.println(indexedHandler.blockReport(blocks));
                    } catch (OutOfRangeException ex) {
                        System.out.println(ex.getMessage());
                    }
            
                    break;
                case 5:
                    indexedHandler.formatPartition();
                    break;
                case 6:
                    System.out.println("Ingrese el id del archivo: ");
                    int idFileSearch = entrada.nextInt();
                    try {
                        System.out.println(indexedHandler.consultSizeFile(idFileSearch));
                    } catch (ExistenceException ex) {
                        System.out.println(ex.getMessage());
                    }
            
                    break;
                default:
                    break;
            }
        } while(option!=7);        
    }
}
