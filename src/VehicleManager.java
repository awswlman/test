import java.util.ArrayList;

public class VehicleManager {
    private ArrayList<Vehicle> vehicles = new ArrayList<>();



    public int getVehicleCount() {
        return vehicles.size();
    }

    public Vehicle getVehicle(int index) {
        return vehicles.get(index);
    }
    public void addVehicle(Vehicle v) {
        vehicles.add(v);
    }

    public void removeVehicle(int index) {
        vehicles.remove(index);
    }

    public void allSpeedUp(double increment) {
        for (Vehicle v : vehicles) {
            v.speedUp(increment);
        }
    }

    public void emergencyStop() {
        for (Vehicle v : vehicles) {
            v.emergencyStop();
        }
    }

    public void showAllStatus() {
        for (Vehicle v : vehicles) {
            System.out.println(v);
        }
    }

    public double getTotalDistance() {
        double total = 0.0;
        for (Vehicle v : vehicles) {
            total += v.getTotalDistance();
        }
        return total;
    }

    public double getAverageSpeed() {
        if (vehicles.isEmpty()) {
            return 0.0;
        }
        double sum = 0.0;
        for (Vehicle v : vehicles) {
            sum += v.getSpeed();
        }
        return sum / vehicles.size();
    }
}