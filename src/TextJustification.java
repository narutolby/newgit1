import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

/**
 * @author boyang.lby
 * @date 9/11/17
 * @description
 */
public class TextJustification {
    public List<String> fullJustify(String[] words, int maxWidth) {
        if(words == null || words.length == 0){
            return Collections.EMPTY_LIST;
        }
        int len = 0;
        List<String> wordsList = new ArrayList<String>();
        List<String> retList = new ArrayList<String>();
        for(int j=0;j<words.length;j++){
            String word = words[j];
            if(word.length() + len + wordsList.size() > maxWidth){
                int spaces = maxWidth - len;
                int size = wordsList.size();
                int avg = spaces / (size == 1 ? 1 : size- 1);
                int mod = spaces % (size == 1 ? 1 : size - 1);
                StringBuilder sb = new StringBuilder();
                for(int i=0;i<wordsList.size();i++){
                    sb.append(wordsList.get(i));
                    if(i == 0 || i < wordsList.size() - 1){
                        for(int n=0;n<avg;n++){
                            sb.append(" ") ;
                        }
                    }
                    if(mod != 0){
                        sb.append(" ") ;
                        mod--;
                    }
                }
                len = word.length();
                wordsList.clear();
                wordsList.add(word);
                retList.add(sb.toString());
            }else{
                wordsList.add(word);
                len += word.length();
            }
        }
        StringBuilder sb = new StringBuilder();
        for(int i=0;i<wordsList.size();i++){
            sb.append(wordsList.get(i));
            if(i<wordsList.size()-1){
                sb.append(" ");
            }
        }
        while(sb.length() < maxWidth){
            sb.append(" ");
        }
        retList.add(sb.toString());
        return retList;
    }
}
