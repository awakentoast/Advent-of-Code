package main;

import java.util.ArrayList;
import java.util.List;

public class Packet2 {
    Packet1 packet1 = new Packet1();

    //unoptimzed
//    public int solve(List<Layer> layers) {
//        int picoseconds = 0;
//
//        while (true) {
//            picoseconds++;
//            List<Layer> testLayers = copyLayers(layers);
//
//            for (int i = 0; i < picoseconds; i++) {
//                packet1.takeStep(testLayers);
//            }
//
//            if (isNotCaught(testLayers)) {
//                return picoseconds;
//            }
//        }
//    }

    public int solve(List<Layer> layers) {
        int picoseconds = 0;

        while (true) {
            if (picoseconds % 10_000 == 0) {
                System.out.println(picoseconds);
            }
            picoseconds++;
            packet1.takeStep(layers);

            List<Layer> loopLayers = copyLayers(layers);

            if (isNotCaught(loopLayers)) {
                return picoseconds;
            }
        }
    }


    public boolean isNotCaught(List<Layer> loopLayers) {
        for (int i = 0; i < loopLayers.size(); i++) {
            Layer currentLayer = loopLayers.get(i);
            if (currentLayer.scannerLocation == 0 && currentLayer.range != 0) {
                return false;
            }
            packet1.takeStep(loopLayers);
        }

        return true;
    }

    public List<Layer> copyLayers(List<Layer> layers) {
        List<Layer> newLayers = new ArrayList<>(layers.size());
        for (Layer layer : layers) {
            newLayers.add(layer.copy());
        }
        return newLayers;
    }
}
