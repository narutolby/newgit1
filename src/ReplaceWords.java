import java.util.Arrays;
import java.util.List;

/**
 * @author boyang.lby
 * @date 9/2/17
 * @description
 */
public class ReplaceWords {
    public String replaceWords(List<String> dict, String sentence) {
        TrieNode root = buildTrieTree(dict);
        String[]words = sentence.split(" ");
        for(int i=0;i<words.length;i++){
            words[i] = findRoot(words[i],root);
        }
        StringBuilder sb = new StringBuilder();
        for(int i=0;i<words.length;i++){
            sb.append(words[i]);
            if(i != words.length-1){
                sb.append(" ");
            }
        }
        return sb.toString();
    }

    public TrieNode buildTrieTree(List<String>dict){
        TrieNode root = new TrieNode();
        for(String word : dict){
            char[]wa = word.toCharArray();
            TrieNode current = root;
            for(int i=0;i<wa.length;i++){
                char c = wa[i];
                if(current.trieNodes[c -'a'] != null){
                    current = current.trieNodes[c - 'a'];
                }else{
                    TrieNode newNode = new TrieNode();
                    newNode.c = c;
                    current.trieNodes[c - 'a'] = newNode;
                    current = newNode;
                }
                if(i == wa.length - 1){
                    current.isLeaf = Boolean.TRUE;
                }
            }
        }
        return root;
    }

    public String findRoot(String word,TrieNode root){
        TrieNode current = root;
        for(int i=0;i<word.length();i++){
            char c = word.charAt(i);
            if(current.trieNodes[c-'a']!=null){
                current = current.trieNodes[c-'a'];
            }else{
                return word;
            }
            if(current.isLeaf){
                return word.substring(0,i+1);
            }
        }
        return word;
    }


    class TrieNode{
        char c;
        TrieNode[]trieNodes = new TrieNode[26];
        boolean isLeaf;
    }

    public static void main(String[]args){
        System.out.println(new ReplaceWords().replaceWords(Arrays.asList("cat", "bat", "rat"),
            "the cattle was rattled by the battery"));
    }
}
