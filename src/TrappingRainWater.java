/**
 * @author boyang.lby
 * @date 5/14/17
 * @description
 */
public class TrappingRainWater {
    public int trap(int[] height) {
        if(height == null || height.length == 0 ){
            return 0;
        }
        int ret = 0;
        int l = 0,r = height.length - 1;
        int maxLeft = 0,maxRight=0;
        while(l <= r){
            if(height[l]<=height[r]){
                if(height[l]<maxLeft){
                    ret += maxLeft - height[l];
                }else{
                    maxLeft = height[l];
                }
                l++;
            }else{
                if(height[r]<maxRight){
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
