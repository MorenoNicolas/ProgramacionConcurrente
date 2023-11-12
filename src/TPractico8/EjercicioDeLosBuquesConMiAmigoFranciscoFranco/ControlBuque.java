package TPractico8.EjercicioDeLosBuquesConMiAmigoFranciscoFranco;

public class ControlBuque extends Thread{
    private Buque b;

    public ControlBuque(Buque bu){
        b = bu;
    }

    public void run(){
        try {
            while(true){
                b.empezarRecorrido();
                Thread.sleep(3000);
                b.terminarRecorrido();
            }
        } catch (Exception e) {
        }
    }
}
