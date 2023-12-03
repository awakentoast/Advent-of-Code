package main;

import java.util.*;

public class TowerSolverPart1 {

    public String solve(List<Node> towerNodes) {
        Optional<Node> root = Node.getRoot(towerNodes);
        if (root.isEmpty()) {
            return "you done goofed";
        }

        return root.get().getTower().getName();
    }
}
