/**
 * @author boyang.lby
 * @date 4/2/17
 * @description
 */
@Deprecated
public class BestTimetoBuyandSellStockIII {

    int[]heap = new int[]{0,0};
    public int maxProfit(int[] prices) {
        if(prices == null || prices.length == 0){
            return 0;
        }
        int min = prices[0];
        for(int i=1;i<prices.length;i++){
            if(prices[i]<=prices[i-1]){
                addHeap(prices[i-1] - min);
                min = prices[i];
            }
        }
        addHeap(prices[prices.length-1] - min);
        return Math.max(0,Math.max(heap[0] + heap[1],heap[1]));
    }

    public void addHeap(int a){
        if(heap[0]<a){
            heap[0] = a;
        }
        if(heap[1]<heap[0]){
            int tmp = heap[0];
            heap[0] = heap[1];
            heap[1] = tmp;
        }
    }

}
