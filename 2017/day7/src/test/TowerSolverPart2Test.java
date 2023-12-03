package test;

import main.Node;
import main.Tower;
import main.TowerSolverPart2;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.util.ArrayList;
import java.util.List;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class TowerSolverPart2Test {

    TowerSolverPart2 towerSolverPart2 = new TowerSolverPart2();

    List<Node> towers = new ArrayList<>();
    Node startNode;
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

        startNode = Node.getNodeTowerByName("tknk", towers);
    }

    @Test
    public void part2() {
        int result = 60;
        assertEquals(result, towerSolverPart2.solve(towers));
    }


    @Test
    public void getWeightsChilds() {
        List<Integer> result = List.of(251,243,243);
        assertEquals(result, towerSolverPart2.getWeightsChilds(startNode));
    }

    @Test
    public void hasWrongChild() {
        boolean result = true;
        assertEquals(result, towerSolverPart2.hasWrongChild(startNode));

        result = false;
        Node node = Node.getNodeTowerByName("padx", towers);
        assertEquals(result, towerSolverPart2.hasWrongChild(node));
    }


    @Test
    public void getWrongNode() {
        List<Node> node = List.of(Node.getNodeTowerByName("tknk", towers));
        List<Node> wrongNodes = towerSolverPart2.getWrongNode(startNode, new ArrayList<>());
        System.out.println(wrongNodes);
        assertEquals(node, wrongNodes);
    }


    @Test
    public void getSumOfChildren() {
        int result = 61 + 61 + 61 + 68;
        Node testNode = Node.getNodeTowerByName("ugml", towers);
        assertEquals(result, towerSolverPart2.getSumOfChild(testNode, 68));

        result = 61;
        testNode = Node.getNodeTowerByName("gyxo", towers);
        assertEquals(result, towerSolverPart2.getSumOfChild(testNode, 61));

        result = 778;
        testNode = Node.getNodeTowerByName("tknk", towers);
        assertEquals(result, towerSolverPart2.getSumOfChild(testNode, 41));
    }


    @Test
    public void isWeightGood() {
        boolean result = true;
        int[] weights = {61, 61, 61};
        assertEquals(result, towerSolverPart2.areAllWeightsTheSame(weights));

        result = false;
        weights = new int[]{0, 61, 61};
        assertEquals(result, towerSolverPart2.areAllWeightsTheSame(weights));
    }
}
