import java.io.*;
import java.text.SimpleDateFormat;
import java.util.*;

public class GPSDataSimulator {

    public static List<GPSData> generarDatosSimulados(int minutos, String[] busIds) {
        List<GPSData> dataList = new ArrayList<>();
        Random rand = new Random();

        double baseLat = 37.3886;
        double baseLong = -5.9823;

        Calendar calendar = Calendar.getInstance();
        SimpleDateFormat isoFormat = new SimpleDateFormat("yyyy-MM-dd'T'HH:mm:ss");

        for (int minute = 0; minute < minutos; minute++) {
            for (String busId : busIds) {
                calendar.add(Calendar.MINUTE, 1);
                String timestamp = isoFormat.format(calendar.getTime());

                double latitude = baseLat + (rand.nextDouble() - 0.5) / 100;
                double longitude = baseLong + (rand.nextDouble() - 0.5) / 100;
                double speed = 20 + rand.nextDouble() * 30;

                GPSData data = new GPSData(busId, timestamp, latitude, longitude, speed);
                dataList.add(data);
            }
        }

        return dataList;
    }

    public static void guardarEnCSV(List<GPSData> dataList, String nombreArchivo) throws IOException {
        try (PrintWriter writer = new PrintWriter(nombreArchivo)) {
            writer.println("busId,timestamp,latitude,longitude,speed");
            for (GPSData data : dataList) {
                writer.println(data);
            }
        }
        System.out.println("Archivo '" + nombreArchivo + "' generado con éxito.");
    }

    // Para pruebas rápidas
    public static void main(String[] args) throws IOException {
        String[] buses = {"BUS001", "BUS002", "BUS003"};
        List<GPSData> datos = generarDatosSimulados(60, buses);
        guardarEnCSV(datos, "gps_data.csv");
    }
}
