package indeed.three;

import java.util.HashSet;
import java.util.Scanner;
import java.util.Set;

/**
 * @author boyang.lby
 * @date 5/27/17
 * @description
 */
public class RoomNumber {
    public static void main(String[]args){
        Scanner sc = new Scanner(System.in);
        int N = sc.nextInt();
        int M = sc.nextInt();
        int[] floor = new int[N];
        for(int i=0;i<N;i++){
            floor[i] = sc.nextInt();
        }
        Set<Integer> set = new HashSet<Integer>();
        for(int i=0;i<M;i++){
            set.add(sc.nextInt());
        }
        for(int i=0;i<N;i++){
            int count = floor[i];
            for(int j=1;;j++){
                if(!set.contains(j)){
                    if(--count == 0){
                        System.out.println(j);
                        break;
                    }
                }
            }
        }
    }
}
