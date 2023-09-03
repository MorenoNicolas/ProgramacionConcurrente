package TPractico2.Ejercicio7;

public class Cliente {

    private String nombre;
    private int[] carroCompra;
    public Cliente(String nombre, int[] carroCompra) {
        this.nombre = nombre;
        this.carroCompra = carroCompra;
    }

    // Constructor y métodos de acceso
    public String getNombre() {
        return this.nombre;
    }

    public int[] getCarroCompra() {
        return this.carroCompra;
    }
    
   
    
}
