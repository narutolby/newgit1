package contest58;

/**
 * @author boyang.lby
 * @date 11/12/17
 * @description
 */
public class FindPivotIndex {
    public int pivotIndex(int[] nums) {
        if(nums == null || nums.length == 0){
            return -1;
        }
        int len = nums.length;
        int[]left = new int[len];
        left[0] = nums[0];
        int[]right = new int[len];
        right[len - 1] = nums[len-1];
        for(int i=1;i<len;i++){
            left[i] = nums[i] + left[i-1];
        }
        for(int i=len-2;i>=0;i--){
            right[i] = nums[i] + right[i+1];
        }
        for(int i=0;i<len;i++){
            if(left[i] == right[i]){
                return i;
            }
        }
        return -1;
    }
}
