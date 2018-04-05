package contest78;

/**
 * @author boyang.lby
 * @date 4/3/18
 * @description
 */
public class ExpressiveWords {
    public int expressiveWords(String S, String[] words) {
        if(S == null || S.length() == 0 || words == null || words.length == 0){
            return 0;
        }
        int[]sword = new int[100];
        char[]cword = new char[100];
        char rep = S.charAt(0);
        char[]chars = S.toCharArray();
        int i=0;
        for(char c:chars){
            if(c != rep){
                rep = c;
                i++;
            }
            sword[i]++;
            cword[i] = rep;
        }
        int ret = 0;
        for(String word : words){
            char[]wordChars = word.toCharArray();
            int j = 0;
            int count = 0;
            rep = wordChars[0];
            outer:
            for(char c : wordChars) {
                if(c != rep){
                    if(cword[j] != rep){
                        continue outer;
                    }
                    if(sword[j] < count || (sword[j]>count && sword[j]<3)){
                        continue outer;
                    }
                    rep = c;
                    j++;
                    count=0;
                }
                count++;
            }
            if(cword[j] == rep && (sword[j] == count || (sword[j]>=3 && sword[j]>count)) && i == j){
                ret++;
            }
        }
        return ret;
    }

    public static void main(String[]args){
        new ExpressiveWords().expressiveWords("aaa",new String[]{"aaaa"});
    }
}
