package com.dt.$36_heapsort;

import java.util.Arrays;

/**
 * Created by robin on 19/1/30.
 */
public class HeapSort {


    public static void main(String[] args) {
        int[] arr = new int[]{9, 6, 8, 7, 0, 1, 10, 4, 2};

        // 开始位置是最后一个非叶子节点, 即最后一个节点的父节点
        int start = (arr.length - 1) / 2;
        // 结束位置 数组长度 - 1
        for (int i = start; i >= 0; i--) {
            maxHeap(arr, arr.length, i);
        }
        System.out.println(Arrays.toString(arr));


        heapSort(arr);
        System.out.println(Arrays.toString(arr));


        int[] b = new int[]{4, 10, 3, 5, 1};
        heapSort2(b, b.length);
        System.out.println(Arrays.toString(b));


    }

    private static void heapSort2(int[] arr, int n) {
        for (int i = n/2-1; i>=0; i--) {
            heapify(arr, n, i);
//            maxHeap(arr, n, i);

        }
        for (int i = n-1; i >=0; i--) {
//            swap(arr[0], arr[i]);
            int tmp = arr[0];
            arr[0] = arr[i];
            arr[i] = tmp;
            heapify(arr, i, 0);
//            maxHeap(arr, i, 0);
        }
    }

    private static void heapify(int[] arr, int n, int i) {

        int leftIndex = 2 * i;
        int rightIndex = 2 * i + 1;

        int max = i;

        if (leftIndex < n && arr[leftIndex] > arr[i]) {
            max = leftIndex;
        }
        if (rightIndex < n && arr[rightIndex] > arr[i]) {
            max = rightIndex;
        }

        if (max > i) {
            int tmp = arr[i];
            arr[i] = arr[max];
            arr[max] = tmp;
            heapify(arr, n, max);
        }

    }


    /**
     * 大顶堆排序
     *
     * @param arr 调整好的大顶堆
     */
    public static void heapSort(int[] arr) {

        // 先把数组中第一个和最后一个交换位置, 再把前面的处理为大顶堆
        for (int i = arr.length - 1; i > 0; i--) {
            int tmp = arr[0];
            arr[0] = arr[i];
            arr[i] = tmp;

            maxHeap(arr, i, 0);
        }

    }

    /**
     * 数组转换为大顶堆
     *
     * @param arr   数组
     * @param size  大小
     * @param index 要调整的元素索引
     */
    public static void maxHeap(int[] arr, int size, int index) {
        // 通过index找到左子节点, 右子节点
        int leftNode = 2 * index + 1;
        int rightNode = 2 * index + 2;

        int max = index;
        // 和两个字节点分别对比
        if (leftNode < size && arr[leftNode] > arr[max]) {
            max = leftNode;
        }
        if (rightNode < size && arr[rightNode] > arr[max]) {
            max = rightNode;
        }

        // 交换位置
        if (max != index) {
            int tmp = arr[index];
            arr[index] = arr[max];
            arr[max] = tmp;
            // 可能会破坏之前排好序的堆
            maxHeap(arr, size, max);
        }
    }
}
