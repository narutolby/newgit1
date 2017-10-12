package google.usefullquestion;https://discuss.leetcode.com/topic/27250/share-my-java-backtracking-solution
public class Solution {
    public boolean canWin(String s) {
        if (s == null || s.length() < 2) {
            return false;
        }
        for (int i = 0; i < s.length() - 1; i++) {
            if (s.startsWith("++", i)) {
            String t = s.substring(0, i) + "--" + s.substring(i + 2);
            if (!canWin(t)) {
                
                return true;
                }
            }
        }
      return false;
    }
}
public boolean canWin(String s) {
    if(s == null || s.length() < 2) return false;
    Map<String, Boolean> map = new HashMap<>();
    return canWin(s, map);
}

public boolean canWin(String s, Map<String, Boolean> map){
    if(map.containsKey(s)) return map.get(s);
    for(int i = 0; i < s.length() - 1; i++) {
        if(s.charAt(i) == '+' && s.charAt(i + 1) == '+') {
            String opponent = s.substring(0, i) + "--" + s.substring(i + 2);
            if(!canWin(opponent, map)) {
                map.put(s, true);
                return true;
            }
        }
    }
    map.put(s, false);
    return false;
}
怎么优化，写了hashmap记录中间结果。
还能怎么优化，用dp(不用写，其实我也不知道咋写)。
怎么存每个state更好，我说可以用bit来存，每一位1就是+，0就是-。
又问其实有些string是属于同一个thing（不懂当时）， 给我举例子：---+--+ 和--+---+++++ 在游戏中实际上是同一个thing
后来发现---+--+有一组连续两个- 和一组连续三个-；--+---+++++也有有一组连续两个- 和一组连续三个-。 所以这个两个在游戏中是同一个thing（因为是把--翻转成++）。
