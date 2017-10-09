package google;

/**
 * 309
 * Say you have an array for which the ith element is the price of a given stock on day i.

 Design an algorithm to find the maximum profit. You may complete as many transactions as you like (ie, buy one and sell one share of the stock multiple times) with the following restrictions:

 You may not engage in multiple transactions at the same time (ie, you must sell the stock before you buy again).
 After you sell your stock, you cannot buy stock on next day. (ie, cooldown 1 day)
 Example:

 prices = [1, 2, 3, 0, 2]
 maxProfit = 3
 transactions = [buy, sell, cooldown, buy, sell]
 */
public class BestTimetoBuyandSellStockwithCooldown {
    public int maxProfit(int[] prices) {
        if(prices == null || prices.length == 0){
            return 0;
        }
        int ret = 0;
        int len = prices.length;
        int maxk = len % 3 ==0 ? len / 3 : len / 3 + 1;
        int[][]dp = new int[maxk+1][len];
        for(int k = 1;k<=maxk;k++) {
            int max = 0-prices[0];
            for (int i = 1; i < len; i++) {
                dp[k][i] = Math.max(dp[k][i],Math.max(prices[i] + max,dp[k][i-1]));
                ret = Math.max(ret,dp[k][i]);
                if(i <= 1){
                    max = Math.max(max,0-prices[i]);
                }else {
                    max = Math.max(max,0-prices[i] + dp[k-1][i-2]);
                }
            }
        }
        return ret;
    }
    // wrong
    public int maxProfit(int[] prices,int s) {
        if(s >= prices.length - 1){
            return 0;
        }
        int start = s;
        int ret = 0;
        while(start+1<prices.length && prices[start+1]<=prices[start]){
           start++;
        }
        if(start + 1 == prices.length){
            return 0;
        }
        int end = start + 1;
        while(end+1<prices.length && prices[end+1]>prices[end]){
            end++;
        }
        if(end - start == 1){
            return prices[end] - prices[start] + maxProfit(prices,end+2);
        }
        ret = Math.max(prices[end] - prices[start] + maxProfit(prices,end+2),prices[end-1] - prices[start]+maxProfit(prices,end+1));
        return ret;
    }
    public static void main(String[]args){
        System.out.println(new BestTimetoBuyandSellStockwithCooldown().maxProfit(new int[]{6,1,6,4,3,0,2}));
        System.out.println(new BestTimetoBuyandSellStockwithCooldown().maxProfit(new int[]{1, 2, 3, 0, 2}));
        System.out.println(new BestTimetoBuyandSellStockwithCooldown().maxProfit(new int[]{6,1,3,2,4,7}));
        System.out.println(new BestTimetoBuyandSellStockwithCooldown().maxProfit(new int[]{1,4,2}));
    }

}
