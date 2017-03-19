import java.util.Arrays;

/**
 * @author boyang.lby
 * @date 3/14/17
 * @description
 */
public class CoinChange2 {

    private int ret = 0;

    public int change(int amount, int[] coins) {
        if(amount !=0 && (coins == null || coins.length == 0)){
            return 0;
        }
        if(amount == 0 && (coins != null && coins.length != 0)){
            return 0;
        }
        if(amount == 0){
            return 1;
        }
        _change(amount,coins,0);
        return ret;
    }

    public void _change(int amount, int[] coins,int j){
        if(amount == 0){
            ret ++;
            return;
        }
        if(amount < 0){
            return;
        }

        for(int i=j;i<coins.length;i++){
            _change(amount - coins[i],coins,i);
        }

    }
}

class CoinChage3{
    public int change(int amount, int[] coins) {
        if(amount !=0 && (coins == null || coins.length == 0)){
            return 0;
        }
        if(amount == 0 && (coins != null && coins.length != 0)){
            return 0;
        }
        if(amount == 0){
            return 1;
        }
        int[]dy = new int[amount + 1];
        Arrays.fill(dy, 0);
        dy[0] = 1;
        for(int j=0;j<coins.length;j++){
            for(int i=1;i<=amount;i++){
                if(i - coins[j] < 0){
                    continue;
                }
                dy[i] += dy[i-coins[j]];
            }
        }

        return dy[amount];

    }


    public static int[] singleNumber(int[] nums) {
        int[]ret = new int[2];
        if(nums == null || nums.length == 0){
            return ret;
        }
        int num = 0;
        for(int i = 0;i<nums.length;i++){
            num = num ^ nums[i];
        }
        int offset = 0;
        while((num & 1) != 1){
            num = num >> 1;
            offset++;
        }
        int left = 0;
        int right = nums.length - 1;
        while(true){
            while((1 & (nums[left] >> offset)) == 0){left++;}
            while(((nums[right] >> offset) & 1) == 1){right--;}
            if(left>right){
                break;
            }
            int tmp = nums[left];
            nums[left] = nums[right];
            nums[right] = tmp;
        }
        ret[0] = 0;
        ret[1] = 0;
        for(int i=0;i<left;i++){
            ret[0] = ret[0] ^ nums[i];
        }
        for(int i=left;i<nums.length;i++){
            ret[1] = ret[1] ^ nums[i];
        }
        return ret;

    }
    public static void main(String[]args){
        //[1,2,1,3,2,5]
        int[]nums  = new int[]{1,2,1,3,2,5};
        singleNumber(nums);
    }
}
