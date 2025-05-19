package ejecuciones;

import clases.GPSCargar;
import clases.GPSData;
import clases.GPSFiltrar;

import java.util.List;

public class MainFiltro {
    public static void main(String[] args) {
        List<GPSData> allData = GPSCargar.loadFromCSV("gps_data_bus27.csv");

        List<GPSData> filteredByBus = GPSFiltrar.filtrarPorBus(allData, "BUS27");

        List<GPSData> filteredByTime = GPSFiltrar.filtrarPorRangoTiempo(
                filteredByBus, "2025-05-15T10:10:00", "2025-05-15T10:30:00");

        System.out.println("Registros válidos BUS27 entre 10:10 y 10:30: " + filteredByTime.size());
    }
}
