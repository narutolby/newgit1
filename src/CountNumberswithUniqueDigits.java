/**
 * Given a non-negative integer n, count all numbers with unique digits, x, where 0 ≤ x < 10n.

 Example:
 Given n = 2, return 91. (The answer should be the total numbers in the range of 0 ≤ x < 100, excluding [11,22,33,44,55,66,77,88,99])

 Credits:
 Special thanks to @memoryless for adding this problem and creating all test cases.
 */
public class CountNumberswithUniqueDigits {
    public int countNumbersWithUniqueDigits(int n) {
        if(n == 0){
            return 0;
        }
        int a10n = 10,a9n_1 = 0;
        int ret = 0;
        for(int i=1;i<=Math.min(n,10);i++){
            ret += a10n - a9n_1;
            a10n = a10n * (10 - i);
            a9n_1 =  a9n_1 == 0 ? 1: a9n_1;
            a9n_1 = a9n_1 * (9 - (i-1));
        }
        return ret;
    }

    public static void main(String[]args){
        System.out.println(new CountNumberswithUniqueDigits().countNumbersWithUniqueDigits(3));
    }
}
