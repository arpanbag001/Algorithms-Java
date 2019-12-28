package com.company.datastructures;

import java.util.HashMap;
import java.util.HashSet;
import java.util.LinkedList;
import java.util.Queue;

public class MyGraphUndirectedUnweighted {

    private int numberOfNodes;
    private HashMap<Integer, HashSet<Integer>> adjacentList = new HashMap<>();
    private HashSet<Edge> edgeList = new HashSet<>();
    public static final int GRAPH_TYPE_ADJACENCY_LIST = 1;
    public static final int GRAPH_TYPE_EDGE_LIST = 2;

    public void addVertex(int node) {
        adjacentList.put(node, new HashSet<>());
        numberOfNodes++;
    }

    public void addEdge(int node1, int node2) {
        //Update the adjacency list
        if (adjacentList.containsKey(node1) && adjacentList.containsKey(node2)) {
            adjacentList.get(node1).add(node2);
            adjacentList.get(node2).add(node1);
        }

        //Update the edgeList
        edgeList.add(new Edge(node1, node2));
    }

    public int getNumberOfNodes() {
        return numberOfNodes;
    }

    public void printGraph(int printGraphType) {
        if (printGraphType == GRAPH_TYPE_ADJACENCY_LIST)
            System.out.println(adjacentList.toString());
        else if (printGraphType == GRAPH_TYPE_EDGE_LIST)
            edgeList.forEach(edge -> System.out.println(edge.getEdge()));
    }


    public void traverseBreadthFirst(int rootNode) {

        //Preprocessing: Initializing datastores and adding rootnode
        Queue<Integer> breadthFirstTraversalQueue = new LinkedList<>();
        breadthFirstTraversalQueue.add(rootNode);
        HashSet<Integer> visitedNodeSet = new HashSet<>();

        traverseBreadthFirstRecursively(breadthFirstTraversalQueue, visitedNodeSet);
    }

    private void traverseBreadthFirstRecursively(Queue<Integer> breadthFirstTraversalQueue, HashSet<Integer> visitedNodeSet) {

        if (breadthFirstTraversalQueue.isEmpty())
            return;

        int currNode = breadthFirstTraversalQueue.poll();

        if (!visitedNodeSet.contains(currNode)) {
            System.out.println(currNode);
            visitedNodeSet.add(currNode);
            breadthFirstTraversalQueue.addAll(adjacentList.get(currNode));
        }

        traverseBreadthFirstRecursively(breadthFirstTraversalQueue, visitedNodeSet);
    }

    private static class Edge {
        int node1;
        int node2;

        Edge(int node1, int node2) {
            this.node1 = node1;
            this.node2 = node2;
        }

        String getEdge() {
            return (node1 + " <--> " + node2);
        }
    }
}
