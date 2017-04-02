/**
 * @author boyang.lby
 * @date 4/2/17
 * @description
 */
public class BestTimetoBuyandSellStockII {
    public int maxProfit(int[] prices) {
        if(prices == null || prices.length == 0){
            return 0;
        }
        int min = prices[0];
        int ret = 0;
        for(int i=1;i<prices.length;i++){
            if(prices[i]<=prices[i-1]){
                ret += prices[i-1] - min;
                min = prices[i];
            }
        }
        ret += prices[prices.length-1] - min;
        return ret;
    }
}
