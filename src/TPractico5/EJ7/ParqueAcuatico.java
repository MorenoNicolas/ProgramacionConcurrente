package TPractico5.EJ7;

import java.util.concurrent.Semaphore;

/**
 * ParqueAcuatico
 */
public class ParqueAcuatico {

    private Semaphore visitanteEspera;
    private Semaphore permiteBajar = new Semaphore(0, true);
    private Semaphore tobogan = new Semaphore(0);//consultar funcionamiento con TRUE o False
    private Semaphore mutex = new Semaphore(2);


    public ParqueAcuatico(int escalones){
        visitanteEspera = new Semaphore(escalones, true);
    }

    public void haciendoFila() throws InterruptedException{
        visitanteEspera.acquire();
        System.out.println("El visitante " + Thread.currentThread().getName()+  " esta en la escalera esperando...");
        permiteBajar.release();
    }

    public void permitirBajar() throws InterruptedException{
        permiteBajar.acquire();
        mutex.acquire();
        System.out.println("El encargado dejo bajar a 1 Persona");
        tobogan.release();
    }

    public void bajarPorTobogan() throws InterruptedException{
        tobogan.acquire();
        System.out.println(Thread.currentThread().getName()+  " esta bajandOoOOoooOOoo ");
        Thread.sleep(1200);
        System.out.println(Thread.currentThread().getName()+  " termino de bajar ");
        mutex.release();
        visitanteEspera.release();
    }

}