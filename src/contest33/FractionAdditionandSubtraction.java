package contest33;
import java.util.ArrayList;
import java.util.List;

/**
 * @author boyang.lby
 * @date 5/21/17
 * @description
 */
public class FractionAdditionandSubtraction {
    public String fractionAddition(String expression) {
        if(expression == null || expression.length() == 0){
            return expression;
        }
        if(expression.charAt(0) == '-'){
            expression = "0" + expression;
        }
        String[]ea = expression.split("-|\\+");
        List<List<Integer>> list = new ArrayList<List<Integer>>();
        Long sum = 1L;
        for(String ee : ea){
            List<Integer> tmpList = new ArrayList<Integer>();
            if(ee.indexOf("/") != -1){
                String[]tmp = ee.split("/");
                tmpList.add(Integer.valueOf(tmp[0]));
                tmpList.add(Integer.valueOf(tmp[1]));
                sum *= tmpList.get(1);
            }else{
                tmpList.add(Integer.valueOf(ee));
            }
            list.add(tmpList);
        }
        Long ret1 = list.get(0).size() == 1 ? 0 : list.get(0).get(0) * sum / list.get(0).get(1);
        int index = 0;
        for(int i=0;i<expression.length();i++){
            char c = expression.charAt(i);
            if(c == '-' || c == '+'){
                index ++;
                Long b = list.get(index).size() == 1 ? 0 : list.get(index).get(0) * sum / list.get(index).get(1);
                if(c == '-'){
                    ret1 = ret1 - b;
                }else{
                    ret1 = ret1 + b;
                }
            }
        }
        Long m = common(ret1, sum);
        return ret1/m + "/" + sum/m;
    }
    public long common (long a, long b){
        long min = Math.abs(Math.min(a, b));
        long max = Math.abs(Math.max(a, b));
        if(min == 0 || max == 0){
            return max;
        }
        while(max%min !=0){
            long tmp = max % min;
            max = min;
            min = tmp;
        }
        return min;
    }
    public static void main(String[]args){
        System.out.println(new FractionAdditionandSubtraction().fractionAddition("7/2+2/3-3/4"));
    }
}
