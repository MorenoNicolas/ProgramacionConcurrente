package TPractico7.EJ1;

import java.util.concurrent.locks.Condition;
import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReentrantLock;

public class GestorSala {
    private int limite;
    private int jubiladosEsperando;
    private int espacioOcupado;
    private int temperaturaAct;
    private int tUmbral;

    public GestorSala(int limte){
        this.limite = limite;
    }
    //locks
    private Lock lock = new ReentrantLock();
    private Condition persona = lock.newCondition();
    private Condition jubilado = lock.newCondition();
    
    public void entrarSala() throws InterruptedException{
        lock.lock();
        try{
            while(espacioOcupado>=limite||jubiladosEsperando!=0){
                persona.await();
            }
            System.out.println(Thread.currentThread().getName()+" persona normal entra a la sala");
            espacioOcupado++;
        }finally{
            lock.unlock();
        }
    }
    public void entrarSalaJubilado() throws InterruptedException{
        lock.lock();
        jubiladosEsperando++;
        while(jubiladosEsperando>=limite){
            jubilado.await();
        }
        System.out.println(Thread.currentThread().getName()+" entro un jubilado");
        espacioOcupado++;
        lock.unlock();
    }
    
    public void salirSala(boolean esJubilado){
      lock.lock();
      if(esJubilado){
        System.out.println(Thread.currentThread().getName() + "  se fue un jubilado");
        jubiladosEsperando--; 
        }else{
            System.out.println(Thread.currentThread().getName() + "  se fue una persona normal");
        }
        espacioOcupado--;
        lock.unlock();
    }
    public void notificarTemperatura(int temperatura){
        lock.lock();
        temperaturaAct = temperatura;
        if(temperaturaAct>tUmbral){
            limite = 35;
        }else{
            limite = 50;
        }
        System.out.println("La temperatura actual es de: "+ temperaturaAct+ "°C");
        System.out.println("---- La sala cambio su capacidad ----");
        lock.unlock();
        //preguntar si es necesario ponerlo en finally
    }
}
