
/**
 * Write a description of class Partido here.
 * 
 * @author (your name) 
 * @version (a version number or a date)
 */
public class Partido
{
    // instance variables - replace the example below with your own
    private Equipo local, visitante;

    /**
     * Constructor for objects of class Partido
     */
    public Partido(Equipo equi1, Equipo equi2)
    {
        local = equi1;
        visitante = equi2;
    }
    
    public void mostrarAlineaciones(){
        local.mostrarAlineaciones();
        System.out.println("");
        visitante.mostrarAlineaciones();
    }
}
