package google;

/**
 * @author boyang.lby
 * @date 10/2/17
 * @description
 */
public class Searcha2DMatrixII {
    public boolean searchMatrix(int[][] m, int target) {
        if(m == null || m.length == 0 || m[0].length == 0){
            return false;
        }
        int s = 0,e = m[0].length -1;
        while(s<m.length && e>=0){
            if(m[s][e] == target){
                return true;
            }else if(m[s][e] < target){
                s++;
            }else{
                e--;
            }
        }
        return false;
    }
}
