package TPractico6.EJ2;

public class ControlMonitor extends Thread{
    SalaDeEstudio salita;

    public ControlMonitor(SalaDeEstudio sa){
        this.salita = sa;
    }
    public void run(){
        try {
            while(true){
                //salita.permitirEntrar();
            }
        } catch (Exception e) {
        }
    }
}
