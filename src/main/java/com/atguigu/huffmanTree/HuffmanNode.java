package com.atguigu.huffmanTree;

/**
 * Created by robin on 18/12/20.
 */
public class HuffmanNode implements Comparable<HuffmanNode> {

    Byte data;
    int weight;
    HuffmanNode left;
    HuffmanNode right;

    public HuffmanNode() {
    }

    public HuffmanNode(Byte data, int weight) {
        this.data = data;
        this.weight = weight;
    }

    @Override
    public int compareTo(HuffmanNode o) {
        return o.weight - this.weight;
    }
}
