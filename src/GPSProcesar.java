import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.List;

public class GPSProcesar {

    // Formato para fechas
    private static final SimpleDateFormat isoFormat = new SimpleDateFormat("yyyy-MM-dd'T'HH:mm:ss");

    // Leer datos desde un archivo CSV con validación
    public static List<GPSData> cargarDesdeCSV(String rutaArchivo) throws IOException{
        List<GPSData> datos = new ArrayList<>();

        try (BufferedReader br = new BufferedReader(new FileReader(rutaArchivo))) {
            String linea = br.readLine();
            while (linea != null) {
                String[] partes = linea.split(",");
                if(partes.length!=5){
                    continue;
                }
                try{
                    String busId = partes[0];
                    String timestamp = partes[1];
                    double lat = Double.parseDouble(partes[2]);
                    double lon = Double.parseDouble(partes[3]);
                    double velocidad = Double.parseDouble(partes[4]);

                    if(lat<-90 || lat>90 || lon<-180 || lon>180 || velocidad<0){
                        continue;
                    }
                    isoFormat.parse(timestamp);
                    datos.add(new GPSData(busId, timestamp, lat, lon, velocidad));
                }catch (NumberFormatException | ParseException e){

                }
            }
        }
        return datos;
    }

    /* Filtrar datos por ID de autobus (he usado .stream() que use en la universiadad para temas de filtrado
    ya que en el momento en que hago esta entrega aun no nos han enseñado a usarlos
    */
    public static List<GPSData> filtrarPorBus(List<GPSData> datos, String busId){
        return datos.stream()
                .filter(d -> d.getBusId().equals(busId))
                .toList();
    }

    // Filtrar por rango de tiempo
    public static List<GPSData> filtrarPorTiempo(List<GPSData> datos, String tiempoInicio, String tiempoFin){
        return datos.stream()
                .filter(d -> d.getTimestamp().compareTo(tiempoInicio) >=0
                        && d.getTimestamp().compareTo(tiempoFin) <=0)
                .toList();
    }

    // Filtrar por bus + tiempo
    public static List<GPSData> filtrarPorBusYTiempo(List<GPSData> datos, String busId, String tiempoInicio, String tiempoFin) {
        return datos.stream()
                .filter(d -> d.getBusId().equals(busId)
                        && d.getTimestamp().compareTo(tiempoInicio) >= 0
                        && d.getTimestamp().compareTo(tiempoFin) <= 0)
                .toList();
    }

}
