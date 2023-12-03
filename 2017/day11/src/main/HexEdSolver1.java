package main;

import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;

public class HexEdSolver1 {


    public int solve(String[] directions) {
        int[] coordinate = {0, 0, 0};

        for (String direction : directions) {
            coordinate = step(direction, coordinate[0], coordinate[1], coordinate[2]);
        }
        System.out.println(Arrays.toString(coordinate));

        int layerAfterVerticalAndAscending = movePointVerticalAndAscending(coordinate[0], coordinate[1]);
        int descendingLayer = movePointDescending(coordinate[0], coordinate[1], coordinate[2], layerAfterVerticalAndAscending);

        System.out.println(descendingLayer + "\n");
        return descendingLayer;
    }

    public int movePointDescending(int vertical, int ascending, int descending, int layer) {
        int stepsTillEdge;
        if (vertical >= 0) {
            if (ascending >= 0) {
                if (descending >= 0) {
                    stepsTillEdge = layer - ascending;
                } else {
                    stepsTillEdge = ascending;
                    descending *= -1;
                }
                layer += Math.max(descending - stepsTillEdge, 0);
            } else {
                if (descending >= 0) {
                    ascending *= -1;
                    stepsTillEdge = layer + 1 - (layer - ascending) - 1;
                    if (descending > stepsTillEdge) {
                        layer += descending - stepsTillEdge;
                    } else if (descending < stepsTillEdge) {
                        Map<Integer, Integer> steps = calculateLayerOfDescendingInALongLine(ascending, descending, layer, vertical);
                        layer = steps.get(descending - 1);
                    }
                } else {
                    descending *= -1;
                    layer += descending;
                }
            }
        } else {
            if (ascending >= 0) {
                if (descending >= 0) {
                    layer += descending;
                } else {
                    vertical *= -1;
                    descending *= -1;
                    stepsTillEdge = layer + 1 - (layer - ascending) - 1;
                    if (descending > stepsTillEdge) {
                        layer += descending - stepsTillEdge;
                    } else {
                        Map<Integer, Integer> steps = calculateLayerOfDescendingInALongLine(ascending, descending, layer, vertical);
                        layer = steps.get(descending - 1);
                    }
                }
            } else {
                ascending *= -1;
                if (descending >= 0) {
                    stepsTillEdge = ascending;
                } else {
                    stepsTillEdge = layer - ascending;
                }
                layer += Math.max(descending - stepsTillEdge, 0);
            }
        }

        return layer;
    }

    private Map<Integer, Integer> calculateLayerOfDescendingInALongLine(int ascending, int descending, int layer, int linesRemovedFromDescendingLine) {
        Map<Integer, Integer> layerOfSteps = new HashMap<>();

        int lengthLayer = layer + 1;
        int maxLength = ascending * 2 - linesRemovedFromDescendingLine; //distance till mirrored on the other side
        int offset = (int) (Math.ceil(maxLength / 2.0) - lengthLayer);

        int tempLayer = layer;
        for (int i = 0; i < descending / 2; i++) {
            if (i > offset && offset > 0) {
                layerOfSteps.put(i, linesRemovedFromDescendingLine);
            } else {
                layerOfSteps.put(i, layer);
            }
        }

        if (descending % 2 != 0) {
            layerOfSteps.put(descending / 2 + 1, linesRemovedFromDescendingLine);
        }

        for (int i = maxLength / 2; i < descending; i++) {
            if (i > offset && offset > 0) {
                layerOfSteps.put(i, linesRemovedFromDescendingLine);
            } else {
                layerOfSteps.put(i, tempLayer++);
            }
        }

        return layerOfSteps;
    }


    public int movePointVerticalAndAscending(int vertical, int ascending) {
        int layer = 0;
        if (vertical >= 0) {
            if (ascending > 0) {
                layer = Math.max(ascending - vertical, 0);
            } else {
                layer = ascending;
            }
        }

        if (vertical < 0) {
            vertical *= -1;
            if (ascending > 0) {
                layer = ascending;
            } else {
                layer = Math.max(ascending - vertical, 0);
            }
        }

        return Math.abs(layer);
    }


    public int[] step(String direction, int vertical, int ascending, int descending) {
        switch (direction) {
            case "n" -> {
                vertical += 1;
            }
            case "ne" -> {
                ascending += 1;
            }
            case "se" -> {
                descending += 1;
            }
            case "s" -> {
                vertical -= 1;
            }
            case "sw" -> {
                ascending -= 1;
            }
            case "nw" -> {
                descending -= 1;
            }

            default -> throw new IllegalArgumentException();
        }

        return new int[]{vertical, ascending, descending};
    }
}
