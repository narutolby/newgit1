package airbnbgo;

/**
 * @author boyang.lby
 * @date 2/10/19
 * @description
 */
public class TrappingRainWater {
    public int trap(int[] height) {
        if (height.length == 0 || height.length == 1){
            return 0;
        }
        int l = 0,r = height.length - 1;
        int maxLeft = 0, maxRight = 0;
        int ret = 0;
        while(l <= r){
            if(height[l] <= height[r] ){
                if(height[l]<=maxLeft){
                    ret += maxLeft - height[l];
                }else{
                    maxLeft = height[l];
                }
                l++;
            }else{
                if(height[r]<=maxRight){
                    ret += maxRight - height[r];
                }else{
                    maxRight = height[r];
                }
                r--;
            }
        }
        return ret;
    }
}
