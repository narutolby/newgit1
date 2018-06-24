package contest90;

import java.util.ArrayList;
import java.util.List;

public class BuddyStrings {
    public boolean buddyStrings(String A, String B) {
        int lenB = B.length();
        int lenA = A.length();
        if(lenA != lenB){
            return false;
        }
        int[]table = new int[26];
        List<Integer> diff = new ArrayList<Integer>();
        for(int i=0;i<lenA;i++){
            table[A.charAt(i)-'a']++;
            if(A.charAt(i) != B.charAt(i)){
                diff.add(i);
            }
        }
        if(diff.size() == 0){
            for(int j=0;j<26;j++){
                if(table[j]>1){
                    return true;
                }
            }
            return false;
        }
        if(diff.size() != 2){
            return false;
        }
        if(A.charAt(diff.get(0)) != B.charAt(diff.get(1)) || A.charAt(diff.get(1)) != B.charAt(diff.get(0))){
            return false;
        }
        return true;
    }
}
