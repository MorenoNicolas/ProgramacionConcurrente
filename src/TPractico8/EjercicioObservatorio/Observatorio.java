package TPractico8.EjercicioObservatorio;

import java.util.concurrent.locks.Condition;
import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReentrantLock;

public class Observatorio {
    private int ocupacion;
    private int capacidadMax;
    private int investigadorTrabajando;
    private int mantenimientoTrabajando;
    private int visVisitando;
    private boolean discapacitado;
    //locks
    private Lock mutex = new ReentrantLock();
    Condition investigador = mutex.newCondition();
    Condition mantenimiento = mutex.newCondition();
    Condition visitante = mutex.newCondition();
    
    public Observatorio(int num){
        this.capacidadMax = num;
    }

    public void entrarVisitante() throws InterruptedException{
        try {
            mutex.lock();
        while(ocupacion>=capacidadMax&&mantenimientoTrabajando>0&&investigadorTrabajando>0){
            visitante.await();
        }
        ocupacion++;
        System.out.println(Thread.currentThread().getName()+" entro visitante comun");
        
        } catch (Exception e) {
        }finally{mutex.unlock();}
    }

    public void entrarMantenimiento(){
        try {
            mutex.lock();
            while(ocupacion>=capacidadMax&&investigadorTrabajando>0&&visVisitando>0){
                mantenimiento.await();
            }
            ocupacion++;
            mantenimientoTrabajando++;
            System.out.println(Thread.currentThread().getName()+" entro mantenimiento"); 
        } catch (Exception e) {
        }finally{mutex.unlock();}
    }

    public void entrarInvestigador(){
        try {
            mutex.lock();
            while(ocupacion>=capacidadMax&&visVisitando>0&&mantenimientoTrabajando>0&&investigadorTrabajando>0){
                investigador.await();
            }
            ocupacion++;
            investigadorTrabajando++;
            System.out.println(Thread.currentThread().getName()+" entro un investigador"); 
        } catch (Exception e) {
        }finally{mutex.unlock();}
    }
    public void salirObservatorio(){
        mutex.lock();
        try {
            ocupacion--;
            if(ocupacion==0){
                investigador.signalAll();
            }else{
                visitante.signalAll();
                mantenimiento.signalAll();
            }
        } catch (Exception e) {
        }finally{mutex.unlock();}
    }
}
