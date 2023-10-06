package TPractico4.EJ6;

public class Main {
    public static void main(String[] args) {
        Taxi taxi = new Taxi();
        Taxista eduardo = new Taxista(taxi);
        Pasajero yo = new Pasajero(taxi);

        eduardo.start();
        yo.start();
    }
}
