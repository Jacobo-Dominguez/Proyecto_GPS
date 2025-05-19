package clases;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.nio.file.StandardCopyOption;
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.time.temporal.ChronoUnit;

public class GPSEliminar {
    private static final DateTimeFormatter FORMATO_ISO = DateTimeFormatter.ISO_DATE_TIME;

    public static void archivarYEliminarPorContenido(String directorioBase) {
        File carpeta = new File(directorioBase);
        if (!carpeta.exists()) {
            System.err.println("El directorio base no existe.");
            return;
        }

        File[] archivos = carpeta.listFiles((dir, name) -> name.endsWith(".csv"));
        if (archivos == null) return;

        File carpetaArchivados = new File(directorioBase + "/archivados");
        if (!carpetaArchivados.exists()) carpetaArchivados.mkdir();

        for (File archivo : archivos) {
            try {
                LocalDate fechaArchivo = extraerFechaDesdeContenido(archivo);
                if (fechaArchivo == null) continue;

                long dias = ChronoUnit.DAYS.between(fechaArchivo, LocalDate.now());

                if (dias > 7) {
                    System.out.println("Eliminando archivo antiguo: " + archivo.getName());
                    archivo.delete();
                } else {
                    Path destino = Paths.get(carpetaArchivados.getPath(), archivo.getName());
                    Files.move(archivo.toPath(), destino, StandardCopyOption.REPLACE_EXISTING);
                    System.out.println("Archivo archivado: " + archivo.getName());
                }

            } catch (Exception e) {
                System.err.println("Error al procesar archivo: " + archivo.getName() + " → " + e.getMessage());
            }
        }
    }

    private static LocalDate extraerFechaDesdeContenido(File archivo) throws IOException {
        BufferedReader br = new BufferedReader(new FileReader(archivo));
        String linea;
        String ultimaLinea = null;
        while ((linea = br.readLine()) != null) {
            if (!linea.trim().isEmpty()) {
                ultimaLinea = linea;
            }
        }
        br.close();

        if (ultimaLinea == null || ultimaLinea.startsWith("busId")) return null;

        String[] partes = ultimaLinea.split(",");
        if (partes.length < 2) return null;

        LocalDate fecha = LocalDate.parse(partes[1].substring(0, 10)); // timestamp → "2025-05-15T08:00:00"
        return fecha;
    }
}
