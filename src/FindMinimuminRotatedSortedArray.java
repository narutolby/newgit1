/**
 * @author boyang.lby
 * @date 5/15/17
 * @description
 */
public class FindMinimuminRotatedSortedArray {
    int ret = Integer.MAX_VALUE;
    public int findMin(int[] nums) {
        if(nums == null || nums.length == 0){
            return 0;
        }
        int l = 0,r = nums.length - 1;
        findMin(nums,l,r);
        return ret;
    }
    public void findMin(int[] nums,int l,int r) {
        while(l<=r){
            int mid  = (l + r)/2;
            if(nums[mid] >= nums[l] && nums[mid] >= nums[r]){
                ret = Math.min(ret,nums[mid]);
                l = mid + 1;
            }else if (nums[mid] > nums[l] && nums[mid] < nums[r] ){
                ret = Math.min(ret,nums[l]);
                break;
            }else{
                ret = Math.min(ret,nums[mid]);
                r = mid - 1;
            }
        }
    }
}
