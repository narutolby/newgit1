package contest73;

/**
 * @author boyang.lby
 * @date 2/25/18
 * @description
 */
public class RotatedDigits {
    public int rotatedDigits(int N) {
        int ret = 0;
        for(int i=1;i<=N;i++){
            String nums = String.valueOf(i);
            char[]chars = nums.toCharArray();
            boolean flag = false;
            for(int j=0;j<chars.length;j++){
                char c = chars[j];
                if(c != '0' && c != '1' && c != '8' && c != '2' && c != '5' && c != '6' && c != '9'){
                    flag = true;
                    break;
                }
                if(c == '2'){
                    chars[j] = '5';
                }else if(c == '5'){
                    chars[j] = '2';
                }else if(c == '6'){
                    chars[j] = '9';
                }else if(c == '9'){
                    chars[j] = '6';
                }
            }
            if(flag){
                continue;
            }
            StringBuilder sb = new StringBuilder();
            sb.append(chars);
            String rotate = sb.toString();
            if(rotate.charAt(0) == '0'){
                continue;
            }
            if(!rotate.equals(nums)){
                ret++;
            }
        }
        return ret;
    }
    public static void main(String[]args){
        System.out.println(new RotatedDigits().rotatedDigits(857));
    }
}
