
/**
 * Write a description of class JugadorDeCampo here.
 * 
 * @author (your name) 
 * @version (a version number or a date)
 */
public class JugadorDeCampo extends Jugador
{
    private int pase;
    private int regate;
    private int remate;
    
    public JugadorDeCampo(String nom, int edad, int estado, int dorsal, int pase, int regate, int remate)
    {
        super(nom, edad, estado, dorsal);
        this.pase = pase;
        this.regate = regate;
        this.remate = remate;
    }
    
    public int getPase(){
        return pase;
    }
    
    public int getRegate(){
        return regate;
    }
    
    public int getRemate(){
        return remate;
    }
    
    public int getValoracion(){
        return (int) ((getEstadoForma() + pase + regate + remate) / 4);
    }
}
