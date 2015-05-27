
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
    private int dorsal;

    /**
     * Constructor for objects of class Jugador
     */
    public Jugador(String nom, int edad, int estado, int dorsal)
    {
        nombre = nom;
        this.edad = edad;
        estadoForma = estado;
        this.dorsal = dorsal;
    }
    
    public String getNombre(){
        return nombre;
    }
    
    public int getEdad(){
        return edad;
    }
    
    public int getEstadoForma(){
        return estadoForma;
    }
    
    public int getDorsal(){
        return dorsal;
    }
    
    @Override
    public String toString(){
        String cadena = String.format("%s %2d%s ", "Dorsal", dorsal, ".");
        cadena += String.format("%-29s", (nombre + " (Edad " + edad + ")"));
        cadena += String.format("%s: %-2d", "Forma", estadoForma);
        return cadena;
    }
    
    public abstract int getValoracion();
}
