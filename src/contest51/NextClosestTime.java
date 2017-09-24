package contest51;

import java.util.TreeSet;

/**
 * @author boyang.lby
 * @date 9/24/17
 * @description
 */
public class NextClosestTime {
    public String nextClosestTime(String time) {
        TreeSet<Integer> treeSet = new TreeSet<Integer>();
        int[]times = new int[4];
        int j = 0;
        for(int i=0;i<time.length();i++){
            if(time.charAt(i) == ':'){
                continue;
            }
            times[j] = time.charAt(i) - '0';
            treeSet.add(time.charAt(i) - '0');
            j++;
        }
        StringBuilder sb = new StringBuilder();
        if(help(times,treeSet,0)){
            for(int i=0;i<times.length;i++){
                sb.append(times[i]);
                if(i==1){
                    sb.append(":");
                }
            }
        }else{
            sb.append(treeSet.first()).append(treeSet.first()).append(":").append(treeSet.first()).append(treeSet.first());
        }
        return sb.toString();
    }

    public boolean help(int[]r,TreeSet<Integer>t,int i){
        boolean ret = false;
        if(i != 3){
            ret = help(r,t,i+1);
            if(ret){
                return ret;
            }
        }
        int v = r[i];
        if(t.last() == v){
            return false;
        }
        int higher = t.higher(v);
        if(i == 0){
            if(higher>2){
                return false;
            }
        }else if (i == 1){
            if(r[0] == 2){
                if(higher>3){
                    return false;
                }
            }else{
                if(higher > 9){
                    return false;
                }
            }
        }else if(i == 2){
            if(higher > 5){
                return false;
            }
        }else if(i == 3){
            if(higher > 9){
                return false;
            }
        }
        r[i] = higher;
        for(int j=i+1;j<=3;j++){
            r[j] = t.first();
        }
        return true;
    }
    public static void main(String[]args){
        System.out.println(new NextClosestTime().nextClosestTime("13:55"));
    }
}
