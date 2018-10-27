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
public class SnakesandLadders {
    public int snakesAndLadders(int[][] board) {
        int N = board.length;
        Queue<Integer[]> queue = new LinkedList();
        int ret = 0;
        queue.add(new Integer[]{N-1,0});
        Set<Integer> set = new HashSet<>();
        int count = 1;
        while(!queue.isEmpty()){
            int tmpCount = 0;
            ret++;
            for(int i=0;i<count;i++){
                Integer[] num = queue.poll();
                int m = num[0];
                int n = num[1];
                int value = board[m][n];
                if(value != -1 && !set.contains(value)){
                    set.add(value);
                    tmpCount ++;
                    queue.add(getIndex(value,N));
                }else{
                    value = getValue(m,n,N);
                }
                for(int j=1;j<=6;j++){
                    int tmpValue = value;
                    if(value + j <=N * N){
                        value = value +j;
                        Integer[]xy = getIndex(value,N);
                        if(board[xy[0]][xy[1]] != -1){
                            value = board[xy[0]][xy[1]];
                        }
                        if(set.contains(value)){
                            continue;
                        }
                        set.add(value);
                        tmpCount++;
                        queue.add(getIndex(value+j,N));
                    }
                    value = tmpValue;
                }
                if(set.contains(N*N)){
                    return ret;
                }
            }
            count = tmpCount;
        }
        return -1;
    }

    public Integer[] getIndex(int seq,int N){
        int rows = (seq-1) / N  + 1;
        int colums = seq % N;
        Integer[] ret = {0,0};
        ret[0] = N - rows ;
        if(colums == 0){
            colums = N;
        }
        if(rows % 2 == 0){
            ret[1] = N - colums;
        }else{
            ret[1] = colums - 1;
        }
        return ret;
    }

    public int getValue(int i,int j,int N){
        int rows = N - i;
        int value = 0;
        value = (rows - 1) * N;
        if(rows % 2 == 0){
            value += (N - j);
        }else{
            value += j + 1;
        }
        return value;
    }

    public static void main(String[]args){
        System.out.println(new SnakesandLadders().snakesAndLadders(new int[][] {
            {-1, -1, -1, -1, -1, -1},
            {-1, -1, -1, -1, -1, -1},
            {-1, -1, -1, -1, -1, -1},
            {-1, 35, -1, -1, 13, -1},
            {-1, -1, -1, -1, -1, -1},
            {-1, 15, -1, -1, -1, -1}
        }));
    }
}
