package contest73;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;

/**
 * @author boyang.lby
 * @date 2/25/18
 * @description
 */
public class CustomSortString {
    public String customSortString(String S, String T) {
        int[]table = new int[26];
        char[]schars = S.toCharArray();
        for(int i =0;i<schars.length;i++){
            table[schars[i]-'a'] = i;
        }
        char[]tchars = T.toCharArray();
        List<Character> chars = new ArrayList(tchars.length);
        for(char c : tchars){
            chars.add(c);
        }
        Collections.sort(chars, new Comparator<Character>() {
            @Override
            public int compare(Character o1, Character o2) {
                return table[o1-'a'] - table[o2-'a'];
            }
        });
        StringBuilder sb = new StringBuilder();
        for(Character c : chars){
            sb.append(c);
        }
        return sb.toString();
    }
}
