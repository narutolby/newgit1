/**
 * @author boyang.lby
 * @date 1/20/18
 * @description
 */
public class MultiplyStrings {
    public String multiply(String num1, String num2) {
        if(num1.equals("0") || num2.equals("0")){
            return "0";
        }
        char[]chars1 = num1.toCharArray();
        char[]chars2 = num2.toCharArray();
        int len1 = num1.length();
        int len2 = num2.length();
        int[]ret = new int[len1 + len2];
        int carry = 0;
        for(int i=len1-1;i>=0;i--){
            for(int j=len2-1;j>=0;j--){
                int n1 = chars1[i] - '0';
                int n2 = chars2[j] - '0';
                int sum = n1 * n2 + carry + ret[i+j+1];
                ret[i+j+1] = sum % 10;
                carry = sum / 10;
            }
            if(carry != 0){
                ret[i] = carry;
                carry = 0;
            }
        }
        StringBuilder sb = new StringBuilder();
        if(carry != 0){
            sb.append(carry);
        }
        int i = 0;
        while(ret[i] == 0){
            i++;
        }
        while(i<len1+len2){
            sb.append(ret[i]);
            i++;
        }
        return sb.toString();
    }
}
