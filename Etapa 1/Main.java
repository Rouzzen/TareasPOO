import java.io.File;
import java.io.IOException;
import java.io.PrintStream;
import java.util.Scanner;

public class Main {
    private Mascota mascota;
    public static void main(String[] args) throws IOException {
        // Carga de archivo config.csv
        if (args.length != 1) {
            System.out.println("Usage: java Stage1 <config.csv>");
            System.exit(-1);
        }

        Scanner in = new Scanner(new File(args[0]));
        Main stage1 = new Main();
        // Lectura de archivo config.csv
        stage1.readConfiguration(in);
        stage1.printEstado(0, null);

        stage1.executeAction(new Scanner(System.in), System.out);
    }

    public void readConfiguration(Scanner in){
        // Creación de mascota
        String nombre_mascota = in.nextLine();
        mascota = new Mascota(nombre_mascota);
        System.out.println("Bienvenido a tu mascota virtual, felicidades por adoptar a " + nombre_mascota);
    }
    
    public void executeAction(Scanner in, PrintStream out){ 
        
    }

    public void printEstado(float step, PrintStream out){
        /* Completar método que muestra el estado de la Mascota y del inventario
        dependiendo de la etapa */
        if (step == 0) {
            System.out.println("-----------");
            System.out.println("Parametros");
            System.out.println("-----------");
            System.out.println("Nombre: "+ mascota.getNombre());
            System.out.println("Edad: "+ mascota.getEdad());
            System.out.println("Salud: "+ mascota.getSalud());
            System.out.println("Energia: "+ mascota.getEnergia());
            System.out.println("Felicidad : "+ mascota.getFelicidad());
            mascota.getEstado();
        }
        else{
        }
    }
    
}
