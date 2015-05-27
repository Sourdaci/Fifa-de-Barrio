
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
}
