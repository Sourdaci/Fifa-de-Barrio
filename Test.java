public class Test
{
    public Test() 
    {
        Equipo equipo1 = Equipo.new("SOLTEROS", 15)
        Equipo equipo2 = Equipo.new("CASADOS", 15)
        Partido miPartido = Partido.new(equipo1, equipo2)
        miPartido.mostrarAlineaciones();
    }
}