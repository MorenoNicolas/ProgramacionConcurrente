package EjerciciosRecu.EjercicioEmbotelladora;

public class Empaquetadora extends Thread{
    private PlantaEmbotelladora planta;

    public Empaquetadora(PlantaEmbotelladora p){
        planta = p;
    }
    public void run(){
        while(true){
            try {
                planta.empaquetarCaja();
                Thread.sleep(1500);
                planta.reponerCaja();                
            } catch (Exception e) {
            }
        }
    }
}
