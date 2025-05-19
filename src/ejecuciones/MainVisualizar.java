package ejecuciones;

import clases.GPSCargar;
import clases.GPSData;
import clases.GPSVisualizar;

import java.util.List;

public class MainVisualizar {

    public static void main(String[] args) {
        List<GPSData> datos27 = GPSCargar.loadFromCSV("gps_data_bus27.csv");
        List<GPSData> datos22 =  GPSCargar.loadFromCSV("gps_data_bus22.csv");
        List<GPSData> datos29 = GPSCargar.loadFromCSV("gps_data_bus29.csv");

        GPSVisualizar.mostrarTrayecto(datos27, "BUS27");
        GPSVisualizar.mostrarTrayecto(datos22, "BUS22");
        GPSVisualizar.mostrarTrayecto(datos29, "BUS29");
    }
}
