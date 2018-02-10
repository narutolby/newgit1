/**
 * @author boyang.lby
 * @date 2/10/18
 * @description
 */
public class NthDigit {
    public int findNthDigit(int n) {
        long start = 9;
        if(n <= start){
            return n;
        }
        long tmp = 9;
        int i = 2;
        long sum = 9;
        for(;;i++){
            tmp += (start * 10) * i;
            if(tmp >= n){
                break;
            }
            start = start * 10;
            sum += start;
        }
        tmp -= (start * 10) * i;
        int num = (int)((n - tmp - 1)/i + 1 + sum);
        int mod = (int)(n - tmp)%i;
        if(mod == 0){
            return Integer.valueOf(String.valueOf(num).toCharArray()[i-1]-'0');
        }else{
            return Integer.valueOf(String.valueOf(num).toCharArray()[mod-1]-'0');
        }

    }

    public static void main(String[]args){
       System.out.println(new NthDigit().findNthDigit(1000000000));
    }
}

