package TPractico8.EjercicioPasteleria;

public class Brazo extends Thread{
    private PasteleriaRC paste;

    public Brazo(PasteleriaRC p){
        paste = p;
    }

    public void run(){
        try {
            while(true){
                paste.retirarCaja();
                Thread.sleep(1000);
                paste.reponerCaja();
            }            
        } catch (Exception e) {
        }
    }
}
