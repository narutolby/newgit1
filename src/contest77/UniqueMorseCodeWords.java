package contest77;

import java.util.HashSet;
import java.util.Set;

public class UniqueMorseCodeWords {
    public int uniqueMorseRepresentations(String[] words) {
        String[] mosa = new String[]{".-","-...","-.-.","-..",".","..-.","--.","....","..",".---","-.-",".-..","--","-.","---",".--.","--.-",".-.","...","-","..-","...-",".--","-..-","-.--","--.."};
        Set<String> set = new HashSet<String>();
        for(String word : words){
            char[]chars = word.toCharArray();
            StringBuilder stringBuilder = new StringBuilder();
            for(char c : chars){
                stringBuilder.append(mosa[c-'a']);
            }
            set.add(stringBuilder.toString());
        }
        return set.size();
    }
}
