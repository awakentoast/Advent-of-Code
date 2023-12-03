package main;

import java.util.ArrayList;
import java.util.List;
import java.util.Objects;
import java.util.Optional;


public class Node {
    private final List<Node> children = new ArrayList<>();
    private Node parent = null;
    private Tower tower = null;

    public Node(Tower tower) {
        this.tower = tower;
    }

    public Tower getTower() {
        return this.tower;
    }

    public Node getParent() {
        return parent;
    }

    public static Node getNodeTowerByName(String name, List<Node> towers) {
        return towers.stream()
                .filter(tower -> Objects.equals(tower.getTower().getName(), name))
                .toList().get(0);
    }

    public void setParent(Node parentNode, Node childNode) {
        childNode.parent = parentNode;
    }

    public boolean isRoot() {
        return this.parent == null;
    }

    public List<Node> getChildren() {
        return children;
    }

    public void addChild(Node childNode) {
        childNode.setParent(this, childNode);
        this.children.add(childNode);
    }

    public static Optional<Node> getRoot(List<Node> nodes) {
        for (Node node : nodes) {
            if (node.isRoot()) {
                return Optional.of(node);
            }
        }

        return Optional.empty();
    }

    @Override
    public String toString() {
        return tower.getName();
    }
}
