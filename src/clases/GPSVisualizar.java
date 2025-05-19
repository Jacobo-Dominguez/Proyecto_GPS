package clases;

import java.util.List;

public class GPSVisualizar {
    public static void mostrarTrayecto(List<GPSData> dataList, String busId) {
        System.out.println("\nTrayecto del autobús " + busId + ":");

        // Filtrar datos válidos y del bus específico, y ordenar por timestamp
        dataList.stream()
                .filter(d -> d.busId.equals(busId) && GPSValidar.isValid(d))
                .sorted((d1, d2) -> d1.timestamp.compareTo(d2.timestamp))
                .forEach(d -> System.out.printf("  %s -> Lat: %.5f, Lon: %.5f, Velocidad: %.2f km/h%n",
                        d.timestamp, d.latitude, d.longitude, d.speed));
    }
}
