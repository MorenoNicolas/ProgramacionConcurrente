package TPractico4.EJ7;

public class Main {
    public static void main(String[] args) {
        PollosHermanos pollito = new PollosHermanos();
        Mozo mariano = new Mozo(pollito);
        Empleado[] arrEmp = new Empleado[4];
        mariano.start();
        for (int i = 0; i < arrEmp.length; i++) {
            arrEmp[i] = new Empleado(pollito);
            arrEmp[i].start();
        }
    }
}
