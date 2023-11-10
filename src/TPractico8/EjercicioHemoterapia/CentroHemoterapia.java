package TPractico8.EjercicioHemoterapia;

import java.util.concurrent.Semaphore;

public class CentroHemoterapia {
    private Semaphore camillas = new Semaphore(4, true);
    private Semaphore revistas = new Semaphore(9);
    private Semaphore mutex = new Semaphore(1);
    private Semaphore mutex2 = new Semaphore(1);
    private int revDisponible = 9;
    private int camOcupadas = 0;

    public void donarSangre() throws InterruptedException{
            mutex.acquire();
            revistas.acquire();
            System.out.println("El donante: "+ Thread.currentThread().getName()+" agarro una revista");
            camillas.acquire();
            System.out.println("El donante: "+ Thread.currentThread().getName()+" termino de leer y se acosto en la camilla");
            revistas.release();
            mutex.release();
        }
    
    public void salirCentro() throws InterruptedException{
        mutex2.acquire();
        System.out.println("--------El donante: "+ Thread.currentThread().getName()+" libero una camilla--------");
        camillas.release();
       
        mutex2.release();
    }
}
