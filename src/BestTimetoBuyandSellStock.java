/**
 * @author boyang.lby
 * @date 4/2/17
 * @description
 */
public class BestTimetoBuyandSellStock {
    public int maxProfit(int[] prices) {
        if(prices == null || prices.length == 0){
            return 0;
        }
        int ret = 0;
        int min = Integer.MAX_VALUE;
        for(int i = 0;i<prices.length;i++){
            min = Math.min(min,prices[i]);
            ret = Math.max(prices[i]-min,ret);
        }
        return ret;
    }
}
