import java.util.List;

public class MainMenu {
    public static void main(String[] args) {
        List<GPSData> datos27 = GPSCargar.loadFromCSV("gps_data_bus27.csv");
        List<GPSData> datos22 = GPSCargar.loadFromCSV("gps_data_bus22.csv");
        List<GPSData> datos29 = GPSCargar.loadFromCSV("gps_data_bus29.csv");

        MenuInteractivo.iniciar(datos27, datos22, datos29);
    }
}
