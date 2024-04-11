public class Mascota {
    /* Completar con los métodos, atributos y constructor de Mascota 
    dependiendo de la etapa */
    @SuppressWarnings("unused")
    private String nombre;
    private float edad;
    private int salud;
    private int energia;
    private int felicidad;

    public Mascota(String nombre) {
        this.nombre = nombre;
        this.edad = 0;
        this.salud = 100;
        this.energia = 100;
        this.felicidad = 50;
    }

    public void tick(){
        this.edad = this.edad + 1/2;
        this.salud = this.salud - 5;
        this.energia = this.energia - 5;
        this.felicidad = this.felicidad - 5;
    }
    public void incrementarSalud(int cant){
        this.salud = this.salud + cant;
    }

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

    public Estado getEstado() {
        Estado estado = Estado.Neutro;
        if (this.salud == 0 || this.energia == 0 || this.edad >= 15) {
            estado = Estado.Muerto;
        }
        else if (this.energia < 15) {
            estado = Estado.Cansado;
        }
        else if (this.edad > 5 && this.salud <=30 && this.energia <=30 ) {
            estado = Estado.Enojado;
        }
        else if ((this.salud<=20 && this.edad <= 5) || (this.salud<=50 && this.edad < 10 && this.edad > 5)) {
            estado = Estado.Hambriento;
        }
        else if (this.felicidad < 20) {
            estado = Estado.Triste;
        }
        else if (this.felicidad > 60) {
            estado = Estado.Feliz;
        }
        return estado;
    }
}