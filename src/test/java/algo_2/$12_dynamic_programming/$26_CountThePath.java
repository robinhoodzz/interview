package algo_2.$12_dynamic_programming;

import org.junit.Assert;
import org.junit.Test;

/**
 * 在一个二维数组里面,从左上顶点走到右下顶点, 有多少种方法
 * 其中, 走路只能向右或向下, 即不能回退
 * 其中, 有些节点有石头, 不能穿过
 * 求: 多少种走法
 * Created by Administrator on 2019/10/5.
 */
public class $26_CountThePath {
    /*
    思路; 向下走的方法总和 + 向右走的方法总和
    但是会有重复计算的地方
    /**
     * @param grid 石头的坐标
     * @param row  行
     * @param col  列
     * @return
    int countPaths(boolean[][] grid, int row, int col) {
        if (validSquare(grid, row, col)) {
            return 0;
        }
        if (isAtEnd(grid, row, col)) return 1;
        return countPaths(grid, row + 1, col) + countPaths(grid, row, col + 1);
    }
     */


    @Test
    public void testCountPaths() throws Exception {
        int[][] blocks = new int[][]{
                new int[]{0, 0, 0, 0, 0, 0, 0, 0},
                new int[]{0, 0, 1, 0, 0, 0, 1, 0},
                new int[]{0, 0, 0, 0, 1, 0, 0, 0},
                new int[]{1, 0, 1, 0, 0, 1, 0, 0},
                new int[]{0, 0, 1, 0, 0, 0, 0, 0},
                new int[]{0, 0, 0, 1, 1, 0, 1, 0},
                new int[]{0, 1, 0, 0, 0, 1, 0, 0},
                new int[]{0, 0, 0, 0, 0, 0, 0, 0}
        };


        int paths = countPaths(blocks);
        Assert.assertEquals(27, paths);
    }


    public int countPaths(int[][] blocks) {
        int rows = blocks.length, cols = blocks[0].length;

        int[][] arr = new int[rows][cols];

        for (int i = rows - 1; i >= 0; i--) {
            for (int j = cols - 1; j >= 0; j--) {
                if (blocks[i][j] == 1) { // 障碍物
                    arr[i][j] = 0;
                } else if (i == rows - 1 && j == cols - 1) { // 终点
                    arr[i][j] = 0;
                } else if (i == rows - 1 || j == cols - 1) { // 线边缘或右边缘
                    arr[i][j] = 1;
                } else {
                    arr[i][j] = arr[i + 1][j] + arr[i][j + 1]; // 递推
                }
            }
        }
        return arr[0][0];
    }
}
