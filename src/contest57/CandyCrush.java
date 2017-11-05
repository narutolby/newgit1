package contest57;

import java.util.HashSet;
import java.util.Set;

/**
 * @author boyang.lby
 * @date 11/5/17
 * @description
 */
public class CandyCrush {

    public int[][] candyCrush(int[][] board) {
        boolean over = false;
        int m = board.length;
        int n = board[0].length;
        while (!over) {
            boolean tmp = true;
            Set<Integer> set = new HashSet<Integer>();
            for (int i = 0; i < m; i++) {
                for (int j = 0; j < n; j++) {
                    int current = board[i][j];
                    if(current == 0){
                        continue;
                    }
                    int v = 1,h=1;
                    while(j+v<n && board[i][j+v] == current ){
                        v++;
                    }
                    if(v - 1 >=2){
                        while(v>=2){
                            //board[i][j+v-1] = 0;
                            set.add(i * n + j + v - 1);
                            v--;
                        }
                        //board[i][j] = 0;
                        set.add(i * n + j);
                        tmp = false;
                    }
                    while(i+h <m && board[i+h][j] == current){
                        h++;
                    }
                    if(h - 1 >=2){
                        while(h>=2){
                            //board[i+h-1][j] = 0;
                            set.add((i + h - 1) * n + j);
                            h--;
                        }
                        set.add(i * n + j);
                        //board[i][j] = 0;
                        tmp = false;
                    }
                }
            }
            over = tmp;
            for(Integer ii : set){
                board[ii / n][ii % n] = 0;
            }
            for (int i = 0; i < m; i++) {
                for (int j = 0; j < n; j++) {
                    int current = board[i][j];
                    if(current != 0 || (i>0 && board[i-1][j] == 0)){
                        continue;
                    }
                    int count = 0,v = i;
                    while(v<m && board[v][j] == current){
                        count++;
                        v++;
                    }
                    for(int x=i-1;x>=0;x--){
                        board[x+count][j] = board[x][j];
                        board[x][j] = 0;
                    }
                }
            }
        }
        return board;
    }
    public static void main(String[]args){
        int[][]board = new int[][]{
            {1,3,5,5,2},{3,4,3,3,1},{3,2,4,5,2},{2,4,4,5,5},{1,4,4,1,1}
        };
        new CandyCrush().candyCrush(board);
    }

}
