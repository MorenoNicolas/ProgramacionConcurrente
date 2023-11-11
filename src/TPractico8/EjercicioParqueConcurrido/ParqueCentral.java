package TPractico8.EjercicioParqueConcurrido;

public class ParqueCentral {
    
    private int privEsperando;
    private int cupoParque;
    private int ocupacion;

    public ParqueCentral(int capacidad){
        cupoParque = capacidad;
    }

    public synchronized void entrarPrivilegiado() throws InterruptedException{
        privEsperando++;
        while(ocupacion>=cupoParque){
            this.wait();
        }
        ocupacion++;
        System.out.println("El vecino VIP: "+Thread.currentThread().getName()+" entro en el parque" );
        privEsperando--;
        this.notifyAll();
    }

    public synchronized void entrarNormal() throws InterruptedException {
        while(ocupacion>=cupoParque&&privEsperando>=1){
            this.wait();
        }
        ocupacion++;
        System.out.println("El vecino normal: "+Thread.currentThread().getName()+" entro en el parque" );
        this.notifyAll();
    }

    public synchronized void salir(){
        System.out.println("El vecino: "+Thread.currentThread().getName()+" salio del parque");
        ocupacion--;
        this.notifyAll();
    }
}
