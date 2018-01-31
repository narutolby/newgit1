package contest69;

import java.util.Arrays;
import java.util.Comparator;
import java.util.PriorityQueue;

/**
 * @author boyang.lby
 * @date 1/28/18
 * @description
 * On a horizontal number line, we have gas stations at positions stations[0], stations[1], ..., stations[N-1], where N = stations.length.

Now, we add K more gas stations so that D, the maximum distance between adjacent gas stations, is minimized.

Return the smallest possible value of D.

Example:

Input: stations = [1, 2, 3, 4, 5, 6, 7, 8, 9, 10], K = 9
Output: 0.500000
Note:

stations.length will be an integer in range [10, 2000].
stations[i] will be an integer in range [0, 10^8].
K will be an integer in range [1, 10^6].
Answers within 10^-6 of the true value will be accepted as correct.
 */
public class MinimizeMaxDistancetoGasStation {
    public double minmaxGasDist(int[] stations, int K) {
        if(stations == null || stations.length == 0 || K == 0){
            return 0.0f;
        }
        int len = stations.length;
        double[]dis = new double[len];
        int[]stc = new int[len];
        Arrays.fill(stc,1);
        PriorityQueue<Integer> priorityQueue = new PriorityQueue<Integer>(new Comparator<Integer>() {
            @Override
            public int compare(Integer o1, Integer o2) {
                return dis[o1]/stc[o1] - dis[o2]/stc[o2] > 0 ? -1 : 1;
            }
        });
        for(int i=1;i<len;i++){
            dis[i-1] = stations[i] - stations[i-1];
            priorityQueue.add(i-1);
        }
        while(K>0){
            Integer t = priorityQueue.poll();
            stc[t]++;
            K--;
            priorityQueue.add(t);
        }
        int minIndex = priorityQueue.peek();
        return dis[minIndex] / stc[minIndex];
    }
}
