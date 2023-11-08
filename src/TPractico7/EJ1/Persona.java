package TPractico7.EJ1;

public class Persona extends Thread {
    private boolean tipo;
    private GestorSala sala;

    public Persona(boolean tipo, GestorSala s){
        this.tipo = tipo;
        this.sala = s;
    }

    public void run(){
        try {
        if(tipo){
            sala.entrarSalaJubilado();
        }else{
            sala.entrarSala();
        }            
        Thread.sleep(2000);
        sala.salirSala(tipo);
        } catch (Exception e) {
        }
    }
}
