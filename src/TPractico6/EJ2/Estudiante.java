package TPractico6.EJ2;

import java.util.Random;

public class Estudiante extends Thread{
    private SalaDeEstudio salita;
    private Random random = new Random();
    public Estudiante(SalaDeEstudio sa){
        this.salita = sa;
    }
    public void run(){
        try {
            
                salita.utilizarSala();
                Thread.sleep(random.nextInt(1001) + 1000);
                salita.salirSala();
            
        } catch (Exception e) {
        }
    }
}
