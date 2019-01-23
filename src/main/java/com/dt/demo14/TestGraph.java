package com.dt.demo14;

/**
 * Created by robin on 19/1/22.
 */
public class TestGraph {


    public static void main(String[] args) {
        Vertex v1 = new Vertex("A");
        Vertex v2 = new Vertex("B");
        Vertex v3 = new Vertex("C");
        Vertex v4 = new Vertex("D");
        Vertex v5 = new Vertex("E");

        Graph g = new Graph(5);
        g.addVertex(v1);
        g.addVertex(v2);
        g.addVertex(v3);
        g.addVertex(v4);
        g.addVertex(v5);

        // 增加边
        g.addEdge("A", "B");
        g.addEdge("A", "C");
        g.addEdge("B", "C");
        g.addEdge("B", "D");
        g.addEdge("B", "E");


        g.printAdjMat();
        g.printAdjMat2();

        g.dfs();
//        g.bfs();


    }
}
