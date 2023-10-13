package TPractico5.EJ1;
import java.util.Random;
public class Persona extends Thread{
    Random random = new Random();
    private Piscina pile;
    private int numeroAleatorio;
    public Persona(Piscina p){
        pile = p;
    }

    public void run(){
        while(true){
            try {
                pile.entrarPileta();
                Thread.sleep(numeroAleatorio = random.nextInt(1501) + 1000);
                pile.salirPileta();
            } catch (InterruptedException e) {
            }
            
        }
    }
}
