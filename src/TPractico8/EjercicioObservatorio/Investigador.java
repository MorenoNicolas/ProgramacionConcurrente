package TPractico8.EjercicioObservatorio;

public class Investigador  extends Thread{
    private Observatorio obs;

    public Investigador(Observatorio bs){
        this.obs = bs;
    }
    public void run(){
        try {
            obs.entrarInvestigador();
            Thread.sleep(1300);
            obs.salirInvestigador();
        } catch (Exception e) {
        }
    }
}
