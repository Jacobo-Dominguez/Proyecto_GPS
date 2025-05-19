package ejecuciones;

import clases.GPSAnalisis;
import clases.GPSCargar;
import clases.GPSData;
import clases.GPSFiltrar;

import java.util.List;

public class MainAnalisis {
    public static void main(String[] args) {
        List<GPSData> bus27Data = GPSCargar.loadFromCSV("gps_data_bus27.csv");
        List<GPSData> datosValidos = GPSFiltrar.filtrarPorBus(bus27Data, "BUS27");

        double media = GPSAnalisis.calcularVelocidadMedia(datosValidos);
        int paradas = GPSAnalisis.contarParadas(datosValidos);

        System.out.printf("Velocidad media del BUS27: %.2f km/h%n", media);
        System.out.println("Número de paradas detectadas: " + paradas);
    }
}
