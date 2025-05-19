import ejecuciones.*;

import java.util.Scanner;

public class AppBuses {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int opcion;

        do {
            System.out.println("\n=== MENÚ PRINCIPAL ===");
            System.out.println("1. Simular datos GPS (22, 27, 29)");
            System.out.println("2. Cargar datos y contar registros");
            System.out.println("3. Filtrar datos por bus y horario");
            System.out.println("4. Calcular velocidad media y paradas");
            System.out.println("5. Visualizar recorrido de los buses");
            System.out.println("6. Exportar última posición en JSON");
            System.out.println("7. Modificar recorrido de un bus");
            System.out.println("8. Eliminar archivos CSV antiguos");
            System.out.println("0. Salir");
            System.out.print("Selecciona una opción: ");

            opcion = scanner.nextInt();
            scanner.nextLine(); // limpiar buffer

            switch (opcion) {
                case 1:
                    GPSSimulator22.main(null);
                    GPSSimulator27.main(null);
                    GPSSimulator29.main(null);
                    break;
                case 2:
                    MainData.main(null);
                    break;
                case 3:
                    MainFiltro.main(null);
                    break;
                case 4:
                    MainAnalisis.main(null);
                    break;
                case 5:
                    MainVisualizar.main(null);
                    break;
                case 6:
                    MainExportar.main(null);
                    break;
                case 7:
                    MainModificar.main(null);
                    break;
                case 8:
                    MainEliminar.main(null);
                    break;
                case 0:
                    System.out.println("¡Hasta luego!");
                    break;
                default:
                    System.out.println("Opción inválida. Intenta de nuevo.");
            }

        } while (opcion != 0);

        scanner.close();
    }
}
