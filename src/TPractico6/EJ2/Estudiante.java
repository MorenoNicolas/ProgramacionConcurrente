package TPractico6.EJ2;

public class Estudiante extends Thread{
    private SalaDeEstudio salita;

    public Estudiante(SalaDeEstudio sa){
        this.salita = sa;
    }
    public void run(){
        try {
            
                salita.utilizarSala();
                Thread.sleep(2000);
                salita.salirSala();
            
        } catch (Exception e) {
        }
    }
}
