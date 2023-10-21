package com.flameshine.nebula.structures;

import java.util.Map;
import java.util.List;
import java.util.HashMap;
import java.util.ArrayList;
import java.util.Objects;

public class Graph<T> {

    private final Map<Vertex<T>, List<Vertex<T>>> adjacencyMatrix;

    public Graph() {
        this.adjacencyMatrix = new HashMap<>();
    }

    /**
     * Adds a new vertex to the graph with the specified data.
     *
     * 1. Check if the data to add isn't null. Throw NPE if it isn't.
     * 2. Add a new entry to the adjacency matrix map.
     *
     * Runtime complexity - O(n), which basically corresponds to the Map's putIfAbsent method complexity.
     */
    public void addVertex(T data) {

        if (data == null) {
            throw new NullPointerException();
        }

        adjacencyMatrix.putIfAbsent(
            new Vertex<>(data),
            new ArrayList<>()
        );
    }

    /**
     * Removes a vertex with the specified data from the graph.
     *
     * 1. Check if the data is null. If so, throw an NPE.
     * 2. Remove all edges with the graph.
     * 3. Remove the graph itself.
     *
     * Runtime complexity - O(n).
     */
    public void removeVertex(T data) {

        if (data == null) {
            throw new NullPointerException();
        }

        var key = new Vertex<>(data);

        for (var connections : adjacencyMatrix.values()) {
            connections.remove(key);
        }

        adjacencyMatrix.remove(key);
    }

    /**
     * Adds an edge between particular vertexes.
     *
     * 1. Verify that vertexes passed aren't null.
     * 2. Verify that the vertexes exist in the adjacency matrix.
     * 3. Retrieve the vertexes and link them if they aren't linked already.
     *
     * Runtime complexity - O(n*m), where n is corresponds to the Map's containsKey and m to the List's contains method.
     */
    public void addEdge(T first, T second) {

        if (first == null || second == null) {
            throw new NullPointerException();
        }

        var firstKey = new Vertex<>(first);
        var secondKey = new Vertex<>(second);

        if (!(adjacencyMatrix.containsKey(firstKey) && adjacencyMatrix.containsKey(secondKey))) {
            throw new IllegalArgumentException();
        }

        var firstConnections = adjacencyMatrix.get(firstKey);
        var secondConnections = adjacencyMatrix.get(secondKey);

        if (!(firstConnections.contains(secondKey) && secondConnections.contains(firstKey))) {
            firstConnections.add(secondKey);
            secondConnections.add(firstKey);
        }
    }

    /**
     * Removes an edge between particular vertexes.
     *
     * 1. Verify that vertexes passed aren't null.
     * 2. Verify that the vertexes exist in the adjacency matrix.
     * 3. Unlink the vertexes if they exist.
     *
     * Runtime complexity - O(n*m), where n is corresponds to the Map's containsKey and m to the List's contains method.
     */
    public void removeEdge(T first, T second) {

        if (first == null || second == null) {
            throw new NullPointerException();
        }

        var firstKey = new Vertex<>(first);
        var secondKey = new Vertex<>(second);

        if (!(adjacencyMatrix.containsKey(firstKey) && adjacencyMatrix.containsKey(secondKey))) {
            throw new IllegalArgumentException();
        }

        var firstConnections = adjacencyMatrix.get(firstKey);
        var secondConnections = adjacencyMatrix.get(secondKey);

        if (firstConnections.contains(secondKey) && secondConnections.contains(firstKey)) {
            firstConnections.remove(secondKey);
            secondConnections.remove(firstKey);
        }
    }

    /**
     * Specifies whether this graph is null or not.
     * Note: a graph known as a null graph if there are no edges in the graph.
     *
     * 1. If the size of the adjacency matrix is zero, we can count this graph as a null graph.
     *
     * Runtime complexity - O(1).
     *
     * @return True if the graph is null, false otherwise.
     */
    public boolean isNull() {
        return adjacencyMatrix.isEmpty();
    }

    /**
     * Specifies whether this graph is trivial or not.
     * Note: a graph known as a trivial graph is there is only a single vertex.
     *
     * 1. If the size of the adjacency matrix is one, we can count this graph as a trivial one.
     *
     * Runtime complexity - O(1).
     *
     * @return True is the graph is trivial, false otherwise.
     */
    public boolean isTrivial() {
        return adjacencyMatrix.size() == 1;
    }

    @Override
    public String toString() {

        var builder = new StringBuilder();
        var counter = 0;

        for (var entry : adjacencyMatrix.entrySet()) {

            builder.append(entry.getKey())
                .append(" -> ")
                .append(entry.getValue());

            if (counter != adjacencyMatrix.size() - 1) {
                builder.append("\n");
            }

            ++counter;
        }

        return builder.toString();
    }

    public static class Vertex<T> {

        private final T data;

        public Vertex(T data) {
            this.data = data;
        }

        @Override
        public boolean equals(Object o) {

            if (this == o) {
                return true;
            }

            if (!(o instanceof Vertex<?> that)) {
                return false;
            }

            return Objects.equals(data, that.data);
        }

        @Override
        public int hashCode() {
            return Objects.hash(data);
        }

        @Override
        public String toString() {
            return data.toString();
        }
    }
}