package TPractico6.EJ7;

public class Pasajero extends Thread{
    Ferry ferry;

    public Pasajero(Ferry f){
        ferry = f;
    }

    public void run(){
        try {
            ferry.subirFerry(true);

            ferry.bajarFerry(true);
        } catch (Exception e) {
        }
    }
}
