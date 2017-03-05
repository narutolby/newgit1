import java.util.Arrays;

/**
 * @author boyang.lby
 * @date 1/19/17
 * @description
 */
public class Heaters {
    public static int findRadius(int[] houses, int[] heaters) {

        int ret = Integer.MIN_VALUE;
        Arrays.sort(heaters);
        for(int house : houses){
            int idx = binarySearch(heaters,house);
            if(idx < 0){
                idx = -(idx + 1);
            }
            if(idx == 0){
                ret = Math.max(heaters[idx] - house,ret);
            }else if(idx == heaters.length){
                ret = Math.max(house - heaters[idx-1] ,ret);
            }else{
                ret = Math.min(house - heaters[idx - 1],heaters[idx] - house);
            }
        }
        return ret;

    }

    public static void main(String[]args){
        int[] b = {6};
        int[] a = {1,2,3,5};
        System.out.println(findRadius(b,a));
    }

    public static int binarySearch(int[] a,int v){
        int s = 0;
        int e = a.length - 1;
        while(s<=e){
            int m = (s + e) / 2;
            if(a[m] == v){
                return m;
            }else if(a[m] < v){
                s = m+1;
            }else{
                e = m - 1;
            }
        }
        return -(s + 1);
    }

}
