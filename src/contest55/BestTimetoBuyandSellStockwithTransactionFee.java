package contest55;

/**
 * @author boyang.lby
 * @date 10/22/17
 * @description
 */
public class BestTimetoBuyandSellStockwithTransactionFee {
    public int maxProfit(int[] prices, int fee) {
        if(prices == null || prices.length == 0){
            return 0;
        }
        int len = prices.length;
        int[]dp = new int[len];
        int max = 0-prices[0];
        for (int i = 1; i <len; i++) {
            dp[i] = Math.max(prices[i] + max - fee,dp[i-1]);
            max = Math.max(max,0 - prices[i] + dp[i-1]);
        }
        return dp[prices.length - 1];

    }

    public static void main(String[]args){
        System.out.println(new BestTimetoBuyandSellStockwithTransactionFee().maxProfit(new int[] {1,4,6,2,8,3,10,14} ,3));
    }


}
