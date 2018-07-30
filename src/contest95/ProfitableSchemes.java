package contest95;

/**
 * 帮派里有 G 名成员，他们可能犯下各种各样的罪行。

 第 i 种犯罪会产生 profit[i] 的利润，它要求 group[i] 名成员共同参与。

 让我们把这些犯罪的任何子集称为盈利计划，该计划至少产生 P 的利润。

 有多少种方案可以选择？因为答案很大，所以返回它模 10^9 + 7 的值。



 示例 1：

 输入：G = 5, P = 3, group = [2,2], profit = [2,3]
 输出：2
 解释：
 至少产生 3 的利润，该帮派可以犯下罪 0 和罪 1 ，或仅犯下罪 1 。
 总的来说，有两种方案。
 示例 2:

 输入：G = 10, P = 5, group = [2,3,5], profit = [6,7,8]
 输出：7
 解释：
 至少产生 5 的利润，只要他们犯其中一种罪就行，所以该帮派可以犯下任何罪行 。
 有 7 种可能的计划：(0)，(1)，(2)，(0,1)，(0,2)，(1,2)，以及 (0,1,2) 。


 提示：

 1 <= G <= 100
 0 <= P <= 100
 1 <= group[i] <= 100
 0 <= profit[i] <= 100
 1 <= group.length = profit.length <= 100

*/

/**
 * There are G people in a gang, and a list of various crimes they could commit.

 The i-th crime generates a profit[i] and requires group[i] gang members to participate.

 If a gang member participates in one crime, that member can't participate in another crime.

 Let's call a profitable scheme any subset of these crimes that generates at least P profit, and the total number of gang members participating in that subset of crimes is at most G.

 How many schemes can be chosen?  Since the answer may be very large, return it modulo 10^9 + 7.



 Example 1:

 Input: G = 5, P = 3, group = [2,2], profit = [2,3]
 Output: 2
 Explanation:
 To make a profit of at least 3, the gang could either commit crimes 0 and 1, or just crime 1.
 In total, there are 2 schemes.
 Example 2:

 Input: G = 10, P = 5, group = [2,3,5], profit = [6,7,8]
 Output: 7
 Explanation:
 To make a profit of at least 5, the gang could commit any crimes, as long as they commit one.
 There are 7 possible schemes: (0), (1), (2), (0,1), (0,2), (1,2), and (0,1,2).
 */
public class ProfitableSchemes {
    public int profitableSchemes(int G, int P, int[] group, int[] profit) {
        int mod = 1000000007;
        int n = group.length;

        long[][] dp = new long[G+1][P+1];
        dp[0][0] = 1;
        for(int i = 0;i < n;i++){
            long[][] ndp = new long[G+1][P+1];
            for(int j = G;j >= 0;j--){
                for(int k = P;k >= 0;k--){
                    ndp[j][k] += dp[j][k];
                    if(ndp[j][k] >= mod)ndp[j][k] -= mod;
                    int nk = Math.min(P, k+profit[i]), nj = j+group[i];
                    if(nj <= G){
                        ndp[nj][nk] += dp[j][k];
                        if(ndp[nj][nk] >= mod)ndp[nj][nk] -= mod;
                    }
                }
            }
            dp = ndp;
        }
        long ret = 0;
        for(int j = 0;j <= G;j++){
            ret += dp[j][P];
        }
        return (int)(ret%mod);
    }
}
