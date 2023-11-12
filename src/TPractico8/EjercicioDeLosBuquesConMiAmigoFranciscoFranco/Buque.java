package TPractico8.EjercicioDeLosBuquesConMiAmigoFranciscoFranco;

import java.util.concurrent.Semaphore;

public class Buque {
    
    private Semaphore semBuque = new Semaphore(0);
    private Semaphore semSubir = new Semaphore(10);
    private Semaphore semBajar = new Semaphore(0);
    private Semaphore mutex = new Semaphore(1);
    private Semaphore mutex2 = new Semaphore(1);
    private int capacidad = 10;
    private int ocupacion =0;

    public void entrarAuto() throws InterruptedException{
        mutex.acquire();
        semSubir.acquire();
        System.out.println("El auto: "+Thread.currentThread().getName()+ " entro en el buque");
        Thread.sleep(500);
        ocupacion++;
        if(ocupacion==capacidad){
            semBuque.release();
            
        }
        mutex.release();
    }

    public void empezarRecorrido() throws InterruptedException{
        semBuque.acquire();
        System.out.println("El buque EMPEZO el recorrido.....");
    }

    public void terminarRecorrido(){
        System.out.println(".....El buque TERMINO el recorrido");
        semBajar.release(10);
    }

    public void bajarAuto() throws InterruptedException{
        semBajar.acquire();
        mutex2.acquire();
        ocupacion--;
        semSubir.release();
        mutex2.release();
    }

}
