package TPractico6.EJ7;

public class Main {
    public static void main(String[] args) {
        Ferry ferrito = new Ferry(6, 3);

        Pasajero[] pasajeros = new Pasajero[30];
        for(int i = 0; i < pasajeros.length; i++) {
            pasajeros[i] = new Pasajero( ferrito);
            pasajeros[i].start();
        }
        
        Automovil[] automoviles = new Automovil[10];
        for(int j = 0; j < automoviles.length; j++) {
            automoviles[j] = new Automovil(ferrito);
            automoviles[j].start();
        }
    }
}
