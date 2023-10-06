package TPractico4.EJ7;

public class Mozo extends Thread {
    private PollosHermanos gustavo;

    public Mozo(PollosHermanos gus){
        this.gustavo= gus;
    }

    public void run(){
        while(true){
            try {
                gustavo.servirComida();

                gustavo.indicarComer();
            } catch (Exception e) {
                
            }
        }
    }
}
