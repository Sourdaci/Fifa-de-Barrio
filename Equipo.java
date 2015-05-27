import java.util.ArrayList;
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

    /**
     * Constructor for objects of class Equipo
     */
    public Equipo(String nom, int num)
    {
        nombre = nom;
        numJugadores = num;
        jugadores = new ArrayList<Jugador>();
    }
}
