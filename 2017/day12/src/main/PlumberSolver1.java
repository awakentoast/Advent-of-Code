package main;

import java.util.*;

public class PlumberSolver1 {
    public int solve(Map<Integer, Set<Integer>> programs) {
        Map<Integer, Set<Integer>> linkedConnectionsMap = makeAllConnections(programs);
        return linkedConnectionsMap.get(0).size();
    }

    public Map<Integer, Set<Integer>> makeAllConnections(Map<Integer, Set<Integer>> programs) {
        Map<Integer, Set<Integer>> allConnectionsMap = new HashMap<>();

        for (Map.Entry<Integer, Set<Integer>> program : programs.entrySet()) {
            List<Integer> alreadyLinked = new ArrayList<>(List.of(program.getKey()));
            Set<Integer> connections = addLinkOfConnection(programs, alreadyLinked, program.getValue());
            allConnectionsMap.put(program.getKey(), connections);
        }

        return allConnectionsMap;
    }

    public Set<Integer> addLinkOfConnection(Map<Integer, Set<Integer>> programs, List<Integer> alreadyLinked, Set<Integer> connections) {
        Set<Integer> connectionsCopy = new HashSet<>(connections);

        for (int connection : connectionsCopy) {
            if (!alreadyLinked.contains(connection)) {
                alreadyLinked.add(connection);
                connections.addAll(addLinkOfConnection(programs, alreadyLinked, programs.get(connection)));
            }
        }

        return connections;
    }
}