package EjerciciosRecu.EjercicioEmbotelladora;

public class Main {
    public static void main(String[] args) {
        PlantaEmbotelladora nuevaPlanta = new PlantaEmbotelladora();
        Transportador transpo = new Transportador(nuevaPlanta);
        transpo.start();
        Empaquetadora empa = new Empaquetadora(nuevaPlanta);
        empa.start();
        Embotelladora[] emboAgua = new Embotelladora[3];
        for (int i = 0; i < emboAgua.length; i++) {
            emboAgua[i] = new Embotelladora(nuevaPlanta, true);
            emboAgua[i].start();
        }
        Embotelladora[] emboVino =new Embotelladora[3];
        for (int i = 0; i < emboVino.length; i++) {
            emboVino[i] = new Embotelladora(nuevaPlanta, false);
            emboVino[i].start();
        }
    }
}
