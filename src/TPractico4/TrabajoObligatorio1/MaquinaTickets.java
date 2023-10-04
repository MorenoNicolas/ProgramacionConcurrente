package TPractico4.TrabajoObligatorio1;

public class MaquinaTickets {
    private int numeroTickets;

    public MaquinaTickets(int cantidad){
        numeroTickets = cantidad;
    }
    public synchronized boolean comprarTicket(){
        boolean exito = false;
        if(numeroTickets>0){
        numeroTickets--;
        exito = true;
        }
        return exito;
    }
}
