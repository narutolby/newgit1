package contest67;

import java.util.Arrays;

public class LargestPlusSign {
    public int orderOfLargestPlusSign(int N, int[][] mines) {
        int[][][]table = new int[4][N][N];
        for(int i=0;i<N;i++){
            for(int m=0;m<4;m++){
                Arrays.fill(table[m][i],1);
            }
        }
        for(int i=0;i<mines.length;i++){
            for(int m=0;m<4;m++){
                table[m][mines[i][0]][mines[i][1]] = 0;
            }
        }

        for(int m=0;m<4;m++){
            if(m == 0){
                for(int i=0;i<N;i++){
                    for(int j=1;j<N;j++){
                        if(table[m][i][j] == 1){
                            table[m][i][j] += table[m][i][j-1];
                        }
                    }
                }
            }else if(m == 1){
                for(int i=0;i<N;i++){
                    for(int j=N-2;j>=0;j--){
                        if(table[m][j][i] == 1){
                            table[m][j][i] += table[m][j+1][i];
                        }
                    }
                }
            }else if(m == 2){
                for(int i=0;i<N;i++){
                    for(int j=N-2;j>=0;j--){
                        if(table[m][i][j] == 1){
                            table[m][i][j] += table[m][i][j+1];
                        }
                    }
                }
            }else{
                for(int i=0;i<N;i++){
                    for(int j=1;j<N;j++){
                        if(table[m][j][i] == 1){
                            table[m][j][i] += table[m][j-1][i];
                        }
                    }
                }
            }
        }
        int ret = 0;
        for(int i=0;i<N;i++){
            for(int j=0;j<N;j++){
                if(table[0][i][j] == 0){
                    continue;
                }
                ret = Math.max(ret,Math.min(Math.min(table[0][i][j],table[1][i][j]),Math.min(table[2][i][j],table[3][i][j])));
            }
        }
        return ret;
    }
}
