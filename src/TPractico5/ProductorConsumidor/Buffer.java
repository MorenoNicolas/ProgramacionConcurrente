package TPractico5.ProductorConsumidor;

import java.util.concurrent.Semaphore;

public class Buffer {

    int cant = 0;
    int capacidad = 10;
    Semaphore vacio = new Semaphore(capacidad);
    Semaphore completo = new Semaphore(0);
    Semaphore mutex = new Semaphore(1);

    public void agrega(int num) throws InterruptedException {
        if (num<=(capacidad-cant)) {
            vacio.acquire(num);
            System.out.println("El Productor " + Thread.currentThread().getName() + " agrego +"+num+" productos");
            mutex.acquire();
            cant += num;
            System.out.println("Hay " + cant + " productos en la cinta");
            mutex.release();
            completo.release(num);
        } 
    }

    public void sacar(int num) throws InterruptedException {
        if (cant > 0 && num <= cant) {
            completo.acquire(num);
            System.out.println("El Consumidor saco -"+num+" productos");
            mutex.acquire();
            cant -= num;
            System.out.println("Hay " + cant + " productos en la cinta");
            mutex.release();
            vacio.release(num);
        }
    }
}
