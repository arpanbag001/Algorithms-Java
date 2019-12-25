package com.company;

import com.company.datastructures.MyBinarySearchTree;

public class Main {

    public static void main(String[] args) {

        MyBinarySearchTree myBinarySearchTree = new MyBinarySearchTree();

        myBinarySearchTree.insert(4);
        myBinarySearchTree.insert(2);
        myBinarySearchTree.insert(3);
        myBinarySearchTree.insert(1);
        myBinarySearchTree.insert(6);
        myBinarySearchTree.insert(7);
        myBinarySearchTree.insert(5);

//        myBinarySearchTree.traversalInorder(myBinarySearchTree.getRoot());
//        System.out.println("\n\n" + myBinarySearchTree.getRoot().value);
//        System.out.println("\n\n" + myBinarySearchTree.getRoot().left.left.value);
//        System.out.println("\n\n" + myBinarySearchTree.getRoot().right.left.value);

        /*
                       4
                   2        6
                1    3     5    7

         */

        myBinarySearchTree.traverseDepthFirstPostOrderIteratively();

    }
}
