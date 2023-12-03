package main;

import java.util.*;

public class TowerSolverPart2 {

    public int solve(List<Node> nodes) {
        Optional<Node> startNodeOptional = Node.getRoot(nodes);
        if (startNodeOptional.isEmpty()) {
            return -1;
        }

        Node startNode = startNodeOptional.get();

        List<Node> wrongNodes = getWrongNode(startNode, new ArrayList<>());

        Node wrongNode = wrongNodes.get(wrongNodes.size() - 1);

        List<Integer> weights = getWeightsChilds(wrongNode);

        int max = weights.stream().max(Integer::compareTo).get();
        int min = weights.stream().min(Integer::compareTo).get();

        int wrongChildIndex = weights.indexOf(max);

        int wrongChildValue = wrongNode.getChildren().get(wrongChildIndex).getTower().getWeight();
        int diff = max - min;

        return wrongChildValue - diff;
    }


    public List<Integer> getWeightsChilds(Node parentNode) {
        List<Integer> weights = new ArrayList<>(parentNode.getChildren().size());

        for (Node child : parentNode.getChildren()) {
            weights.add(getSumOfChild(child, child.getTower().getWeight()));
        }

        return weights;
    }


    public List<Node> getWrongNode(Node node, List<Node> wrongNodes) {
        int[] weightsChildren = getWeightsChilds(node).stream().mapToInt(Integer::intValue).toArray();
        if (hasWrongChild(node) && !areAllWeightsTheSame(weightsChildren)) {
            wrongNodes.add(node);
        }

        for (Node child : node.getChildren()) {
            getWrongNode(child, wrongNodes);
        }
        return wrongNodes;
    }

    public boolean hasWrongChild(Node node) {
        if (node.getChildren().isEmpty()) {
            return false;
        }
        int[] weights = new int[node.getChildren().size()];

        for (int index = 0; index < weights.length; index++) {
            weights[index] = getSumOfChild(node.getChildren().get(index), 0);
        }

        return !areAllWeightsTheSame(weights);
    }




    public int getSumOfChild(Node node, int sum) {
        for (Node child : node.getChildren()) {
            sum += child.getTower().getWeight();
            sum = getSumOfChild(child, sum);
        }
        return sum;
    }


    public boolean areAllWeightsTheSame(int[] weights) {
        HashSet<Integer> set = new HashSet<>();

        for (int weight : weights) {
            set.add(weight);
        }

        return set.size() == 1;
    }
}
