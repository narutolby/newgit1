package contest54;

import java.util.HashMap;
import java.util.Map;

/**
 * Given an array of integers nums and a positive integer k, find whether it's possible to divide this array into k non-empty subsets whose sums are all equal.

 Example 1:
 Input: nums = [4, 3, 2, 3, 5, 2, 1], k = 4
 Output: True
 Explanation: It's possible to divide it into 4 subsets (5), (1, 4), (2,3), (2,3) with equal sums.
 */
public class PartitiontoKEqualSumSubsets {
    public boolean canPartitionKSubsets(int[] nums, int k) {
        int sum = 0;
        for(int i:nums){
            sum += i;
        }
        if(sum % nums.length != 0){
            return false;
        }
        int unit = sum / nums.length;
        return false;
    }

    public void dfs(int[]nums,int unit,int sum){

    }


//    class Solution {
//        public:
//        bool dfs(vector<int> &nums, int idx, vector<int> &sums, int n, int &k, int &sum) {
//            if (n == idx) {
//                return true;
//            }
//            // cout << "idx = " << idx << endl;
//            // for (int i = 0; i < k; i++) {
//            //     cout << "i, sums[i] = " << i << ", " << sums[i] << endl;
//            // }
//            for (int i = 0; i < k; i++) {
//                if (sums[i] + nums[idx] > sum) {
//                    continue;
//                }
//                sums[i] += nums[idx];
//                if (dfs(nums, idx + 1, sums, n, k, sum)) {
//                    return true;
//                }
//                sums[i] -= nums[idx];
//            }
//            return false;
//        }
//
//        bool canPartitionKSubsets(vector<int>& nums, int k) {
//            int sum = 0;
//            for (int i : nums) {
//                sum += i;
//            }
//            if (sum % k != 0) {
//                return false;
//            }
//            sum /= k;
//            sort(nums.begin(), nums.end());
//            reverse(nums.begin(), nums.end());
//            vector<int> sums(k);
//            return dfs(nums, 0, sums, nums.size(), k, sum);
//        }
//    };

}
