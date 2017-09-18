import java.util.*;
import java.util.concurrent.atomic.AtomicInteger;

public class SlidingWindowMedian {
    public double[] medianSlidingWindow(int[] nums, int k) {
        if(nums == null || nums.length == 0 || k == 0){
            return new double[0];
        }
        int len = nums.length;
        double[]ret = new double[len - k + 1];
        int[]window = Arrays.copyOfRange(nums,0,k);
        Arrays.sort(window);
        int mid1 = (k - 1) / 2,mid2 = k / 2;
        int index = 0;
        ret[index++] = ((double)window[mid1] + (double)window[mid2])/2;
        for(int i=k;i<len;i++){
            int r = Arrays.binarySearch(window,nums[i-k]);
            while(r+1<k && window[r+1]<nums[i]){
                window[r] = window[r+1];
                r++;
            }
            while(r-1>=0 && window[r-1]>nums[i]){
                window[r] = window[r-1];
                r--;
            }
            window[r] = nums[i];
            ret[index++] = ((double)window[mid1] + (double)window[mid2])/2;
        }
        return ret;
    }
    public static void main(String[]args){
        AtomicInteger atomicInteger = new AtomicInteger();
        Queue<Integer> queue = new LinkedList<>();
        List<Integer>[] adj = new List[0];
        TreeSet treeSet = new TreeSet();
    }
}
