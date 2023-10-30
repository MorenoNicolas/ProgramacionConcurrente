package TPractico6.EJ5;

public class Productor extends Thread{
    private Buffer bufer;
    
    public Productor(Buffer b){
        bufer = b;
    }
    public void run(){
        try {
            while(true){
                bufer.producir();
            }
        } catch (Exception e) {
        }
    }
}
