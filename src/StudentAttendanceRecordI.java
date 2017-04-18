/**
 * @author boyang.lby
 * @date 4/16/17
 * @description
 */
public class StudentAttendanceRecordI {
    public boolean checkRecord(String s) {
        if(s == null || s.length() == 0) return true;
        char[]chars = s.toCharArray();
        int acount = 0;
        int lcount = 0;
        for(int i=0;i<chars.length;i++){
            char c = chars[i];
            if(c == 'A'){
                acount++;
                lcount = 0;
            }else if(c == 'L'){
                lcount++;
            }else{
                lcount = 0;
            }
            if(acount >1 || lcount > 2){
                return false;
            }
        }
        return true;
    }

    public static void main(String[]args){
    }
}
