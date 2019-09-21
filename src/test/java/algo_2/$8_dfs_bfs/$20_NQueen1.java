package algo_2.$8_dfs_bfs;

import com.alibaba.fastjson.JSON;
import org.junit.Test;

import java.util.*;

/**
 * N皇后问题
 * 国际象棋
 * N个皇后放在N*N的棋盘上, 使其不能相互攻击(吃掉)
 */
public class $20_NQueen1 {

    /*
    思路:
    1. 深度优先
     */
    List<List<String>> result = new ArrayList<>();
    Set<Integer> cols = new HashSet<>();
    Set<Integer> pie = new HashSet<>();
    Set<Integer> na = new HashSet<>();


    @Test
    public void testSolveNQueens() {
        List<String[]> strings = solveNQueens(4);
        System.out.println(JSON.toJSONString(strings));
    }

    public List<String[]> solveNQueens(int n) {
        List<String[]> res = new ArrayList<>();
        helper(0, new boolean[n], new boolean[2 * n], new boolean[2 * n], new String[n], res);


        return res;
    }

    private void helper(int r, boolean[] cols, boolean[] d1, boolean[] d2, String[] board, List<String[]> res) {
        if (r == board.length) {
            res.add(board.clone());

        } else {
            for (int c = 0; c < board.length; c++) {
                int id1 = r - c + board.length, id2 = 2 * board.length - r - c - 1;
                if (!cols[c] && !d1[id1] && !d2[id2]) {
                    char[] row = new char[board.length];
                    Arrays.fill(row, '.');
                    row[c] = 'Q';
                    board[r] = new String(row);
                    cols[c] = true;
                    d1[id1] = true;
                    d2[id2] = true;
                    helper(r + 1, cols, d1, d2, board, res);
                    cols[c] = false;
                    d1[id1] = false;
                    d2[id2] = false;
                }
            }
        }
    }

}
