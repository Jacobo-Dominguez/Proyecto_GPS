import java.io.*;
import java.text.SimpleDateFormat;
import java.util.*;

public class GPSDataSimulator {

    public static void main(String[] args) throws IOException {
        List<GPSData> dataList = new ArrayList<>();
        String[] busIds = {"BUS001", "BUS002", "BUS003"};
        Random rand = new Random();

        // Punto de partida inicial (ejemplo en Sevilla)
        double baseLat = 37.3886;
        double baseLong = -5.9823;

        // Timestamp inicial
        Calendar calendar = Calendar.getInstance();
        SimpleDateFormat isoFormat = new SimpleDateFormat("yyyy-MM-dd'T'HH:mm:ss");

        for (int minute = 0; minute < 60; minute++) {
            for (String busId : busIds) {
                calendar.add(Calendar.MINUTE, 1);
                String timestamp = isoFormat.format(calendar.getTime());

                // Simular desplazamiento
                double latitude = baseLat + (rand.nextDouble() - 0.5) / 100;
                double longitude = baseLong + (rand.nextDouble() - 0.5) / 100;
                double speed = 20 + rand.nextDouble() * 30; // entre 20 y 50 km/h

                GPSData data = new GPSData(busId, timestamp, latitude, longitude, speed);
                dataList.add(data);
            }
        }

        // Guardar en CSV
        try (PrintWriter writer = new PrintWriter("gps_data.csv")) {
            writer.println("busId,timestamp,latitude,longitude,speed");
            for (GPSData data : dataList) {
                writer.println(data);
            }
        }

        System.out.println("Archivo gps_data.csv generado con éxito.");
    }
}
