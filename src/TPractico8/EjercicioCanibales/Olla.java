package TPractico8.EjercicioCanibales;

import java.util.concurrent.Semaphore;

public class Olla {
    
    private Semaphore comer;
    private Semaphore cocinar = new Semaphore(0);
    private Semaphore mutex = new Semaphore(1);
    private Semaphore mutex2 = new Semaphore(1);
    private int raciones;
    private int racionesTotales;

    public Olla(int num){
        racionesTotales = num;
        raciones = num;
        comer = new Semaphore(num);
    }

    public void quiereComer() throws InterruptedException{
        mutex.acquire();
        if(raciones!=0){
            comer.acquire();
            raciones--;
            System.out.println("El canibal: " +Thread.currentThread().getName()+ " comio de la olla, quedan: "+ raciones);
        }else{
            cocinar.release();
            System.out.println("El canibal: "+Thread.currentThread().getName()+ " pidio rellenar la olla ");
            comer.acquire();
            raciones--;
            System.out.println("El canibal: " +Thread.currentThread().getName()+ " comio de la olla, quedan: "+ raciones);
        }
        mutex.release();
    }

    public void cocina() throws InterruptedException{
        cocinar.acquire();
        mutex2.acquire();
        System.out.println("------- El cocinero relleno la olla -------");
        raciones = racionesTotales;
        comer.release(raciones);
        mutex2.release();
    }
}
