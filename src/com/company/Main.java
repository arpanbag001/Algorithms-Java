package com.company;

import com.company.datastructures.MyBinarySearchTree;
import com.company.datastructures.MyGraphUndirectedUnweighted;

public class Main {

    public static void main(String[] args) {

        MyGraphUndirectedUnweighted myGraphUndirectedUnweighted = new MyGraphUndirectedUnweighted();

        myGraphUndirectedUnweighted.addVertex(2);
        myGraphUndirectedUnweighted.addVertex(4);
        myGraphUndirectedUnweighted.addVertex(6);
        myGraphUndirectedUnweighted.addVertex(8);
        myGraphUndirectedUnweighted.addVertex(10);
        myGraphUndirectedUnweighted.addVertex(12);

        myGraphUndirectedUnweighted.addEdge(2, 4);
        myGraphUndirectedUnweighted.addEdge(4, 8);
        myGraphUndirectedUnweighted.addEdge(4, 6);
        myGraphUndirectedUnweighted.addEdge(8, 10);
        myGraphUndirectedUnweighted.addEdge(10, 12);
        myGraphUndirectedUnweighted.addEdge(6, 12);

        /*

             6-----------
             |          |
         2---4---8--10--12
             |___|

         */
        //myGraphUndirectedUnweighted.printGraph(MyGraphUndirectedUnweighted.GRAPH_TYPE_ADJACENCY_LIST);
        myGraphUndirectedUnweighted.traverseBreadthFirst(2);

    }
}
