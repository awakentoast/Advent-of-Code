package main;

import java.util.*;

public class PlumberSolver2 {

    PlumberSolver1 plumberSolver1 = new PlumberSolver1();

    public int solve(Map<Integer, Set<Integer>> programs) {
        List<Set<Integer>> differentGroups = new ArrayList<>();
        Map<Integer, Set<Integer>> linkedConnectionsMap = plumberSolver1.makeAllConnections(programs);

        for (Set<Integer> connections : linkedConnectionsMap.values()) {
            if (!inList(differentGroups, connections)) {
                differentGroups.add(connections);
            }
        }

        return differentGroups.size();
    }

    public boolean inList(List<Set<Integer>> differentGroups, Set<Integer> values) {
        for (Set<Integer> group : differentGroups) {
            if (Objects.equals(group, values)) {
                return true;
            }
        }

        return false;
    }
}
