package TPractico8.EjercicioHemoterapia;

public class Donador extends Thread{
    private CentroHemoterapia centro;

    public Donador(CentroHemoterapia c){
        centro = c;
    }

    public void run(){
        try {
            centro.donarSangre();
            Thread.sleep(2500);
            centro.salirCentro();            
        } catch (Exception e) {
        }
    }
    
}
