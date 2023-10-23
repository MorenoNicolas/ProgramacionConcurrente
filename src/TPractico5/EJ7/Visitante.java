package TPractico5.EJ7;

public class Visitante extends Thread{
    private ParqueAcuatico parquesito;

    public Visitante(ParqueAcuatico p){
        this.parquesito = p;
    }
    public void run(){
        try {
                parquesito.haciendoFila();

                parquesito.bajarPorTobogan();

        } catch (Exception e) {
        }
    }
}
