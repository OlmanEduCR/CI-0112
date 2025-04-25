public class Robot{
    //Atributos
    private String nombre; //El nombre del robot.
    private double puntosVida; //Cantidad de vida (entre 50 y 100)
    private double ataque; //Cantidad de daño que puede causar (entre 10 y 20).
    private double defensa; //Un porcentaje del ataque que se resta del ataque (el porcentaje oscila entre 5 y 10)

    //Getters
    public String getNombre(){
        return this.nombre;
    }

    public double getPuntosVida(){
        return this.puntosVida;
    }

    public double getAtaque(){
        return this.ataque;
    }

    public double getDefensa(){
        return this.defensa;
    }

    //Setters
    public void setNombre(String nombreP){
        this.nombre = nombreP;
    }

    public void setPuntosVida(double puntosVidaP){
        this.puntosVida = puntosVidaP;
    }

    public void setAtaque(double ataqueP){
        this.ataque = ataqueP;
    }

    public void setDefensa(double defensaP){
        this.defensa = defensaP;
    }

    //Método constructor
    public Robot(String nombre, double puntosVida, double ataque, double defensa){
        this.nombre = nombre;
        this.ataque = ataque;
        this.puntosVida = puntosVida;
        this.defensa = defensa;
    }

    //Métodos
    public void atacar(Robot otroRobot){
        double puntosNuevosVida = otroRobot.getDefensa() - this.ataque;
        otroRobot.setPuntosVida(puntosNuevosVida);
    }//la función básica de ataque, la cual resta de la vida el ataque y el resultado lo convierte en la nueva vida

    public boolean estaVivo(){
        boolean estado = false;
        if(puntosVida>0){
            estado = true;
        }
        return estado;
    }//la funcion principal es determinar el estado del robot que sea solicitado

    /* public double defensa(double defensaDeTurno){
        double puntosNuevosVida = puntosVida + (defensaDeTurno/100);
    } */
}
