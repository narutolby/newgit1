package context111;

/**
 * @author boyang.lby
 * @date 11/18/18
 * @description
 */
public class ValidMountainArray {
    public boolean validMountainArray(int[] A) {
        if( A == null || A.length < 3){
            return false;
        }
        int len = A.length;
        int i = 0;
        while(i < len-1 && A[i] < A[i+1]){
            i++;
        }
        if (i == 0 || i == len-1){
            return false;
        }
        while(i < len-1 && A[i] > A[i+1]){
            i++;
        }
        if (i != len -1){
            return false;
        }
        return true;
    }
}
