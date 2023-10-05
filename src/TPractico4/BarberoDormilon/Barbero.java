package TPractico4.BarberoDormilon;



/**
 *
 * @author Giuli Vicentino
 */
public class Barbero extends Thread {

    private Asiento sillon;

    public Barbero(Asiento sillon) {
        this.sillon = sillon;
    }

    public void run() {
        while (true) {
            try {
                sillon.barbroMimir();
                Thread.sleep(1000);
            } catch (InterruptedException ex) {
            }
            System.out.println("Ya te corté paaaaaaaaaaa. ahora andate");
            sillon.indicarSalida();
            System.out.println("Me duermo mimimimimi");
        }
    }
}
