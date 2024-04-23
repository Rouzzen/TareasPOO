public class Juguete extends Item {
    public Juguete(int id, String nombre, int cantidad) {
        super(id, nombre, cantidad);
    }

    @Override
    // APLICA ITEM JUGUETE A MASCOTA
    public void ItemAplicado(Mascota mascota) {
        mascota.incrementarFelicidad(30);
        System.out.println("Usando Juguete: " + nombre);
    }
}