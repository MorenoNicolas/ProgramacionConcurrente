package TPractico4.TrabajoObligatorio1;

public class Principal {
    public static void main(String[] args) {
        Tren tren = new Tren(5);
        ControlTren inspector = new ControlTren(tren);
        Pasajero[] pasajeros = new Pasajero[20];
        MaquinaTickets maquinita = new MaquinaTickets(15);

        for(int i = 0; i < pasajeros.length; i++) {
            pasajeros[i] = new Pasajero(tren, i + 1, maquinita);
        }

        inspector.start();
        for(int i = 0; i < pasajeros.length; i++) {
            pasajeros[i].start();
        }
    }
}
