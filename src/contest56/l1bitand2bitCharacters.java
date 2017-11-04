package contest56;

/**
 * @author boyang.lby
 * @date 10/29/17
 * @description
 */
public class l1bitand2bitCharacters {
    public boolean isOneBitCharacter(int[] bits) {
        if(bits.length == 1){
            return true;
        }
        int i = 0;
        while(i<bits.length){
            if(bits[i] == 1){
                i +=2;
            }else{
                i++;
            }
            if( i == bits.length - 1){
                return true;
            }
        }
        return false;
    }
}
