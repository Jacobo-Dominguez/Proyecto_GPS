import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;

public class GPSCargar {
    public static ArrayList<GPSData> loadFromCSV(String filename) {
        ArrayList<GPSData> dataList = new ArrayList<>();

        try (BufferedReader reader = new BufferedReader(new FileReader(filename))) {
            String line;
            reader.readLine(); // Saltar cabecera

            while ((line = reader.readLine()) != null) {
                String[] parts = line.split(",");

                String busId = parts[0];
                String timestamp = parts[1];
                double latitude = Double.parseDouble(parts[2]);
                double longitude = Double.parseDouble(parts[3]);
                double speed = Double.parseDouble(parts[4]);

                GPSData data = new GPSData(busId, timestamp, latitude, longitude, speed);
                dataList.add(data);
            }

        } catch (IOException e) {
            e.printStackTrace();
        }

        return dataList;
    }
}
