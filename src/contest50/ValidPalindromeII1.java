package contest50;

/**
 * @author boyang.lby
 * @date 9/17/17
 * @description
 */
public class ValidPalindromeII1 {
    public boolean validPalindrome(String s) {
        int l = 0,r = s.length() - 1;
        char[]chars = s.toCharArray();
        while(l < r && chars[l] == chars[r]){
            l++;
            r--;
        }
        if(l>=r){
            return true;
        }
        return valid(chars,l+1,r) || valid(chars,l,r+1);
    }

    public boolean valid(char[]s,int i,int j){
        while(i < j && s[i] == s[j]){
            i++;
            j--;
        }
        return i >= j;
    }
    public static void main(String[]args){
        System.out.println(new ValidPalindromeII1().validPalindrome("deeee"));
    }

}
