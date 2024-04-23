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
        // CREACION DE MASCOTA
        String nombre_mascota = in.nextLine();
        mascota = new Mascota(nombre_mascota);
        System.out.println("Bienvenido a tu mascota virtual, felicidades por adoptar a " + nombre_mascota);
        // CREACIÓN DE INVENTARIO VACÍO
        inventario = new Inventario();
        // LLENANDO INVENTARIO
        Comida comida1 = new Comida(1, "Queso", 5);
        inventario.agregarItem(comida1);

        Comida comida2 = new Comida(2, "Pan", 3);
        inventario.agregarItem(comida2);

        Medicina medicina = new Medicina(3, "Jarabe", 4);
        inventario.agregarItem(medicina);

        Juguete juguete = new Juguete(4, "Pelota", 4);
        inventario.agregarItem(juguete);
    }
    
    // EJECUTAR ACCION
    public void executeAction(Scanner in, PrintStream out){ 
        double tiempo = 0.0;
        boolean condicion = true;
        while (condicion) {
            // MASCOTA MUERE POR EDAD
            if (mascota.getEdad() >= 15.0) {
                out.println("Tu mascota ha muerto x_x");
                break;   
            }
            // MASCOTA MUERE POR OTRA RAZON
            if (mascota.getEstado() == Estado.Muerto) {
                out.println("Tu mascota ha muerto x_x");
                break;   
            }
            out.println("MENU");
            boolean running = true;
                    while (running){
                        out.println("Seleccione una accion:");
                        out.println("0. Dormir ");
                        out.println("1. Jugar con "+ mascota.getNombre());
                        out.println("2. Alimentar a " + mascota.getNombre());
                        out.println("3. Usar Medicina");
                        out.println("4. Mostrar Inventario");
        
                        int choice = in.nextInt();
                        in.nextLine();
        
                        switch(choice){
                            // MASCOTA DUERME
                            case 0:
                                mascota.Dormir();
                                printEstado(choice, out);
                                tiempo = tiempo + 0.5;
                                running = false;
                                break;
                            // MASCOTA JUEGA
                            case 1:
                                List<Juguete> juguetes = inventario.obtenerJuguetes();
                                if (!juguetes.isEmpty()){
                                    System.out.println("Juguetes disponibles en el inventario:");
                                    for (Juguete juguete : juguetes) {
                                        System.out.println(juguete.getNombre() + ", ID: " + juguete.getId()+ ", Cantidad: "+ juguete.getCantidad());
                                    }
                                    System.out.print("con cual te gustaria jugar? ");
                                    int idJugueteSelec = Integer.parseInt(in.nextLine());
                                    
                                    Juguete jugueteSelec = null;
                                    for (Juguete juguete : juguetes){
                                        if (juguete.getId() == idJugueteSelec){
                                            jugueteSelec = juguete;
                                            tiempo = tiempo + 0.5;
                                            mascota.tick();
                                            running = false;
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
                                    running = false;
                                    tiempo = tiempo + 0.5;
                                    mascota.tick();
                                    break;
        
                                }else{
                                    System.out.println("No hay juguetes disponibles en el inventario.");
                                    running = false;
                                    break;
                                }
                            // MASCOTA COME
                            case 2:
                                List<Comida> comidas = inventario.obtenerComida();
                                if (!comidas.isEmpty()){
                                    System.out.println("Alimentos disponibles en el inventario:");
                                    for (Comida comida : comidas) {
                                        System.out.println(comida.getNombre() + ", ID: " + comida.getId()+ ", Cantidad: "+ comida.getCantidad());
                                    }
                                    System.out.print("cual te gustaria darle de comer? ");
                                    int idComidaSelec = Integer.parseInt(in.nextLine());
                                    
                                    Comida comidaSelec = null;
                                    for (Comida comida : comidas){
                                        if (comida.getId() == idComidaSelec){
                                            comidaSelec = comida;
                                            tiempo = tiempo + 0.5;
                                            mascota.tick();
                                            running = false;
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
                                    tiempo = tiempo + 0.5;
                                    mascota.tick();
                                    running = false;
                                    break;
        
                                }else{
                                    System.out.println("No hay alimentos disponibles en el inventario.");
                                    running = false;
                                    break;
                                }
                            // MASCOTA USA MEDICINA
                            case 3:
                                List<Medicina> medicinas = inventario.obtenerMedicina();
                                if (!medicinas.isEmpty()){
                                    System.out.println("Medicinas disponibles en el inventario:");
                                    for (Medicina medicina : medicinas) {
                                        System.out.println(medicina.getNombre() + ", ID: " + medicina.getId()+ ", Cantidad: "+ medicina.getCantidad());
                                    }
                                    System.out.print("cual te gustaria darle a "+ mascota.getNombre()+"? ");
                                    int idMedicinaSelec = Integer.parseInt(in.nextLine());
                                    
                                    Medicina comidaSelec = null;
                                    for (Medicina medicina : medicinas){
                                        if (medicina.getId() == idMedicinaSelec){
                                            comidaSelec = medicina;
                                            tiempo = tiempo + 0.5;
                                            mascota.tick();
                                            running = false;
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
                                    tiempo = tiempo + 0.5;
                                    mascota.tick();
                                    running = false;
        
                                }else{
                                    System.out.println("No hay medicinas disponibles en el inventario.");
                                    running = false;
                                    break;
                                }
                            // MOSTRAR INVENTARIO
                            case 4:
                            inventario.mostrarInventario();
                        }
                        
                    }
        }
    }

    public void printEstado(float step, PrintStream out){
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
