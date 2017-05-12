/**
 * @author boyang.lby
 * @date 5/12/17
 * @description
 */
public class ScrambleString {
    public boolean isScramble(String s1, String s2) {
        if(s1 == s2) return true;
        if(s1.equals(s2)) return true;
        if(s1.length() != s2.length()) return false;
        int []letters = new int[26];
        for(int i=0;i<s1.length();i++){
            letters[s1.charAt(i) - 'a'] ++;
            letters[s2.charAt(i) - 'a'] --;
        }
        for(int i=0;i<26;i++){
            if(letters[i] != 0){
                return false;
            }
        }
        int len = s1.length();
        for(int i=1;i<len;i++){
            if(isScramble(s1.substring(0,i),s2.substring(0,i)) && isScramble(s1.substring(i),s2.substring(i)) ) {
                return true;
            }
            if(isScramble(s1.substring(i),s2.substring(0,len-i)) && isScramble(s1.substring(0,i),s2.substring(len-i,len))){
                return true;
            }
        }
        return false;
    }

    public static void main(String[]args){
        new ScrambleString().isScramble("ab","ba");
    }
}
