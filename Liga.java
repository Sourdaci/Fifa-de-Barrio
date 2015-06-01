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
    
//     /**
//      * Jugamos jornadas
//      */
//     public void jugarJornadas(int numeroJornadas){
//         int cont = jornada;
//         //comprovamos que no se hagan mas jornadas de las que tiene la liga
//         //Si pones mas te hace la liga completa y no sigue jugando jornadas.
//         if(numeroJornadas+jornada > numEquipos-1){
//             numeroJornadas = numEquipos-1-jornada;
//         }
//         // Jugamos las jornadas pedidas
//         while (cont < numeroJornadas){
//             int equipo = 0;
//             //jugamos una jornada
//             while (equipo < numEquipos/2){
//                 Partido partido = new Partido(equipos.get(equipo),equipos.get(equipo+jornada));
//                 equipo += jornada;
//             }
//             
//             cont ++;
//         }
//     }
    
    /**
     * Jugar liga
     */
    public void jugarLiga(){
   
       int tope=10;//modificar el numero de clubes
       
       int auxT=equipos.size();
       boolean impar=(auxT%2!=0);
       if(impar){
          ++auxT;
       }
       int totalP=(auxT*(auxT-1))/2;//total de partidos de una ronda
       Equipo [] local=new Equipo [totalP];
       Equipo [] visita=new Equipo [totalP];
       int modIF=(auxT/2);//para hacer mod cada inicio de fecha
       int indiceInverso=auxT-2;
       for(int i=0;i<totalP;i++){
          if (i%modIF==0){//seria el partido inicial de cada fecha
             //si es impar el numero de clubes la primera fecha se borra poniendo null
             if (impar){
                local[i]=null;
                visita[i]=null;
             }
             else{
                //se pone uno local otro  visita al ultimo equipo
                if(i%2==0){
                   local[i]=equipos.get(i%(auxT-1));
                   visita[i]=equipos.get(auxT-1);
                }
                else{
                   local[i]=equipos.get(auxT-1);
                   visita[i]=equipos.get(i%(auxT-1));
                }
             }
          }
          else{
             local[i]=equipos.get(i%(auxT-1));
             visita[i]=equipos.get(indiceInverso);           
             --indiceInverso;
             if (indiceInverso<0){
                indiceInverso=auxT-2;
             }
          }
       }
       for(int i=0;i<totalP;i++){
          if(local[i]!=null){
             //Elegimos los dos equipos que juegan
             Partido partido = new Partido(local[i],visita[i]);
             //Vemos el resultado y sumamos datos
             partido.verResultado();
             //Entrenamos a los dos equipos
             local[i].entrenar();
             visita[i].entrenar();
          }
       }
       System.out.println("\n Segunda ronda \n \n");
       for(int i=0;i<totalP;i++){
          if(local[i]!=null){
             //Elegimos los dos equipos que juegan
             Partido partido = new Partido(visita[i],local[i]);
             //Vemos el resultado y sumamos datos
             partido.verResultado();
             //Entrenamos a los dos equipos
             local[i].entrenar();
             visita[i].entrenar();
          }
       }
    }
}
