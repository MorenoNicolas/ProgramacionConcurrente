package TPractico8.EjercicioCanibales;

public class Canibales extends Thread{
    private Olla ollita;

    public Canibales(Olla oya){
        this.ollita = oya;
    }

    public void run(){
        try {
              ollita.quiereComer();
              //Thread.sleep(1000);          
        } catch (Exception e) {
        }
    }
}
