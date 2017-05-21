import java.util.Timer;
import java.util.TimerTask;

/**
 * @author boyang.lby
 * @date 5/19/17
 * @description
 */
public class PowerofFour {
    public boolean isPowerOfFour(int num) {
        if(num != 0 && (num & num-1) == 0 && (num & 0x55555555) != 0){
            return true;
        }
        return false;
    }
}
