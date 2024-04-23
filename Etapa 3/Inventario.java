import java.util.ArrayList;
import java.util.List;

public class Inventario {
    private ArrayList<Item> items;

    // INSTANCIACION DE INVENTARIO
    public Inventario(){
        this.items = new ArrayList<>();
    }

    // METODO PARA AGREGAR ITEM AL INVENTARIO
    public void agregarItem(Item item){
        items.add(item);
    }

    // METODO PARA ELIMINAR ITEM DEL INVENTARIO
    public void eliminarItem(int id) {
        for (int i = 0; i < items.size(); i++) {
            if (items.get(i).getId() == id) {
                items.remove(i);
                break;
            }
        }
    }

    // METODO PARA USAR UN ITEM
    public void usarItem(int id, Mascota mascota) {
        for (Item item : items) {
            if (item.getId() == id) {
                // USANDO ITEM Y DESCONTANDO DEL INVENTARIO
                if (item.getCantidad() > 0) {
                    System.out.println("Usando " + item.getNombre() + "...");
                    item.ItemAplicado(mascota);
                    item.setCantidad(item.getCantidad() - 1);
                    if (item.getCantidad() == 0) {
                        eliminarItem(item.getId());
                        System.out.println("Usaste el último " + item.getNombre() + " que te quedaba. Se eliminó del inventario");
                    }
                }
                // NO QUEDA CANTIDAD EN EL INVENTARIO
                else {
                    System.out.println("No hay suficiente cantidad de " + item.getNombre() + " en el inventario.");
                }
                return;
            }
        }
        System.out.println("No tienes este item en tu inventario");
    }

    // PRINT DEL INVENTARIO
    public void mostrarInventario() {
        System.out.println("-----------");
        System.out.println("Inventario:");
        System.out.println("-----------");
        for (Item item : items) {
            System.out.println("ID: " + item.getId() + ", Nombre: " + item.getNombre() + ", Cantidad: " + item.getCantidad());
        }
    }

    // LISTA DE JUGUETES
    public List<Juguete> obtenerJuguetes(){
        List<Juguete> juguetes = new ArrayList<>();
        for (Item item : items){
            if (item instanceof Juguete) {
                juguetes.add((Juguete) item);
            }
        }
        return juguetes;
    }
    
    // LISTA DE MEDICINA
    public List<Medicina> obtenerMedicina(){
        List<Medicina> medicinas = new ArrayList<>();
        for (Item item : items){
            if (item instanceof Medicina) {
                medicinas.add((Medicina) item);
            }
        }
        return medicinas;
    }
    
    // LISTA DE COMIDA
    public List<Comida> obtenerComida(){
        List<Comida> comidas = new ArrayList<>();
        for (Item item : items){
            if (item instanceof Comida) {
                comidas.add((Comida) item);
            }
        }
        return comidas;
    }
}
