package google.usefullquestion;O(log(min(n, m)))
https://discuss.leetcode.com/topic/3367/share-my-iterative-solution-with-o-log-min-n-m
public class Solution {
    public double findMedianSortedArrays(int[] nums1, int[] nums2) {
        int n = nums1.length;
        int m = nums2.length;
        // the following call is to make sure len(A) <= len(B).
        // yes, it calls itself, but at most once, shouldn't be
        // consider a recursive solution
        if (n > m)
            return findMedianSortedArrays(nums2, nums1);
    
        // now, do binary search
        int k = (n + m - 1) / 2;
        int l = 0, r = Math.min(k, n); // r is n, NOT n-1, this is important!!
        while (l < r) {
            int midA = (l + r) / 2;
            int midB = k - midA;
            if (nums1[midA] < nums2[midB])
                l = midA + 1;
            else
                r = midA;
        }
        /*
        ***&****
        ********&******
            binary search 后，结果只能在
        ***&&&&&
        &&&&&&&&&******中，这就是binary search的意义
        */
        // after binary search, we almost get the median because it must be between
        // these 4 numbers: A[l-1], A[l], B[k-l], and B[k-l+1] 
    
        // if (n+m) is odd, the median is the larger one between A[l-1] and B[k-l].
        // and there are some corner cases we need to take care of.
        int a = Math.max(l > 0 ? nums1[l - 1] : Integer.MIN_VALUE, k - l >= 0 ? nums2[k - l] : Integer.MIN_VALUE);
        if (((n + m) & 1) == 1)
            return (double) a;
    
        // if (n+m) is even, the median can be calculated by 
        //      median = (max(A[l-1], B[k-l]) + min(A[l], B[k-l+1]) / 2.0
        // also, there are some corner cases to take care of.
        int b = Math.min(l < n ? nums1[l] : Integer.MAX_VALUE, k - l + 1 < m ? nums2[k - l + 1] : Integer.MAX_VALUE);
        return (a + b) / 2.0;
    }
}