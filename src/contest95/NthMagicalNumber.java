package contest95;

public class NthMagicalNumber {
    public int nthMagicalNumber(int N, int A, int B) {
        long mod = 1000000007;
        long l = 1,h = Long.MAX_VALUE;
        int g = A * B / gcd(A,B);
        while(l < h){
            long mid = l + (h - l)/2;
            long count = mid / A + mid /B - mid/g;
            if(count >= N){
                h = mid;
            }else{
                l = mid + 1;
            }
        }
        return (int)(h % mod);
    }

    public int gcd(int A,int B){
        while(B > 0){
            int c = A;
            A = B;
            B = c % B;
        }
        return A;
    }

}
