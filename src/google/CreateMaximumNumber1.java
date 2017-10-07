package google;

import java.util.Comparator;
import java.util.Iterator;
import java.util.Map;
import java.util.TreeMap;
import java.util.TreeSet;

/**
 * @author boyang.lby
 * @date 10/5/17
 * @description
 * Given two arrays of length m and n with digits 0-9 representing two numbers. Create the maximum number of length k <= m + n from digits of the two. The relative order of the digits from the same array must be preserved. Return an array of the k digits. You should try to optimize your time and space complexity.

Example 1:
nums1 = [3, 4, 6, 5]
nums2 = [9, 1, 2, 5, 8, 3]
k = 5
return [9, 8, 6, 5, 3]

Example 2:
nums1 = [6, 7]
nums2 = [6, 0, 4]
k = 5
return [6, 7, 6, 0, 4]

Example 3:
nums1 = [3, 9]
nums2 = [8, 9]
k = 3
return [9, 8, 9]
 */
public class CreateMaximumNumber1 {
    public int[] maxNumber(int[] nums1, int[] nums2, int k){
        int len1 = nums1.length;
        int len2 = nums2.length;
        int[]ret = new int[k];
        for(int i=Math.max(0,k-len2);i<=k && i<=len1;i++){
            int[]maxArray1 = maxArray(nums1,i);
            int[]maxArray2 = maxArray(nums2,k-i);
            int[]mergeArray = merge(maxArray1,maxArray2);
            ret = max(ret,mergeArray,0,0)?ret:mergeArray;
        }
        return ret;
    }

    public int[]merge(int[]n1,int[]n2){
        int[]ret = new int[n1.length + n2.length];
        int i = 0,j=0,k=0;
        while(k < n2.length + n1.length){
            if(max(n1,n2,i,j)){
                ret[k++] = n1[i++];
            }else {
                ret[k++] = n2[j++];
            }
        }
        return ret;
    }

    public boolean max(int[]n1,int[]n2,int i,int j){
        while(i<n1.length && j< n2.length && n1[i] == n2[j]){
            i++;j++;
        }
        return j == n2.length ||(i<n1.length && n1[i] > n2[j]);
    }

    public int[]maxArray(int[]nums,int k){
        int[]ret = new int[k];
        if(k == 0) {
            return ret;
        }
        for(int i=0,j=0;i<nums.length ;i++){
            while(i-j < nums.length - k && j>0 && ret[j-1]<nums[i]){
                j--;
            }
            if(j < k){
                ret[j] = nums[i];
                j++;
            }
        }
        return ret;
    }

    public static void main(String[]args){
        new CreateMaximumNumber1().maxNumber(new int[]{3,4,6,5},new int[]{9,1,2,5,8,3},5);
        //new CreateMaximumNumber1().maxNumber(new int[]{6, 7},new int[]{6,0,4},5);
        //new CreateMaximumNumber1().maxNumber(new int[]{8, 9},new int[]{3,9},3);
        //new CreateMaximumNumber1().maxNumber(new int[]{5,5,1},new int[]{4,0,1},3);
        //new CreateMaximumNumber1().maxNumber(new int[]{5,1,0},new int[]{5,2,1},3);
    }
}
