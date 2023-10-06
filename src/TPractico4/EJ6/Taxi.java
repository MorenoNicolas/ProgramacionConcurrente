package TPractico4.EJ6;

import java.util.concurrent.Semaphore;

public class Taxi {
    private Semaphore mutex1 = new Semaphore(0);
    private Semaphore mutex2 = new Semaphore(1);
    private Semaphore mutex3 = new Semaphore(0);

    public void dormirTaxista()  {
        System.out.println("El taxista se durmio");
        mutex2.release();
        
    }
    public void despertarTaxiasta(){
        System.out.println("Desperte al taxista");
        mutex1.release();
        
    }

    public void sentarseTaxi() throws InterruptedException{
        mutex2.acquire();
        System.out.println("me subi");
    }
    public void bajarseTaxi() throws InterruptedException{
        mutex3.acquire();
        System.out.println("me baje");
    }

    public void comenzarViaje() throws InterruptedException{
        mutex1.acquire();
        System.out.println("Viajando...");
    }
    public void recorridoFin() {
        System.out.println("Termino el recorrido");
        mutex3.release();
        
    }
}
