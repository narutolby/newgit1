package indeed.three;

import java.util.Arrays;
import java.util.Scanner;

/**
 * @author boyang.lby
 * @date 5/27/17
 * @description
 */
public class CandyOrder {
    public static void main(String[]args) {
        Scanner sc = new Scanner(System.in);
        int N = sc.nextInt();
        int T = sc.nextInt();
        int[]array = new int[3 * T];
        for(int i=0;i<3*T;i++){
            array[i] = sc.nextInt();
        }
        Arrays.sort(array);
        int ret = 0;
        int num = 0;
        for(int i=0;i<3*T;i++){
            if(num + array[i]>N){
                System.out.println(ret);
                return;
            }else{
                num += array[i];
                ret++;
            }
        }
        System.out.println(ret);
    }
}
