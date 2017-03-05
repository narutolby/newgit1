/**
 * @author boyang.lby
 * @date 1/19/17
 * @description
 */
public class NumberofSegmentsinaString {
    public static int countSegments(String s) {
        boolean start = false;
        int ret = 0;
        char[] chars = new char[0];
        try {
            chars = s.toCharArray();
        } catch (Exception e) {
            e.printStackTrace();
        }

        for(char c : chars){
            if(c == ' '){
                start = false;
                continue;
            }
            if(start == false ){
                start = true;
                ret++;
            }
        }

        return ret;
    }

    public static void main(String[]args){
        System.out.println(countSegments(", , , ,        a, eaefa"));
    }
}
