import java.util.List;
import java.util.Scanner;

public class MenuInteractivo {
    private static final Scanner scanner = new Scanner(System.in);

    public static void iniciar(List<GPSData> datos27, List<GPSData> datos22, List<GPSData> datos29) {
        while (true) {
            System.out.println("\n--- MENÚ INTERACTIVO ---");
            System.out.println("1. Ver última posición de un autobús");
            System.out.println("2. Ver trayecto completo de un autobús");
            System.out.println("3. Salir");
            System.out.print("Seleccione una opción: ");
            String opcion = scanner.nextLine();

            switch (opcion) {
                case "1":
                    consultarUltimaPosicion(datos27, datos22, datos29);
                    break;
                case "2":
                    consultarTrayecto(datos27, datos22, datos29);
                    break;
                case "3":
                    System.out.println("Saliendo del menú...");
                    return;
                default:
                    System.out.println("Opción no válida. Intente de nuevo.");
            }
        }
    }

    private static void consultarUltimaPosicion(List<GPSData> datos27, List<GPSData> datos22, List<GPSData> datos29) {
        String busId = solicitarBusId();
        List<GPSData> datos = obtenerDatosPorBus(busId, datos27, datos22, datos29);
        GPSExportar.exportarUltimaPosicionJSON(datos, busId);  // También genera el JSON
    }

    private static void consultarTrayecto(List<GPSData> datos27, List<GPSData> datos22, List<GPSData> datos29) {
        String busId = solicitarBusId();
        List<GPSData> datos = obtenerDatosPorBus(busId, datos27, datos22, datos29);
        GPSVisualizar.mostrarTrayecto(datos, busId);
    }

    private static String solicitarBusId() {
        System.out.print("Ingrese el ID del autobús (BUS27, BUS22, BUS29): ");
        return scanner.nextLine().toUpperCase();
    }

    private static List<GPSData> obtenerDatosPorBus(String busId, List<GPSData> datos27, List<GPSData> datos22, List<GPSData> datos29) {
        return switch (busId) {
            case "BUS27" -> datos27;
            case "BUS22" -> datos22;
            case "BUS29" -> datos29;
            default -> {
                System.out.println("Bus no reconocido.");
                yield List.of();
            }
        };
    }
}
