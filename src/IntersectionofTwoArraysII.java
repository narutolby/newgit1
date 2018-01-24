import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * Given two arrays, write a function to compute their intersection.

 Example:
 Given nums1 = [1, 2, 2, 1], nums2 = [2, 2], return [2, 2].

 Note:
 Each element in the result should appear as many times as it shows in both arrays.
 The result can be in any order.
 Follow up:
 What if the given array is already sorted? How would you optimize your algorithm?
 What if nums1's size is small compared to nums2's size? Which algorithm is better?
 What if elements of nums2 are stored on disk, and the memory is limited such that you cannot load all elements into the memory at once?
 */
public class IntersectionofTwoArraysII {
    public int[] intersect(int[] nums1, int[] nums2) {
        if(nums1.length == 0 || nums2.length == 0){
            return new int[]{};
        }
        Arrays.sort(nums1);
        Arrays.sort(nums2);
        List<Integer> list = new ArrayList<Integer>();
        for(int m=0,n=0;m<nums1.length &&  n<nums2.length;){
            if(nums1[m] == nums2[n]){
                list.add(nums1[m]);
                m++;
                n++;
            }else if(nums1[m] < nums2[n]){
                m++;
            }else{
                n++;
            }
        }
        int[]ret = new int[list.size()];
        for(int i=0;i<list.size();i++){
            ret[i] = list.get(i);
        }
        return ret;
    }
}
