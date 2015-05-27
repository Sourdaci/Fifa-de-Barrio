import java.util.ArrayList;
import java.util.Random;
/**
 * Write a description of class Equipo here.
 * 
 * @author (your name) 
 * @version (a version number or a date)
 */
public class Equipo
{
    // instance variables - replace the example below with your own
    private int numJugadores;
    private String nombre;
    private ArrayList<Jugador> jugadores;
    private int dorsalActual = 1;
    private static String nombres[] = {"Ramon", "Pedro", "Juan", "Mario", "Marcos", "Miguel", 
        "Luis", "Carlos", "Jose Ramon", "Federico", "Alberto", "Roberto", "Ruben", "Guillermo", 
        "Hector", "Mario", "Felipe", "Manuel", "Tomas", "Agustin", "Jose Manuel", "Juan Jesus", 
        "Pepe", "Ricardo", "Fernando", "Antonio", "Jose Alberto", "Jose Luis", "David", 
        "Emilio", "Cesar", "German", "Raul", "Pablo"};

    /**
     * Constructor for objects of class Equipo
     */
    public Equipo(String nom, int num)
    {
        nombre = nom;
        numJugadores = num;
        jugadores = new ArrayList<Jugador>();
        creaEquipo();
    }
    
    private void creaEquipo(){
        Random aleatorio = new Random();
        String nom = nombres[aleatorio.nextInt(nombres.length)];
        int edad = aleatorio.nextInt(23) + 18;
        int estadoForma = aleatorio.nextInt(11);
        int pase, regate, remate;
        jugadores.add(new Portero(nom, edad, estadoForma, dorsalActual, aleatorio.nextInt(11), aleatorio.nextInt(11)));
        dorsalActual++;
        for (int i=1; i<numJugadores; i++){
            nom = nombres[aleatorio.nextInt(nombres.length)];
            edad = aleatorio.nextInt(23) + 18;
            estadoForma = aleatorio.nextInt(11);
            pase = aleatorio.nextInt(11);
            regate = aleatorio.nextInt(11);
            remate = aleatorio.nextInt(11);
            jugadores.add(new JugadorDeCampo(nom, edad, estadoForma, dorsalActual, pase, regate, remate));
            dorsalActual++;
        }
    }
    
    public int getReservas(){
        int numero = 0;
        if(numJugadores > 11){
            numero = numJugadores - 11;
        }
        return numero;
    }
    
    public void mostrarAlineaciones(){
        float acumulador = 0;
        ArrayList<Jugador> alinear = new ArrayList<Jugador>(jugadores);
        System.out.println(nombre + "\nTitulares");
        Portero parador = (Portero) alinear.remove(0);
        System.out.println(parador.toString() + String.format("%12s%s: %d", "", "\tValoracion", parador.getValoracion()));
        acumulador += parador.getValoracion();
        Random aleatorio = new Random();
        Jugador queCorre = alinear.remove(aleatorio.nextInt(alinear.size()));
        int liderazgo = aleatorio.nextInt(6);
        System.out.println(queCorre.toString() + "\tValoracion: " + (queCorre.getValoracion() + liderazgo) + "\tLiderazgo: " + liderazgo);
        acumulador += queCorre.getValoracion() + liderazgo;
        for (int i=0; i<9; i++){
            queCorre = alinear.remove(aleatorio.nextInt(alinear.size()));
            System.out.println(queCorre.toString() + "\tValoracion: " + queCorre.getValoracion());
            acumulador += queCorre.getValoracion();
        }
        System.out.print("**************************** ");
        System.out.print("Media de valoracion del equipo titular: ");
        System.out.print(String.format("%.2f", (acumulador / 11)));
        System.out.print(" ****************************\nReservas:\n");
        while(!alinear.isEmpty()){
            queCorre = alinear.remove(aleatorio.nextInt(alinear.size()));
            System.out.println(queCorre.toString() + "\tValoracion: " + queCorre.getValoracion());
        }
    }
}
