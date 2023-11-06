package TPractico6.EJ7;

public class ControlFerry extends Thread{
    Ferry ferry;

    public ControlFerry(Ferry f){
        ferry = f;
    }

    public void run(){
        try {
            while(true){
                ferry.empezarFerry();

                Thread.sleep(2000);
                
                ferry.terminarFerry();
            }
        } catch (Exception e) {
        }
    }
}
