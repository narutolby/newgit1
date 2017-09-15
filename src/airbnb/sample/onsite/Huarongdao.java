package airbnb.sample.onsite;

import java.util.HashSet;
import java.util.LinkedList;
import java.util.Queue;
import java.util.Set;

/**
 * @author boyang.lby
 * @date 9/12/17
 * @description
 */
public class Huarongdao {
    Set<String> set = new HashSet<String>();
    class Mirror{
        char[][]m;
        Mirror p;
        @Override
        public String toString(){
            StringBuilder sb = new StringBuilder();
            if(m == null){
                return "";
            }
            for(int i=0;i<m.length;i++){
                for(int j=0;j<m[0].length;j++){
                    sb.append(m[i][j]);
                }
            }
            return sb.toString();
        }

    }
    public void  build(char[][]m){
        if(m == null || m.length == 0 || m[0].length == 0){
            return;
        }
        int x = 0,y = 0;
        for(int i=0;i<m.length;i++){
            for(int j=0;j<m[0].length;j++){
               if(m[i][j] == ' '){
                   x = i;
                   y = j;
                   break;
               }
            }
        }
        bfs(m,x,y);

    }

    public void bfs(char[][]m,int x ,int y){
        Queue<Point> queue = new LinkedList<Point>();
        Queue<Mirror> queue1 = new LinkedList<Mirror>();
        Mirror mirror = new Mirror();
        mirror.p = new Mirror();
        mirror.m = m;
        queue.add(new Point(x,y));
        queue1.add(mirror);
        int[]xx = {1,-1,0,0};
        int[]yy = {0,0,1,-1};
        while(!queue.isEmpty()){
            Point p = queue.poll();
            mirror  = queue1.poll();
            if(mirror == null) continue;
            for(int i=0;i<4;i++){
                int xxx = p.x + xx[i];
                int yyy = p.y + yy[i];
                if(xxx>=0 && xxx<m.length && yyy>=0 && yyy<m[0].length){
                    Mirror mirror1 = new Mirror();
                    mirror1.m = swap(p,new Point(xxx,yyy),mirror.m);
                    if(set.contains(mirror1.toString())){
                        continue;
                    }else{
                        set.add(mirror1.toString());
                    }
                    mirror1.p = mirror;
                    queue.add(new Point(xxx,yyy));
                    if(check(mirror1.m)){
                        print(mirror1);
                        break;
                    }
                    queue1.add(mirror1);
                }
            }
        }
    }

    void print(Mirror mirror){
        while(mirror != null){
            if(mirror.m == null) break;
            for(int i=0;i<mirror.m.length;i++){
                for(int j=0;j<mirror.m[0].length;j++){
                    System.out.print(mirror.m[i][j]);
                }
                System.out.println();
            }
            System.out.println();
            mirror = mirror.p;
        }
    }

    public boolean check(char[][]m){
        for(int i=0;i<m.length;i++){
            for(int j=0;j<m[0].length;j++){
                if(i == m.length - 1 && j ==m[0].length - 1){
                    if(m[i][j] != ' '){
                        return false;
                    }
                }else{
                    if(m[i][j] != String.valueOf(i*m[0].length + j + 1).toCharArray()[0]){
                        return false;
                    }
                }
            }
        }
        return true;
    }

   char[][] swap(Point p1,Point p2,char[][]m) {
       char[][]mirro = new char[m.length][m[0].length];
       for(int i=0;i<m.length;i++){
           for(int j=0;j<m[0].length;j++){
               mirro[i][j] = m[i][j];
           }
       }
       char tmp = mirro[p2.x][p2.y];
       mirro[p2.x][p2.y] = mirro[p1.x][p1.y];
       mirro[p1.x][p1.y] = tmp;
       return mirro;
   }

    class Point{
        int x = 0;
        int y = 0;
        public Point(int x,int y){
            this.x = x;
            this.y = y;
        }
    }

    public static void main(String[]args){
        char[][] m = new char[][]{
            {' ','1','3'},
            {'4','2','5'},
            {'6','7','8'}
        };
        new Huarongdao().build(m);
    }
}
