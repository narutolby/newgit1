/**
 * @author boyang.lby
 * @date 4/16/17
 * @description
 */
public class StudentAttendanceRecordII {
    public int checkRecord(int n) {
        if(n == 0){
            return 0;
        }
        if(n == 1){
            return 1;
        }
        if(n == 2){
            return 8;
        }
        int all = (int)Math.pow(3,n);
        int moreOneA = all - (int)Math.pow(2,n) - amn(n,1);
        return 0;

    }

    public int amn(int m,int n){
        int ret = 1;
        for(int i=0;i<n;i++){
            ret = ret * (m--);
        }
        return ret;
    }

    public static void main(String[]args){
        System.out.println(Math.pow(2,3));
    }
}

