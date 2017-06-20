package twitch;

/**
 * @author boyang.lby
 * @date 6/17/17
 * @description
 */
public class Task1 {
    final long MAX = 1000000000L;
    public int solution(int[] A) {
        if(A == null || A.length <= 2){
            return 0;
        }
        int P = 0,Q = 1,diff = A[1] - A[0],len = A.length,ret = 0;
        for(int i=2;i<len;i++){
            if(A[i] - A[i-1] == diff){
                Q = i;
            }
            if(A[i] - A[i-1] != diff || i == len - 1){
                if(P + 1 < Q){
                    ret += (Q - P - 1);
                    if(P+2 < Q){
                        ret++;
                    }
                }
                if(ret > MAX){
                    return -1;
                }
                P = i-1;
                Q = i;
                diff = A[i] - A[i-1];
            }
        }
        return ret;
    }

    public static void main(String[]args){
        System.out.println(new Task1().solution(new int[]{-1, 1, 3, 3, 3, 2, 1, 0}));
    }
}
