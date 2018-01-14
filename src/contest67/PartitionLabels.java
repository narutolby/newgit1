package contest67;

import sun.jvm.hotspot.utilities.Interval;

import java.util.*;

public class PartitionLabels {
    class Interval{
        int l;
        int r;
        public Interval(int l,int r){
            this.l = l;
            this.r = r;
        }
    }
    public List<Integer> partitionLabels(String S) {
        int[][]table = new int[26][2];
        char[]chars = S.toCharArray();
        for(int i=0;i<26;i++){
            Arrays.fill(table[i],-1);
        }
        for(int i=0;i<chars.length;i++){
            if(table[chars[i]-'a'][0] == -1){
                table[chars[i]-'a'][0] = i;
                table[chars[i]-'a'][1] = i;
            }else{
                table[chars[i] - 'a'][1] = i;
            }
        }
        List<Interval> list = new ArrayList<>();
        for(int i=0;i<26;i++){
            if(table[i][0] !=-1){
                list.add(new Interval(table[i][0],table[i][1]));
            }
        }
        Collections.sort(list, new Comparator<Interval>() {
            @Override
            public int compare(Interval o1, Interval o2) {
                return o1.l - o2.l;
            }
        });

        Stack<Interval> another = new Stack<>();
        another.add(list.get(0));
        for(int i=1;i<list.size();i++){
            if(list.get(i).l<another.peek().r){
                 another.peek().r = Math.max(list.get(i).r,another.peek().r);
            }else {
                another.push(new Interval(list.get(i).l,list.get(i).r));
            }
        }
        List<Integer> ret = new ArrayList<>();
        for(Interval i : another){
            ret.add(i.r - i.l + 1);
        }
        return ret;
    }
    public static void main(String[]args){
        new PartitionLabels().partitionLabels("ababcbacadefegdehijhklij");
    }
}
