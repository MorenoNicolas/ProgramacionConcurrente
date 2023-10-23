package TPractico5.EJ6;

public class Main {
    public static void main(String[] args) {
        int cantDespegues = 5, cantAterrizajes = 10;
        Pista pista = new Pista(cantDespegues, cantAterrizajes);

        Torre torre = new Torre(pista);
        torre.start();

        Avion[] avionesADespegar = new Avion[cantDespegues];
        for (int i = 0; i < cantDespegues; i++) {
            avionesADespegar[i] = new Avion(pista, 'D');
            avionesADespegar[i].start();
        }

        Avion[] avionesAAterrizar = new Avion[cantAterrizajes];
        for (int j = 0; j < cantAterrizajes; j++) {
            avionesAAterrizar[j] = new Avion(pista, 'A');
            avionesAAterrizar[j].start();
        }

    }
}
