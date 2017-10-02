/**
 * @author boyang.lby
 * @date 10/2/17
 * @description
 * 思路:
 * 整体思路和解数学公式的思路是一样的,数字进行相加减(dig标识加减结果),x的系数进行相加减(co标识相加减结果),用一个s的变量来标识当前遍历是等号
 * 左边还是右边,s=1代表等号左边,s=-1代表等号右边,sign标识符号,当遍历遇到'x',把计算好的num赋值给co,因为此时的num一定是x的系数,存在特殊
 * case是'0x=0'和x没有系数的情况(此时x的系数为1),需要特殊判断'x'前一个字符是否为'0',不为0,则需要判断num是否为0
 * (e.charAt(i-1) == '0'?0:num == 0?1:num)来决定x的系数,最后遍历完的结果是 co * x (+/-) dig = 0,如果co和dig都为0,则代表x可以任意取值,
 * 返回"Infinite solutions";如果co为0,dig不为0,则 "No solution";如果上述都不是,则 x = (0 - dig) / co.
 *
 *
 *
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
