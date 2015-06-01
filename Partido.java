import java.util.Random;
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
    private int golesL;
    private int golesV;

    /**
     * Constructor for objects of class Partido
     * 
     * @param equi1 Equipo que juega como local
     * @param equi2 Equipo que juega como visitante
     */
    public Partido(Equipo equi1, Equipo equi2)
    {
        local = equi1;
        visitante = equi2;
        golesL = 0;
        golesV = 0;
    }
    
    /**
     * Muestra las alineaciones de los equipos que jugaran el partido
     */
    public void mostrarAlineaciones(){
        local.mostrarAlineaciones();
        System.out.println("");
        visitante.mostrarAlineaciones();
    }
    
    /**
     * Jugar el partido
     */
    public void jugarPartido(){
        if (local.valoracionMedia() > visitante.valoracionMedia()){
            golesL = (int)(((local.valoracionMedia() - visitante.valoracionMedia())*10));
            Random aleatorio = new Random();
            int goles = aleatorio.nextInt(5);
            golesL += goles;
            golesV += goles;
        }
        else {
            golesV = (int)(((visitante.valoracionMedia() - local.valoracionMedia())*10));
            Random aleatorio = new Random();
            int goles = aleatorio.nextInt(5);
            golesL += goles;
            golesV += goles;
        }
        // sumamos los puntos a los equipos
        if(golesL > golesV){
            local.victoria();
        }
        else if (golesL < golesV){
            visitante.victoria();
        }
        else {
            local.empate();
            visitante.empate();
        }
        
    }
    
    /**
     * Mostrar Resultado
     */
    public void verResultado(){
        jugarPartido();
        System.out.println("Local " + golesL + " - " + golesV + " Visitante");
        
    }
    
}
