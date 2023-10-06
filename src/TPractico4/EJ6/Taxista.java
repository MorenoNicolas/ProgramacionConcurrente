package TPractico4.EJ6;

public class Taxista extends Thread {
    private Taxi taxi;

    public Taxista(Taxi taxi){
        this.taxi = taxi;
    }
    public void run(){
        while (true){
            try {
                taxi.comenzarViaje(); 
                Thread.sleep(2000);
                taxi.recorridoFin();
            } catch (InterruptedException e) {
            }
        }
    }
    
}
