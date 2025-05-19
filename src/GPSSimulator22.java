import clases.GPSData;

import java.io.FileWriter;
import java.io.IOException;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;

public class GPSSimulator22 {
    public static void main(String[] args) {
        Paradas[] paradas = {
                new Paradas("Plaza de la Gavidia", 37.3938, -5.9952),
                new Paradas("San Juan de Ribera", 37.3963, -5.9919),
                new Paradas("Doctor Jiménez Díaz", 37.3987, -5.9893),
                new Paradas("Ronda de Pío XII (Macarena)", 37.4031, -5.9810),
                new Paradas("Ronda de Pío XII", 37.4044, -5.9788),
                new Paradas("Ronda Historiador Díez Canseco", 37.4057, -5.9766),
                new Paradas("Av. Canal Sur", 37.4070, -5.9744),
                new Paradas("Facultad Derecho", 37.4083, -5.9722),
                new Paradas("Cervezas", 37.4096, -5.9700),
                new Paradas("Polígono San Pablo", 37.4109, -5.9678)
        };

        DateTimeFormatter formatter = DateTimeFormatter.ISO_LOCAL_DATE_TIME;
        LocalDateTime fechaInicio = LocalDateTime.of(2025, 5, 15, 9, 0); // 9:00 am

        try (FileWriter writer = new FileWriter("gps_data_bus22.csv")) {
            writer.write("busId,timestamp,latitud,longitud,velocidad\n");

            int totalMinutes = 60;
            int paradaActual = 0;

            for (int i = 0; i < totalMinutes; i++) {
                Paradas parada = paradas[paradaActual];
                double velocidad = (Math.random() < 0.2) ? 0 : 20 + Math.random() * 20;
                String timestamp = fechaInicio.plusMinutes(i).format(formatter);
                GPSData data = new GPSData("BUS22", timestamp, parada.latitude, parada.longitude, velocidad);
                writer.write(data.toCSV() + "\n");

                if ((i + 1) % 6 == 0 && paradaActual < paradas.length - 1) {
                    paradaActual++;
                }
            }

            System.out.println("Archivo gps_data_bus22.csv generado correctamente.");

        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
