package contest69;

import java.util.ArrayDeque;
import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;
import java.util.Queue;

/**
 * @author boyang.lby
 * @date 1/28/18
 * @description
 * On a 2x3 board, there are 5 tiles represented by the integers 1 through 5, and an empty square represented by 0.

A move consists of choosing 0 and a 4-directionally adjacent number and swapping it.

The state of the board is solved if and only if the board is [[1,2,3],[4,5,0]].

Given a puzzle board, return the least number of moves required so that the state of the board is solved. If it is impossible for the state of the board to be solved, return -1.

Examples:

Input: board = [[1,2,3],[4,0,5]]
Output: 1
Explanation: Swap the 0 and the 5 in one move.
Input: board = [[1,2,3],[5,4,0]]
Output: -1
Explanation: No number of moves will make the board solved.
Input: board = [[4,1,2],[5,0,3]]
Output: 5
Explanation: 5 is the smallest number of moves that solves the board.
An example path:
After move 0: [[4,1,2],[5,0,3]]
After move 1: [[4,1,2],[0,5,3]]
After move 2: [[0,1,2],[4,5,3]]
After move 3: [[1,0,2],[4,5,3]]
After move 4: [[1,2,0],[4,5,3]]
After move 5: [[1,2,3],[4,5,0]]
Input: board = [[3,2,4],[1,5,0]]
Output: 14
Note:

board will be a 2 x 3 array as described above.
board[i][j] will be a permutation of [0, 1, 2, 3, 4, 5].
Discuss


 */
public class SlidingPuzzle {
    //public int encPerm(int[] a)
    //{
    //    int n = a.length;
    //    int used = 0;
    //    int ret = 0;
    //    for(int i = 0;i < n;i++){
    //        ret = ret * (n - i) + a[i] - Integer.bitCount(used & ((1<<a[i]) - 1));
    //        used |= 1<<a[i];
    //    }
    //    return ret;
    //}
    public int slidingPuzzle(int[][] board) {
        String target = "012345";
        StringBuilder sb = new StringBuilder();
        int rows = board.length;
        int columns = board[0].length;
        for(int i=0;i<rows;i++){
            for(int j=0;j<columns;j++){
                sb.append(String.valueOf(board[i][j]));

            }
        }
        char[]chars = sb.toString().toCharArray();
        Queue<char[]> queue = new ArrayDeque<>();
        Map<String,Integer> stepMap = new HashMap<String,Integer>();
        stepMap.put(sb.toString(),0);
        queue.offer(chars);
        int[]dx = {0,1,0,-1};
        int[]dy = {-1,0,1,0};
        while(!queue.isEmpty()){
            char[]chars1 = queue.poll();
            String cus = new String(chars1);
            if(cus.equals(target)){
                return stepMap.get(cus);
            }
            for(int i=0;i<chars1.length;i++){
                char c = chars1[i];
                if (c == '0'){
                    int rx = i / columns,ry = i % columns;
                    for(int j=0;j<4;j++){
                        int tx = rx + dx[j];
                        int ty = ry + dy[j];
                        char[]chars2 = Arrays.copyOf(chars1,rows * columns );
                        if(tx>=0 && tx<rows && ty>=0 && ty<columns){
                            char tmp = chars2[tx * columns + ty];
                            chars2[tx * columns + ty] = c;
                            chars2[i] = tmp;
                            String newb = new String(chars2);
                            if(!stepMap.containsKey(newb)){
                                queue.offer(chars2);
                                stepMap.put(newb,stepMap.get(cus) + 1);
                            }
                        }

                    }
                }
            }
        }
        return -1;
    }

    public static void main(String[]args){
       // System.out.println(new SlidingPuzzle().encPerm(new int[]{1,2,3,4,5,0}));
    }
}
