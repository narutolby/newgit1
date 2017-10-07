package google;

/**
 * @author boyang.lby
 * @date 10/4/17
 * @description
 */
public class Hindex {
    int ret = 0;
    public int hIndex(int[] c) {
        if(c == null || c.length == 0){
            return 0;
        }
        quickSelect(c,0,c.length-1);
        return ret;
    }
    public void quickSelect(int[]c,int l,int r){
        if(l>r){
            return;
        }
        int len = c.length;
        if(l == r){
            ret = Math.max(Math.min(len-r,c[r]),ret);
            return;
        }
        int p = partition(c,l,r);
        if(len - p  == c[p]){
            ret = c[p];
        }else if(len - p > c[p]){
            ret = Math.max(ret,c[p]);
            quickSelect(c,p+1,r);
        }else {
            ret = Math.max(ret,len-p);
            quickSelect(c,l,p-1);
        }
    }

    public int partition(int[]c,int l,int r){

        int x = c[r];
        int p = l - 1;
        for(int i=l;i<=r-1;i++){
            if(c[i]<x){
                swap(c,++p,i);
            }
        }
        swap(c,p+1,r);
        return p+1;
    }
    public void swap(int[]c,int i,int j){
        int tmp = c[i];
        c[i] = c[j];
        c[j] = tmp;
    }
    public static void main(String[]args){
        System.out.println(new Hindex().hIndex(new int[]{2,1}));
    }
}
