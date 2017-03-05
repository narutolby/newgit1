import java.util.HashMap;
import java.util.Map;

/**
 * @author boyang.lby
 * @date 1/1/17
 * @description
 */
public class Total_Hamming_Distance {
    private Map<HammingDistanceObj,Integer> map = new HashMap<HammingDistanceObj,Integer>();
    static class HammingDistanceObj{
        private Integer a;
        private Integer b;
        private Integer distance;

        public HammingDistanceObj(Integer a,Integer b ,Integer d){
            this.a = a;
            this.b = b;
            this.distance = d;
        }

        public Integer getA() {
            return a;
        }

        public void setA(Integer a) {
            this.a = a;
        }

        public Integer getB() {
            return b;
        }

        public void setB(Integer b) {
            this.b = b;
        }

        public Integer getDistance() {
            return distance;
        }

        public void setDistance(Integer distance) {
            this.distance = distance;
        }

        @Override
        public int hashCode() {
            return a.hashCode() * b.hashCode();
        }

        @Override
        public boolean equals(Object o1) {
            HammingDistanceObj o = (HammingDistanceObj)o1;
            if((o.getA().equals(this.getA()) && o.getB().equals(this.getB()))
                    || o.getB().equals(this.getA()) && o.getA().equals(this.getB())){
                return true;
            }
            return false;
        }
    }

    public int totalHammingDistance(int[] nums) {
        int ret = 0;
        if (nums == null || nums.length == 0){
            return ret;
        }
        for (int i=0;i<nums.length;i++){
            for(int j=i+1;j<nums.length;j++){
                HammingDistanceObj hammingDistanceObj = new HammingDistanceObj(nums[i],nums[j],null);
                if(map.containsKey(hammingDistanceObj)){
                     ret += map.get(hammingDistanceObj);
                }else{
                    int tmp = calculateHammingDistance(nums[i],nums[j]);
                    ret += tmp;
                    hammingDistanceObj.setDistance(tmp);
                    map.put(hammingDistanceObj,tmp);
                }

            }
        }
        return ret;
    }


    public int calculateHammingDistance(int a,int b){
        int c = a ^ b;
        return calculate1num(c);
    }

    public int calculate1num(int c){
        int ret = 0;
        while(c != 0){
            c = c & (c - 1); //判断
            ret ++;
        }
        return ret;
    }
    public static void main(String[]args){
        int []nums = new int[]{4,14,2};
        System.out.println(new Total_Hamming_Distance().totalHammingDistance(nums));
    }
}
