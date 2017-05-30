package contest34;

/**
 * @author boyang.lby
 * @date 5/28/17
 * @description
 */
public class RangeAdditionII {
    public int maxCount(int m, int n, int[][] ops) {
        if(m ==0 || n == 0 ){
            return 0;
        }
        int x = m,y = n;
        for(int i=0;i<ops.length;i++){
            int _x = ops[i][0];
            int _y = ops[i][1];
            x = Math.min(_x,x);
            y = Math.min(_y,y);
        }
        return x * y;
    }
}
