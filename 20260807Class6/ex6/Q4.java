import java.io.*;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

class SensorData implements Serializable {
    private static final long serialVersionUID = 1L;
    private String sensorId;
    private double temperature;
    private double humidity;
    private double pressure;

    public SensorData(String sensorId, double temperature, double humidity, double pressure) {
        this.sensorId = sensorId;
        this.temperature = temperature;
        this.humidity = humidity;
        this.pressure = pressure;
    }

    public double getTemperature() {
        return temperature;
    }

    @Override
    public String toString() {
        return "SensorData{ID='" + sensorId + "', Temp=" + temperature + "°C, Humidity=" + humidity + "%, Pressure=" + pressure + "hPa}";
    }
}

class CountingFilterInputStream extends FilterInputStream {
    private int bytesRead = 0;

    protected CountingFilterInputStream(InputStream in) {
        super(in);
    }

    @Override
    public int read() throws IOException {
        int b = super.read();
        if (b != -1) bytesRead++;
        return b;
    }

    @Override
    public int read(byte[] b, int off, int len) throws IOException {
        int result = super.read(b, off, len);
        if (result != -1) bytesRead += result;
        return result;
    }

    public int getBytesRead() {
        return bytesRead;
    }
}

public class Q4 {
//NetworkSensorProcessor
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        System.out.print("Enter number of sensor packets to generate: ");
        int count = Integer.parseInt(scanner.nextLine());

        List<byte[]> packetList = new ArrayList<>();
        for (int i = 0; i < count; i++) {
            System.out.println("\nPacket " + (i + 1) + ":");
            System.out.print("Enter Sensor ID: ");
            String id = scanner.nextLine();
            System.out.print("Enter Temperature (°C): ");
            double temp = Double.parseDouble(scanner.nextLine());
            System.out.print("Enter Humidity (%): ");
            double hum = Double.parseDouble(scanner.nextLine());
            System.out.print("Enter Pressure (hPa): ");
            double pres = Double.parseDouble(scanner.nextLine());

            SensorData data = new SensorData(id, temp, hum, pres);
            try (ByteArrayOutputStream baos = new ByteArrayOutputStream();
                 ObjectOutputStream oos = new ObjectOutputStream(baos)) {
                oos.writeObject(data);
                oos.flush();
                packetList.add(baos.toByteArray());
            } catch (IOException e) {
                System.err.println("Error serializing data: " + e.getMessage());
            }
        }

        System.out.print("\nEnter temperature threshold filter (°C): ");
        double threshold = Double.parseDouble(scanner.nextLine());

        List<SensorData> filteredReadings = new ArrayList<>();

        for (byte[] packet : packetList) {
            try (ByteArrayInputStream bais = new ByteArrayInputStream(packet);
                 CountingFilterInputStream fis = new CountingFilterInputStream(bais);
                 ObjectInputStream ois = new ObjectInputStream(fis)) {

                SensorData reading = (SensorData) ois.readObject();
                if (reading.getTemperature() > threshold) {
                    filteredReadings.add(reading);
                }
            } catch (IOException | ClassNotFoundException e) {
                System.err.println("Error deserializing packet: " + e.getMessage());
            }
        }

        System.out.println("\n=== FILTERED SENSOR READINGS (Temperature > " + threshold + "°C) ===");
        for (SensorData data : filteredReadings) {
            System.out.println(data);
        }
    }
}