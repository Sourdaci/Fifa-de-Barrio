
/**
 * Write a description of class Jugador here.
 * 
 * @author (your name) 
 * @version (a version number or a date)
 */
public abstract class Jugador
{
    // instance variables - replace the example below with your own
    private String nombre;
    private int edad;
    private int estadoForma;

    /**
     * Constructor for objects of class Jugador
     */
    public Jugador(String nom, int edad, int estado)
    {
        nombre = nom;
        this.edad = edad;
        estadoForma = estado;
    }
}
