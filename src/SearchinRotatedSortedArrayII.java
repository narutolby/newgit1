/**
 * @author boyang.lby
 * @date 3/19/17
 * @description
 */
public class SearchinRotatedSortedArrayII {
    public boolean search(int[] nums, int target) {
        if(nums == null || nums.length == 0){
            return false;
        }
        convertToSortedArray(nums);
        return _search(nums,target,0,nums.length-1);
    }

    public boolean _search(int[]nums,int target,int left,int right){
        if(target < nums[left] || target > nums[right]){
            return false;
        }

        int mid = left + (right - left)/2;
        if(nums[mid] == target){
            return true;
        }else if(nums[mid] > target){
            return _search(nums,target,left,mid-1);
        }else{
            return _search(nums,target,mid+1,right);
        }

    }

    public void convertToSortedArray(int[]nums){
        int index = 0;
        for(int i=1;i<nums.length;i++){
            if(nums[i] < nums[i-1]){
                index = i;
                break;
            }
        }
        revert(nums,0,index-1);
        revert(nums,index,nums.length - 1);
        revert(nums,0,nums.length-1);
    }

    public void revert(int[]nums,int left,int right){
        while (left < right){
            int tmp = nums[left];
            nums[left] = nums[right];
            nums[right] = tmp;
            left ++;
            right--;
        }
    }
}
