package TPractico4.EjercicioABC;

import java.util.concurrent.Semaphore;

public class RecursoComp {

    private Semaphore mutexA;
    private Semaphore mutexB;
    private Semaphore mutexC;

    public RecursoComp() {
        mutexA = new Semaphore(1);
        mutexB = new Semaphore(0);
        mutexC = new Semaphore(0);
    }

    public void imprimir(char caract, int n) throws InterruptedException {
        switch (caract) {
            case 'A':
                this.imprimirA(n);
            case 'B':
                this.imprimirB(n);
            case 'C':
                this.imprimirC(n);
        }
    }

    private void imprimirA(int n) throws InterruptedException {
        mutexA.acquire();
        for (int i = 0; i < n; i++) {
            System.out.print('a');
        }
        mutexB.release();
    }

    private void imprimirB(int n) throws InterruptedException {
        mutexB.acquire();
        for (int i = 0; i < n; i++) {
            System.out.print('b');
        }
        mutexC.release();
    }

    private void imprimirC(int n) throws InterruptedException {
        mutexC.acquire();
        for (int i = 0; i < n; i++) {
            System.out.print('c');
        }
        mutexA.release();
    }
}
