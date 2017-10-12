package google.usefullquestion;有很多candidates，他们的votes上有对应的timestamp，首先求出the most vote getter。我是先写出class定义，然后用hashmap做的。
follow up是求出前k了vote getter，我直接用max heap

    
1,用hashmap存每个出现的频率，找最大的
    类似这个代码：
    hashmap存频率，然后维持count最大的
    public char hepler(String s) {
        HashMap<Character,Integer> map=new HashMap<>();
        int count=0;
        char cc='0';
        for(int i=0;i<s.length();i++){
            char c=s.charAt(i);
            Character.toLowerCase(c); 不区分大小写
            if(!Character.isLetterOrDigit(c)) continue;去掉其他字符
            if(c==' ') continue; 去掉空格加这个
            if(map.containsKey(c)){
                map.put(c,map.get(c)+1);
            }else map.put(c,1);
            if(map.get(c)>count){
                count=map.get(c);
                cc=c;
            }
        }
        return cc;
    }
2，前k个，用priorityqueue维持前k个
    类似代码：
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