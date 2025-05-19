package clases;

import java.io.FileWriter;
import java.io.IOException;
import java.util.List;

public class GPSModificar {
    public static void modificarRecorrido(List<GPSData> dataList, String busId, int desdeIndex, int hastaIndex, double nuevaLat, double nuevaLon) {
        int cambios = 0;

        for (int i = 0; i < dataList.size(); i++) {
            GPSData d = dataList.get(i);
            if (d.busId.equals(busId) && i >= desdeIndex && i <= hastaIndex) {
                d.latitude = nuevaLat;
                d.longitude = nuevaLon;
                cambios++;
            }
        }

        System.out.printf("Se modificaron %d registros de %s entre posiciones %d y %d%n", cambios, busId, desdeIndex, hastaIndex);
    }

    public static void guardarCSVModificado(List<GPSData> dataList, String nuevoArchivo) {
        try (FileWriter writer = new FileWriter(nuevoArchivo)) {
            writer.write("busId,timestamp,latitude,longitude,speed\n");
            for (GPSData d : dataList) {
                writer.write(String.format("%s,%s,%.6f,%.6f,%.2f\n",
                        d.busId, d.timestamp, d.latitude, d.longitude, d.speed));
            }
            System.out.println("Datos modificados guardados en: " + nuevoArchivo);
        } catch (IOException e) {
            System.err.println("Error al guardar el archivo modificado: " + e.getMessage());
        }
    }
}
