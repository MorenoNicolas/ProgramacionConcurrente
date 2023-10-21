package TPractico5.EJ2;

public class Mozo extends Thread{
    
    private Confiteria conf;

    public Mozo(Confiteria conf){
        this.conf = conf;
    }
    public void run(){
        while(true){
            try {
                conf.entregarBebida();//acuair
                
                conf.indicarBeber();//relaease
            } catch (Exception e) {
                
            }
        }
    }
}

