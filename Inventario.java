import java.util.ArrayList;

public class Inventario {
    private ArrayList<Item> items;

    public Inventario(){
        this.items = new ArrayList<>();
    }

    public void agregarItem(Item item){
        items.add(item);
    }

    public void eliminarItem(int id) {
        for (int i = 0; i < items.size(); i++) {
            if (items.get(i).getId() == id) {
                items.remove(i);
                break;
            }
        }
    }
    // FALTA DEFINIR LO DEL TIEMPO
    public void usarItem(int id, Mascota mascota) {
        for (Item item : items) {
            if (item.getId() == id) {
                if (item.getCantidad() > 0) {
                    System.out.println("Usando " + item.getNombre() + "...");
                    item.printItemAplicado(mascota);
                    item.setCantidad(item.getCantidad() - 1);
                    if (item.getCantidad() == 0) {
                        eliminarItem(item.getId());
                        System.out.println("Usaste el último " + item.getNombre() + " que te quedaba. Se eliminó del inventario");
                    }
                } else {
                    System.out.println("No hay suficiente cantidad de " + item.getNombre() + " en el inventario.");
                }
                return;
            }
        }
        System.out.println("No tienes este item en tu inventario");
    }

    public void mostrarInventario() {
        System.out.println("Inventario:");
        for (Item item : items) {
            System.out.println("ID: " + item.getId() + ", Nombre: " + item.getNombre() + ", Cantidad: " + item.getCantidad());
        }
    }
}
