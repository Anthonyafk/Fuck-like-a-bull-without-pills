import java.time.Duration;
import java.time.LocalTime;


public class Automovil {
    String modelo, color, marca, placas, tipo;

    int ano;
        
    LocalTime horaEntrada;
    LocalTime horaSalida;
    boolean boletoPerdido;
    boolean pensionado;
    

    // Constructor  por parametros
    public Automovil(String modelo, String color, String marca,  String placas, String tipo, int ano, LocalTime horaEntrada, LocalTime horaSalida, boolean boletoPerdido, boolean pensionado) {

        this.tipo = tipo;
        this.marca = marca;
        this.modelo = modelo;
        this.ano = ano;
        this.color = color;
        this.placas = placas;
        this.horaEntrada = horaEntrada;
        this.horaSalida = horaSalida;
        this.boletoPerdido = boletoPerdido;
        this.pensionado = pensionado;
    
    }

    //Contructor por Omision
    public Automovil(){

        this.tipo = "Coche";
        this.marca = "Volkswagen";
        this.modelo = "Vocho";
        this.ano = 1966;
        this.color = "Azul";
        this.placas = "CV-813";
        this.horaEntrada = null;
        this.horaSalida = null;
        this.boletoPerdido = false;
        this.pensionado = true;
    }
    
    // (setters)
    public void setHoraSalida(LocalTime horaSalida) {
        this.horaSalida = horaSalida;
    }

    public void setBoletoPerdido(boolean boletoPerdido) {
        this.boletoPerdido = boletoPerdido;
    }

    public void setPensionado(boolean pensionado) {
        this.pensionado = pensionado;
    }


    //Metodo para calcular tiempo

    public void calcularTiempoTotal() {

        if (horaSalida == null) {
            System.out.println("El vehículo aún no ha salido del estacionamiento.");
        } else {
            long segundos = Duration.between(horaEntrada, horaSalida).getSeconds();
            System.out.println("El tiempo total de estancia del vehículo es: " + segundos + " segundos.");
        }
    }