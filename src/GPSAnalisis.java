import java.util.List;

public class GPSAnalisis {
    public static double calcularVelocidadMedia(List<GPSData> dataList) {
        if (dataList.isEmpty()) return 0.0;

        double suma = 0.0;
        int contador = 0;

        for (GPSData data : dataList) {
            if (GPSValidar.isValid(data)) {
                suma += data.speed;
                contador++;
            }
        }

        return contador == 0 ? 0.0 : suma / contador;
    }

    public static int contarParadas(List<GPSData> dataList) {
        int paradas = 0;

        for (GPSData data : dataList) {
            if (GPSValidar.isValid(data) && data.speed == 0.0) {
                paradas++;
            }
        }

        return paradas;
    }


}
