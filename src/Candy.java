import java.util.Arrays;
import java.util.Comparator;
import java.util.HashSet;
import java.util.Set;

public class Candy {
    public int candy(int[] ratings) {
        Integer[]index = new Integer[ratings.length];
        int[]count = new int[ratings.length];
        for(int i=0;i<index.length;i++){
            index[i] = i;
        }
        Arrays.sort(index, Comparator.comparingInt(x -> ratings[x]));
        Set<Integer> set = new HashSet<Integer>();
        int ret = 0;
        int len = index.length;
        for(int i=0;i<len;i++){
            int cur = index[i];
            count[cur] = 1;
            if(cur>0 && cur < len - 1){
                if(set.contains(cur - 1) && set.contains(cur + 1)){
                    if(ratings[cur] == ratings[cur - 1] && ratings[cur] == ratings[cur+1]) {
                        count[cur] = 1;
                    }else if(ratings[cur] == Math.max(ratings[cur-1],ratings[cur+1])){
                        count[cur] = Math.min(count[cur-1],count[cur+1]) + 1;
                    }else{
                        count[cur] = Math.max(count[cur-1],count[cur+1]) + 1;
                    }
                }else if(set.contains(cur - 1)){
                    if(ratings[cur] == ratings[cur - 1]){
                       count[cur]  = count[cur - 1];
                    }else{
                        count[cur]  = count[cur - 1] + 1;
                    }
                }else if (set.contains(cur + 1)){
                    if(ratings[cur] == ratings[cur + 1]){
                        count[cur]  = count[cur + 1];
                    }else{
                        count[cur]  = count[cur + 1] + 1;
                    }
                }
            }else if(cur == 0 && cur + 1 < len){
                if(set.contains(cur + 1)) {
                    if (ratings[cur] != ratings[cur + 1]) {
                        count[cur] = count[cur + 1] + 1;
                    }
                }
            }else if(cur == len - 1 && cur > 0){
                if(set.contains(cur - 1)){
                    if (ratings[cur] != ratings[cur - 1]) {
                        count[cur] = count[cur - 1] + 1;
                    }
                }
            }
            set.add(cur);
            ret += count[cur];
        }
        return ret;
    }
    public static void main(String[]args){
        new Candy().candy(new int[]{1,2,4,4,3});
    }
}
