package contest50;

/**
 * @author boyang.lby
 * @date 9/17/17
 * @description
 */
public class ValidPalindromeII1 {
    public boolean validPalindrome(String s) {
        int l = 0,r = s.length() - 1;
        while(l < r){
            if(s.charAt(l) != s.charAt(r)){
                break;
            }
            l++;
            r--;
            if(l >= r){
                return  true;
            }
        }
        int ll = l,rr = r;
        l++;
        boolean ret = true;
        while(l < r){
            if(s.charAt(l) != s.charAt(r)){
                ret = false;
                break;
            }
            l++;
            r--;
        }
        if(ret){
            return ret;
        }
        l = ll;
        r = rr - 1;
        while(l < r){
            if(s.charAt(l) != s.charAt(r)){
               return false;
            }
            l++;
            r--;
        }
        return true;
    }

    public boolean vlid(String s){
       if(s == null){
            return false;
        }
        if(s.length() == 0){
            return true;
        }
        int l = 0,r = s.length() - 1;
        while(l < r){
            if(s.charAt(l) == s.charAt(r)){
                l++;
                r--;
            }else{
                return false;
            }
        }
        return true;
    }
    public static void main(String[]args){
        System.out.println(new ValidPalindromeII1().validPalindrome("deeee"));
    }

}
