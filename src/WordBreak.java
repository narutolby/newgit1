import java.util.HashSet;
import java.util.List;
import java.util.Set;

/**
 * @author boyang.lby
 * @date 9/23/17
 * @description
 */
public class WordBreak {
    public boolean wordBreak(String s, List<String> wordDict) {
        Set<String> set = new HashSet<String>();
        set.addAll(wordDict);
        if(set.contains(s)){
            return true;
        }
        boolean[]dp = new boolean[s.length() + 1];
        dp[0] = true;
        for(int i =1;i<=s.length();i++){
            for(int j=i;j>=1;j--){
                if(dp[j-1] && set.contains(s.substring(j-1,i))){
                    dp[i] = true;
                    break;
                }
            }
        }
        return dp[s.length()];
    }

}
