package contest58;

import java.util.HashMap;
import java.util.Map;

/**
 * @author boyang.lby
 * @date 11/12/17
 * @description
 */
public class MinimumWindowSubsequence {
    public String minWindow(String S, String T) {
        int[]tt = new int[26];
        int[]st = new int[26];
        for(int i=0;i<T.length();i++){
            tt[T.charAt(i) - 'a']++;
        }
        int count = T.length();
        int s = 0;
        String ret = "";
        int min = Integer.MAX_VALUE;
        Map<String,Boolean> map = new HashMap<>();
        for(int i=0;i<=S.length();i++){
            if(count == 0){
                while(tt[S.charAt(s) - 'a'] == 0 || (st[S.charAt(s) - 'a'] > tt[S.charAt(s) - 'a']) && isSubsequence(T,S.substring(s+1,i))){
                    st[S.charAt(s) - 'a']--;
                    s++;
                }
                if(i - s < min){
                    String tmp = S.substring(s,i);
                    if(isSubsequence(T,tmp)){
                        ret = tmp;
                        min = i - s;
                    }
                }
            }
            if(i == S.length()){
                break;
            }
            char c = S.charAt(i);
            if(st[c - 'a'] < tt[c- 'a']){
                st[c - 'a']++;
                count --;
            }else {
                st[c - 'a']++;
            }
        }
        return ret;
    }

    public boolean isSubsequence(String s, String t) {
        int sLength=s.length();     //s的长度
        int tLength=t.length(); //t的长度

        int sIndex=0;       //记录找到了s的第几个字符
        int tIndex=0;       //记录遍历到了t的第几个字符

        while(tIndex<tLength){       //这里用到的贪心算法，就是在t中越先找到 s的字符 那么在t中就更容易的找到 s剩下的字符
            if(sIndex<sLength&&(s.charAt(sIndex)==t.charAt(tIndex))){        //找到一个相等的字符就查找s的下一个字符
                sIndex++;
            }
            tIndex++;
        }
        if(sIndex==sLength){        //从前往后在t中找到了s的所有字符 。所以存在
            return true;
        }
        else{
            return false;
        }
    }

    public static void main(String[]args){
        new MinimumWindowSubsequence().minWindow("fgrqsqsnodwmxzkzxwqegkndaa" ,"kzed");
    }



    public String minWindow1(String S, String T) {
        int[][] next = new int[S.length()][26];
        for(int i = 0; i < S.length(); ++ i) {
            for(int c = 'a'; c <= 'z'; ++ c) {
                if(i == 0 || c == S.charAt(i)) {
                    int k = i+1;
                    for(; k < S.length() && S.charAt(k) != c; ++ k) ;
                    next[i][c - 'a'] = k;
                }
                else {
                    next[i][c - 'a'] = next[i-1][c - 'a'];
                }
            }
        }
        int mw = Integer.MAX_VALUE;
        int start = 0;
        for(int i = 0; i < S.length(); ++ i) {
            if(S.charAt(i) != T.charAt(0)) {
                continue;
            }
            int pos = i;
            for(int k = 1; k < T.length(); ++ k) {
                pos = next[pos][T.charAt(k) - 'a'];
                if(pos >= S.length()) {
                    break;
                }
            }
            if(pos < S.length()) {
                int w = pos - i + 1;
                if(w < mw) {
                    mw = w;
                    start = i;
                }
            }
        }
        if(mw != Integer.MAX_VALUE) {
            return S.substring(start, start + mw);
        }
        else {
            return "";
        }
    }


    public String minWindow2(String S, String T) {
        char[] s = S.toCharArray();
        int[][] next = makeFatNext(s, 'a', 'z');
        int minlen = 9999999;
        int best = -1;
        outer:
        for(int i = 0;i < s.length;i++){
            int j = i;
            for(char c : T.toCharArray()){
                int ne = next[c-'a'][j];
                if(ne > s.length)continue outer;
                j = ne;
            }
            if(j-i < minlen){
                minlen = j-i;
                best = i;
            }
        }
        if(best == -1)return "";
        return S.substring(best, best + minlen);
    }

    public int[][] makeFatNext(char[] s, char inf, char sup)
    {
        int n = s.length;
        int[][] next = new int[sup-inf+1][n+1];
        for(int i = 0;i < sup-inf+1;i++)next[i][n] = n+1;
        for(int i = s.length-1;i >= 0;i--){
            for(int j = 0;j < sup-inf+1;j++)next[j][i] = next[j][i+1];
            next[s[i]-inf][i] = i+1;
        }
        return next;
    }
}
