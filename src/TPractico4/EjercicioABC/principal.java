package TPractico4.EjercicioABC;

public class principal {
    public static void main(String[] args) {
        RecursoComp nuevo  = new RecursoComp();
        Hilo hilo1 = new Hilo(nuevo, 'A', 2);
        Hilo hilo2 = new Hilo(nuevo, 'B',2 );
        Hilo hilo3 = new Hilo(nuevo, 'C', 1);

        
        hilo1.start();
        hilo2.start();
        hilo3.start();

    }
}
