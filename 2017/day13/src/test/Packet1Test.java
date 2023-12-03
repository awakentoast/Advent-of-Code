package test;

import main.Layer;
import main.Packet1;
import main.Packet2;
import org.junit.jupiter.api.Test;

import java.util.ArrayList;
import java.util.List;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class Packet1Test {

    Packet1 packet1 = new Packet1();
    Packet2 packet2 = new Packet2();



    public List<Layer> getLayers() {
        List<Layer> layers = new ArrayList<>();
        layers.add(new Layer(0, 3));
        layers.add(new Layer(1, 2));
        layers.add(new Layer(2, 0));
        layers.add(new Layer(3, 0));
        layers.add(new Layer(4, 4));
        layers.add(new Layer(5, 0));
        layers.add(new Layer(6, 4));

        return layers;
    }

    @Test
    public void part1() {
        int result = 24;
        assertEquals(result, packet1.solve(getLayers()));
    }


    @Test
    public void part2() {
        int result = 10;
        assertEquals(result, packet2.solve(getLayers()));
    }
}
