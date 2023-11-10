package TPractico8.EjercicioHemoterapia;

public class Main {
    public static void main(String[] args) {
        int caca=300;
        CentroHemoterapia centro = new CentroHemoterapia();
        Donador[] donadores = new Donador[30];
        for (int i = 0; i < donadores.length; i++) {
            donadores[i] = new Donador(centro);
            donadores[i].start();
        }
    }
}
