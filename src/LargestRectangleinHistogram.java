import java.util.Stack;

/**
 * @author boyang.lby
 * @date 5/15/17
 * @description
 */
public class LargestRectangleinHistogram {
    public int largestRectangleArea(int[] heights) {
        if(heights == null || heights.length == 0){
            return 0;
        }
        int ret = 0;
        Stack<Integer> stack = new Stack<Integer>();
        for(int i=0;i<=heights.length;i++){
            int ch = (i == heights.length ? -1 : heights[i]);
            while(!stack.isEmpty() && ch<=heights[stack.peek()]){
                int h = heights[stack.pop()];
                int w = stack.isEmpty() ? i : i - stack.peek() - 1;
                ret = Math.max(ret,h * w);
            }
            stack.push(i);
        }
        return ret;
    }
}
