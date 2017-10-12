package google.onsite20171011;

import java.util.Comparator;
import java.util.PriorityQueue;

public class AddStationToMinMaxLength {

    class Interval{
        private int width;
        private int count;
        public Interval(int width,int count){
            this.width = width;
            this.count = count;
        }
    }

    public int addGasStation(int k,int[]stations){
        if(k == 0 || stations == null || stations.length == 0 ){
            return 0;
        }
        PriorityQueue<Interval> pq = new PriorityQueue<Interval>(new Comparator<Interval>(){
            @Override
            public int compare(Interval i1,Interval i2){
                return i2.width / i2.count - i1.width / i1.count;
            }
        });

        for(int i=0;i<stations.length;i++){
            pq.add(new Interval(stations[i],1));
        }
        while(k > 0){
            Interval max = pq.poll();
            max.count ++;
            pq.add(max);
            k--;
        }
        return pq.poll().width;

    }
    public static void main(String[]args){
        System.out.println(new AddStationToMinMaxLength().addGasStation(3,new int[]{2,3,4}));
    }

}
