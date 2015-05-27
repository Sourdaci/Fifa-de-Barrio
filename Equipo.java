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
    private static ArrayList<String> nombres;

    /**
     * Constructor for objects of class Equipo
     */
    public Equipo(String nom, int num)
    {
        nombre = nom;
        numJugadores = num;
        jugadores = new ArrayList<Jugador>();
        nombres = new ArrayList<String>();
        creaNombres();
        creaEquipo();
    }
    
    private void creaNombres(){
        nombres.add("Ramon");
        nombres.add("Pedro");
        nombres.add("Juan");
        nombres.add("Mario");
        nombres.add("Marcos");
        nombres.add("Miguel");
        nombres.add("Luis");
        nombres.add("Carlos");
        nombres.add("Jose Ramon");
        nombres.add("Federico");
        nombres.add("Alberto");
        nombres.add("Roberto");
        nombres.add("Ruben");
        nombres.add("Guillermo");
        nombres.add("Hector");
        nombres.add("Mario");
        nombres.add("Felipe");
        nombres.add("Manuel");
        nombres.add("Tomas");
        nombres.add("Agustin");
        nombres.add("Jose Manuel");
        nombres.add("Juan Jesus");
        nombres.add("Pepe");
        nombres.add("Ricardo");
        nombres.add("Fernando");
        nombres.add("Antonio");
        nombres.add("Jose Alberto");
        nombres.add("Jose Luis");
        nombres.add("David");
        nombres.add("Emilio");
        nombres.add("Cesar");
        nombres.add("German");
        nombres.add("Raul");
        nombres.add("Pablo");
    }
    
    private void creaEquipo(){
        Random aleatorio = new Random();
        String nom = nombres.remove(aleatorio.nextInt(nombres.size()));
        int edad = aleatorio.nextInt(23) + 18;
        int estadoForma = aleatorio.nextInt(11);
        int pase, regate, remate;
        jugadores.add(new Portero(nom, edad, estadoForma, dorsalActual, aleatorio.nextInt(11), aleatorio.nextInt(11)));
        dorsalActual++;
        for (int i=1; i<numJugadores; i++){
            nom = nombres.remove(aleatorio.nextInt(nombres.size()));
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
        System.out.println(parador.toString() + "\tValoracion: " + parador.getValoracion());
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
        System.out.print("*********************************** ");
        System.out.print("Media de valoracion del equipo titular: ");
        System.out.print(String.format("%.2f", (acumulador / 11)));
        System.out.print(" ***********************************\nReservas:\n");
        while(!alinear.isEmpty()){
            queCorre = alinear.remove(aleatorio.nextInt(alinear.size()));
            System.out.println(queCorre.toString() + "\tValoracion: " + queCorre.getValoracion());
        }
    }
}
