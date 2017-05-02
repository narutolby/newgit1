package contest30;

/**
 * @author boyang.lby
 * @date 4/30/17
 * @description
 */
public class SubarraySumEqualsK {
    public int subarraySum(int[] nums, int k) {
        if(nums.length == 0){
            return 0;
        }
        int ret = 0;
        for(int i=1;i<nums.length;i++){
            nums[i] += nums[i-1];
        }

        for(int i=1;i<=nums.length;i++){
            for(int j=i-1;j>=0;j--){
                int gap;
                if(j == 0){
                    gap = nums[i-1];
                }else{
                    gap = nums[i-1] - nums[j-1];
                }
                if(gap == k){
                    ret++;
                }
            }
        }
        return ret;
    }

    public static void main(String[]args){
        int[]a = new int[]{1,2,1,2,1};
        System.out.println(new SubarraySumEqualsK().subarraySum(a,3));
    }
}
