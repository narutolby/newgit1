package google.usefullquestion;

public class ValidWordAbbr {
    HashMap<String, String> map;
    public ValidWordAbbr(String[] dictionary) {
        map = new HashMap<String, String>();
        for(String str:dictionary){
            String key = getKey(str);
            // If there is more than one string belong to the same key
            // then the key will be invalid, we set the value to ""
            if(map.containsKey(key)){
                if(!map.get(key).equals(str)){
                    map.put(key, "");
                }
            }
            else{
                map.put(key, str);
            }
        }
    }

    public boolean isUnique(String word) {
        return !map.containsKey(getKey(word))||map.get(getKey(word)).equals(word);
    }
    
    String getKey(String str){
        if(str.length()<=2) return str;
        return str.charAt(0)+Integer.toString(str.length()-2)+str.charAt(str.length()-1);
    }
}

不用额外空间怎么做，用boolean确保只出现一次
给一个缩写，需要确定字典里面所有单词的这种缩写只出现一次。 那就用一个boolean表示是否出现了，如果已经出现了后再出现代表不是unique。 之后再看是否出现过一次，是的话true，不是的话false
// Your ValidWordAbbr object will be instantiated and called as such:
// ValidWordAbbr vwa = new ValidWordAbbr(dictionary);
// vwa.isUnique("Word");
// vwa.isUnique("anotherWord");