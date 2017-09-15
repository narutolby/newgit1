package indeed;

import java.util.Arrays;
import java.util.Scanner;

/**
 * @author boyang.lby
 * @date 4/22/17
 * @description
 */
public class SpiralMove {
    public static void main(String[]args){
        int n = 10;
        int[][] board = new int[n][n];
        int i = 0,j = 0;
        for(int m=1;m<n * n ;){
            while(true){
                board[i][j] = m;
                if(j== n-1 || board[i][j+1] != 0){
                    break;
                }
                j++;
                m++;
            }
            while(true){
                board[i][j] = m;
                if(i== n-1 || board[i+1][j] != 0){
                    break;
                }
                i++;
                m++;
            }
            while(true){
                board[i][j] = m;
                if(i == 0 || board[i-1][j] != 0){
                    break;
                }
                i--;
                m++;
            }

            while(true){
                board[i][j] = m;
                if(j == 0 || board[i][j-1] != 0){
                    break;
                }
                j--;
                m++;
            }
        }
        for(i=0;i<n;i++){
            for(j=0;j<n;j++){
                System.out.print(board[i][j]);
            }
            System.out.println();
        }
    }
}
