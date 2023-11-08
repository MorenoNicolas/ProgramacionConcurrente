package TPractico8.EjercicioSoldados;

public class Soldado extends Thread {
    private Cuartel cuartel;
    private char tipo;

    public Soldado(Cuartel c, char tip) {
        this.cuartel = c;
        this.tipo = tip;
    }

    public void run() {
        try {
            if (tipo == 'N') {
                cuartel.ocupaMostradorAlmuerzo();
            } else if (tipo == 'B') {
                cuartel.ocupaMostradorAlmuerzo();
                cuartel.usaAbridor();
            } else {
                cuartel.ocupaMostradorAlmuerzo();
                cuartel.ocuparMostradorPostre();
            }
        } catch (Exception e) {
        }
    }
}
