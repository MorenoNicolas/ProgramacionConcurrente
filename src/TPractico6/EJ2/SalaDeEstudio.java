package TPractico6.EJ2;

/**
 * SalaDeEstudio
 */
public class SalaDeEstudio {
    private int cantEstudiantes;
    private int cantMesas;

    public SalaDeEstudio(int numE, int numM){
        this.cantEstudiantes = numE;
        this.cantMesas = numM;
    }

    public synchronized void utilizarSala() throws InterruptedException{
        while(cantEstudiantes==cantMesas){
            this.wait();
        }
        cantEstudiantes++;
        System.out.println("El estudiante entro a la sala: "+Thread.currentThread().getName());
    }

    public synchronized void salirSala(){
        cantEstudiantes--;
        System.out.println("El estudiante: " +Thread.currentThread().getName()+ " salio de la sala");
        this.notifyAll();
    }

}