package contest61;

import java.util.Stack;

/**
 * @author boyang.lby
 * @date 12/3/17
 * @description
 */
public class DailyTemperatures {
    public int[] dailyTemperatures(int[] temperatures) {
        Stack<Integer> stack = new Stack<Integer>();
        int[]ret = new int[temperatures.length];
        for(int i=0;i<temperatures.length;i++){
            while(!stack.isEmpty() && temperatures[stack.peek()] < temperatures[i]){
                ret[stack.peek()] = i -stack.pop();
            }
            stack.push(i);
        }
        return ret;
    }

    public static void main(String[]args){
        new DailyTemperatures().dailyTemperatures1(new int[]{55,38,53,81,61,93,97,32,43,78});
    }

    public int[] dailyTemperatures1(int[] t) {
        int n = t.length;
        int[] e = enumNextWall(t);
        for (int i = 0;i < n;i++){
            e[i] = e[i] == n ? 0 : e[i] - i;
        }
        return e;
    }

    public int[] enumNextWall(int[] a)
    {
        int n = a.length;
        int[] L = new int[n];
        for(int i = n-1;i >= 0;i--){
            L[i] = i+1;
            while(L[i] < n && a[L[i]] <= a[i])L[i] = L[L[i]];
        }
        return L;
    }
}
