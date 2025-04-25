public class Robot{
    //Atributos
    private String nombre; //El nombre del robot.
    private double puntosVida; //Cantidad de vida (entre 50 y 100)
    private double ataque; //Cantidad de daño que puede causar (entre 10 y 20).

    //Getters
    public String getNombre(){
        return nombre;
    }

    public double getPuntosVida(){
        return puntosVida;
    }

    public double getAtaque(){
        return ataque;
    }

    //Setters
    public void setNombre(String nombrep){
        this.nombre = nombrep;
    }

    public void setPuntosVida(double puntosVidap){
        this.puntosVida = puntosVidap;
    }

    public void setAtaque(double ataquep){
        this.ataque = ataquep;
    }

    //Método constructor
    public Robot(String nombre, double puntosVida, double ataque){
        this.nombre = nombre;
        this.ataque = ataque;
        this.puntosVida = puntosVida;
    }

    //Métodos
    public double atacar(double ataqueDeTurno){
        double puntosNuevosVida = puntosVida - ataqueDeTurno;
        this.puntosVida = puntosNuevosVida;
        return puntosNuevosVida;
    }//función básica de ataque, el cual resta de la vida el ataque y el resultado lo convierte en la nueva vida

    public boolean estaVivo(){
        boolean estado = false;
        if(puntosVida>0){
            estado = true;
        }
        return estado;
    }//funcion principal es determinar el estado del robot que sea solicitado
}
