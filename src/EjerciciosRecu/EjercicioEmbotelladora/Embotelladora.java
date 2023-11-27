package EjerciciosRecu.EjercicioEmbotelladora;

public class Embotelladora extends Thread {
    private PlantaEmbotelladora planta;
    private boolean esDeAgua;

    public Embotelladora(PlantaEmbotelladora p, boolean es) {
        planta = p;
        esDeAgua = es;
    }

    public void run() {
        try {
            if (esDeAgua) {
                while (true) {
                    planta.embotellarAgua();
                    Thread.sleep(1200);
                }
            } else {
                while (true) {
                    planta.embotellarVino();
                    Thread.sleep(1200);
                }
            }
        } catch (Exception e) {
        }
    }
}
