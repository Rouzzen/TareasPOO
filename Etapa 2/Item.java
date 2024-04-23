public abstract class Item {
    protected int id;
    protected String nombre;
    protected int cantidad;

    // INSTANCIACION DEL ITEM
    public Item(int id, String nombre, int cantidad){
        this.id = id;
        this.nombre = nombre;
        this.cantidad = cantidad;
    }

    public abstract void ItemAplicado(Mascota mascota);

    // METODO PARA OBTENER ID DEL ITEM
    public int getId() {
        return id;
    }

    // METODO PARA OBTENER NOMBRE DEL ITEM
    public String getNombre() {
        return nombre;
    }

    // METODO PARA OBTENER CANTIDAD DEL ITEM
    public int getCantidad() {
        return cantidad;
    }
    
    // METODO PARA ASIGNAR CANTIDAD DEL ITEM
    public void setCantidad(int cantidad) {
        this.cantidad = cantidad;
    }

}

