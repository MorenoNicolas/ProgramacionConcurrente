package TPractico5.EJ2;

import java.util.concurrent.Semaphore;

public class Confiteria {
    
    private Semaphore bebilona = new Semaphore(0);
    private Semaphore semComida = new Semaphore(0);
    private Semaphore semBebida = new Semaphore(0);
    private Semaphore semSilla = new Semaphore(2);
    private Semaphore comilona = new Semaphore(0);

    public void sentarse() throws InterruptedException{
        semSilla.acquire();
    }
    public void levantarse(){
        semSilla.release();
    }
    public void indicarComer(){
        comilona.release();
    }
    public void indicarBeber(){
        bebilona.release();
    }
    public void empezarAComer() throws InterruptedException{
        comilona.acquire();
        System.out.println("El empleado "+Thread.currentThread().getName()+ " esta comiendo" );
        Thread.sleep(1000);
    }
    public void empezarABeber() throws InterruptedException{
        bebilona.acquire();
        System.out.println("El empleado "+Thread.currentThread().getName()+ " esta tomando" );
        Thread.sleep(1000);
    }
    public void pedirBebida() {
        System.out.println("El empleado "+Thread.currentThread().getName()+ " pidio Bebida" );
        semBebida.release();
    }
    public void entregarBebida() throws InterruptedException{
        Thread.sleep(500);
        semBebida.acquire();
    }
    public void pedirComida() {
        System.out.println("El empleado "+Thread.currentThread().getName()+ " pidio Comida" );
        semComida.release();
    }
    public void entregarComida() throws InterruptedException{
        Thread.sleep(500);
        semComida.acquire();
    }
}
