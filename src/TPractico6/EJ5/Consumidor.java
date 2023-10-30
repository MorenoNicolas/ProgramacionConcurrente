package TPractico6.EJ5;

public class Consumidor extends Thread{
    private Buffer bufer;

    public Consumidor(Buffer b){
        bufer = b;
    }
    public void run(){
        try {
            while(true){
                bufer.consumir();
            }
        } catch (Exception e) {
        }
    }
}
