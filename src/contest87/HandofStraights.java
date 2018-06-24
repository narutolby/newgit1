package contest87;

import contest54.FallingSquares;

import java.util.*;

/**
 * Alice has a hand of cards, given as an array of integers.

 Now she wants to rearrange the cards into groups so that each group is size W, and consists of W consecutive cards.

 Return true if and only if she can.



 Example 1:

 Input: hand = [1,2,3,6,2,3,4,7,8], W = 3
 Output: true
 Explanation: Alice's hand can be rearranged as [1,2,3],[2,3,4],[6,7,8].
 Example 2:

 Input: hand = [1,2,3,4,5], W = 4
 Output: false
 Explanation: Alice's hand can't be rearranged into groups of 4.


 Note:

 1 <= hand.length <= 10000
 0 <= hand[i] <= 10^9
 1 <= W <= hand.length

 */
public class HandofStraights {
    public boolean isNStraightHand(int[] hand, int W) {
        if(hand.length % W != 0){
            return false;
        }
        if(W == 1){
            return true;
        }
        Arrays.sort(hand);
        List<Integer> list = new LinkedList<Integer>();
        Map<Integer,Integer> map = new HashMap<Integer,Integer>();
        for(int i=0;i<hand.length;i++){
            int val = hand[i];
            if(map.containsKey(val)){
                map.put(val,map.get(val)+1);
            }else{
                list.add(val);
                map.put(val,1);
            }
        }
        int groups = hand.length / W;
        for(int i=0;i<groups;i++){
            int start = -1;
            for(int j=0;j<W;j++){
                boolean isbreak = false;
                for(Iterator<Integer> iterator = list.iterator();iterator.hasNext();){
                    int candi = iterator.next();
                    if(map.get(candi)!=0){
                        if(start == -1){
                            start = candi;
                            map.put(candi,map.get(candi)-1);
                            isbreak = true;
                            break;
                        }else{
                            if(start+1 == candi){
                                start = candi;
                                map.put(candi,map.get(candi)-1);
                                isbreak = true;
                                break;
                            }
                        }
                    }else{
                        iterator.remove();
                    }
                }
                if(!isbreak){
                    return false;
                }
            }
        }
        return true;
    }
    public static void main(String[]args){
        new HandofStraights().isNStraightHand(new int[]{1,1,2,2,3,3 },2);
    }
}
