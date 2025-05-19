package ejecuciones;

import clases.GPSCargar;
import clases.GPSData;
import clases.GPSModificar;

import java.util.List;

public class MainModificar {
    public static void main(String[] args) {
        List<GPSData> datos27 = GPSCargar.loadFromCSV("gps_data_bus27.csv");

        // Modificar recorrido: desvío simulado entre minuto 15 y 20
        GPSModificar.modificarRecorrido(datos27, "BUS27", 15, 20, 37.399999, -5.980000);  // ejemplo coordenadas nuevas

        // Guardar con nuevo nombre
        GPSModificar.guardarCSVModificado(datos27, "gps_data_bus27_modificado.csv");
    }
}
