import java.time.Duration;
import java.time.LocalTime;

public class Estacionamiento extends Automovil{
    
    //Constructor por parametros

    public Estacionamiento(LocalTime horaEntrada) {
        this.horaEntrada = horaEntrada;
        this.horaSalida = null;
        this.boletoPerdido = false;
        this.pensionado = false;
    }

    //Constructor por Omision
    public Estacionamiento (){
        
    }
    
        // Método para calcular el monto total a cobrar
        public double calcularMontoTotal() {
            Duration duracion = Duration.between(horaEntrada, horaSalida);
            long minutos = duracion.toMinutes();
            double montoTotal = 0;
    
            if (boletoPerdido) {
                montoTotal = 350;
            } else if (pensionado) {
                montoTotal = 750;
            } else {
                // Calcular monto por tiempo de estacionamiento
                if (minutos <= 120) {
                    montoTotal = 10;
                } else {
                    int horasCompletas = (int) (minutos / 60);
                    int minutosRestantes = (int) (minutos % 60);
    
                    montoTotal = horasCompletas * 15;
    
                    if (minutosRestantes > 0) {
                        montoTotal += 15;
                    }
                }
            }
    
            return montoTotal;
        }
    }
