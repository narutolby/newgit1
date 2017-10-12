package google.usefullquestion;Given a string of letters and a dictionary of legal words, find the longest legal word you can make by removing letters from the string.
比如：dict = ["cat", "dog", "bird"]
"caxtx" -> "cat".
"catbird" -> "cat"或"bird"
    
先对string做预处理，用hashmap，key是每个不一样的字符，value是该字符在string中出现的下标们组成的有序数组。当对某一个单词进行验证时，可以依次对该单词的每一个字符在hashmap[字符]中进行二分查找。假设单词长度是k，那么对该单词的这次验证的时间复杂度就是O(klogn)，所以总的时间复杂度是O(mklogn)。这种方法比暴力做法快，因为一般情况下n远大于klogn。
    
binary search是优化，暴力解法：
    
    首先预处理：
    
    HashMap<Character,List<Integer>> map=new HashMap<>();
    for(int i=0;i<str.length();i++){
        if(map.containsKey(str.charAt(i))){
            map.get(str.charAt(i).add(i));
        }else{
            map.push(str.charAt(i),i);
        }
    }
    遍历dict，找每个是否出现:
    //没有写完，但大概意思如此，缺：如果找到后，更新maxlen，res，如果没找到，跳过这个单词
    int maxlen=0;
    String res="";
    for(String s:dict){
        int index=0;//维持index，因为是顺序的
        for(int i=0;i<s.length();i++){
            if(map.containsKey(s.charAt(i))){
                List<Integer> temp=map.get(s.charAt(i));
                for(int j=0;j<temp.size();j++){
                    if(temp.get(i)>index){
                        index=temp.get(i);
                        break;
                    }
                }
            }
        }
    }