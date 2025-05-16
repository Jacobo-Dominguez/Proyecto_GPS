import java.util.List;

public class MainExportar {
    public static void main(String[] args) {
        // Cargar datos de las tres líneas
        List<GPSData> datos27 = GPSCargar.loadFromCSV("gps_data_bus27.csv");
        List<GPSData> datos22 = GPSCargar.loadFromCSV("gps_data_bus22.csv");
        List<GPSData> datos29 = GPSCargar.loadFromCSV("gps_data_bus29.csv");

        // Exportar última posición para cada bus
        GPSExportar.exportarUltimaPosicionJSON(datos27, "BUS27");
        GPSExportar.exportarUltimaPosicionJSON(datos22, "BUS22");
        GPSExportar.exportarUltimaPosicionJSON(datos29, "BUS29");
    }
}
