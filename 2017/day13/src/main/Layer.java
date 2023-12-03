package main;

public class Layer {
    int depth;
    int range;
    int scannerLocation;
    boolean up;

    public Layer(int depth, int range) {
        this.depth = depth;
        this.range = range;
        this.scannerLocation = 0;
        this.up = true;
    }

    public Layer(Layer layer) {
        this.depth = layer.depth;
        this.range = layer.range;
        this.scannerLocation = layer.scannerLocation;
        this.up = layer.up;
    }

    public void takeStep() {
        if (range != 0) {
            if (up) {
                scannerLocation++;
                if (scannerLocation >= range) {
                    scannerLocation -= 2;
                    up = false;
                }
            } else {
                scannerLocation--;
                if (scannerLocation < 0) {
                    scannerLocation += 2;
                    up = true;
                }
            }
        }
    }


    public Layer copy() {
        return new Layer(this);
    }



    @Override
    public String toString() {
        return "Layer{" +
                "depth=" + depth +
                ", range=" + range +
                ", scannerLocation=" + scannerLocation +
                '}';
    }
}
