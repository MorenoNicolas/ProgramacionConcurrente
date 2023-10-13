package TPractico5.EJ1;

import java.util.concurrent.Semaphore;

public class Piscina {
    
    Semaphore libre = new Semaphore(5);
    Semaphore lleno = new Semaphore(0);
    Semaphore mutex = new Semaphore(1);

    public void entrarPileta() throws InterruptedException{
        lleno.acquire();
        System.out.println( Thread.currentThread().getName()+ " entro a la pile ");
    }

    public void salirPileta(){
        System.out.println( Thread.currentThread().getName()+ " salio de la pile ");
        libre.release();
    }

    public void solicitarPile() throws InterruptedException{
        mutex.acquire();
        libre.acquire();
    }

    public void dejarEntrar(){
        lleno.release();
        mutex.release();
    }
}
