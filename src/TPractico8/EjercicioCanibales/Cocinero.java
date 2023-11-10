package TPractico8.EjercicioCanibales;

public class Cocinero extends Thread{
    private Olla ollita;

    public Cocinero(Olla oya){
        this.ollita = oya;
    }

    public void run(){
        try {
              while(true){
                ollita.cocina();
                //Thread.sleep(2000);
              }          
        } catch (Exception e) {
        }
    }
}
