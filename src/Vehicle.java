public class Vehicle {
    private int speed;
    private String size;
    private double x, y;
    private double fuel = 100.0;
    private final double fuelConsumption; // 每公里油耗
    private double totalDistance; // 新增总行驶距离属性

    public Vehicle(double fuelConsumption) {
        this.fuelConsumption = fuelConsumption;
    }

    // 新增方法：急停（用于兼容 VehicleManager）
    public void emergencyStop() {
        this.speed = 0;
    }

    // 修改加速方法：支持任意增量（原 speedUp() 方法需要删除）
    public void speedUp(double increment) {
        this.speed += increment;
        if (this.speed < 0) this.speed = 0; // 防止负数速度
    }

    // 新增减速方法（可选，与 VehicleManager 无关）
    public void speedDown(double decrement) {
        this.speed -= decrement;
        if (this.speed < 0) this.speed = 0;
    }

    public void move(double hours) {
        if (fuel <= 0) {
            System.out.println("没有燃料了");
            return;
        }

        double maxDistance = fuel / fuelConsumption; // 当前油量能跑的最远距离
        double desiredDistance = speed * hours;
        double actualDistance = Math.min(desiredDistance, maxDistance);

        if (actualDistance > 0) {
            x += actualDistance; // 沿 x 轴移动
            fuel -= actualDistance * fuelConsumption;
            totalDistance += actualDistance; // 累加总行驶距离
            System.out.printf(
                    "移动了 %.2f 公里（计划 %.2f 公里），当前位置 (%.2f, %.2f)，燃料剩余 %.2f\n",
                    actualDistance, desiredDistance, x, y, fuel
            );
        } else {
            System.out.println("燃料不足，无法移动");
        }
    }

    // 新增方法：获取总行驶距离（用于 VehicleManager）
    public double getTotalDistance() {
        return totalDistance;
    }

    // 重写 toString 方法（用于 showAllStatus）
    @Override
    public String toString() {
        return String.format(
                "[Vehicle] 速度: %d, 位置: (%.2f, %.2f), 燃料: %.2f, 总行驶距离: %.2f",
                speed, x, y, fuel, totalDistance
        );
    }

    //--- Getter/Setter 保持与原始代码兼容 ---
    public void setSpeed(int speed) {
        this.speed = speed;
    }
    public void setSize(String size) {
        this.size = size;
    }
    public int getSpeed() {
        return speed;
    }
    public String getSize() {
        return size;
    }
}