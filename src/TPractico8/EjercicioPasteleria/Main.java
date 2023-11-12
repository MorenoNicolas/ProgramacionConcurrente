package TPractico8.EjercicioPasteleria;

public class Main {
    public static void main(String[] args) {
        int numEmpaquetadores=2;
        PasteleriaRC fabricaPastel = new PasteleriaRC(numEmpaquetadores, 25);
        Brazo brazito = new Brazo(fabricaPastel);
        Horno hornoA = new Horno(fabricaPastel, 'A');
        Horno hornoB = new Horno(fabricaPastel, 'B');
        Horno hornoC = new Horno(fabricaPastel, 'C');

        hornoA.start();
        hornoB.start();
        hornoC.start();
        brazito.start();

        Empaquetador[] arrEmpaquetadors = new Empaquetador[numEmpaquetadores];
        for (int i = 0; i < arrEmpaquetadors.length; i++) {
            arrEmpaquetadors[i] = new Empaquetador(fabricaPastel);
            arrEmpaquetadors[i].start();
        }
    }
}
