/**
 * @author boyang.lby
 * @date 4/2/17
 * @description
 */
public class ValidPalindrome {
    public boolean isPalindrome(String s) {
        if(s == null || s.length() == 0){
            return true;
        }
        int left = 0;
        int right = s.length() - 1;
        while(left<right){
            while(left<right && !isAlphabet(s.charAt(left))){left++;}
            while(left<right && !isAlphabet(s.charAt(right))){right--;}
            if(toLowerChar(s.charAt(left)) == toLowerChar(s.charAt(right))){
                left++;
                right--;
            }else{
                return false;
            }
        }
        return true;

    }

    public boolean isAlphabet(char a){
        if((a <= 'z' && a >= 'a') || (a>='A' && a <= 'Z') || (a >= '0' && a<= '9')){
            return true;
        }
        return false;
    }

    public char toLowerChar(char a){
        if(a>='A' && a <= 'Z'){
            return (char)(a + 32);
        }
        return a;
    }
}
