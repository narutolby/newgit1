package contest90;

public class MirrorReflection {
    public int mirrorReflection(int p, int q) {
        int mod = maxCommonDivisor(p,q);
        int x = p / mod;
        int y = q / mod;
        int l = x % 2;
        int n = y % 2;
        if(l == 0){
            return 2;
        }else{
            if(n == 1){
                return 1;
            }else{
                return 0;
            }
        }
    }

    public static int maxCommonDivisor(int m, int n) {
        if (m < n) {// 保证m>n,若m<n,则进行数据交换
            int temp = m;
            m = n;
            n = temp;
        }
        if (m % n == 0) {// 若余数为0,返回最大公约数
            return n;
        } else { // 否则,进行递归,把n赋给m,把余数赋给n
            return maxCommonDivisor(n, m % n);
        }
    }


    public static int mirrorReflection_1(int p, int q) {
        for(int i = 1;;i++){
            int y = q*i % (2*p);
            if(y == 0){
                if(i % 2 == 1){
                    return 0;
                }else{
                    throw new RuntimeException();
                }
            }else if(y == p){
                if(i % 2 == 1){
                    return 1;
                }else{
                    return 2;
                }
            }
        }
    }
}
