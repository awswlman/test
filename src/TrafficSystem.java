import java.util.Scanner;

public class TrafficSystem {
    private static VehicleManager manager = new VehicleManager();
    private static Scanner scanner = new Scanner(System.in);

    public static void main(String[] args) {
        while (true) {
            printMainMenu();
            int choice = getIntInput("请选择操作：", 1, 5);

            switch (choice) {
                case 1 -> addVehicle();
                case 2 -> showAllStatus();
                case 3 -> batchAccelerate();
                case 4 -> operateSingleVehicle();
                case 5 -> {
                    System.out.println("感谢使用，再见！");
                    System.exit(0);
                }
            }
        }
    }

    private static void printMainMenu() {
        System.out.println("\n=== 交通管理系统 ===");
        System.out.println("1. 添加车辆");
        System.out.println("2. 显示所有状态");
        System.out.println("3. 批量加速");
        System.out.println("4. 操作单个车辆");
        System.out.println("5. 退出");
    }

    private static void addVehicle() {
        System.out.println("\n--- 添加新车辆 ---");
        double consumption = getDoubleInput("请输入车辆油耗（升/公里）：", 0.01, 10.0);
        manager.addVehicle(new Vehicle(consumption));
        System.out.println("车辆添加成功！");
    }

    private static void showAllStatus() {
        System.out.println("\n--- 所有车辆状态 ---");
        if (manager.getVehicleCount() == 0) {
            System.out.println("当前没有车辆");
            return;
        }
        manager.showAllStatus();
    }

    private static void batchAccelerate() {
        System.out.println("\n--- 批量加速 ---");
        if (manager.getVehicleCount() == 0) {
            System.out.println("当前没有可操作的车辆");
            return;
        }
        double increment = getDoubleInput("请输入加速量（km/h）：", 1, 200);
        manager.allSpeedUp(increment);
        System.out.println("所有车辆已加速！");
    }

    private static void operateSingleVehicle() {
        if (manager.getVehicleCount() == 0) {
            System.out.println("当前没有可操作的车辆");
            return;
        }

        System.out.println("\n--- 车辆列表 ---");
        manager.showAllStatus();

        int index = getIntInput("请选择要操作的车辆编号：", 1, manager.getVehicleCount()) - 1;
        Vehicle vehicle = manager.getVehicle(index);

        while (true) {
            printVehicleMenu(vehicle);
            int choice = getIntInput("请选择操作：", 1, 6);

            switch (choice) {
                case 1 -> showVehicleStatus(vehicle);
                case 2 -> accelerateVehicle(vehicle);
                case 3 -> decelerateVehicle(vehicle);
                case 4 -> moveVehicle(vehicle);
                case 5 -> emergencyStop(vehicle);
                case 6 -> { return; }
            }
        }
    }

    private static void printVehicleMenu(Vehicle vehicle) {
        System.out.println("\n--- 车辆操作 ---");
        System.out.println("当前选择车辆：");
        System.out.println(vehicle);
        System.out.println("1. 显示状态");
        System.out.println("2. 加速");
        System.out.println("3. 减速");
        System.out.println("4. 移动");
        System.out.println("5. 急停");
        System.out.println("6. 返回上级");
    }

    private static void showVehicleStatus(Vehicle vehicle) {
        System.out.println("\n--- 车辆状态 ---");
        System.out.println(vehicle);
    }

    private static void accelerateVehicle(Vehicle vehicle) {
        double increment = getDoubleInput("请输入加速量（km/h）：", 1, 200);
        vehicle.speedUp(increment);
        System.out.println("加速成功！当前速度：" + vehicle.getSpeed() + " km/h");
    }

    private static void decelerateVehicle(Vehicle vehicle) {
        double decrement = getDoubleInput("请输入减速量（km/h）：", 1, 200);
        vehicle.speedDown(decrement);
        System.out.println("减速成功！当前速度：" + vehicle.getSpeed() + " km/h");
    }

    private static void moveVehicle(Vehicle vehicle) {
        double hours = getDoubleInput("请输入移动时间（小时）：", 0.1, 24);
        vehicle.move(hours);
    }

    private static void emergencyStop(Vehicle vehicle) {
        vehicle.emergencyStop();
        System.out.println("急停成功！速度已归零");
    }

    // 输入验证方法
    private static int getIntInput(String prompt, int min, int max) {
        while (true) {
            try {
                System.out.print(prompt);
                int input = Integer.parseInt(scanner.nextLine());
                if (input >= min && input <= max) return input;
                System.out.printf("输入无效，请输入 %d-%d 之间的整数\n", min, max);
            } catch (NumberFormatException e) {
                System.out.println("请输入有效的整数！");
            }
        }
    }

    private static double getDoubleInput(String prompt, double min, double max) {
        while (true) {
            try {
                System.out.print(prompt);
                double input = Double.parseDouble(scanner.nextLine());
                if (input >= min && input <= max) return input;
                System.out.printf("输入无效，请输入 %.2f-%.2f 之间的数值\n", min, max);
            } catch (NumberFormatException e) {
                System.out.println("请输入有效的数字！");
            }
        }
    }
}


