package TPractico8.EjercicioObservatorio;

public class Visitante  extends Thread{
    private Observatorio obs;

    public Visitante(Observatorio bs){
        this.obs = bs;
    }
    public void run(){
        try {
            obs.entrarVisitante();
            Thread.sleep(1300);
            obs.salirVisitante();
        } catch (Exception e) {
        }
    }
}
