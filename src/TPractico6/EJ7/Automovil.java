package TPractico6.EJ7;

/**
 * Automovil
 */
public class Automovil extends Thread {

    Ferry ferry;

    public Automovil(Ferry f){
        ferry = f;
    }

    public void run(){
        try {
            ferry.subirFerry(false);

            ferry.bajarFerry(false);
        } catch (Exception e) {
        }
    }
}