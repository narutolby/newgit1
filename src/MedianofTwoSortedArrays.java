public class MedianofTwoSortedArrays {
    public double findMedianSortedArrays(int[] nums1, int[] nums2) {
        int len1 = nums1.length,len2 = nums2.length;
        if(len1 == 0){
            return len2 % 2 == 0 ? ((double)nums2[len2/2] + (double)nums2[len2/2-1]) / 2 : (double)nums2[len2/2 - 1];
        }
        if(len2 == 0){
            return len1 % 2 == 0 ? ((double)nums1[len1/2] + (double)nums1[len1/2-1]) / 2 : (double)nums1[len1/2 - 1];
        }
        int len = len1 + len2;
        int median = len % 2 == 0 ? len / 2 : len / 2 + 1;
        int l = 0,r = len1;
        int mid1 = -1;
        int mid2 = -1;
        while(l<r){
            int mid = l + (r - l) / 2;
            int other = median - 1 - mid;
            if((other>0 && nums2[other]>=nums1[mid] && nums1[mid]>=nums2[other-1]) || other == 0 ){
                mid1 = nums1[mid];
                if(mid + 1 <= len1 - 1){
                    mid2 = nums1[mid1+1]<nums2[other] ? nums1[mid+1]:nums2[other];
                }else{
                    mid2 = nums2[other];
                }
                if(len % 2 != 0) return mid1;
                else return ((double)mid1 + (double)mid2)/2;
            }else if(nums1[mid]>nums2[other]){
                r = mid -1;
            }else{
                l = mid + 1;
            }
        }
        if(mid1 == -1){
            l = 0;r = len2;
            while(l<r){
                int mid = l + (r - l) / 2;
                int other = median - 1 - mid;
                if((other>0 && nums1[other]>=nums2[mid] && nums2[mid]>=nums1[other-1]) || other == 0 ){
                    mid1 = nums2[mid];
                    if(mid + 1 <= len2 - 1){
                        mid2 = nums2[mid1+1]<nums1[other] ? nums2[mid+1]:nums1[other];
                    }else{
                        mid2 = nums1[other];
                }
                    if(len % 2 != 0) return mid1;
                    else return ((double)mid1 + (double)mid2)/2;
                }else if(nums2[mid]>nums1[other]){
                    r = mid -1;
                }else{
                    l = mid + 1;
                }
            }
        }
        return -1D;
    }
}
