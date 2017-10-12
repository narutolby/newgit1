package google.usefullquestion;

public class Solution {
    public int[] productExceptSelf(int[] nums) {
        if (nums == null || nums.length == 0) {
            return nums;
        }
        int[] res = new int[nums.length];
        res[0] = 1;//initialization
        for (int i = 1; i < nums.length; i++) {//use res[i] to store the product of nums on the left of nums[i]
            res[i] = res[i - 1] * nums[i - 1];//update left product
        }
        int right = 1;//initialization
        for (int i = nums.length - 1; i >= 0; i--) {//use right to store the product of nums on the right of nums[i]
            res[i] *= right;//the final result will be equal to the product of left * right
            right *= nums[i];//update right
        }
        return res;
    }
}
给定数组A，和k，求数组B，满足b=a*a[i+1]*...*a[i+k-1]，同样不让使用除法
我们有A1=[A,B,C,D,E,F,G,H,I,J], 根据A1，可以有A2=[AB, BC, CD, DE, EF, FG,GH,HI,IJ], 根据A2可以有A3=[ABCD,BCDE,CDEF,DEFG,EFGH,FGHI,GHIJ],然后可以有A4=[ABCDEFGH, BCDEFGHI, CDEFGHIJ] ... 依此类推，就像二进制1，2，4，8，16，有了这些，我们就可以随便产色任意组合，比如说K=5=0b(101)，所以结果就是A*BCDE, B*CDEF, C*DEFG, D*EFGH，所以复杂度就降为nlog(k)了。如果再不懂，我也没办法了。。。谢谢