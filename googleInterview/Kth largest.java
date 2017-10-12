package google.usefullquestion;array, 是以max-heap形式的。比如100， 40， 20， 2, 30， 15， 9 等等... 返回第k大的数。不能改变array的顺序
// minHeap: O(nlogk) time and O(k) space
public class Solution {
    public int findKthLargest(int[] nums, int k) {
        if (nums == null || nums.length == 0 || k < 1) {
            return 0;
        }
        Queue<Integer> minHeap = new PriorityQueue<>();
        for (int i : nums) {
            if (minHeap.size() < k) {
                minHeap.offer(i);
                continue;
            }
            if (i > minHeap.peek()) {
                minHeap.poll();
                minHeap.offer(i);
            }
        }
        return minHeap.poll();
    }
}