package contest69;

/**
 * @author boyang.lby
 * @date 1/28/18
 * @description
 * 用树状数组来做
 */
public class GlobalandLocalInversions1 {
    int[]c;
    public boolean isIdealPermutation(int[] a) {
        if(a == null || a.length == 0 || a.length == 1){
            return true;
        }
        c = new int[a.length + 1];
        int l = 0;
        int g = 0;
        update(a[0]+1,1);
        for(int i=1;i<a.length;i++){
            if(a[i]<a[i-1]){
                l++;
            }
            g+=(sum(a.length)-sum(a[i]+1));
            update(a[i]+1,1);
        }
        return l == g;
    }

    public int lowbit(int x){
        return x & (-x);
    }

    public void update(int i ,int a){
        while(i<c.length){
            c[i]+=a;
            i+=lowbit(i);
        }
    }

    public int sum(int i){
        int ret = 0;
        while(i>=1){
            ret += c[i];
            i -= lowbit(i);
        }
        return ret;
    }

    public static void main(String[]args){
        new GlobalandLocalInversions1().isIdealPermutation(new int[]{1,2,0});
    }
}
