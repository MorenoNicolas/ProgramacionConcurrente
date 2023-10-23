package TPractico5.EJ6;

public class Torre extends Thread{
    private Pista pista;
    

    public Torre(Pista pista){
        this.pista = pista;
    }

    public void run(){
        while(true){
            try {
                pista.torreControl();
            } catch (Exception e) {
                // TODO: handle exception
            }
        }
    }
}
