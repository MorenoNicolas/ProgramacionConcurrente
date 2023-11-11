package TPractico8.EjercicioParqueConcurrido;

public class Vecinos extends Thread{
    private ParqueCentral parquesito;
    private boolean esVIP;

    public Vecinos(ParqueCentral p, boolean vip){
        parquesito = p;
        esVIP = vip;
    }

    public void run(){
        try {
            if(esVIP){
                parquesito.entrarPrivilegiado();
            }else{
                parquesito.entrarNormal();
            }    
            Thread.sleep(1500);
            parquesito.salir();
        } catch (Exception e) {
        }
    }
}
