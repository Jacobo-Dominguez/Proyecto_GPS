import java.io.FileWriter;
import java.io.IOException;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;

public class GPSSimulator29 {
    public static void main(String[] args) {
        Paradas[] paradas = {
                new Paradas("Plaza de Armas", 37.3909, -5.9997),
                new Paradas("San Bernardo", 37.3822, -5.9844),
                new Paradas("Menéndez Pelayo", 37.3796, -5.9817),
                new Paradas("Av. de Roma", 37.3771, -5.9791),
                new Paradas("Av. de la Borbolla", 37.3750, -5.9764),
                new Paradas("Av. de la Palmera", 37.3728, -5.9737),
                new Paradas("Av. República Argentina", 37.3696, -5.9700),
                new Paradas("Av. de Jerez (Blas Infante)", 37.3662, -5.9664),
                new Paradas("Av. de Jerez (Piscina)", 37.3630, -5.9629),
                new Paradas("Bermejales (Av. Jerez)", 37.3600, -5.9600)
        };

        DateTimeFormatter formatter = DateTimeFormatter.ISO_LOCAL_DATE_TIME;
        LocalDateTime fechaInicio = LocalDateTime.of(2025, 5, 15, 10, 0); // 10:00 am

        try (FileWriter writer = new FileWriter("gps_data_bus29.csv")) {
            writer.write("busId,timestamp,latitude,longitude,speed\n");

            int totalMinutes = 60;
            int paradaActual = 0;

            for (int i = 0; i < totalMinutes; i++) {
                Paradas parada = paradas[paradaActual];
                double speed = (Math.random() < 0.2) ? 0 : 20 + Math.random() * 20;
                String timestamp = fechaInicio.plusMinutes(i).format(formatter);
                GPSData data = new GPSData("BUS29", timestamp, parada.latitude, parada.longitude, speed);
                writer.write(data.toCSV() + "\n");

                if ((i + 1) % 6 == 0 && paradaActual < paradas.length - 1) {
                    paradaActual++;
                }
            }

            System.out.println("Archivo gps_data_bus29.csv generado correctamente.");

        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
