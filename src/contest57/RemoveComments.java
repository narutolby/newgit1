package contest57;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

/**
 * @author boyang.lby
 * @date 11/5/17
 * @description
 */
public class RemoveComments {
    StringBuffer sb = new StringBuffer();
    boolean isBlock = false;
    boolean isLine = false;
    public List<String> removeComments(String[] source) {
        if(source == null || source.length == 0){
            return Collections.EMPTY_LIST;
        }

        for(int i=0;i<source.length;i++){
            String line = source[i];
            isLine = false;
            for(int j=0;j<line.length();j++){
                if(!isComment() && line.charAt(j) == '/' && j < line.length()-1 && line.charAt(j+1) == '*'){
                    isBlock = true;
                    j++;
                    continue;
                }else if(!isComment() && line.charAt(j) == '/' && j < line.length()-1 && line.charAt(j+1) == '/'){
                    isLine = true;
                    j++;
                    continue;
                }else if(isComment() && line.charAt(j) == '*' && j < line.length()-1 && line.charAt(j+1) == '/'){
                    isBlock = false;
                    j++;
                    continue;
                }else if(!isComment()){
                    sb.append(line.charAt(j));
                }
            }
            if(isLine || !isComment()){
                sb.append('\n');
            }
        }
        String[] ret = sb.toString().split("\n");
        List<String> retList = new ArrayList<>();
        for(String str : ret){
            if(str.equals("")){
                continue;
            }
            retList.add(str);
        }
        return retList;
    }


    public boolean isComment(){
        return isBlock || isLine;
    }


}
