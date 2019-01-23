package com.dt.demo14;

import java.util.Arrays;
import java.util.PriorityQueue;
import java.util.Queue;
import java.util.Stack;

/**
 * Created by robin on 19/1/22.
 */
public class Graph {

    public Vertex[] vertices; // 存储顶点
    private int currentSize = 0; // 当前容量
    private int[][] adjMat; // 邻接矩阵表
    private Stack<Integer> stack = new Stack<>();// 栈
    private Queue<Integer> queue = new PriorityQueue<>(); // 队列
    private int currentIndex = 0; // 当前遍历的下标

    public Graph(int size) {
        vertices = new Vertex[size];
        adjMat = new int[size][size];

        for (int i = 0; i < size; i++) {
            adjMat[i][i] = 1;
        }
    }


    /**
     * 向图中加入一个顶点
     *
     * @param vertex 顶点
     */
    public void addVertex(Vertex vertex) {
        vertices[currentSize++] = vertex;
    }

    /**
     * 增加
     *
     * @param v1 顶点的值
     * @param v2 顶点的值
     */
    public void addEdge(String v1, String v2) {

        // 找出2个顶点的下标
        int v1Index = this.getIndexByValue(v1);
        int v2Index = this.getIndexByValue(v2);

        // 因为是无向图, 所以两边都是通的
        adjMat[v1Index][v2Index] = 1;
        adjMat[v2Index][v1Index] = 1;


    }

    /**
     * 根据值 获取索引
     *
     * @param value 值
     * @return 索引
     */
    private int getIndexByValue(String value) {
        int index = -1;
        for (int i = 0; i < vertices.length; i++) {
            if (vertices[i].getValue().equals(value)) {
                index = i;
                break;
            }
        }
        return index;
    }


    /**
     * 打印邻接矩阵
     */
    public void printAdjMat() {

        for (int i = 0; i < currentSize; i++) {
            for (int j = 0; j < currentSize; j++) {
                System.out.print(adjMat[i][j] + "\t");
            }
            System.out.println();
        }
    }

    /**
     * 打印邻接矩阵
     */
    public void printAdjMat2() {
        for (int[] ints : adjMat) {
            System.out.println(Arrays.toString(ints));
        }
    }

    /**
     * 深度优先搜索算法 遍历图
     */
    public void dfs() {
        // 把第0个顶点标记为已访问状态
        vertices[0].setVisit(true);
        // 把第0个元素的下标放入栈中
        stack.push(0);
        // 打印顶点的值
        System.out.println(vertices[0].getValue());
        // 遍历跳出条件: 栈空
        out:
        while (!stack.isEmpty()) {
            for (int i = currentIndex + 1; i < currentSize; i++) {
                if (adjMat[currentIndex][i] == 1 && !vertices[i].isVisit()) { // 相连接的 && 没有被访问过的, 压入栈中
                    stack.push(i);
                    vertices[i].setVisit(true);
                    System.out.println(vertices[i].getValue()); // 此处打印的是入栈的顺序
                    continue out;
                }
            }

            // 弹出栈顶元素
            /** 出栈条件: 没有符合条件的元素可入栈时 */
            stack.pop();
            // 修改当前位置为 栈顶元素的位置
            if (!stack.isEmpty()) {
                currentIndex = stack.peek();
            }
        }
    }

    public void bfs() {
        // 把第0个顶点标记为已访问状态
        vertices[0].setVisit(true);
        // 把第0个元素的下标放入栈中
        queue.add(0);
        // 打印顶点的值
        System.out.println(vertices[0].getValue());
        // 遍历跳出条件: 栈空
        while (!queue.isEmpty()) {
            for (int i = currentIndex + 1; i < currentSize; i++) {
                if (adjMat[currentIndex][i] == 1 && !vertices[i].isVisit()) {
                    queue.add(i);
                    vertices[i].setVisit(true);
                    System.out.println(vertices[i].getValue()); // 此处打印的是入队列的顺序
                }
            }
            /** 出队列条件:  */
            queue.poll();
            if (!queue.isEmpty()) {
                currentIndex = queue.peek();
            }
        }
    }
}
