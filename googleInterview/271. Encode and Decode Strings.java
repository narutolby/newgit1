package google.usefullquestion;

public class Codec {

    // Encodes a list of strings to a single string.
    public String encode(List<String> strs) {
        StringBuilder sb=new StringBuilder();
        for(String s:strs){
            sb.append(s.length()).append('/').append(s);
        }
        return sb.toString();
    }

    // Decodes a single string to a list of strings.
    public List<String> decode(String s) {
        List<String> res=new ArrayList<>();
        int i=0;
        while(i<s.length()){
            int slash=s.indexOf('/',i);//int indexOf(String str, int fromIndex) 从指定的索引处开始，返回第一次出现的指定子字符串在此字符串中的索引。 
            int size=Integer.valueOf(s.substring(i,slash));
            res.add(s.substring(slash+1,slash+size+1));
            i=slash+size+1;
        }
        return res;
    }
}

// Your Codec object will be instantiated and called as such:
// Codec codec = new Codec();
// codec.decode(codec.encode(strs));
decode 的时候，如果传入的string 没有空格，没有长度，或者长度空格出现次数不匹配等等情况都要return null。
    又问如果input量很大的时候 或者string特别特别长的时候会出什么问题 我就说程序里的int就不行了 应该要换成别的。他问还有呢 我找了半天也没找到别的 他说ostringstream如果接很长很大的东西也会出问题。