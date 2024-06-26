public class Medicina extends Item {
    public Medicina(int id, String nombre, int cantidad) {
        super(id, nombre, cantidad);
    }

    @Override
    // APLICA ITEM MEDICINA A MASCOTA
    public void ItemAplicado(Mascota mascota) {
        mascota.incrementarSalud(40);
        System.out.println("Aplicando Medicamento: " + nombre);
    }
}