package google;

/**
 * @author boyang.lby
 * @date 10/10/17
 * @description
 */
public class SuperUglyNumber {
    public int nthSuperUglyNumber(int n, int[] primes) {
        if(n <=0) return 0;
        if(n == 1) return 1;
        int[]k = new int[n];
        k[0] = 1;
        int[]idx = new int[primes.length];
        for(int i=1;i<n;i++){
            int min = Integer.MAX_VALUE;
            for(int j=0;j<primes.length;j++){
                if(k[idx[j]] * primes[j]<min){
                    min = k[idx[j]] * primes[j];
                }
            }
            k[i]=min;
            for(int j=0;j<primes.length;j++){
                if(k[idx[j]] * primes[j]==min){
                    idx[j]++;
                }
            }

        }
        return k[n-1];
    }
}
