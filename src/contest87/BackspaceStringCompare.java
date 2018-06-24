package contest87;

/**
 * Given two strings S and T, return if they are equal when both are typed into empty text editors. # means a backspace character.

 Example 1:

 Input: S = "ab#c", T = "ad#c"
 Output: true
 Explanation: Both S and T become "ac".
 Example 2:

 Input: S = "ab##", T = "c#d#"
 Output: true
 Explanation: Both S and T become "".
 Example 3:

 Input: S = "a##c", T = "#a#c"
 Output: true
 Explanation: Both S and T become "c".
 Example 4:

 Input: S = "a#c", T = "b"
 Output: false
 Explanation: S becomes "c" while T becomes "b".
 Note:

 1 <= S.length <= 200
 1 <= T.length <= 200
 S and T only contain lowercase letters and '#' characters.
 Follow up:

 Can you solve it in O(N) time and O(1) space?
 */
public class BackspaceStringCompare {
    public boolean backspaceCompare(String S, String T) {
        return this.convert(S).equals(convert(T));
    }

    public String convert(String S){
       char[]chars = S.toCharArray();
       int j=-1;
       for(int i=0;i<chars.length;i++){
           char c = S.charAt(i);
           if(c == '#'){
               if(j>=0){
                   j--;
               }
           }else{
               j++;
               chars[j] = chars[i];
           }
       }
       return new String(chars,0,j+1);
    }

    public static void main(String[]args){
        System.out.println(new BackspaceStringCompare().convert("ab##"));
    }
}
