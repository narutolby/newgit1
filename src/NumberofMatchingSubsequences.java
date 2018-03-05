import java.util.*;

/**
 * Given string S and a dictionary of words words, find the number of words[i] that is a subsequence of S.

 Example :
 Input:
 S = "abcde"
 words = ["a", "bb", "acd", "ace"]
 Output: 3
 Explanation: There are three words in words that are a subsequence of S: "a", "acd", "ace".
 Note:

 All words in words and S will only consists of lowercase letters.
 The length of S will be in the range of [1, 50000].
 The length of words will be in the range of [1, 5000].
 The length of words[i] will be in the range of [1, 50].
 */
public class NumberofMatchingSubsequences {
    public int numMatchingSubseq(String S, String[] words) {
        if(S == null || words.length == 0){
            return 0;
        }
        Map<Character,List<Integer>> map = new HashMap<>();
        char[]chars = S.toCharArray();
        for(int i=0;i<chars.length;i++){
            List<Integer> list = map.getOrDefault(chars[i],new ArrayList<>());
            list.add(i);
            map.put(chars[i],list);
        }
        int count = 0;
        for(String word:words){
            char[]wordchars = word.toCharArray();
            if(!map.containsKey(wordchars[0])){
                continue;
            }
            int pre = map.get(wordchars[0]).get(0);
            int j = 1;
            for(j=1;j<wordchars.length;j++)   {
                char c = wordchars[j];
                if(!map.containsKey(c)){
                    break;
                }else{
                    List<Integer> list = map.get(c);
                    int index = Collections.binarySearch(list,pre+1);
                    if(index >= 0){
                        pre = index;
                    }else{
                        index = -index;
                        if(index - 1 > list.size()-1){
                            break;
                        }else{
                            pre = index - 1;
                        }
                    }
                    pre = list.get(pre);
                }
            }
            if(j == wordchars.length){
                count++;
            }
        }
        return count;
    }
    public static void main(String[]args){
        System.out.println(new NumberofMatchingSubsequences().
                numMatchingSubseq("rwpddkvbnnuglnagtvamxkqtwhqgwbqgfbvgkwyuqkdwhzudsxvjubjgloeofnpjqlkdsqvruvabjrikfwronbrdyyjnakstqjac",
                new String[]{"wpddkvbnn","lnagtva","kvbnnuglnagtvamxkqtwhqgwbqgfbvgkwyuqkdwhzudsxvju","rwpddkvbnnugln","gloeofnpjqlkdsqvruvabjrikfwronbrdyyj","vbgeinupkvgmgxeaaiuiyojmoqkahwvbpwugdainxciedbdkos","mspuhbykmmumtveoighlcgpcapzczomshiblnvhjzqjlfkpina","rgmliajkiknongrofpugfgajedxicdhxinzjakwnifvxwlokip","fhepktaipapyrbylskxddypwmuuxyoivcewzrdwwlrlhqwzikq","qatithxifaaiwyszlkgoljzkkweqkjjzvymedvclfxwcezqebx"}));
    }
}
