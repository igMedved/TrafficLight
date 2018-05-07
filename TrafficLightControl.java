package hw_jw0;

public class TrafficLightControl {
    // реализую только один светофор, но можно организовать список светофоров
    private TrafficLight trafficLight;

    public void addTrafficLight(int redTime, int yellowTime, int greenTime) {
        trafficLight = new TrafficLight(redTime, yellowTime, greenTime);
    }

    // проверка на следующий цвет, если нет его, то ничего не передаем
    private Light chooseNextLight() {
        Light light = trafficLight.getCurrentLight();
        for (int i = 0; i < trafficLight.lights.length; i++) {
            if (light == trafficLight.lights[i]) {
                int k = i + 1;
                if (k == trafficLight.lights.length) {
                    return null;
                }
                light = trafficLight.lights[k];
                trafficLight.setCurrentLight(light);
                break;
            }
        }
        return light;
    }

    // запускаем светофор
    public void start() {
        Light light = trafficLight.getCurrentLight();
        showLight();
    }

    private void showLight() {
        Light light = trafficLight.getCurrentLight();
        System.out.println("Светофор установил " + light.name + " свет");
        int time = light.time;
        Thread thread = new Thread() {
            @Override
            public void run() {
                for (int i = 0; i < time; i++) {
                    try {
                        this.sleep(1000);
                    } catch (InterruptedException e) {
                        e.printStackTrace();
                    }
                }
                if (switchLight() != null) {
                    TrafficLightControl.this.showLight();
                }
            }
        };
        thread.start();
    }

    private Light switchLight() {
        Light light = chooseNextLight();
        if (light != null) {
            trafficLight.setCurrentLight(light);
        }
        return light;
    }


}
