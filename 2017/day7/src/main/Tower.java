package main;

import java.util.List;
import java.util.Objects;

public class Tower {
    private String name;
    private int weight;

    public Tower(String name, int weight) {
        this.name = name;
        this.weight = weight;
    }

    //for testing, straight text input
    public Tower(String unparsedString) {
        String[] inputParts = unparsedString.split(" -> ");
        String[] parent = inputParts[0].split(" ");

        this.name = parent[0];
        this.weight = Integer.parseInt(parent[1].replace("(", "").replace(")", ""));
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getWeight() {
        return weight;
    }

    public void setWeight(int weight) {
        this.weight = weight;
    }

    @Override
    public String toString() {
        return "Tower{" +
                "name='" + name + '\'' +
                ", weight=" + weight +
                '}';
    }
}
