/**
 * @author boyang.lby
 * @date 3/3/18
 * @description
 */
public class TargetSum {
    int count = 0;
    public int findTargetSumWays(int[] nums, int S) {
        if(nums == null || nums.length == 0){
            return 0;
        }
        dfs(nums,0,0,S);
        return count;
    }
    public void dfs(int[]nums,int i,int sum,int S){
        if(i == nums.length){
            if(sum == S){
                count++;
            }
            return;
        }
        dfs(nums,i+1,sum+nums[i],S);
        dfs(nums,i+1,sum-nums[i],S);
    }
    public static void main(String[]args){
        System.out.println(new TargetSum().findTargetSumWays(new int[]{1,1,1,1,1},3));
    }

}
