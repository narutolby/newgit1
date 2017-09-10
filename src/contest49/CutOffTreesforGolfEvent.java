package contest49;

import java.util.*;

public class CutOffTreesforGolfEvent {
    static class Point{
        int x,y,v,l;
        Point(int x,int y,int v,int l){
            this.x = x;
            this.y = y;
            this.v = v;
            this.l = l;
        }
    }
    public int cutOffTree(List<List<Integer>> forest) {
        if(forest == null || forest.size() == 0){
            return 0;
        }
        List<Point> pointList = new ArrayList<Point>();
        for(int i=0;i<forest.size();i++){
            List<Integer> line = forest.get(i);
            for(int j=0;j<line.size();j++){
                if(line.get(j) > 1){
                    pointList.add(new Point(i,j,line.get(j),0));
                }
            }
        }
        Collections.sort(pointList, new Comparator<Point>() {
            @Override
            public int compare(Point o1, Point o2) {
                return o1.v - o2.v;
            }
        });
        int ret = 0;
        for(int i = 0;i<pointList.size();i++)     {
            int tmp = 0;
            if(i == 0){
                tmp = bfs(new Point(0,0,forest.get(0).get(0),0),pointList.get(i),forest);
            }else{
                tmp = bfs(pointList.get(i-1),pointList.get(i),forest);
            }
            if(tmp == -1){
                return -1;
            }else{
                ret += tmp;
            }
        }
        return ret;
    }
    public int bfs(Point s,Point e,List<List<Integer>> forest) {
        if(s.v == 0){
            return -1;
        }
        Queue<Point> queue = new LinkedList<Point>();
        queue.add(s);
        int[][] d = new int[forest.size()][forest.get(0).size()];
        int I = 999999999;
        d[s.x][s.y] = 0;
        for(int i = 0;i < forest.size();i++) {
            Arrays.fill(d[i],I);
        }
        int[]xx = {0,0,1,-1};
        int[]yy = {1,-1,0,0};
        while(!queue.isEmpty()){
            Point point = queue.poll();
            if(point.x == e.x && point.y == e.y){
                return point.l;
            }
            for(int j=0;j<4;j++){
                int xxx = point.x + xx[j];
                int yyy = point.y + yy[j];
                if(xxx>=0 && xxx<forest.size() && yyy>=0 && yyy<forest.get(0).size() && d[xxx][yyy] == I
                        && forest.get(xxx).get(yyy) != 0){
                    queue.add(new Point(xxx,yyy,forest.get(xxx).get(yyy),point.l + 1));
                    d[xxx][yyy] = d[point.x][point.y] + 1;
              }
            }

        }
        return -1;
    }
    public static void main(String[]args){
        List<List<Integer>> list = new ArrayList<>();
        list.add(Arrays.asList(63750247,40643210,95516857,89928134,66334829,58741187,76532780,45104329));
        list.add(Arrays.asList(3219401,97566322,9135413,75944198,93735601,33923288,50116695,83660397));
        list.add(Arrays.asList(64460750,53045740,31903386,78155821,90848739,38769489,99349027,85982891));
        list.add(Arrays.asList(30628785,51077683,70534803,67460877,91077770,74197235,5696362,91459886));
        list.add(Arrays.asList(56105195,82479378,45937951,52817583,2768114,43329099,28189138,21418604));
        System.out.println(new CutOffTreesforGolfEvent().cutOffTree(list));
    }
}
