package contest32;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.Comparator;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

/**
 * @author boyang.lby
 * @date 5/14/17
 * @description
 */
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

public class ErecttheFence {
    public List<Point> outerTrees(Point[] points) {
        List<Point> ret = new ArrayList<Point>();
        if (points == null || points.length == 0) {
            return ret;
        }
        Point root = null;
        int y = Integer.MAX_VALUE;
        int index = 0;
        for (int i=0;i<points.length;i++) {
            Point point = points[i];
            if (point.y < y) {
                root = point;
                y = point.y;
                index = i;
            }
        }
        final Point tmp = root;

        Point tmp1 = points[0];
        points[0] = points[index];
        points[index] = tmp1;

        Arrays.sort(points,1,points.length, new Comparator<Point>() {
            @Override
            public int compare(Point o1, Point o2) {
              return ErecttheFence.this.compare(tmp,o1,o2);
            }
        });
        Set<Point> set = new HashSet<Point>();
        for(int i=0;i<points.length;i++){
            Point tmp2 = null;
            if(tmp2 != null && tmp2 != points[i]){
                continue;
            }
            for(int j=0;j<points.length;j++){
               if(i == j) {
                   continue;
               }
               if(tmp2 == null) {
                   tmp2 = points[j];
               }else{
                   if(compare(points[i],tmp2,points[j])<0){
                       tmp2 = points[j];
                   }
               }
            }
            set.add(tmp2);
        }
        ret.addAll(set);
        return ret;
    }

    int cross(Point p0, Point p1, Point p2) //计算叉积  p0p1 X p0p2
    {
        return (p1.x - p0.x) * (p2.y - p0.y) - (p1.y - p0.y) * (p2.x - p0.x);
    }
    double dis(Point p1,Point p2)  //计算 p1p2的 距离
    {
        return Math.sqrt((double)(p2.x - p1.x) * (p2.x-p1.x)+(p2.y-p1.y)*(p2.y-p1.y));
    }

    public int compare(Point tmp,Point o1, Point o2) {
        int t =  cross(tmp, o1, o2);
        if(t > 0){ return t;}
        else if(t == 0 && dis(tmp,o1)<dis(tmp,o2)){
            return 1;
        }else {
            return -1;
        }

    }
    public static void main(String[]args){
        Point[]points = new Point[6];
        Point p = new Point(1,1);
        Point p1 = new Point(2,2);
        Point p2 = new Point(2,0);
        Point p3 = new Point(2,4);
        Point p4 = new Point(3,3);
        Point p5 = new Point(4,2);
        points[0] = p;
        points[1] = p1;
        points[2] = p2;
        points[3] = p3;
        points[4] = p4;
        points[5] = p5;
        new ErecttheFence().outerTrees(points);
    }
}

