package com.company.datastructures;

import java.util.LinkedList;
import java.util.Queue;
import java.util.Stack;

public class MyBinarySearchTree {

    public static class Node {
        public int value;
        public Node left;
        public Node right;

        Node(int value) {
            this.value = value;
        }
    }

    private Node root;
    private Queue<Node> breadthFirstTraversalQueue;
    private Stack<Node> depthFirstTraversalStack;

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


    //              *** Traversals ***

    public void traverseBreadthFirst() {
        if (breadthFirstTraversalQueue == null) {
            breadthFirstTraversalQueue = new LinkedList<>();
            breadthFirstTraversalQueue.add(getRoot());
        }
        if (breadthFirstTraversalQueue.isEmpty())
            return;
        Node node = breadthFirstTraversalQueue.poll();
        System.out.println(node.value);
        if (node.left != null)
            breadthFirstTraversalQueue.add(node.left);
        if (node.right != null)
            breadthFirstTraversalQueue.add(node.right);
        traverseBreadthFirst();
    }

    public void traverseBreadthFirstIteratively() {
        breadthFirstTraversalQueue = new LinkedList<>();
        breadthFirstTraversalQueue.add(getRoot());
        while (!breadthFirstTraversalQueue.isEmpty()) {
            Node node = breadthFirstTraversalQueue.poll();
            System.out.println(node.value);
            if (node.left != null)
                breadthFirstTraversalQueue.add(node.left);
            if (node.right != null)
                breadthFirstTraversalQueue.add(node.right);
        }
    }

    public void traverseDepthFirstInOrder(Node node) {
        if (node == null)
            return;
        traverseDepthFirstInOrder(node.left);
        System.out.println(node.value);
        traverseDepthFirstInOrder(node.right);
    }

    public void traverseDepthFirstPreOrder(Node node) {
        if (node == null)
            return;
        System.out.println(node.value);
        traverseDepthFirstPreOrder(node.left);
        traverseDepthFirstPreOrder(node.right);
    }

    public void traverseDepthFirstPostOrder(Node node) {
        if (node == null)
            return;
        traverseDepthFirstPostOrder(node.left);
        traverseDepthFirstPostOrder(node.right);
        System.out.println(node.value);
    }

    public void traverseDepthFirstInOrderIteratively() {
        if (depthFirstTraversalStack == null)
            depthFirstTraversalStack = new Stack<>();

        Node currNode = getRoot();

        // If current node is null and stack is also empty, we're done
        while (!depthFirstTraversalStack.isEmpty() || currNode != null) {

            // If current node is not null, push it to the stack (defer it)
            // and move to its left child
            if (currNode != null) {
                depthFirstTraversalStack.push(currNode);
                currNode = currNode.left;
            } else {
                // Else if current node is null, we pop an element from stack,
                // print it and finally set current node to its right child
                currNode = depthFirstTraversalStack.pop();
                System.out.println(currNode.value);
                currNode = currNode.right;
            }

        }
    }

    public void traverseDepthFirstPreOrderIteratively() {
        if (depthFirstTraversalStack == null)
            depthFirstTraversalStack = new Stack<>();
        if (depthFirstTraversalStack.isEmpty())
            depthFirstTraversalStack.add(getRoot());

        while (!depthFirstTraversalStack.isEmpty()) {
            Node node = depthFirstTraversalStack.pop();
            System.out.println(node.value);
            if (node.right != null)
                depthFirstTraversalStack.push(node.right);
            if (node.left != null)
                depthFirstTraversalStack.push(node.left);
        }
    }

    public void traverseDepthFirstPostOrderIteratively() {

        /*  Same as pre order, just using two reversing techniques.
            In pre order, output is root-left-right. Here we want left-right-root.
            Since we can't reinsert one node (root) to stack after popping it out (otherwise will cause infinite loop),
            We can't print it either, like in pre order, as root should be printed only after left and right.
            So we must handle the root node in a special way to print it later, after left and right.
            So, we should use those reversing techniques.
            Here first we are changing the order of stack push of left right elements,
            instead of pushing right-left, like in pre order, here we are pushing left-right,
            making the overall order root-right-left.
            Secondly, we are using an output stack to reverse the whole output,
            making the output: left-right-root, which is what we wanted.
        */

        if (depthFirstTraversalStack == null)
            depthFirstTraversalStack = new Stack<>();
        if (depthFirstTraversalStack.isEmpty())
            depthFirstTraversalStack.add(getRoot());

        // A stack just to hold and reverse the output numbers
        Stack<Integer> outputStack = new Stack<>();

        while (!depthFirstTraversalStack.isEmpty()) {
            Node node = depthFirstTraversalStack.pop();
            outputStack.push(node.value);
            if (node.left != null)
                depthFirstTraversalStack.push(node.left);
            if (node.right != null)
                depthFirstTraversalStack.push(node.right);
        }

        while (!outputStack.isEmpty())
            System.out.println(outputStack.pop());
    }

}
