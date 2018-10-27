package contest103;

import java.util.HashSet;
import java.util.LinkedList;
import java.util.Queue;
import java.util.Set;

/**
 * @author boyang.lby
 * @date 9/23/18
 * @description
 */
public class SnakesandLadders1 {
    public int snakesAndLadders(int[][] board) {
        int N = board.length;
        int[] transferArray = new int[N * N];
        int index = 0;
        int flag = 1;
        for (int i = N - 1; i >= 0; i--) {
            if (flag == 1) {
                for (int j = 0; j < N; j++) {
                    transferArray[index++] = board[i][j]-1;
                }
            } else {
                for (int j = N - 1; j >= 0; j--) {
                    transferArray[index++] = board[i][j]-1;
                }
            }
            flag *= -1;
        }
        Queue<Integer> queue = new LinkedList<>();
        queue.add(0);
        int ret = 0;
        int levelCount = 1;
        Set<Integer> set = new HashSet<>();
        set.add(0);
        while (!queue.isEmpty()) {
            int tmpCount = 0;
            ret++;
            for (int i = 0; i < levelCount; i++) {
                index = queue.poll();
                for (int j = 1; j <= 6 && index+j<N*N; j++) {
                    int next = transferArray[index + j];
                    if (next == -2) {
                        next = index+j;
                    }
                    if (next == N * N - 1) {
                        return ret ;
                    }

                    if (!set.contains(next)) {
                        set.add(next);
                        tmpCount++;
                        queue.add(next);
                    }
                }
            }
            levelCount = tmpCount;
        }
        return -1;
    }

    public static void main(String[] args) {
        System.out.println(new SnakesandLadders1().snakesAndLadders(new int[][] {
            {-1,-1,-1},{-1,9,8},{-1,8,9}
        }));
    }
}
