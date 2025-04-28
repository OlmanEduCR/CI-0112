import java.util.Scanner;
import java.util.Random;

public class JuegoBatalla{
    Scanner entrada = new Scanner(System.in);

    //Atributos
    private static Robot[] arrayRobots;

   
    public static void main(String[] args){
        Scanner entrada = new Scanner(System.in);
        int opcion = 0;
        do{
            System.out.println("Digite una opción del menú:");
            System.out.println("1.Cantidad de Robots por agregar");
            System.out.println("2.Agregar nuevo Robot");
            System.out.println("3.Iniciar batalla");
            System.out.println("4.Salir de la simulación");
            opcion = entrada.nextInt();

            switch(opcion){
                case 1:
                    System.out.println("Ingrese la cantidad de robots del juego:");
                    int cantidadRobots = entrada.nextInt();
                    if (cantidadRobots > 1 && cantidadRobots < 11){
                        arrayRobots = new Robot[cantidadRobots];
                    }else{
                        System.out.println("Los Robots deben de ser más de 1 y menos de 11");
                    }
                    break;
                case 2:
                    for(int indice = 0; indice < arrayRobots.length; indice++){
                        double puntosVida = 0;
                        double ataque = 0;
                        entrada.nextLine();
                        System.out.println("Ingrese el nombre del robot " + (indice + 1) + ": ");
                        String nombre = entrada.nextLine();
                        while(true){
                            System.out.println("Digite los puntos de vida (Deben de estar entre 50 y 100)");
                            puntosVida = entrada.nextInt();
                            if(puntosVida >= 50 && puntosVida <= 100)
                                break;
                            else
                                System.out.println("Los puntos de vida deben estar entre 50 y 100");        
                        }
                        entrada.nextLine();
                        while(true){
                            System.out.println("Digite los puntos de ataque que tendrá el robot (Deben de estar entre 10 y 20)");
                            ataque = entrada.nextInt();
                            if(ataque >= 10 && ataque <= 20)
                                break;
                            else
                                System.out.println("Los puntos de ataque deben estar entre 10 y 20"); 
                        }
                        arrayRobots[indice] = new Robot(nombre, puntosVida, ataque);
                    }
                    break;
                case 3:
                    iniciarBatalla();
                    break;    
                case 4:
                    System.out.println("Gracias por utilizar el sistema");
                break;        
            }
        }while(opcion != 4);
                
    }//El método main es una interfaz en la cual el usuario por medio de numeración, elige cuál opción quiere realizar.
    
    //Métodos
    public static void iniciarBatalla(){
        Random robotAleatorio = new Random();
        int cantidadRobots = arrayRobots.length;
        int robotAtaque, robotAtacado;
        int robotsEnJuego = arrayRobots.length;
        while(true){
            robotAtaque = robotAleatorio.nextInt(cantidadRobots);
            robotAtacado = robotAleatorio.nextInt(cantidadRobots);
            if(arrayRobots[robotAtaque] != null && arrayRobots[robotAtacado] != null){
                if(robotAtaque != robotAtacado){
                    System.out.println(arrayRobots[robotAtaque].getNombre() + " contra " + arrayRobots[robotAtacado].getNombre());
                    arrayRobots[robotAtaque].atacar(arrayRobots[robotAtacado]);
                    if(!arrayRobots[robotAtacado].estaVivo()){
                        arrayRobots[robotAtacado] = null;
                        robotsEnJuego--;
                        if(robotsEnJuego == 1){
                            mostrarGanador();
                            break;
                        }
                    }
                }
            }
        }
    }/*Este método utiliza el total de elementos que posee el arreglo, dado por la cantidad de robots, donde usando la biblioteca Random, se verifica primero 
    que los robots seleccionados existan (que sean distintos de nulo) y ademas que el robot atacante sea diferente del robot atacado, los cuales se generan
    de forma aleatoria, y se enfrentan sin pausa hasta que solo quede uno con vida, y se llama a la función mostrarGanador para mostrar el robot que 
    aun sigue en pie.*/

    public static void mostrarGanador(){
        for(int indice = 0; indice < arrayRobots.length; indice++){
            if(arrayRobots[indice] != null){
                System.out.println("El Robot ganador es:");
                System.out.println(arrayRobots[indice].getNombre());
            }
        }
    }/*Este método verifica en cada espacio del arreglo, cual es el elemento no vacio, donde para hacer mención de él, se obtiene mediante un get
    su nombre, establecido previamente.*/
}