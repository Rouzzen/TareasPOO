public class Juguete extends Item {
    public Juguete(int id, String nombre, int cantidad) {
        super(id, nombre, cantidad);
    }

    @Override
    public void printItemAplicado(Mascota mascota) {
        mascota.incrementarFelicidad(30);
        System.out.println("Usando Juguete: " + nombre);
    }
}