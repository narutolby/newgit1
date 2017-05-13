import java.util.HashMap;
import java.util.LinkedHashMap;
import java.util.Map;
import java.util.Stack;

/**
 * @author boyang.lby
 * @date 5/13/17
 * @description
 */
public class IntegertoEnglishWords {

    Map<Integer,String> unit = new LinkedHashMap<Integer,String>();
    Map<Integer,String> translator = new HashMap<Integer,String>();
    {
        unit.put(9,"Billion");
        unit.put(6,"Million");
        unit.put(3,"Thousand");
        unit.put(2,"Hundred");
    }

    {
        translator.put(0,"Zero");
        translator.put(1,"One");
        translator.put(2,"Two");
        translator.put(3,"Three");
        translator.put(4,"Four");
        translator.put(5,"Five");
        translator.put(6,"Six");
        translator.put(7,"Seven");
        translator.put(8,"Eight");
        translator.put(9,"Nine");
        translator.put(10,"Ten");
        translator.put(11,"Eleven");
        translator.put(12,"Twelve");
        translator.put(13,"Thirteen");
        translator.put(14,"Fourteen");
        translator.put(15,"Fifteen");
        translator.put(16,"Sixteen");
        translator.put(17,"Seventeen");
        translator.put(18,"Eighteen");
        translator.put(19,"Nineteen");
        translator.put(20,"Twenty");
        translator.put(30,"Thirty");
        translator.put(40,"Forty");
        translator.put(50,"Fifty");
        translator.put(60,"Sixty");
        translator.put(70,"Seventy");
        translator.put(80,"Eighty");
        translator.put(90,"Ninety");
    }
    Stack<String> stack = new Stack<String>();

    public String numberToWords(int num) {
        if(translator.containsKey(num)){
            return translator.get(num);
        }
        String numStr = String.valueOf(num);
        numberStrToWords(numStr);
        StringBuilder sb = new StringBuilder();
        for(int i=0;i<stack.size()-1;i++){
            sb.append(stack.get(i));
            sb.append(" ");
        }
        sb.append(stack.get(stack.size()-1));
        return sb.toString();
    }

    public void numberStrToWords(String num){
        int n = Integer.valueOf(num);
        num = String.valueOf(n);
        int len = num.length();
        if(n == 0){return;}
        if(translator.containsKey(n)){
            stack.push(translator.get(n));
            return;
        }
        if(len <= 2){
            stack.push(translator.get(n / 10 * 10));
            stack.push(translator.get(n % 10));
            return;
        }

        for(Map.Entry<Integer,String> entry : unit.entrySet()){
            Integer key = entry.getKey();
            String u = entry.getValue();
            if(len > key){
                String str1 = num.substring(0,len - key);
                numberStrToWords(str1);
                stack.push(u);
                String str2 = num.substring(len - key);
                numberStrToWords(str2);
                break;
            }
        }
    }

    public static void main(String[]args){
        System.out.println(new IntegertoEnglishWords().numberToWords(123));
    }
}
