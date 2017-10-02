/**
 * @author boyang.lby
 * @date 10/2/17
 * @description
 */
public class SolvetheEquation {
    public String solveEquation(String e) {
        String NS = "No solution";
        String IS = "Infinite solutions";
        if(e == null || e.length() == 0){
            return NS;
        }
        int co = 0;
        int dig = 0;
        int s = 1;
        int sign = 1;
        int num = 0;
        for(int i=0;i<e.length();i++){
            char c = e.charAt(i);
            if(isDigit(c)){
                num = num * 10 + c - '0';
            }
            if(!isDigit(c) || i == e.length() - 1){
                if(c == 'x'){
                    co += s * sign * (i>0 && e.charAt(i-1) == '0'?0:num == 0?1:num);
                }else if(c == '='){
                    dig += s * sign * num;
                    s = -1;
                    sign = 1;
                }else if(c == '+'){
                    dig += s * sign * num;
                    sign = 1;
                }else if (c == '-'){
                    dig += s * sign * num;
                    sign = -1;
                }else {
                    dig += s * sign * num;
                }
                num = 0;
            }
        }
        if(co == 0 && dig == 0){
            return IS;
        }
        if(co == 0){
            return NS;
        }
        return "x=" + (0 - dig / co);
    }

    public boolean isDigit(char c){
        return c >= '0' && c <= '9';
    }
}
