package indeed;

import java.util.Scanner;

/**
 * @author boyang.lby
 * @date 4/22/17
 * @description
 */
public class SpiralMove {
    public static void main(String[]args){
        Scanner sc = new Scanner(System.in);
        int N = sc.nextInt();
        long M = sc.nextLong();
        byte[][]board = new byte[N][N];
        int i = 0;
        int j = 0;
        board[i][j] = 1;
        for(long m=1;m<M;){
            boolean f = false;
            while(j<N-1 && board[i][j+1] == 0){
                j++;
                m++;
                board[i][j] = 1;
                f = true;
                if(m>=M){
                    System.out.println((i+1) + " " + (j+1));
                    return;
                }
            }

            while(i<N-1 && board[i+1][j] == 0){
                i++;
                m++;
                board[i][j] = 1;
                f = true;
                if(m>=M){
                    System.out.println((i+1) + " " + (j+1));
                    return;
                }
            }

            while(j>0 && board[i][j-1] == 0){
                j--;
                m++;
                board[i][j] = 1;
                f = true;
                if(m>=M){
                    System.out.println((i+1) + " " + (j+1));
                    return;
                }
            }

            while(i>0 && board[i-1][j] == 0){
                i--;
                m++;
                board[i][j] = 1;
                f = true;
                if(m>=M){
                    System.out.println((i+1) + " " + (j+1));
                    return;
                }
            }

            if(!f){
                break;
            }
        }

        System.out.println((i+1) + " " + (j+1));


    }
}
