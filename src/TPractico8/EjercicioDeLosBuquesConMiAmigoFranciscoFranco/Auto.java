package TPractico8.EjercicioDeLosBuquesConMiAmigoFranciscoFranco;

public class Auto extends Thread{
    private Buque b;

    public Auto(Buque bu){
        b = bu;
    }

    public void run(){
        try {
            b.entrarAuto();
            
            b.bajarAuto();
        } catch (Exception e) {
        }
    }
}
