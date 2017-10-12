package google.usefullquestion;

public class Solution {
    public List<String> findMissingRanges(int[] nums, int lower, int upper) {
        List<String> list = new ArrayList<String>();
        long alower=(long)lower,aupper=(long)upper;
        for(int num : nums){
            if(num==alower) alower++;
            else if(alower<num){
                if(alower+1==num) list.add(String.valueOf(alower));
                else list.add(alower+"->"+(num-1));
                alower=(long)num+1;
            }
        }
        if(alower == aupper) list.add(String.valueOf(alower));
        else if(alower < aupper) list.add(alower + "->" + aupper);
        return list;
    }
}