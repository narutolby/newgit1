package contest58;

import java.util.ArrayList;
import java.util.List;

/**
 * @author boyang.lby
 * @date 11/12/17
 * @description
 */
public class SplitLinkedListinParts {
    public ListNode[] splitListToParts(ListNode root, int k) {
        if(root == null){
            return new ListNode[0];
        }
        int len = 0;
        ListNode p = root;
        List<ListNode> list = new ArrayList<>();
        while(p != null){
            list.add(p);
            p = p.next;
        }
        len = list.size();
        ListNode[] ret = new ListNode[k];
        if(len <= k){
            for(int i=0;i<len;i++){
                ret[i] = list.get(i);
                ret[i].next = null;
            }
            return ret;
        }else{
            int count = len / k;
            int mod = len % k;
            int cidex = 0;
            for(int i=0;i<k;i++){
                int c = 0;
                if(mod != 0){
                    c++;
                    mod --;
                }
                int cc = c + count;
                ret[i] = list.get(cidex);
                list.get(cidex + cc - 1).next = null;
                cidex = cidex + cc;
            }
            return ret;
        }


    }
}

class ListNode {
         int val;
         ListNode next;
         ListNode(int x) { val = x; }
     }