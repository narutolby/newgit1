package contest33;

import java.util.Arrays;
import java.util.Comparator;

/**
 * @author boyang.lby
 * @date 5/21/17
 * @description
 */
public class ValidSquare {
    public boolean validSquare(int[] p1, int[] p2, int[] p3, int[] p4) {

        int[][]square = new int[][]{p1,p2,p3,p4};
        Arrays.sort(square,1,4, new Comparator<int[]>() {
            @Override
            public int compare(int[] o1, int[] o2) {
                return cross(o1,o2,square[0]);
            }
        });
        if(square[1][0] - square[0][0] == square[2][0] - square[3][0] &&
            square[1][1] - square[0][1] == square[2][1] - square[3][1] &&
            square[3][0] - square[0][0] == square[2][0] - square[1][0] &&
            square[3][1] - square[0][1] == square[2][1] - square[1][1] &&
            (square[1][0] - square[0][0]) * (square[3][0] - square[0][0]) + (square[1][1] - square[0][1]) * (square[3][1] - square[0][1]) == 0 &&
            (square[1][0] - square[0][0] == -(square[3][1] - square[0][1])) &&
            square[1][1] - square[0][1] == square[3][0] - square[0][0]
            ){
            return true;
        }
        return false;
    }

    int cross(int[]p1,int[] p2,int[]p0){
        return (p1[0]-p0[0])*(p2[1]-p0[1]) - (p1[1]-p0[1])*(p2[0]-p0[0]);
    }

    public static void main(String[]args){
       /* int[]p1 = new int[]{0,0};
        int[]p2 = new int[]{5,0};
        int[]p3 = new int[]{5,4};
        int[]p4 = new int[]{0,4};*/
        int[]p1 = new int[]{0,0};
        int[]p2 = new int[]{1,1};
        int[]p3 = new int[]{1,0};
        int[]p4 = new int[]{0,1};
        new ValidSquare().validSquare(p1,p2,p3,p4);
    }
}
