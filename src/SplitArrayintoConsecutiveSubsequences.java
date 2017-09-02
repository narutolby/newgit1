import java.util.ArrayList;
import java.util.HashMap;
import java.util.HashSet;
import java.util.List;
import java.util.Map;
import java.util.PriorityQueue;
import java.util.Set;

/**
 * @author boyang.lby
 * @date 8/15/17
 * @description
 */
public class SplitArrayintoConsecutiveSubsequences {
    public boolean isPossible(int[] nums) {
        if(nums == null || nums.length == 0){
            return false;
        }
        Map<Integer,Integer> freMap = new HashMap<Integer,Integer>();
        Set<Integer> end = new HashSet<Integer>();
        PriorityQueue<Integer> priorityQueue = new PriorityQueue<Integer>();
        for(int i : nums){
            if(freMap.containsKey(i)){
                freMap.put(i,freMap.get(i)+1);
            }else{
                freMap.put(i,1);
                priorityQueue.add(i);
            }
        }
        List<Integer> duplicate = new ArrayList<Integer>();
        while(!priorityQueue.isEmpty()){
            Integer pre = priorityQueue.poll();
            freMap.put(pre,freMap.get(pre)-1);
            if(freMap.get(pre)>0){
                duplicate.add(pre);
            }
            if(end.contains(pre-1)){
                end.remove(pre - 1);
                end.add(pre);
                if(priorityQueue.isEmpty() && !duplicate.isEmpty()){
                    priorityQueue.addAll(duplicate);
                    duplicate.clear();
                }
                continue;
            }
            Integer count = 1;
            while(!priorityQueue.isEmpty() && priorityQueue.peek() == pre + 1){
                Integer ele = priorityQueue.poll();
                freMap.put(ele,freMap.get(ele)-1);
                pre = ele;
                if(freMap.get(ele)>0){
                    duplicate.add(ele);
                }
                count++;
                if(count == 3){
                    end.add(pre);
                    count = 0;
                }
            }
            if(count < 3){
                return false;
            }
            priorityQueue.addAll(duplicate);
            duplicate.clear();
        }
        return true;
    }
    public static void main(String[]args){
        System.out.println(new SplitArrayintoConsecutiveSubsequences().isPossible(new int[] {4,5,6,7,7,8,8,9,10,11}));
    }
}
