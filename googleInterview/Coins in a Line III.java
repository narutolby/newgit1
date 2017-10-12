package google.usefullquestion;https://zhengyang2015.gitbooks.io/lintcode/content/coins_in_a_line_iii_396.html?q=

public class Solution {
    /**
     * @param values: an array of integers
     * @return: a boolean which equals to true if the first player will win
     */
    public boolean firstWillWin(int[] values) {
        // write your code here
        if(values == null || values.length == 0){
            return false;
        }

        int n = values.length;
        int[] sum = new int[n + 1];
        sum[0] = 0;
        for(int i = 1; i <= n; i++){
            sum[i] = sum[i - 1] + values[i - 1];
        }
        int[][] dp = new int[n + 1][n + 1];
        boolean[][] visit = new boolean[n + 1][n + 1];

        return search(1, n, sum, dp, visit) > sum[n] / 2;
    }

    private int search(int start, int end, int[] sum, int[][] dp, boolean[][] visit){
        if(visit[start][end]){
            return dp[start][end];
        }

        if(start == end){
            visit[start][end] = true;
            return dp[start][end] = sum[end] - sum[start - 1];
        }

        int max = (sum[end] - sum[start - 1]) - Math.min(search(start, end - 1, sum, dp, visit), search(start + 1, end, sum, dp, visit));

        visit[start][end] = true;
        dp[start][end] = max;
        return dp[start][end];
    }
}