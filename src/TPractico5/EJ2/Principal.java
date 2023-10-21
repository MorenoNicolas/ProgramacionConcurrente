package TPractico5.EJ2;

public class Principal {
    public static void main(String[] args) {
        Confiteria confiteria = new Confiteria();
        Mozo mozo = new Mozo(confiteria);
        Cocinero cocinero = new Cocinero(confiteria);
        Empleado[] empleados = new Empleado[10];
        
        mozo.start();
        cocinero.start();
        
        for(int i = 0; i < empleados.length; i++) {
            // (i % 3) + 1 para hacerlos tipo 1(toma) / 2(come) / 3(toma y come)
            empleados[i] = new Empleado(confiteria, (i % 3) + 1);
            empleados[i].start();
        }
        
    }
    }

