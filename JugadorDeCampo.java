
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
    
    /**
     * Constructor for objects of class Jugador
     * 
     * @param nom Nombre del jugador
     * @param edad Edad del jugador
     * @param estado Estado de forma del jugador [0,10]
     * @param dorsal Numero de la camiseta del jugador
     * @param pase Habilidad de pases del jugador [0,10]
     * @param regate Habilidad para regatear del jugador [0,10]
     * @param remate Habilidad para efectuar remates del jugador [0,10]
     */
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
    
    public void setPase(int pase){
        this.pase = pase;
    }
    public void setRegate(int regate){
        this.regate = regate;
    }
    public void setRemate(int remate){
        this.remate = remate;
    }
    public void setEstado(int estado){
        super.setEstado(estado);
    }
    public void entrenar(float aumento){
        if((pase*((aumento/100)+1))<10){
            pase = (int)(pase*((aumento/100)+1));
        };
        if((regate*((aumento/100)+1))<10){
            regate=(int)(regate*((aumento/100)+1));
        };
        if((remate*((aumento/100)+1))<10){
            remate=(int)(remate*((aumento/100)+1));
        };
        if(((getEstadoForma()*((getEstadoForma()/100)+1)))<10){
            setEstado((int)(getEstadoForma()*((aumento/100)+1)));
        };
    }
    
    /**
     * Calcula la valoracion del jugador en base a sus estadisticas
     * 
     * @return Valoracion media del jugador
     */
    public int getValoracion(){
        return (int) ((getEstadoForma() + pase + regate + remate) / 4);
    }
    
    @Override
    public String toString(){
        String cadena = super.toString();
        cadena += String.format("  %s: %-2d", "Pases", pase);
        cadena += String.format("  %s: %-2d", "Regate", regate);
        cadena += String.format("  %s: %-2d", "Remate", remate);
        return cadena;
    }
}
