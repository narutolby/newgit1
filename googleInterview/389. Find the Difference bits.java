package google.usefullquestion;

public class Solution {
    public char findTheDifference(String s, String t) {
        int n = t.length();
    	char c = t.charAt(n - 1);
    	for (int i = 0; i < n - 1; ++i) {
    		c ^= s.charAt(i);
    		c ^= t.charAt(i);
    	}
    	return c;
    }
}
Follow up: 我在写第一个的时候念叨了句好像可以binary search，面试官让我详细思考下，我想了下发现要no consecutive same character才行，他让我描述了下做法
binary search 找中间是否相等
Follow up2: 如果要检查两个字符串是否满足Problem描述的关系要怎么做，我说了找出第一个不同后继续扫描，他让我写了代码