package google.usefullquestion;有很骰子，每个骰子有6个面，上面全是字母，每个骰子用长度为6字符串如"adsads"来表示，给你一组骰子，和一个target word,问你可不可能用这些骰子投出这个单词。
LZ用backtrack解决的 （见phone number leetcode17）
follow up1:假设骰子可能有一个面是"*"，可以代表任何字母。这个就是判断条件+一个“|| char == "*”
follow up2:.
假设骰子有表示顺序，例如第一个骰子必须在第二个骰子之前。 
LZ就是每次选下一个骰子的时候判断是不是合法的
    
把每个骰子建一个hashset，然后扔到一个list里面去。从单词的第一个字母开始，用一个for循环遍历所有的骰子，一旦这个骰子包含了这个字母我们就把一个visit标记下说明用了这个骰子，然后去backtrack单词的第二个字母，同样也是一个for循环去找所有的骰子。一旦可以backtrack到深度和单词的长度一致就返回true。
然后follow up的，如果一个骰子有*，那么其实就是这个骰子的hashset返回的永远是true，可以把单词的所有字母都事先扔进去。 之后的follow up如果可以有k次错误就相当去我们backtrack分叉的时候多了一个岔路，这个岔路不消耗任何的骰子但是消耗一个k，就是k--。
    
    
//seq: 记录每次dice的index，
public boolean dfs(String target,int index,List<String> list,int seq,int k){
    if(index==target.length()) return true;
    for(String s:list){
        //seq: if现在的cur的seq小于seq，continue
        for(int i=0;i<s.length();i++){
            if(s.charAt(i)==target.charAt(index)||s.charAt(i)=='*'){
                list.remove(s);
                if(dfs(target,index+1,list)) return true;
                list.add(s);
            }else if(k>0){
                list.remove(s);
                k--;
                if(dfs(target,index+1,list)) return true;
                list.add(s);
            }
        }
    }
    return false;
}