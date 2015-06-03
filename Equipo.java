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
    private boolean hayCrack;
    private int puntos;
    private int partidosJugados;
    private int partidosGanados;
    private int partidosEmpatados;
    private int partidosPerdidos;

    /**
     * Crea un nuevo equipo
     * 
     * @param nom Nombre del equipo
     * @param num Numero de jugadores del equipo
     */
    public Equipo(String nom, int num)
    {
        nombre = nom;
        numJugadores = num;
        jugadores = new ArrayList<Jugador>();
        creaEquipo();
        hayCrack = false;
        puntos = 0;
        partidosGanados=0;
        partidosPerdidos=0;
        partidosEmpatados=0;
        partidosJugados=0;
    }
    
    /**
     * Crea los jugadores del equipo de futbol. 
     * Se les asignan estadisticas de forma aleatoria
     */
    private void creaEquipo(){
        Random aleatorio = new Random();
        //miramos si va a haber un crack o no.
        int crack = aleatorio.nextInt(2);
        if(crack == 1){
            hayCrack = true;
        }
        
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
        //Si hay crack lo modificamos
        if (hayCrack){
            int elegido = aleatorio.nextInt(10)+1;
            ((JugadorDeCampo)jugadores.get(elegido)).setPase(10);
            ((JugadorDeCampo)jugadores.get(elegido)).setRegate(10);
            ((JugadorDeCampo)jugadores.get(elegido)).setRemate(10);
            jugadores.get(elegido).setEstado(10);
        }
    }
    
    /**
     * Devuelve el nombre del equipo
     */
    public String getNombre(){
        return nombre;
    }
    /**
     * Devuelve los puntos que tiene el equipo.
     */
    public int getPuntos()
    {
        return puntos;
    }
    
    /**
     * Calcula el numero de jugadores del equipo que estan en el banquillo
     * 
     * @return Numero de jugadores suplentes
     */
    public int getReservas(){
        int numero = 0;
        if(numJugadores > 11){
            numero = numJugadores - 11;
        }
        return numero;
    }
    
    /**
     * Crea las alineaciones para el partido. El portero es siempre titular. 
     * El resto de los jugadores se seleccionan aleatoriamente. El primero de ellos sera el capitan.
     */
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
    /**
     * Aumentamos un tanto porciento aleatorio las habilidades de los jugadores del equipo
     */
    public void entrenar(){
        Random aleatorio = new Random();
        int aumento = aleatorio.nextInt(101);
        for(Jugador jugador : jugadores){
            jugador.entrenar(aumento);
        }
        
    }
    /**
     * Devolvemos la media de valoracion de todo el equipo.
     */
    public double valoracionMedia(){
        double media = 0;
        for(Jugador jugador:jugadores){
            media += jugador.getValoracion();
        }
        return media/numJugadores;
    }
    /**
     * sumamos puntos al equipo VICTORIA +3
     */
    public void victoria(){
        puntos += 3;
        partidosGanados += 1;
    }
    /**
     * sumamos puntos al equipo EMPATE +1
     */
    public void empate(){
        puntos += 1;
        partidosEmpatados += 1;
    }
    /**
     * sumamos un partido mas
     */
    public void addPartido(){
        partidosJugados++;
    }
    /**
     * sumamos un partido perdido
     */
    public void derrota(){
        partidosPerdidos += 1;
    }
    /**
     * Mostramo la informacion del equipo.
     */
    public String toString(){
        return String.format("%-10s %2d %2d %2d %2d %2d",nombre,puntos,partidosGanados,partidosEmpatados,partidosPerdidos,partidosJugados);
    }
}
