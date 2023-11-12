package TPractico8.EjercicioPasteleria;

public class Empaquetador extends Thread{
    private PasteleriaRC paste;

    public Empaquetador(PasteleriaRC p){
        paste = p;
    }

    public void run(){
        try {
            while(true){
                paste.tomarPastel();
                Thread.sleep(2000);
            }            
        } catch (Exception e) {
        }
    }
}
