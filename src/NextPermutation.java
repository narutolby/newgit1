/**
 * @author boyang.lby
 * @date 5/17/17
 * @description
 */
public class NextPermutation {
    public void nextPermutation(int[] nums) {
        if(nums == null || nums.length < 2){
            return;
        }
        int i = nums.length - 2;
        while(i>=0 && nums[i]>=nums[i+1]){
            i--;
        }
        if(i >= 0){
            int j = nums.length - 1;
            while (j > i && nums[j] <= nums[i]){
                j--;
            }
            swap(nums,i,j);
        }
        reverse(nums,i+1,nums.length-1);
    }
    public void swap(int[]nums,int i,int j){
        int tmp = nums[i];
        nums[i] = nums[j];
        nums[j] = tmp;
    }
    public void reverse(int[]nums,int i,int j){
        while(i<j){
            swap(nums,i,j);
            i++;
            j--;
        }
    }
}
