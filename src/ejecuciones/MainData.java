package ejecuciones;

import clases.GPSCargar;
import clases.GPSData;

import java.util.ArrayList;

public class MainData {
    public static void main(String[] args) {
        ArrayList<GPSData> bus27Data = GPSCargar.loadFromCSV("gps_data_bus27.csv");
        ArrayList<GPSData> bus22Data = GPSCargar.loadFromCSV("gps_data_bus22.csv");
        ArrayList<GPSData> bus29Data = GPSCargar.loadFromCSV("gps_data_bus29.csv");

        System.out.println("Registros de BUS27: " + bus27Data.size());
        System.out.println("Registros de BUS22: " + bus22Data.size());
        System.out.println("Registros de BUS29: " + bus29Data.size());
    }
}
