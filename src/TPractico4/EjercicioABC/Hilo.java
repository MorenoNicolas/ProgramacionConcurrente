package TPractico4.EjercicioABC;

import TPractico2.Ejercicio1.Recurso;

public class Hilo extends Thread  {
    public char c;
    private RecursoComp rc;
    private int n;

    public Hilo(RecursoComp rc, char c, int n){
        this.rc = rc;
        this.c = c;
        this.n = n;
    }
    public void run() {
        while(true){
                try {
                    rc.imprimir(c, n);
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            
        }
    }
}
