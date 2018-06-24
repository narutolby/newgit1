package contest88;

/**
 * We have a string S of lowercase letters, and an integer array shifts.

 Call the shift of a letter, the next letter in the alphabet, (wrapping around so that 'z' becomes 'a').

 For example, shift('a') = 'b', shift('t') = 'u', and shift('z') = 'a'.

 Now for each shifts[i] = x, we want to shift the first i+1 letters of S, x times.

 Return the final string after all such shifts to S are applied.

 Example 1:

 Input: S = "abc", shifts = [3,5,9]
 Output: "rpl"
 Explanation:
 We start with "abc".
 After shifting the first 1 letters of S by 3, we have "dbc".
 After shifting the first 2 letters of S by 5, we have "igc".
 After shifting the first 3 letters of S by 9, we have "rpl", the answer.
 Note:

 1 <= S.length = shifts.length <= 20000
 0 <= shifts[i] <= 10 ^ 9
 */
public class ShiftingLetters {
    public String shiftingLetters(String S, int[] shifts) {
        long[] shiftSum = new long[shifts.length];
        shiftSum[shifts.length-1] = shifts[shifts.length-1];
        for(int i=shifts.length-2;i>=0;i--){
            shiftSum[i] = shiftSum[i+1] + shifts[i];
        }
        char[]chars = S.toCharArray();
        for(int i=0;i<chars.length;i++){
            long asc = ((int)chars[i]) + shiftSum[i]%26;
            chars[i] = asc > (long)'z' ? (char)('a' + asc - (long)'z' - 1) : (char)asc;
        }
        return new String(chars);
    }

    public static void main(String[]args){
        new ShiftingLetters().shiftingLetters("bad",new int[]{10,20,30});
    }

}
