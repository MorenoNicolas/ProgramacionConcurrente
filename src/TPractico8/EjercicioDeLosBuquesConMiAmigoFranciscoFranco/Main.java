package TPractico8.EjercicioDeLosBuquesConMiAmigoFranciscoFranco;

public class Main {
    public static void main(String[] args) {
        Buque buque = new Buque();
        
        ControlBuque control = new ControlBuque(buque);
        control.start();
        
        // Considero que siempre se llena como el Tren Turistico?
        for(int i = 1; i < 61; i++) {
            Auto auto = new Auto(buque);
            auto.start();
        }
    }
    }

