package contest81;

import java.util.Arrays;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;
import java.util.Set;

/**
 Given an array of unique integers, each integer is strictly greater than 1.

 We make a binary tree using these integers and each number may be used for any number of times.

 Each non-leaf node's value should be equal to the product of the values of it's children.

 How many binary trees can we make?  Return the answer modulo 10 ** 9 + 7.

 * @author boyang.lby
 * @date 4/22/18
 * @description
 */
public class BinaryTreesWithFactors {
    static class BitMap{
        byte[] bucket;
        public BitMap(int count){
            bucket = new byte[count / 8 + 1];
        }

        public void set(int i){
            int index = (i - 1) / 8  + 1;
            int mod = i % 8;
            if(mod == 0){
                mod = 7;
            }else{
                mod --;
            }
            bucket[index-1] |= 1<<mod;
        }

        public int get(int i){
            int index = (i - 1) / 8  + 1;
            int mod = i % 8;
            if(mod == 0){
                mod = 7;
            }else{
                mod --;
            }
            return (bucket[index-1] >> mod) & 1;
        }
    }
    public int numFactoredBinaryTrees(int[] A) {
        Arrays.sort(A);
        int mod = 1000000007;
        int count = A[A.length-1];
        Map<Integer,Integer> map = new HashMap<>();
        BitMap bitMap = new BitMap(count);
        for(int i=0;i<A.length;i++){
            map.put(A[i],1);
            bitMap.set(A[i]);
        }
        for(int i=1;i<=count;i++){
            if(bitMap.get(i) == 0){
                continue;
            }
            for(int j=0;j<A.length;j++){
                int prod = i * A[j];
                if(prod>count){
                    continue;
                }
                bitMap.set(prod);
                map.put(prod,map.getOrDefault(prod,0) + map.get(i));
                map.put(prod,map.get(prod)%mod);
            }
        }
        int ret = 0;
        for(int i:A){
            ret += map.get(i) % mod;
        }
        return ret % mod;
    }

    public static void main(String[]args){
        System.out.println(new BinaryTreesWithFactors().numFactoredBinaryTrees(new int[]{18,3,6,2}));
    }
}
