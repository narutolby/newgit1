package google.usefullquestion;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Random;

public class Solution {
	
	public static void main(String[] args) {
		int res=helper(4);
		System.out.println(res);
    }
	public static int helper(int n){
		int len=1;
        int max=0;
		while(n!=1){
			if(n%2==0){
				n=n/2;
			}else{
				n=n*3+1;
			}
            max=Math.max(max,n);
			len++;
		}
		return len;
	}
}
没看明白下面说的是啥：
第二个小问题：
就是求出第一问的所有loop过的数的最大数。

两个loop 两个函数一起是n方复杂度.鏈枃鍘熷垱鑷�1point3acres璁哄潧

1然后让优化，提示让我用memorization . 1point 3acres 璁哄潧
然后我说用hashmap
2 算结束 继续一个followup 说是over的
就是给出一个length，然后让返回所有这个length的数值，其实就是一个inverse的function. 我没答出来，面试官说的。。。其实想到了dfs 没敢说，不知道对不对。。
