package com.company.datastructures;

import java.util.*;

public class MyGraphUndirectedUnweighted {

    private int numberOfNodes;
    private HashMap<Integer, HashSet<Integer>> adjacentList = new HashMap<>();
    private HashSet<Edge> edgeList = new HashSet<>();
    public static final int GRAPH_TYPE_ADJACENCY_LIST = 1;
    public static final int GRAPH_TYPE_EDGE_LIST = 2;
    public static final int SEARCH_KEY_UNDEFINED = -1;
    public static final int SEARCH_RESULT_NOT_FOUND = 404;

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


    public void traverseBreadthFirst(int rootNode, int searchKey, int graphType) {

        //Preprocessing: Initializing datastores and adding rootnode
        Queue<Integer> breadthFirstTraversalQueue = new LinkedList<>();
        breadthFirstTraversalQueue.add(rootNode);
        HashSet<Integer> visitedNodeSet = new HashSet<>();

        int searchResult = traverseBreadthFirstRecursively(graphType, searchKey, breadthFirstTraversalQueue, visitedNodeSet);

        if (searchKey != SEARCH_KEY_UNDEFINED && searchResult == SEARCH_RESULT_NOT_FOUND)
            System.out.println("\n" + searchKey + " not found!");
    }

    private int traverseBreadthFirstRecursively(int graphType, int searchKey, Queue<Integer> breadthFirstTraversalQueue, HashSet<Integer> visitedNodeSet) {

        if (breadthFirstTraversalQueue.isEmpty())
            return SEARCH_RESULT_NOT_FOUND;

        int currNode = breadthFirstTraversalQueue.poll();

        if (searchKey != SEARCH_KEY_UNDEFINED && currNode == searchKey) {
            System.out.println(searchKey + " found!");
            return searchKey;
        } else {
            if (!visitedNodeSet.contains(currNode)) {
                System.out.println(currNode);
                visitedNodeSet.add(currNode);
                if (graphType == GRAPH_TYPE_ADJACENCY_LIST)
                    breadthFirstTraversalQueue.addAll(adjacentList.get(currNode));
                else if (graphType == GRAPH_TYPE_EDGE_LIST) {
                    for (Edge edge : edgeList) {
                        if (edge.node1 == currNode)
                            breadthFirstTraversalQueue.add(edge.node2);
                        else if (edge.node2 == currNode)
                            breadthFirstTraversalQueue.add(edge.node1);
                    }
                }
            }
            return traverseBreadthFirstRecursively(graphType, searchKey, breadthFirstTraversalQueue, visitedNodeSet);
        }

    }

    public void traverseDepthFirst(int rootNode, int graphType) {
        //Preprocessing: Initializing datastores
        HashSet<Integer> visitedNodeSet = new HashSet<>();

        traverseDepthFirstRecursively(rootNode, graphType, visitedNodeSet);
    }

    private void traverseDepthFirstRecursively(int currNode, int graphType, HashSet<Integer> visitedNodeSet) {

        if (!visitedNodeSet.contains(currNode)) {
            System.out.println(currNode);
            visitedNodeSet.add(currNode);
            if (graphType == GRAPH_TYPE_ADJACENCY_LIST) {
                HashSet<Integer> adjacentVertices = adjacentList.get(currNode);
                for (int adjacentVertex : adjacentVertices) {
                    traverseDepthFirstRecursively(adjacentVertex, graphType, visitedNodeSet);
                }
            } else if (graphType == GRAPH_TYPE_EDGE_LIST) {
                for (Edge edge : edgeList) {
                    if (edge.node1 == currNode)
                        traverseDepthFirstRecursively(edge.node2, graphType, visitedNodeSet);
                    else if (edge.node2 == currNode)
                        traverseDepthFirstRecursively(edge.node1, graphType, visitedNodeSet);
                }
            }
        }

    }

    public void traverseBreadthFirstIteratively(int rootNode, int graphType) {

        //Preprocessing: Initializing datastores and adding rootnode
        Queue<Integer> breadthFirstTraversalQueue = new LinkedList<>();
        breadthFirstTraversalQueue.add(rootNode);
        HashSet<Integer> visitedNodeSet = new HashSet<>();

        while (!breadthFirstTraversalQueue.isEmpty()) {
            int currNode = breadthFirstTraversalQueue.poll();
            if (!visitedNodeSet.contains(currNode)) {
                System.out.println(currNode);
                visitedNodeSet.add(currNode);
                if (graphType == GRAPH_TYPE_ADJACENCY_LIST)
                    breadthFirstTraversalQueue.addAll(adjacentList.get(currNode));
                else if (graphType == GRAPH_TYPE_EDGE_LIST) {
                    for (Edge edge : edgeList) {
                        if (edge.node1 == currNode)
                            breadthFirstTraversalQueue.add(edge.node2);
                        else if (edge.node2 == currNode)
                            breadthFirstTraversalQueue.add(edge.node1);
                    }
                }
            }
        }
    }

    public void traverseDepthFirstIteratively(int rootNode, int graphType) {

        //Preprocessing: Initializing datastores and adding rootnode
        Stack<Integer> depthFirstTraversalStack = new Stack<>();
        depthFirstTraversalStack.add(rootNode);
        HashSet<Integer> visitedNodeSet = new HashSet<>();

        while (!depthFirstTraversalStack.isEmpty()) {
            int currNode = depthFirstTraversalStack.pop();
            if (!visitedNodeSet.contains(currNode)) {
                System.out.println(currNode);
                visitedNodeSet.add(currNode);
                if (graphType == GRAPH_TYPE_ADJACENCY_LIST)
                    depthFirstTraversalStack.addAll(adjacentList.get(currNode));
                else if (graphType == GRAPH_TYPE_EDGE_LIST) {
                    for (Edge edge : edgeList) {
                        if (edge.node1 == currNode)
                            depthFirstTraversalStack.add(edge.node2);
                        else if (edge.node2 == currNode)
                            depthFirstTraversalStack.add(edge.node1);
                    }
                }
            }
        }
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
