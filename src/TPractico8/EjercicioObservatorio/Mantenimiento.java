package TPractico8.EjercicioObservatorio;

public class Mantenimiento  extends Thread{
    private Observatorio obs;

    public Mantenimiento(Observatorio bs){
        this.obs = bs;
    }
    public void run(){
        try {
            obs.entrarMantenimiento();
            Thread.sleep(1300);
            obs.salirMantenimiento();
        } catch (Exception e) {
        }
    }
}
