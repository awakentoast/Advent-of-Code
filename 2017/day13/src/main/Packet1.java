package main;

import java.util.List;

public class Packet1 {
    public int solve(List<Layer> layers) {
        int answer = 0;
        //print(layers);
        for (int i = 0; i < layers.size(); i++) {
            Layer currentLayer = layers.get(i);
            if (currentLayer.scannerLocation == 0 && currentLayer.range != 0) {
                answer += i * layers.get(i).range;
            }
            takeStep(layers);
        }

        return answer;
    }

    public void takeStep(List<Layer> layers) {
        for (Layer layer : layers) {
            layer.takeStep();
        }
    }

    public void print(List<Layer> layers) {
        for (Layer layer : layers) {
            System.out.println(layer);
        }
        System.out.println();
    }
}
