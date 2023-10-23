package TPractico5.EJ6;

import java.util.concurrent.Semaphore;

public class Pista {
    private Semaphore mutexTorre = new Semaphore(0);
    private Semaphore semAterrizaje = new Semaphore(5);
    private Semaphore semDespegue = new Semaphore(0);
    private Semaphore mutexPista = new Semaphore(1);
    private int aterrizadosTotal;
    private int despegadosTotal;
    private int contDespegados = 0;
    private int cantAterrizajes = 0;
    boolean huboDespegue = false;

    public Pista(int despegados, int aterrizados){
        this.despegadosTotal = despegados;
        this.aterrizadosTotal = aterrizados;
    }

    public void despegar() throws InterruptedException {
        semDespegue.acquire();
        System.out.println("Intento DESPEGAR " + Thread.currentThread().getName());
        mutexPista.acquire(); //ECLUSION MUTUA    pido la pista
        System.out.println("----------------------------------------");
        System.out.println(Thread.currentThread().getName() + " despegoooo");
        Thread.sleep(100);
        System.out.println(Thread.currentThread().getName() + " termine el despegoooo");
        huboDespegue = true;
        //System.out.println("aterrizajes actuales: " + cantAterrizajes + " hubo despegue?   " + huboDespegue);
        mutexPista.release();
        mutexTorre.release();//ahora dejo que la torre controlee
    }

    public void torreControl() throws InterruptedException {//reseteo la los permisos de aterrizajes a que vuela a ser 10
        mutexTorre.acquire();
        mutexPista.acquire();
        if (huboDespegue ) {//si ya uno pudo aterrizar no te interesa el despegue
            semAterrizaje.release(cantAterrizajes); //con que despegue alguno ya pueden aterrizar hasta 10 mas
            huboDespegue = false;
            cantAterrizajes=0;
            System.out.println("----------------");
        }
        if (cantAterrizajes == 5) {
            semDespegue.release(); //con que despegue alguno ya pueden aterrizar hasta 10 mas
        }
        mutexPista.release();
    }

    public void aterriza() throws InterruptedException {
        System.out.println("Intento ATERRIZAR " + Thread.currentThread().getName());
        semAterrizaje.acquire(); //puede aterrizar hasta 10 veces y sino espera a un depegue q le da los permisos
        mutexPista.acquire(); //EXCLUSION MUTUA  pido la pista
        System.out.println("----------------------------------------");
        System.out.println(Thread.currentThread().getName() + " aterrizooooo");
        Thread.sleep(1000);
        System.out.println(Thread.currentThread().getName() + " termine de aterrizaaaar ");
        cantAterrizajes++;
        mutexPista.release();
        mutexTorre.release(); //ahora dejo que la torre controlee
        System.out.println(cantAterrizajes+".......................... ");
    }

}

