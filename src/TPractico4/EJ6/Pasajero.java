package TPractico4.EJ6;

public class Pasajero extends Thread {
    private Taxi taxi;

    public Pasajero(Taxi taxi){
        this.taxi=taxi;
    }

    public void run(){
        while(true){
            try {
                taxi.sentarseTaxi();
                taxi.despertarTaxiasta();

                taxi.bajarseTaxi();
                taxi.dormirTaxista();
            } catch (Exception e) {
            }
        }
    }
}
                // taxi.estacionado();
                // taxi.despertarTaxiasta();
                // System.out.println("El taxista se desperto");
                // taxi.sentarseTaxi();
                // System.out.println("Me sente");
                
                // System.out.println("Termino el viaje");
                // taxi.liberarTaxi();
                // System.out.println("Me levante");
