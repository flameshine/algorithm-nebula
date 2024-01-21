package com.flameshine.nebula.problems.leetcode.learn.queue_stack;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * №133 Clone Graph
 *
 * Given a reference of a node in a connected undirected graph.
 * Return a deep copy (clone) of the graph.
 * Each node in the graph contains a value (int) and a list (List[Node]) of its neighbors.
 */
public class CloneGraph {

    public static void main(String... args) {

        var node1 = new Node(1);
        var node2 = new Node(2);
        var node3 = new Node(3);

        node1.neighbors = List.of(node2);
        node2.neighbors = List.of(node3);

        System.out.println(
            cloneGraph(node1)
        );
    }

    private static Node cloneGraph(Node node) {
        if (node == null) {
            return null;
        }
        Map<Integer, Node> visited = new HashMap<>();
        return cloneGraphHelper(node, visited);
    }

    private static Node cloneGraphHelper(Node node, Map<Integer, Node> visited) {

        List<Node> clonedNeighbors = new ArrayList<>();

        var clonedNode = new Node(node.val);

        visited.put(clonedNode.val, clonedNode);

        for (var oldNeighbor : node.neighbors) {
            if (!visited.containsKey(oldNeighbor.val)) {
                clonedNeighbors.add(
                    cloneGraphHelper(oldNeighbor, visited)
                );
            } else {
                clonedNeighbors.add(
                    visited.get(oldNeighbor.val)
                );
            }
        }

        clonedNode.neighbors = clonedNeighbors;

        return clonedNode;
    }

    private static class Node {

        private final int val;

        private List<Node> neighbors;

        public Node(int val) {
            this.val = val;
            this.neighbors = new ArrayList<>();
        }

        @Override
        public String toString() {
            return "Node{" + "val=" + val + ", neighbors=" + neighbors + '}';
        }
    }
}