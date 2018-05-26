import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;

/**
 * Given an array consists of non-negative integers, your task is to count the number of triplets chosen from the array that can make triangles if we take them as side lengths of a triangle.
 Example 1:
 Input: [2,2,3,4]
 Output: 3
 Explanation:
 Valid combinations are:
 2,3,4 (using the first 2)
 2,3,4 (using the second 2)
 2,2,3
 Note:
 The length of the given array won't exceed 1000.
 The integers in the given array are in the range of [0, 1000].
 */
public class ValidTriangleNumber {
    public int triangleNumber(int[] nums) {
        if(nums == null || nums.length < 3){
            return 0;
        }
        Arrays.sort(nums);
        int result = 0;
        int index = nums.length - 1;
        while(index >=2){
            int left = 0,right = index - 1;
            while(left<right){
                if(nums[left] + nums[right] <= nums[index]){
                    left++;
                }else{
                    result += right - left;
                    right--;
                }
            }
            index--;
        }
        return result;
    }
    public static void main(String[]args){
        new ValidTriangleNumber().triangleNumber(new int[]{ 2,2,3,4});
    }
}

