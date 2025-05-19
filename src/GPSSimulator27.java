import clases.GPSData;

import java.io.FileWriter;
import java.io.IOException;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;

public class GPSSimulator27 {
    public static void main(String[] args) {
        Paradas[] paradas = {
                new Paradas("Plaza de Armas", 37.3909, -5.9997),
                new Paradas("Torneo", 37.3930, -5.9955),
                new Paradas("San Luis", 37.3982, -5.9876),
                new Paradas("Puerta de la Macarena", 37.4005, -5.9854),
                new Paradas("Resolana", 37.4018, -5.9832),
                new Paradas("Ronda de Pío XII (Macarena)", 37.4031, -5.9810),
                new Paradas("Ronda de Pío XII", 37.4044, -5.9788),
                new Paradas("Ronda Historiador Díez Canseco", 37.4057, -5.9766),
                new Paradas("Av. Canal Sur", 37.4070, -5.9744),
                new Paradas("Facultad Derecho", 37.4083, -5.9722),
                new Paradas("Cervezas", 37.4096, -5.9700),
                new Paradas("Polígono San Pablo", 37.4109, -5.9678)
        };

        DateTimeFormatter formatter = DateTimeFormatter.ISO_LOCAL_DATE_TIME;
        LocalDateTime fechaInicio = LocalDateTime.of(2025, 5, 15, 8, 0);

        try (FileWriter writer = new FileWriter("gps_data_bus27.csv")) {
            writer.write("busId,timestamp,latitud,longitud,velocidad\n");
            int totalMinutes = 60;
            int paradaActual = 0;

            for (int i = 0; i < totalMinutes; i++) {
                Paradas parada = paradas[paradaActual];
                double velocidad = (Math.random() < 0.2) ? 0 : 20 + Math.random() * 20; // 20% chance of stop
                String timestamp = fechaInicio.plusMinutes(i).format(formatter);
                GPSData data = new GPSData("BUS27", timestamp, parada.latitude, parada.longitude, velocidad);
                writer.write(data.toCSV() + "\n");

                // Cada 5 minutos avanza a la siguiente parada (12 paradas → 60 minutos)
                if ((i + 1) % 5 == 0 && paradaActual < paradas.length - 1) {
                    paradaActual++;
                }
            }

            System.out.println("Archivo gps_data_bus27.csv generado correctamente.");

        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
