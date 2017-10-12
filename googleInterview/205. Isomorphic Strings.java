package google.usefullquestion;

public class Solution {
    public boolean isIsomorphic(String s, String t) {
        if(s==null) return true;
        HashMap<Character,Character> map=new HashMap<Character,Character>();
        for(int i=0;i<s.length();i++){
            char a=s.charAt(i);
            char b=t.charAt(i);
            if(map.containsKey(a)){
                if(map.get(a).equals(b))
                    continue;
                else return false;
            }else{
                if(!map.containsValue(b))
                    map.put(a,b);
                else return false;
            }
        }
        return true;
    }
}
public:
    bool isIsomorphic(string s, string t) {
        int m1[256] = {0}, m2[256] = {0}, n = s.size();
        for (int i = 0; i < n; ++i) {
            if (m1[s[i]] != m2[t[i]]) return false;
            m1[s[i]] = i + 1;
            m2[t[i]] = i + 1;
        }
        return true;
    }
};
这样的话用mapping 复杂度太高，需要用另一种思路，也就是将其转化为等价类的基♂上。我定义其为等价类中字典序最小的一个。这样只要转化后的基是否相同即可。. 