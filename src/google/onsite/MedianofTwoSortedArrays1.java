package google.onsite;

/**
 * @author boyang.lby
 * @date 9/18/17
 * @description
 */
public class MedianofTwoSortedArrays1 {
    public double findMedianSortedArrays(int[] nums1, int[] nums2) {
        int len = nums1.length + nums2.length;
        if(len % 2 == 0){
            int mid1 = kth(nums1,0,nums2,0,(len-1)/2);
            int mid2 = kth(nums1,0,nums2,0,len/2);
            return ((double)mid1 + (double)mid2) / 2;
        }else{
            int mid1 = kth(nums1,0,nums2,0,(len-1)/2);
            return (double)mid1;
        }

    }

    public int kth(int[]nums1,int n1,int[]nums2,int n2,int k){
        if(nums1.length-n1 > nums2.length-n2){
            return kth(nums2,n2,nums1,n1,k);
        }
        if(n1 == nums1.length){
            return nums2[n2+k-1];
        }
        if(k==1){
            return nums1[n1] < nums2[n2] ? nums1[n1] : nums2[n2];
        }
        int l1 = Math.min(n1 + k/2 -1,nums1.length - 1);
        int l2 = k - (l1 - n1 + 1) + n2 - 1;
        if(nums1[l1]<nums2[l2]){
            return kth(nums1,l1+1,nums2,n2,k - (l1 - n1 + 1));
        }else if(nums1[l1]>nums2[l2]){
            return kth(nums1,n1,nums2,l2+1,k - (l2 - n2 + 1));
        }
        return nums1[l1];
    }
}
