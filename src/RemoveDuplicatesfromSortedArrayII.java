/**
 * @author boyang.lby
 * @date 6/8/17
 * @description
 */
public class RemoveDuplicatesfromSortedArrayII {
   public int removeDuplicates(int[] nums) {
        int i = 0;
        for(int n:nums){
            if(i<2 || n > nums[i-2]){
                nums[i++] = n;
            }
        }
        return i;
    }

}
