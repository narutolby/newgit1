package contest81;

import java.util.Arrays;
import java.util.Comparator;

/**
 * @author boyang.lby
 * @date 4/22/18
 * @description
 */
public class ShortEncodingofWords1 {


    public int minimumLengthEncoding(String[] words) {
        if(words.length  == 1){
            return words[0].length() + 1;
        }
        int tmp = 0;
        int ret = 0;
        Arrays.sort(words, new Comparator<String>() {
            @Override
            public int compare(String o1, String o2) {
                return o1.length() - o2.length();
            }
        });
        for(int i=0;i<words.length;i++){
            ret += words[i].length() + 1;
            for(int j=i+1;j<words.length;j++){
                if(words[j].endsWith(words[i])){
                    tmp += words[i].length() + 1;
                    break;
                }
            }
        }
        return ret - tmp;
    }

    public static void main(String[]args){
        System.out.println(new ShortEncodingofWords1().minimumLengthEncoding(new String[] {"time", "atime", "btime"}));
    }
}
