package TPractico4.EJ7;

import java.util.concurrent.Semaphore;

public class PollosHermanos {
    
    private Semaphore mutex1 = new Semaphore(1);
    private Semaphore mutex2 = new Semaphore(0);
    private Semaphore mutex3 = new Semaphore(0);

    public void sentarse() throws InterruptedException{
        mutex1.acquire();
        System.out.println("El empleado numero " + Thread.currentThread().getName()+ " se sento");
    }

    public void levantarse(){
        System.out.println("El empleado numero " + Thread.currentThread().getName()+ " se fue");
        mutex1.release();
    }

    public void indicarComida(){
        mutex2.release();
    }
    public void servirComida() throws InterruptedException{
        mutex2.acquire();
    }

    public void indicarComer(){
        mutex3.release();
    }
    public void comer() throws InterruptedException{
        mutex3.acquire();
        System.out.println("El empleado numero " + Thread.currentThread().getName()+ " esta comiendo...");
    }

}
