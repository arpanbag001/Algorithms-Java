package com.company.datastructures;

public class MyBinarySearchTree {

    private Node root;

    public Node insert(int value) {
        Node newNode = new Node(value);
        if (root == null) {     //Tree is empty
            root = newNode;
        } else {
            Node leafNode = traverseToNodeWithClosestValue(value);
            if (value > leafNode.value) {
                leafNode.right = newNode;
            } else
                leafNode.left = newNode;
        }
        return newNode;
    }

    public boolean lookup(int value) {
        if (root == null)  //Tree is empty
            return false;
        else {
            Node closestNode = traverseToNodeWithClosestValue(value);      //Find the node with closest value
            if (closestNode.value == value)                                //If the closest value is the key itself
                return true;
            else
                return false;
        }
    }

    public Node getRoot() {
        return root;
    }

    public void traversalInorder(Node node) {
        if (node == null)
            return;
        traversalInorder(node.left);
        System.out.println(node.value);
        traversalInorder(node.right);
    }

    private Node traverseToNodeWithClosestValue(int value) {
        Node currentNode = root;
        while (true) {
            if (value > currentNode.value) {            //Value is larger than current node

                if (currentNode.right == null)          //But current node does not have a right child
                    return currentNode;                 //So, current node is the node with closest value
                else
                    currentNode = currentNode.right;    //If current node has a right child, move to that

            } else if (value < currentNode.value) {     // ... Same as before ...

                if (currentNode.left == null)           //...
                    return currentNode;                 //...
                else
                    currentNode = currentNode.left;     //...
            } else {
                return currentNode;                     //...
            }

        }
    }

    static class Node {
        int value;
        Node left;
        Node right;

        Node(int value) {
            this.value = value;
        }
    }
}
