import java.util.Arrays;

/**
 * @author boyang.lby
 * @date 6/5/17
 * @description
 */
public class KdiffPairsinanArray {
    public int findPairs(int[] nums, int k) {
        if(nums == null || nums.length == 0){
            return 0;
        }
        Arrays.sort(nums);
        int ret = 0;
        for(int i=0;i<nums.length;i++){
            if(i != 0 && nums[i] == nums[i-1]){
                continue;
            }
            int l = i+1;
            int r = nums.length - 1;
            while(l<=r){
                int mid = l + (r - l)/2;
                if(nums[i] + k == nums[mid]){
                    ret++;
                    break;
                }else if(nums[i] + k < nums[mid]){
                    r = mid - 1;
                }else{
                    l = mid + 1;
                }
            }
        }
        return ret;
    }
    public static void main(String[]args){
        new KdiffPairsinanArray().findPairs(new int[]{3,1,4,1,5},2);
    }
}
