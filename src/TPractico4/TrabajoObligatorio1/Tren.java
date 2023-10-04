package TPractico4.TrabajoObligatorio1;

import java.util.concurrent.Semaphore;

public class Tren {
    private int espacio;
    private int ocupacion;
    private Semaphore mutex = new Semaphore(1, true);
    private Semaphore bajarse = new Semaphore(0);
    private Semaphore trenLleno = new Semaphore(0);

    public Tren(int cantidad) {
        espacio = cantidad;
        ocupacion = 0;
    }

    public int getEspacio() {
        return espacio;
    }

    public void incrementarPasajero() {
        ocupacion++;
    }
    
    public void subirPasajero() throws InterruptedException{
        mutex.acquire();
        incrementarPasajero();
        System.out.println("Pasajero " + Thread.currentThread().getName() + " Se sento en el tren");
        if(ocupacion == espacio){
            System.out.println("Se lleno el tren");
            trenLleno.release();
        }else{
            mutex.release();
        }
    }
    public void iniciaViaje() throws InterruptedException{
        trenLleno.acquire();
        System.out.println("Comienza el recorrido");
    }
    public void finRecorrido(){
        System.out.println("Finalizo recorrido");
        bajarse.release();
    }
    public void bajarAsiento() throws InterruptedException{
        bajarse.acquire();
        ocupacion -= 1;
        System.out.println("Pasajero " + Thread.currentThread().getName() + " Se bajo del tren");
        if(ocupacion==0){
            System.out.println("Se vacio el tren");
            mutex.release();
        } else {
        bajarse.release();
    }
    }
}