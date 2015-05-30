
/**
 * Write a description of class Portero here.
 * 
 * @author (your name) 
 * @version (a version number or a date)
 */
public class Portero extends Jugador
{
    private int agilidad;
    private int fortalezaMental;
    
    /**
     * Constructor for objects of class Portero
     * 
     * @param nom Nombre del jugador
     * @param edad Edad del jugador
     * @param estado Estado de forma del jugador [0,10]
     * @param dorsal Numero de la camiseta del jugador
     * @param agi Agilidad del jugador [0,10]
     * @param fort Fortaleza mental del jugador [0,10]
     * 
     */
    public Portero(String nom, int edad, int estado, int dorsal, int agi, int fort)
    {
        super(nom, edad, estado, dorsal);
        agilidad = agi;
        fortalezaMental = fort;
    }
    
    public int getAgilidad(){
        return agilidad;
    }
    
    public int getFortalezaMental(){
        return fortalezaMental;
    }
    
    public void entrenar(float aumento){
        if(agilidad*((aumento/100)+1)<10){
            agilidad = (int)(agilidad*((aumento/100)+1));
        }
        if(fortalezaMental*((aumento/100)+1)<10){
            fortalezaMental = (int)(fortalezaMental*((aumento/100)+1));
        };
        if((getEstadoForma()*((getEstadoForma()/100)+1))<10){
            setEstado((int)(getEstadoForma()*((aumento/100)+1)));
        };
    }
    
    /**
     * Calcula la valoracion del jugador en base a sus estadisticas
     * 
     * @return Valoracion media del jugador
     */
    public int getValoracion(){
        return (int) ((getEstadoForma() + agilidad + fortalezaMental) / 3);
    }
    
    @Override
    public String toString(){
        String cadena = super.toString();
        cadena += String.format("  %s: %-2d", "Agil.", agilidad);
        cadena += String.format("  %s: %-2d", "Fort.M", fortalezaMental);
        return cadena;
    }
}
