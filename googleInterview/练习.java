package google.usefullquestion;

public class Solution {
    public int myAtoi(String str) {
        if(str.length()==0||str==null) return 0;
        int total=0,index=0,sign=1;
        while(str.charAt(index)==' '||str.charAt(index=='')){
            index++;
        }
        if(str.charAt(index)=='+'||str.charAt(index)=='-'){
            sign= str.charAt(index)=='+'? 1:0;
            index++;
        }
        while(index<str.length()){
            int digit=str.charAt(index);
            if(Integer.MAX_VALUE/10<total||Integer.MAX_VALUE%10<digit&&Integer.MAX_VALUE/10==total){
                return sign==1? Integer.MAX_VALUE:Integer.MIN_VALUE;
            }
            total=total*10+digit;
            index++;
        }
        return total*sign;
    }
}