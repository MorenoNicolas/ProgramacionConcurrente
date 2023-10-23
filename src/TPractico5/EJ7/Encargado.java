package TPractico5.EJ7;

public class Encargado extends Thread{
    
    private ParqueAcuatico parquesito;

    public Encargado(ParqueAcuatico p){
        this.parquesito = p;
    }
    public void run(){
        try {
            while(true){
                parquesito.permitirBajar();
            }
        } catch (Exception e) {
        }
    }
}
