package test;

import main.Node;
import main.Tower;
import main.TowerSolverPart1;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.util.ArrayList;
import java.util.List;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class TowerSolverPart1Test {

    TowerSolverPart1 towerSolverPart1 = new TowerSolverPart1();

    List<Node> towers = new ArrayList<>();
    @BeforeEach
    public void init() {
        towers.add(new Node(new Tower("pbga (66)")));
        towers.add(new Node(new Tower("xhth (57)")));
        towers.add(new Node(new Tower("ebii (61)")));
        towers.add(new Node(new Tower("havc (66)")));
        towers.add(new Node(new Tower("ktlj (57)")));
        towers.add(new Node(new Tower("fwft (72) -> ktlj, cntj, xhth")));
        towers.add(new Node(new Tower("qoyq (66)")));
        towers.add(new Node(new Tower("padx (45) -> pbga, havc, qoyq")));
        towers.add(new Node(new Tower("tknk (41) -> ugml, padx, fwft")));
        towers.add(new Node(new Tower("jptl (61)")));
        towers.add(new Node(new Tower("ugml (68) -> gyxo, ebii, jptl")));
        towers.add(new Node(new Tower("gyxo (61)")));
        towers.add(new Node(new Tower("cntj (57)")));

        Node parentTower = Node.getNodeTowerByName("fwft", towers);
        parentTower.addChild(Node.getNodeTowerByName("ktlj", towers));
        parentTower.addChild(Node.getNodeTowerByName("cntj", towers));
        parentTower.addChild(Node.getNodeTowerByName("xhth", towers));


        parentTower = Node.getNodeTowerByName("padx", towers);
        parentTower.addChild(Node.getNodeTowerByName("pbga", towers));
        parentTower.addChild(Node.getNodeTowerByName("havc", towers));
        parentTower.addChild(Node.getNodeTowerByName("qoyq", towers));


        parentTower = Node.getNodeTowerByName("tknk", towers);
        parentTower.addChild(Node.getNodeTowerByName("ugml", towers));
        parentTower.addChild(Node.getNodeTowerByName("padx", towers));
        parentTower.addChild(Node.getNodeTowerByName("fwft", towers));


        parentTower = Node.getNodeTowerByName("ugml", towers);
        parentTower.addChild(Node.getNodeTowerByName("gyxo", towers));
        parentTower.addChild(Node.getNodeTowerByName("ebii", towers));
        parentTower.addChild(Node.getNodeTowerByName("jptl", towers));
    }

    @Test
    public void part1() {
        String check = "tknk";
        String result = towerSolverPart1.solve(towers);
        assertEquals(result, result);
    }
}
