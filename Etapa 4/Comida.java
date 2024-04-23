public class Comida extends Item {
    public Comida(int id, String nombre, int cantidad) {
        super(id, nombre, cantidad);
    }

    @Override
    // APLICA ITEM COMIDA A MASCOTA
    public void ItemAplicado(Mascota mascota) {
        mascota.incrementarSalud(20);
        mascota.incrementarEnergia(20);
        System.out.println("Dando de comer: " + getNombre());
    }
}