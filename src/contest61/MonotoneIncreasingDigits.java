package contest61;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Map;
import java.util.Stack;
import java.util.TreeMap;

/**
 * @author boyang.lby
 * @date 12/3/17
 * @description
 */
public class MonotoneIncreasingDigits {
    public int monotoneIncreasingDigits(int N) {
        if(N<10){
            return N;
        }else if(N == 10){
            return 9;
        }else{
            String str = String.valueOf(N);
            char[]chars = str.toCharArray();
            int len = chars.length;
            int i = len -1;
            while(i>0 && chars[i] >= chars[i-1]){
                i--;
            }
            if(i == 0){
                return N;
            }else{
                int index = i;
                for(int j=i;j>0;j--){
                    if(chars[j]<chars[j-1]){
                        chars[j] = '9';
                        chars[j-1] = (char)(chars[j-1] - 1);
                        index = j;
                    }
                }
                int start = 0;
                while(chars[start] == '0'){
                    start ++;
                }
                StringBuilder sb = new StringBuilder();
                for(i=start;i<chars.length;i++){
                    if(i>=index){
                        sb.append('9');
                    }else{
                        sb.append(chars[i]);
                    }
                }
                return Integer.valueOf(sb.toString());
            }
        }
    }
    public static void main(String[]args){
        new MonotoneIncreasingDigits().monotoneIncreasingDigits(148594);
    }
}
