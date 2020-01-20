package algo_2.$13_union_find;

import org.junit.Assert;
import org.junit.Test;

/**
 * 岛屿问题
 * 200
 * 描述
 * <p>
 * 1    1   0   0   0
 * 1    1   0   0   0
 * 0    0   1   0   0
 * 0    0   0   1   1
 * 找相邻的岛屿, 如左上角4个1是一组, 中间一个1是一组, 最后右下角2个1是一组, 总共3组
 * <p>
 * <p>
 * Created by Administrator on 2019/10/7.
 */
public class $34_Island {

    /*
    思路:
    1. 染色 flood fill
        1. 遍历节点(可以是一层循环或二层循环, 根据后面是用DFS还是BFS决定)
        2. if node == '1'
                count++
                将node和附近节点置 - > '0'
                此时可以用 DFS 或者 BFS
            else
                什么也不做
    2. 并查集
        1. 初始化, 针对所有为1的节点, parent指向自己
        2. 遍历所有节点: 相邻节点合并
            '1'尝试合并, '0'略过即可
        3. 遍历查询有多少个组
     */

    private int n;
    private int m;

    @Test
    public void testNumIslans() throws Exception {
        char[][] grid = new char[][]{
                new char[]{'1', '1', '0', '0', '0'},
                new char[]{'1', '1', '0', '0', '0'},
                new char[]{'0', '0', '1', '0', '0'},
                new char[]{'0', '0', '0', '1', '1'},
        };

        Assert.assertEquals(3, numIslansColor(grid));
////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////
        // 因为上面执行已经改变了原始数组
        grid = new char[][]{
                new char[]{'1', '1', '0', '0', '0'},
                new char[]{'1', '1', '0', '0', '0'},
                new char[]{'0', '0', '1', '0', '0'},
                new char[]{'0', '0', '0', '1', '1'},
        };
        Assert.assertEquals(3, numIslansUnionFind(grid));

    }


    public int numIslansColor(char[][] grid) {
        int count = 0;
        n = grid.length;
        if (n == 0) return 0;
        m = grid[0].length;

        for (int i = 0; i < n; i++) {
            for (int j = 0; j < m; j++) {
                if (grid[i][j] == '1') {
                    DFSMarking(grid, i, j);
                    count++;
                }
            }
        }
        return count;
    }

    private void DFSMarking(char[][] grid, int i, int j) {
        if (i < 0 || j < 0 || i >= n || j >= m || grid[i][j] != '1') return;
        grid[i][j] = '0';
        DFSMarking(grid, i + 1, j);
        DFSMarking(grid, i - 1, j);
        DFSMarking(grid, i, j + 1);
        DFSMarking(grid, i, j - 1);
    }


    public int numIslansUnionFind(char[][] grid) {
        if (grid.length == 0 || grid[0].length == 0) return 0;
        int m = grid.length, n = grid[0].length;
        UF uf = new UF(m, n, grid);

        for (int i = 0; i < m; i++) {
            for (int j = 0; j < n; j++) {
                if (grid[i][j] == '0') continue;
                int p = i * n + j;
                int q;
                if (i > 0 && grid[i - 1][j] == '1') {
                    q = p - n;
                    uf.unoin(p, q);
                }

                if (i < m - 1 && grid[i + 1][j] == '1') {
                    q = p + n;
                    uf.unoin(p, q);
                }

                if (j > 0 && grid[i][j - 1] == '1') {
                    q = p - 1;
                    uf.unoin(p, q);
                }

                if (j < n - 1 && grid[i][j + 1] == '1') {
                    q = p + 1;
                    uf.unoin(p, q);
                }

            }
        }
        return uf.count;
    }

    class UF {
        public int[] id = null;
        private int count;

        public UF(int m, int n, char[][] grid) {
            for (int i = 0; i < m; i++) {
                for (int j = 0; j < n; j++) {
                    if (grid[i][j] == '1') {
                        count++;
                    }
                }
            }
            id = new int[m * n];
            for (int i = 0; i < m * n; i++) {
                id[i] = i;
            }
        }

        public int find(int p) {
            while (p != id[p]) {
                id[p] = id[id[p]];
                p = id[p];
            }
            return p;
        }

        public boolean isConnected(int p, int q) {
            return find(p) == find(q);
        }

        public void unoin(int p, int q) {
            int pRoot = find(p);
            int qRoot = find(q);
            if (pRoot == qRoot) return;
            id[pRoot] = qRoot;
            count--;
        }
    }
}
