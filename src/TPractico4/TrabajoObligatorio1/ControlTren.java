package TPractico4.TrabajoObligatorio1;

public class ControlTren extends Thread {
    private Tren tren;

    public ControlTren(Tren tren) {
        this.tren = tren;
    }

    public void run() {
        while (true) {
            try {
                tren.iniciaViaje();
                //System.out.println("El tren comenzo el viaje");
                Thread.sleep(1000);
                tren.finRecorrido();
                //System.out.println("El tren finalizo el viaje");
            } catch (Exception ex) {

            }

        }
    }
}
