package indeed.two;

import java.util.Arrays;
import java.util.Comparator;
import java.util.HashSet;
import java.util.Scanner;
import java.util.Set;

/**
 * @author boyang.lby
 * @date 5/13/17
 * @description
 */
public class Mixingg {
    static int ret = 0;
    static int tmp = 0;
    public static void main(String[]args){
        Scanner sc = new Scanner(System.in);
        int N = sc.nextInt();
        int K = sc.nextInt();
        int M = sc.nextInt();
        int[][]in = new int[M][3];
        for(int i=0;i<M;i++){
            for(int j=0;j<3;j++){
                in[i][j] = sc.nextInt();
            }
        }
        if(K>=M){
            for(int i=0;i<M;i++){
                ret += in[i][2];
            }
            System.out.println(ret);
            return;
        }
        Arrays.sort(in, new Comparator<int[]>() {
            @Override
            public int compare(int[] o1, int[] o2) {
                return o2[2] - o1[2];
            }
        });
        for(int i = 0;i<M;i++){
            Set<Integer> set = new HashSet<Integer>();
            Set<Integer> set1 = new HashSet<Integer>();
            tmp = 0;
            dfs(in, i, set, set1, K, M, 0, false,null);
            for(int j=i+1;j<M;j++){
                if(!set.contains(j) && !(set1.contains(in[j][0]) || set1.contains(in[j][1]))){
                    dfs(in,j,set,set1,K,M,0,true,new HashSet<Integer>());
                    ret = Math.max(ret,tmp);
                }
            }
        }
        System.out.println(ret);
    }

    public static void dfs(int[][]in,int start,Set<Integer> set,Set<Integer> set1,int k,int m,int tmp1,boolean clean,Set<Integer> set2){

        set.add(start);
        if(set2 == null){
            set2 = set1;
        }
        set2.add(in[start][0]);
        set2.add(in[start][1]);
        tmp1 += in[start][2];

        if(set2.size()== k){
            tmp += tmp1;
            return;
        }
        for(int i=start+1;i<m;i++){
            if(!set.contains(i) && (set2.contains(in[i][0]) || set2.contains(in[i][1])) && !(set1.contains(in[i][0]) && set1.contains(in[i][1]))){
                dfs(in,start+1,set,set1,k,m,tmp1,clean,set2);
                break;
            }
        }
        if(clean){
            set.remove(start);
            set1.remove(in[start][0]);
            set1.remove(in[start][1]);
        }
    }
}
