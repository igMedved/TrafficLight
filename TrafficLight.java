package hw_jw0;

public class TrafficLight {
    private final static int SIZE = 3;
    Light[] lights = new Light[SIZE];
    private Light currentLight;

    TrafficLight(int redTime, int yellowTime, int greenTime) {
        Light light = new Light("Зеленый", greenTime);
        lights[0] = light;
        light = new Light("Желтый", yellowTime);
        lights[1] = light;
        light = new Light("Красный", redTime);
        lights[2] = light;
        currentLight = lights[0];
    }

    public void setCurrentLight(Light currentLight) {
        this.currentLight = currentLight;
    }

    public Light getCurrentLight() {
        return currentLight;
    }
}
