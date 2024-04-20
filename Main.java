import java.io.File;
import java.io.IOException;
import java.io.PrintStream;
import java.util.List;
import java.util.Scanner;

public class Main {
    private Mascota mascota;
    private Inventario inventario;
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
        stage1.printEstado(1,null);
        

        stage1.executeAction(new Scanner(System.in), System.out);
    }

    public void readConfiguration(Scanner in){
        // Creación de mascota
        String nombre_mascota = in.nextLine();
        mascota = new Mascota(nombre_mascota);
        System.out.println("Bienvenido a tu mascota virtual, felicidades por adoptar a " + nombre_mascota);
        // Creación de inventario vacío
        inventario = new Inventario();
        // Llenando inventario
        while (in.hasNextLine()) {
            String linea = in.nextLine();
            String[] item_csv = linea.split(";");
            int id = Integer.parseInt(item_csv[0]);
            String tipoItem = item_csv[1];
            String nombreItem = item_csv[2];
            int cantidad = Integer.parseInt(item_csv[3]);
            if (tipoItem.equals("Comida")) {
                inventario.agregarItem(new Comida(id, nombreItem, cantidad));
            } else if (tipoItem.equals("Medicina")) {
                inventario.agregarItem(new Medicina(id, nombreItem, cantidad));
            } else if (tipoItem.equals("Juguete")) {
                inventario.agregarItem(new Juguete(id, nombreItem, cantidad));
            } else {
                System.out.println("Tipo de item desconocido: " + tipoItem);
            }
        }
    }
    
    public void executeAction(Scanner in, PrintStream out){
        boolean running = true;
        while (running){
            out.println("Seleccione una accion:");
            out.println("1. Jugar con "+ mascota.getNombre());
            out.println("2. Alimentar a " + mascota.getNombre());
            out.println("3. Usar Medicina");

            int choice = in.nextInt();
            in.nextLine();

            switch(choice){
                case 1:
                    List<Juguete> juguetes = inventario.obtenerJuguetes();
                    if (!juguetes.isEmpty()){
                        System.out.println("Juguetes disponibles en el inventario:");
                        for (Juguete juguete : juguetes) {
                            System.out.println(juguete.getNombre() + ", ID: " + juguete.getId());
                        }
                        System.out.print("¿con cual te gustaria jugar? ");
                        int idJugueteSelec = Integer.parseInt(in.nextLine());
                        
                        Juguete jugueteSelec = null;
                        for (Juguete juguete : juguetes){
                            if (juguete.getId() == idJugueteSelec){
                                jugueteSelec = juguete;
                                break;
                            }
                        }
                        if (jugueteSelec != null) {
                            System.out.println("Ha seleccionado el juguete: " + jugueteSelec.getNombre());
                            inventario.usarItem(idJugueteSelec, mascota);
                            printEstado(0, null);
                        } else {
                            System.out.println("No Ingresaste correctamente la ID del juguete");
                        }

                    }else{
                        System.out.println("No hay juguetes disponibles en el inventario.");
                    }

                case 2:
                    List<Comida> comidas = inventario.obtenerComida();
                    if (!comidas.isEmpty()){
                        System.out.println("Alimentos disponibles en el inventario:");
                        for (Comida comida : comidas) {
                            System.out.println(comida.getNombre() + ", ID: " + comida.getId());
                        }
                        System.out.print("¿cual te gustaria darle de comer? ");
                        int idComidaSelec = Integer.parseInt(in.nextLine());
                        
                        Comida comidaSelec = null;
                        for (Comida comida : comidas){
                            if (comida.getId() == idComidaSelec){
                                comidaSelec = comida;
                                break;
                            }
                        }
                        if (comidaSelec != null) {
                            System.out.println("Ha seleccionado la comida: " + comidaSelec.getNombre());
                            inventario.usarItem(idComidaSelec, mascota);
                            printEstado(0, null);
                        } else {
                            System.out.println("No Ingresaste correctamente la ID del alimento");
                        }

                    }else{
                        System.out.println("No hay alimentos disponibles en el inventario.");
                    }
                case 3:
                    List<Medicina> medicinas = inventario.obtenerMedicina();
                    if (!medicinas.isEmpty()){
                        System.out.println("Medicinas disponibles en el inventario:");
                        for (Medicina medicina : medicinas) {
                            System.out.println(medicina.getNombre() + ", ID: " + medicina.getId());
                        }
                        System.out.print("¿cual te gustaria darle a "+ mascota.getNombre()+"? ");
                        int idMedicinaSelec = Integer.parseInt(in.nextLine());
                        
                        Medicina comidaSelec = null;
                        for (Medicina medicina : medicinas){
                            if (medicina.getId() == idMedicinaSelec){
                                comidaSelec = medicina;
                                break;
                            }
                        }
                        if (comidaSelec != null) {
                            System.out.println("Ha seleccionado la medicina: " + comidaSelec.getNombre());
                            inventario.usarItem(idMedicinaSelec, mascota);
                            printEstado(0, null);
                        } else {
                            System.out.println("No Ingresaste correctamente la ID de la medicina");
                        }

                    }else{
                        System.out.println("No hay medicinas disponibles en el inventario.");
                    }
            }
        }
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
            inventario.mostrarInventario();
        }
    }
    
}
