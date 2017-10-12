package google.usefullquestion;

public class Solution {
    public boolean isOneEditDistance(String s, String t) {
        for (int i = 0; i < Math.min(s.length(), t.length()); i++) { 
        	if (s.charAt(i) != t.charAt(i)) {
        		if (s.length() == t.length()) // s has the same length as t, so the only possibility is replacing one char in s and t
        			return s.substring(i + 1).equals(t.substring(i + 1));
    			else if (s.length() < t.length()) // t is longer than s, so the only possibility is deleting one char from t
    				return s.substring(i).equals(t.substring(i + 1));	        	
    			else // s is longer than t, so the only possibility is deleting one char from s
    				return t.substring(i).equals(s.substring(i + 1));
        	}
        }       
        //All previous chars are the same, the only possibility is deleting the end char in the longer one of s and t 
        return Math.abs(s.length() - t.length()) == 1;        
    }
}
预处理：trie tree
public class Solution {
    public boolean isOneEditDistance(String s, HashSet dict) {
        for(String ss:dict){
            if(ss.length()!=s.length()) continue;
            for (int i = 0; i <s.length(); i++) { 
            	if (s.charAt(i) != t.charAt(i)) {
                    return s.substring(i + 1).equals(t.substring(i + 1));
            	}
            }      
        }     
    }
}
389
有两个string，一个比另外一个多一个char，其他都一样，如"hello"和"hepllo"，要找出这个char
    简单的一次扫描， 注意要考虑这个char在字符串末尾
    Follow up2: 如果要检查两个字符串是否满足Problem描述的关系要怎么做，我说了找出第一个不同后继续扫描，他让我写了代码.
    Follow up3: 如果可以打乱顺序怎么解，如"hello"和"lelloh"，我说用bucket记录下出现次数，他让我写了.
    Follow up4: 如果字典太大，用bucket开销太大怎么办，我说用sort再用follow up2里的方法，他没让我写代码
    Follow up5: 如果不能改变字符串怎么办？亦或
        
快排worst case   O(n^2)  最好和平均O(nlogn)
        稳定的NlogN方法（我说heapsort）
        然后我嘴贱地说merge sort，他问我空间复杂度，我一想发现需要额外的NlogN space赶紧纠正。