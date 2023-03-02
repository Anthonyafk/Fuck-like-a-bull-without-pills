import java.io.*;
import java.time.Duration;
import java.time.LocalDateTime;
import java.time.LocalTime;
import java.time.format.DateTimeFormatter;
import java.util.ArrayList;
import java.util.Random;

public class Prueba{

    public static void main(String[] args) {
        
        int Simulacion = 60; // Duración de la simulación en minutos
        LocalDateTime horaActual = LocalDateTime.now();
        LocalDateTime horaFinSimulacion = horaActual.plusMinutes(Simulacion);

        List<Ticket> tickets = new ArrayList<Ticket>();
        Random rand = new Random();

        while (horaActual.isBefore(horaFinSimulacion)) {
            // Simular la entrada de un vehículo
            LocalTime horaEntrada = horaActual.toLocalTime();
            String placas = generarPlacasAleatorias();
            String tipo = generarTipoAleatorio();
            Automovil automovil = new Automovil("", "", "", placas, tipo, 0, horaEntrada, null, false, false);
            Ticket ticket = new Ticket(automovil, horaActual);
            tickets.add(ticket);
            System.out.println("Entró un vehículo: " + ticket);

            // Simular la salida de un vehículo
            int indiceTicketSalida = rand.nextInt(tickets.size());
            Ticket ticketSalida = tickets.get(indiceTicketSalida);
            tickets.remove(indiceTicketSalida);
            ticketSalida.getAutomovil().setHoraSalida(horaActual.toLocalTime());
            ticketSalida.calcularMontoCobrado();
            System.out.println("Salió un vehículo: " + ticketSalida);

            //hora Actual
            horaActual = horaActual.plusMinutes(rand.nextInt(60) + 1);

        }
    }
}