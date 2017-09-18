package contest50;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Stack;
import java.util.StringJoiner;

/**
 * @author boyang.lby
 * @date 9/17/17
 * @description
 */
public class G24Game {
    public boolean judgePoint24(int[] nums) {
        int n = 24;
        Arrays.sort(nums);
        for(int i=0;i<n;i++){
            String carry = String.valueOf(nums[0]);
            if(calculate(nums,carry,1,0,0)){
                return true;
            }else{
                nextPermutation(nums);
            }
        }
        return false;
    }
    public boolean calculate(int[]nums,String carry,int s,int l,int p){
        if(l == 3 && p == l && s == nums.length){
            System.out.println(carry);
            return false;
        }
        char[]oper = new char[]{'*','/','+','-'};
        for(char c : oper){
            String str = null;
            if(s == nums.length){
                str = "";
            }else{
                String.valueOf(nums[s]);
                str = c + str;
            }
            boolean ret = calculate(nums,carry + str,s+1,l,p);
            if(l<3){
                ret = calculate(nums ,"(" + carry + str,s+1,l+1,p);
            }
            if(p<l){
                ret = calculate(nums,carry + str + ")",s+1,l,p+1);
            }
        }
        boolean ret = calculate(nums,carry + '*' + nums[s],s+1,l,p) || calculate(nums,carry + '+' + nums[s],s+1,l,p)
            || calculate(nums,carry + '/' + nums[s],s+1,l,p) || calculate(nums,carry + '-' + nums[s],s+1,l,p);
        if(l < 3){
            carry = "(" + carry;
             ret = calculate(nums,carry + '*' + nums[s],s+1,l+1,p) || calculate(nums,carry + '+' + nums[s],s+1,l+1,p)
                || calculate(nums,carry + '/' + nums[s],s+1,l+1,p) || calculate(nums,carry + '-' + nums[s],s+1,l+1,p);
        }
        if(p < l){
            ret = calculate(nums,carry + '*' + nums[s] + ')',s+1,l,p+1) || calculate(nums,carry + '+' + nums[s] + ')',s+1,l,p+1)
                || calculate(nums,carry + '/' + nums[s] + ')',s+1,l,p+1) || calculate(nums,carry + '-' + nums[s] + ')',s+1,l,p+1);
        }
        return ret;
    }

    public double cal(String a){
        char sign = '+';
        Stack<Double> stack = new Stack<Double>();
        stack.push(0D);
        for(int i=0;i<a.length();){
            if(a.charAt(i) == '+' || a.charAt(i) == '-' || a.charAt(i) == '*' || a.charAt(i) == '/'){
                sign = a.charAt(i);
                i++;
                continue;
            }
            int i0 = i;
            while(i0<a.length() && isdigit(a.charAt(i0))){
                i0++;
            }
            Double d = Double.valueOf(a.substring(i,i0));
            if(sign == '+'){
                stack.push(stack.pop() + d);
            }else if(sign == '-'){
                stack.push(stack.pop() - d);
            }else if(sign == '*'){
                stack.push(stack.pop() * d);
            }else{
                stack.push(stack.pop() / d);
            }
            i = i0;
        }
        double ret = 0D;
        for(int i=0;i<stack.size();i++){
            ret += stack.get(i);
        }
        return ret;
    }

    public boolean isdigit(char c){
        return c >= '0' && c<= '9';
    }

    public void nextPermutation(int []nums){
        int j = nums.length - 2;
        while (j>= 0 && nums[j] >= nums[j+1]){
            j--;
        }
        if(j>=0){
            int i = nums.length - 1;
            while(i>=0 && nums[i]<=nums[j]){
                i--;
            }
            swap(nums,j,i);
        }
        reverse(nums,j+1,nums.length - 1);
    }

    public void swap(int[]nums,int i,int j){
        int tmp = nums[i];
        nums[i] = nums[j];
        nums[j] = tmp;
    }
    public void reverse(int[]nums,int i,int j){
        while(i<j){
            swap(nums,i,j);
            i++;
            j--;
        }
    }
    public static void main(String[]agrs){
        int[] n = new int[]{1,3,4,6};
        Arrays.sort(n);
        System.out.println(new G24Game().judgePoint24(n));
        new G24Game().nextPermutation(n);
        for(int i=0;i<n.length;i++){
            System.out.print(n[i]);
        }
        System.out.println(new G24Game().cal("1+2/2"));
    }
}
