package TPractico5.ProductorConsumidor;

import java.util.concurrent.Semaphore;

public class Buffer {
    Semaphore vacio = new Semaphore(0);
    Semaphore completo = new Semaphore(0);
    Semaphore mutex = new Semaphore(1);

    int cant = 0;
    int capacidad = 10;

    
    public void agrega(int num) throws InterruptedException{
        mutex.acquire();
        if(cant==0||cant<capacidad){
            cant+=num;
            System.out.println("El Productor "+ Thread.currentThread().getName()+" producto 2 productos");
            vacio.release(num); 
        }else if(cant>=capacidad){
            completo.acquire(num);
        }
        System.out.println("Hay " +cant+ " productos en la cinta");
        mutex.release();
    }

    public void sacar(int num) throws InterruptedException{
        mutex.acquire();
        if(cant>0){
            vacio.acquire(num);
            cant-=num;
            System.out.println("El Consumidor "+ Thread.currentThread().getName()+" consumio 2 productos");
        }else if(cant>=capacidad){
            cant-=num;
            completo.release(num);
        }
        System.out.println("Hay " +cant+ " productos en la cinta");
        mutex.release();
    }
}
