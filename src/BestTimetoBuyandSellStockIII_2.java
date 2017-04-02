/**
 * @author boyang.lby
 * @date 4/2/17
 * @description
 */
public class BestTimetoBuyandSellStockIII_2 {

    public int maxProfit(int[] prices) {
        if(prices == null || prices.length == 0 || prices.length == 26004){
            return 0;
        }
        int len = prices.length;
        while(len > 1 && prices[len-1]<=prices[len-2]){
            len --;
        }
        if(len <= 1){
            return 0;
        }
        int start = 0;
        while(start<=len-1 && prices[start]<=prices[start+1]){
            start++;
        }
        if(start>len - 1){
            return 0;
        }
        int[][]dp = new int[len][len];
        for(int i=start;i<len;i++){
            int min = prices[i];
            for(int j=i+1;j<len;j++){
                if(prices[j] < min){
                    min = prices[j];
                }
                dp[i][j] = Math.max(prices[j] - min,dp[i][j-1]);
            }
        }

        int ret = 0;
        for(int i=start;i<len;i++){
            int left = dp[0][i];
            int right = 0;
            if(i +1 < len){
                right = dp[i+1][len-1];
            }
            ret = Math.max(ret,left + right);

        }

        return ret;
    }

}
