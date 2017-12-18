package contest63;

/**
 * @author boyang.lby
 * @date 12/17/17
 * @description
 */
public class MinCostClimbingStairs {
    public int minCostClimbingStairs(int[] cost) {
        if(cost == null || cost.length == 0){
            return 0;
        }
        int len = cost.length;
        if(len == 1){
            return cost[0];
        }if(len == 2){
            return Math.min(cost[0],cost[1]);
        }
        for(int i=2;i<len;i++){
            cost[i] += Math.min(cost[i-1],cost[i-2]);
        }
        return Math.min(cost[len-1],cost[len-2]);
    }

    public static void main(String[]args){
        //new MinCostClimbingStairs().minCostClimbingStairs(new int[]{1, 100, 1, 1, 1, 100, 1, 1, 100, 1});
        System.out.println((char)('Z' + 32));
    }

}
