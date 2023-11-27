package EjerciciosRecu.EjercicioEmbotelladora;

public class Transportador extends Thread{
    private PlantaEmbotelladora planta;

    public Transportador(PlantaEmbotelladora p){
        planta = p;
    }
    public void run(){
        while(true){
            try {
                planta.transportarCajas();
                Thread.sleep(2000);
            } catch (Exception e) {
            }
        }
    }
}
