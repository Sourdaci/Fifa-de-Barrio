import java.util.ArrayList;
/**
 * Write a description of class Liga here.
 * 
 * @author (your name) 
 * @version (a version number or a date)
 */
public class Liga
{
    // instance variables - replace the example below with your own
    private ArrayList<Equipo> equipos;
    private int numEquipos;
    private final static int JUGADORES_POR_EQUIPO = 16;
    private int jornada = 1;

    /**
     * Constructor for objects of class Liga
     */
    public Liga(int numEquipos)
    {
        int cont = 1;
        equipos = new ArrayList<>();
        while (cont <= numEquipos){
            equipos.add(new Equipo("Equipo " + cont,JUGADORES_POR_EQUIPO));
            cont++;
        }
    }
    
    /**
     * Mostramos la clasificacion
     */
    public void mostrarClasificaciones(){
        for(Equipo equipo:equipos){
            System.out.println(equipo);
        }
    }
    
    /**
     * Jugamos jornadas
     */
    public void jugarJornadas(int numeroJornadas){
        int cont = jornada;
        //comprovamos que no se hagan mas jornadas de las que tiene la liga
        //Si pones mas te hace la liga completa y no sigue jugando jornadas.
        if(numeroJornadas+jornada > numEquipos-1){
            numeroJornadas = numEquipos-1-jornada;
        }
        // Jugamos las jornadas pedidas
        while (cont < numeroJornadas){
            int equipo = 0;
            //jugamos una jornada
            while (equipo < numEquipos/2){
                Partido partido = new Partido(equipos.get(equipo),equipos.get(equipo+jornada));
                equipo += jornada;
            }
            
            cont ++;
        }
    }

}
