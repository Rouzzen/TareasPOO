public abstract class Item {
    protected String nombre;

    public Item(String nombre){
        this.nombre = nombre;
    }
    public abstract void printItemAplicado(Mascota mascota);
}

public class Comida extends Item {
    public Comida(String nombre) {
        super(nombre);
    }

    @Override
    public void printItemAplicado(Mascota mascota) {
        mascota.incrementarSalud(20);
        mascota.incrementarEnergia(20);
        System.out.println("Dando de comer: " + nombre);
    }
}
public class Medicina extends Item {
    public Medicina(String nombre) {
        super(nombre);
    }

    @Override
    public void printItemAplicado(Mascota mascota) {
        mascota.incrementarSalud(40);
        System.out.println("Aplicando Medicamento: " + nombre);
    }
}
public class Juguete extends Item {
    public Juguete(String nombre) {
        super(nombre);
    }

    @Override
    public void printItemAplicado(Mascota mascota) {
        mascota.incrementarFelicidad(30);
        System.out.println("Usando Juguete: " + nombre);
    }
}
