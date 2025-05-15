public class GPSValidar {
    public static boolean isValid(GPSData data) {
        if (data == null) return false;

        // Coordenadas válidas
        if (data.latitude < -90 || data.latitude > 90) return false;
        if (data.longitude < -180 || data.longitude > 180) return false;

        // Velocidad razonable (0 - 120 km/h)
        if (data.speed < 0 || data.speed > 120) return false;

        // Timestamp no nulo ni vacío
        if (data.timestamp == null || data.timestamp.isEmpty()) return false;

        return true;
    }
}
