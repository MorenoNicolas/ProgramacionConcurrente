package TPractico4.TrabajoObligatorio1;

public class Pasajero extends Thread {

    private Tren tren;
    private int numero;
    private MaquinaTickets maquina;

    public Pasajero(Tren tren, int numero, MaquinaTickets maquina) {
        this.tren = tren;
        this.numero = numero;
        this.maquina = maquina;
    }

    public void run() {
        if(maquina.comprarTicket()){
            try {
                tren.subirPasajero();
                tren.bajarAsiento();
            } catch (InterruptedException e) {
            }
        }
    }
    }

