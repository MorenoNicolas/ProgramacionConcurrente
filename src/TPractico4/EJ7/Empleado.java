package TPractico4.EJ7;

public class Empleado extends Thread{
    private PollosHermanos gustavo;

    public Empleado(PollosHermanos gus){
        this.gustavo= gus;
    }
    @Override
    public void run(){
       try {
        gustavo.sentarse();
        gustavo.indicarComida();

        gustavo.comer();
        Thread.sleep(2000);
        gustavo.levantarse();
       } catch (Exception e) {
        // TODO: handle exception
       }
    }

}
