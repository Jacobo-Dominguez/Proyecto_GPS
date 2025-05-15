import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.List;
import java.util.stream.Collectors;

public class GPSFiltrar {
    public static List<GPSData> filtrarPorBus(List<GPSData> dataList, String busId) {
        return dataList.stream()
                .filter(d -> d.busId.equals(busId))
                .filter(GPSValidar::isValid)
                .collect(Collectors.toList());
    }

    public static List<GPSData> filtrarPorRangoTiempo(List<GPSData> dataList, String start, String end) {
        DateTimeFormatter formatter = DateTimeFormatter.ISO_LOCAL_DATE_TIME;
        LocalDateTime startTime = LocalDateTime.parse(start, formatter);
        LocalDateTime endTime = LocalDateTime.parse(end, formatter);

        return dataList.stream()
                .filter(d -> {
                    LocalDateTime time = LocalDateTime.parse(d.timestamp, formatter);
                    return (time.isEqual(startTime) || time.isAfter(startTime)) &&
                            (time.isEqual(endTime) || time.isBefore(endTime));
                })
                .collect(Collectors.toList());
    }
}
