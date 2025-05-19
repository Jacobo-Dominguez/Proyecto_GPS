package clases;

import java.io.FileWriter;
import java.io.IOException;
import java.util.List;

public class GPSExportar {

    public static void exportarUltimaPosicionJSON(List<GPSData> dataList, String busId) {
        // Filtrar datos válidos del bus
        List<GPSData> datosBus = dataList.stream()
                .filter(d -> d.busId.equals(busId) && GPSValidar.isValid(d))
                .toList();

        if (datosBus.isEmpty()) {
            System.out.println("No hay datos válidos para el bus " + busId);
            return;
        }

        // Obtener el último registro (por timestamp)
        GPSData ultimo = datosBus.stream()
                .max((d1, d2) -> d1.timestamp.compareTo(d2.timestamp))
                .orElse(null);

        if (ultimo == null) return;

        // Crear JSON manualmente
        String json = String.format(
                "{\n  \"busId\": \"%s\",\n  \"latitude\": %.6f,\n  \"longitude\": %.6f,\n  \"timestamp\": \"%s\"\n}",
                ultimo.busId, ultimo.latitude, ultimo.longitude, ultimo.timestamp);

        // Guardar en archivo
        String nombreArchivo = busId.toLowerCase() + "_status.json";

        try (FileWriter writer = new FileWriter(nombreArchivo)) {
            writer.write(json);
            System.out.println("Archivo JSON creado: " + nombreArchivo);
        } catch (IOException e) {
            System.err.println("Error al escribir archivo JSON: " + e.getMessage());
        }
    }
}
