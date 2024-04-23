public class Mascota {
    @SuppressWarnings("unused")
    private String nombre;
    private double edad;
    private int salud;
    private int energia;
    private int felicidad;

    // INSTANCIACION STATS MASCOTA INICIAL
    public Mascota(String nombre) {
        this.nombre = nombre;
        this.edad = 0.0;
        this.salud = 100;
        this.energia = 100;
        this.felicidad = 50;
    }

    // PASO DEL TIEMPO
    public void tick(){
        this.edad = this.edad + 0.5;
        this.salud = this.salud - 5;
        if (this.energia-5 <= 0) {
            this.energia = 0;
        }
        else {this.energia = this.energia - 5;}
        if (this.felicidad-5 <= 0) {
            this.felicidad = 0;
        }
        else {this.felicidad = this.felicidad - 5;}
    }

    // METODO PARA INCREMENTAR SALUD DE LA MASCOTA
    public void incrementarSalud(int cant){
        if (this.salud + cant >= 100) {
            this.salud = 100;
        }
        else {
            this.salud = this.salud + cant;
        }
    }

    // METODO PARA INCREMENTAR ENERGIA DE LA MASCOTA
    public void incrementarEnergia(int cant){
        if (this.energia + cant >= 100) {
            this.energia = 100;
        }
        else {
            this.energia = this.energia + cant;
        }
    }

    // METODO PARA INCREMENTAR FELICIDAD DE LA MASCOTA
    public void incrementarFelicidad(int cant){
        if (this.felicidad + cant >= 100) {
            this.felicidad = 100;
        }
        else {
            this.felicidad = this.felicidad + cant;
        }
    }

    // METODO PARA ACTUALIZAR STATS DE MASCOTA
    public void afectar() {
        if (this.salud < 10) {
            this.felicidad = this.felicidad - 20;
        }
        else if (this.salud < 50 && this.edad <= 10) {
            this.felicidad = this.felicidad - 20;
            this.energia = this.energia - 10;
        }
        else if (this.salud <= 50 && this.edad > 10){
            this.felicidad = this.felicidad - 30;
            this.energia = this.energia - 20;
        }
    }

    // METODO PARA PONER A DORMIR A LA MASCOTA
    public void Dormir(){
        this.edad = this.edad + 0.5;
        this.energia = 100;
        this.incrementarFelicidad(15);
        this.incrementarSalud(15);
    }

    // METODO PARA CALCULAR ESTADO DE LA MASCOTA
    public Estado getEstado() {
        Estado estado = Estado.Neutro;
        // ESTADO: MUERTO
        if (this.salud == 0 || this.energia == 0 || this.edad >= 15) {
            estado = Estado.Muerto;
            System.out.println("Estado: (x_x) fin del juego");
        }
        // ESTADO: CANSADO
        else if (this.energia < 15) {
            estado = Estado.Cansado;
            System.out.println("Estado:  (=_=) zzzz....");
        }
        // ESTADO: ENOJADO
        else if (this.edad > 5 && this.salud <=30 && this.energia <=30 ) {
            estado = Estado.Enojado;
            System.out.println("Estado: (ôwô) grrrr....");
        }
        // ESTADO: HAMBRIENTO
        else if ((this.salud<=20 && this.edad <= 5) || (this.salud<=50 && this.edad < 10 && this.edad > 5)) {
            estado = Estado.Hambriento;
            System.out.println("Estado: (0o0) hambre hambre!");
        }
        // ESTADO: TRISTE
        else if (this.felicidad < 20) {
            estado = Estado.Triste;
            System.out.println("Estado: (._.) snif.... ");
        }
        // ESTADO: FELIZ
        else if (this.felicidad > 60) {
            estado = Estado.Feliz;
            System.out.println("Estado:  |(^_^)/ Weeeeeh!");
        }
        // ESTADO: NEUTRO
        else{System.out.println("Estado: (-_-) Meh....");}
        return estado;
    }

    // METODO PARA RETORNAR NOMBRE DE MASCOTA
    public String getNombre(){
        return this.nombre;
    }
    // METODO PARA RETORNAR EDAD DE MASCOTA
    public double getEdad(){
        return this.edad;
    }
    // METODO PARA RETORNAR SALUD DE MASCOTA
    public int getSalud(){
        return this.salud;
    }
    // METODO PARA RETORNAR ENERGIA DE MASCOTA
    public int getEnergia(){
        return this.energia;
    }
    // METODO PARA RETORNAR FELICIDAD DE MASCOTA
    public int getFelicidad(){
        return this.felicidad;
    }
}