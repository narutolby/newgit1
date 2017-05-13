package indeed.two;

import java.util.Scanner;

/**
 * @author boyang.lby
 * @date 5/13/17
 * @description
 */
public class Tiling {
    public static void main(String[]args){
        Scanner sc = new Scanner(System.in);
        int H = sc.nextInt();
        int W = sc.nextInt();
        int A = sc.nextInt();
        int B = sc.nextInt();
        String[]image = new String[H];
        for(int i = 0;i<H;i++){
            String line = sc.next();
            image[i] = line;
        }
        for(int m=0;m<A;m++){
            for(int i=0;i<H;i++) {
                for (int n = 0; n < B; n++) {
                    System.out.print(image[i]);
                }
                System.out.println();
            }
        }
    }
}
