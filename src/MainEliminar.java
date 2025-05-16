public class MainEliminar {
    public static void main(String[] args) {
        System.out.println("\n📦 Archivando y limpiando archivos antiguos...");
        GPSEliminar.archivarYEliminarPorContenido(".");

        System.out.println("\n✅ Proceso finalizado.");
    }
}
