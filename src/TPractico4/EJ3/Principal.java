package TPractico4.EJ3;

public class Principal {
    
    public static void main(String[] args) {
        ProcesoI[] arr = new ProcesoI[3];
        Datos unDato1 = new Datos(1, 1);
        Datos unDato2 = new Datos(2, 0);
        Datos unDato3 = new Datos(3, 0);

        arr[0] = new ProcesoI(unDato1);
        arr[1] = new ProcesoI(unDato2);
        arr[2] = new ProcesoI(unDato3);

        arr[0].start();
        arr[1].start();
        arr[2].start();
    }
}
