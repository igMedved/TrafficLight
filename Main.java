package hw_jw0;

public class Main {
    public static void main(String[] args) {
       UserConsole userConsole = new UserConsole();
        int redTime = userConsole.getTime("Введите время работы красного света (в минутах):");
        int yellowTime = userConsole.getTime("Введите время работы желтого света (в минутах):");
        int greenTime = userConsole.getTime("Введите время работы зеленого света (в минутах):");

        // создаем управляющий блок светофором и создаем светофор
        TrafficLightControl trafficLightControl = new TrafficLightControl();
        trafficLightControl.addTrafficLight(redTime,yellowTime,greenTime);

        trafficLightControl.start();
    }
}
