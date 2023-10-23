package TPractico5.EJ6;

public class Avion extends Thread{
    
    private Pista pista;
    private char tipo;

    public Avion(Pista pista, char tipo){
        this.pista = pista;
        this.tipo = tipo;
    }

    public void run(){
        try {
            if(tipo == 'A'){
                pista.aterriza();
            }else{
                pista.despegar();
            }
        } catch (Exception e) {
            // TODO: handle exception
        }
    }
}
