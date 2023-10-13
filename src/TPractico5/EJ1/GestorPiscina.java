package TPractico5.EJ1;

public class GestorPiscina extends Thread{
    
    private Piscina pile;

    public GestorPiscina(Piscina p){
        pile = p;
    }

    public void run(){
        while(true){
            try {
                pile.solicitarPile();

                pile.dejarEntrar();
            } catch (InterruptedException e) {
            }
            
        }
    }
}
