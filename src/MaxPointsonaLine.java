import java.util.HashMap;
import java.util.Map;
import java.util.TreeMap;

public class MaxPointsonaLine {
    public int maxPoints(Point[] points) {
        if(points == null)    {
            return 0;
        }
        if(points.length <=2){
            return points.length;
        }
        Map<Integer,Map<Integer,Integer>> map = new HashMap<Integer,Map<Integer,Integer>>();
        int ret = 0;
        for(int i=0;i<points.length;i++){
            int overlap = 0;
            map.clear();
            int max = 0;
            for(int j=i+1;j<points.length;j++){
                int x = points[i].x - points[j].x;
                int y = points[i].y - points[j].y;
                if(x == 0 && y == 0){
                    overlap++;
                    continue;
                }
                int cd = getGCD(x,y);
                x = x / cd;
                y = y / cd;
                if(map.containsKey(x)){
                    Map<Integer,Integer> _map = map.get(x);
                    if(_map.containsKey(y)){
                        _map.put(y,_map.get(y) + 1);
                    }else{
                        _map.put(y,1);
                    }
                }else{
                    Map<Integer,Integer> _map = new HashMap<Integer,Integer>();
                    _map.put(y,1);
                    map.put(x,_map);
                }
                max = Math.max(max,map.get(x).get(y));
            }
            ret = Math.max(ret,max+overlap + 1);
        }
        return ret;

    }
    int getGCD(int x,int y){
        if(y == 0){
            return x;
        }
        return getGCD(y,x % y);
    }
    public static void main(String[]args){
        //new MaxPointsonaLine().maxPoints(new Point[]{new Point(0,0),new Point(1,1),new Point(0,0)});
        //System.out.println(new MaxPointsonaLine().getGCD(16 , -4));
        TreeMap<Integer,Integer> treeMap = new TreeMap<Integer,Integer>();
        treeMap.put(1,2);
        treeMap.put(1,2);
        System.out.println(treeMap);
    }
}
class Point {
    int x;
    int y;

    Point() {
        x = 0;
        y = 0;
    }

    Point(int a, int b) {
        x = a;
        y = b;
    }
}
