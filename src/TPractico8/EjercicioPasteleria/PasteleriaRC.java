package TPractico8.EjercicioPasteleria;

import java.util.LinkedList;
import java.util.Queue;
import java.util.concurrent.Semaphore;

public class PasteleriaRC {
    
    private Queue<Integer> colaPasteles = new LinkedList<Integer>();
    private Semaphore caja = new Semaphore(1);
    private Semaphore empaquetadores;
    private Semaphore pasteles = new Semaphore(0);
    private Semaphore brazo = new Semaphore(0);
    private Semaphore mutex = new Semaphore(1);
    private Semaphore mutex2 = new Semaphore(1);
    private int pesoCaja;
    private int pesoCajaActual;

    public PasteleriaRC(int numEmpaquetadores, int pesoCaja){
        this.empaquetadores = new Semaphore(numEmpaquetadores);
        this.pesoCaja = pesoCaja;
    }

    public void hornearPastel(int peso) throws InterruptedException{
        colaPasteles.add(peso);
        System.out.println("Se agrego un pastel a la cinta de: " +peso+" gramos");
        pasteles.release();
    }

    public void tomarPastel() throws InterruptedException{
        mutex.acquire();
        pasteles.acquire();
        empaquetadores.acquire();
        
        if(pesoPrimerPastel()+pesoCajaActual<=pesoCaja){
            pesoCajaActual += pesoPrimerPastel();
            System.out.println("La empaquetadora: "+ Thread.currentThread().getName()+" puso un pastel en la caja");
            System.out.println("Hay: "+pesoCajaActual+"/"+pesoCaja+"kg en la caja actualmente");
            colaPasteles.remove();
            
        }else{
            System.out.println("------Se intento meter un pastel de: "+colaPasteles.peek()+", pidio reponer la caja------");
            brazo.release();
            caja.acquire();
            pesoCajaActual += pesoPrimerPastel();
            colaPasteles.remove();
        }
        empaquetadores.release();
        mutex.release();
    }

    public void reponerCaja() throws InterruptedException{
        pesoCajaActual = 0;
        caja.release();
        
    }

    public void retirarCaja() throws InterruptedException{
        
        brazo.acquire();
        System.out.println("El brazo retiro la caja y coloco otra en su lugar");
    }

    private int pesoPrimerPastel(){
        return colaPasteles.peek();
    }
}
