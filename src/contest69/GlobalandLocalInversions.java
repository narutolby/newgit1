package contest69;

import java.util.Set;
import java.util.TreeSet;

/**
 * @author boyang.lby
 * @date 1/28/18
 * @description
 */
public class GlobalandLocalInversions {
    public boolean isIdealPermutation(int[] a) {
        int n = a.length;
        int[] ft = new int[n+3];
        int inv = 0;
        for(int i = n-1;i >= 0;i--){
            inv += sumFenwick(ft, a[i]);
            addFenwick(ft, a[i], 1);
        }
        for(int i = 0;i < n-1;i++){
            if(a[i] > a[i+1])inv--;
        }
        return inv == 0;
    }

    public int sumFenwick(int[] ft, int i)
    {
        int sum = 0;
        for(i++;i > 0;i -= i&-i)sum += ft[i];
        return sum;
    }

    public void addFenwick(int[] ft, int i, int v)
    {
        if(v == 0 || i < 0)return;
        int n = ft.length;
        for(i++;i < n;i += i&-i)ft[i] += v;
    }

    public static void main(String[]args){
        new GlobalandLocalInversions().isIdealPermutation(new int[]{1,2,0});
    }
}
