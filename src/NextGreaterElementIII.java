/**
 * @author boyang.lby
 * @date 7/26/17
 * @description
 */
public class NextGreaterElementIII {
    public int nextGreaterElement(int n) {
        if(n < 10){
            return -1;
        }
        String strn = String.valueOf(n);
        char[]stra = strn.toCharArray();
        int i;
        for(i = stra.length - 1;i>0;i--){
            if(stra[i]>stra[i-1]){
                break;
            }
        }
        if(i == 0){
            return -1;
        }
        int j = stra.length - 1;
        i--;
        while(stra[j]<=stra[i]){
            j--;
        }
        swap(stra,i,j);
        reverse(stra,i+1,stra.length-1);
        long ret = Long.valueOf(new String(stra));
        if(ret > Integer.MAX_VALUE){
            return -1;
        }
        return (int)ret;

    }
    public void swap(char[]str,int i,int j){
        char tmp = str[i];
        str[i] = str[j];
        str[j] = tmp;
    }
    public void reverse(char[]str,int i,int j){
        while(i<j){
            swap(str,i,j);
            i++;
            j--;
        }
    }
}
