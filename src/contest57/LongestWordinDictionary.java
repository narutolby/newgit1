package contest57;

import java.util.Arrays;
import java.util.Comparator;
import java.util.HashSet;
import java.util.Set;

/**
 * @author boyang.lby
 * @date 11/5/17
 * @description
 */
public class LongestWordinDictionary {
    public String longestWord(String[] words) {
        String ret = "";
        if(words.length == 1){
            return ret;
        }
        int maxLen = 0;
        Set<String> set = new HashSet<String>();
        for(String word:words){
            set.add(word);
        }
        for(int i=0;i<words.length;i++){
            boolean flag = true;
            for(int j=1;j<=words[i].length()-1;j++){
                String sub = words[i].substring(0,j);
                if(!set.contains(sub)){
                    flag = false;
                    break;
                }
            }
            if(flag){
                if(words[i].length() > maxLen){
                    ret = words[i];
                    maxLen = words[i].length();
                }else if(words[i].length() == maxLen){
                    ret = words[i].compareTo(ret) > 0 ? ret : words[i];
                }
            }
        }
        return ret;
    }
    public static void main(String[]args){
        new LongestWordinDictionary().longestWord(
            new String[] {"yo","ew","fc","zrc","yodn","fcm","qm","qmo","fcmz","z","ewq","yod","ewqz","y"});
    }
}
