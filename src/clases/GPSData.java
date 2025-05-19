package clases;

public class GPSData {
    String busId;
    String timestamp;
    double latitude;
    double longitude;
    double speed;

    public GPSData(String busId, String timestamp, double latitude, double longitude, double speed) {
        this.busId = busId;
        this.timestamp = timestamp;
        this.latitude = latitude;
        this.longitude = longitude;
        this.speed = speed;
    }

    public String toCSV() {
        return busId + "," + timestamp + "," + latitude + "," + longitude + "," + speed;
    }
}
