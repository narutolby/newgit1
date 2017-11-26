import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.Stack;

public class SummaryRanges1 {
    public List<String> summaryRanges(int[] nums) {
        if(nums == null || nums.length == 0){
            return Collections.EMPTY_LIST;
        }
        Stack<Integer> stack = new Stack<Integer>();
        List<String> retList = new ArrayList<>();
        for(int i : nums){
            if(stack.isEmpty()){
                stack.push(i);
            }else{
                if(i != stack.peek() + 1){
                    refreshStack(stack,retList);
                }
                stack.push(i);
            }
        }
        refreshStack(stack,retList);
        return retList;
    }

    public void refreshStack(Stack<Integer> stack,List<String> retList){
        if(stack.empty()){
            return;
        }
        if(stack.get(0) == stack.peek()){
            retList.add(String.valueOf(stack.get(0)));
        }else{
            retList.add(String.valueOf(stack.get(0)) + "->" + stack.peek());
        }
        stack.clear();
    }
}
