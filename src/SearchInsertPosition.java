/**
 * @author boyang.lby
 * @date 9/16/17
 * @description
 */
public class SearchInsertPosition {
    public int searchInsert(int[] nums, int target) {
        if(nums == null || nums.length == 0){
            return -1;
        }
        int l = 0,r = nums.length;
        while(l < r){
            int mid = l + (r -l >> 1);
            if(nums[mid]<target) l++;
            else r = mid;
        }
        return r;
    }
}
