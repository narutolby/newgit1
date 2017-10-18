package contest54;

public class CountBinarSubstrings {
    public int countBinarySubstrings(String s) {
        if(s == null || s.length() == 0 || s.length() == 1){
            return 0;
        }
        int last = 0,ret = 0,count = 0;
        char now = s.charAt(0);
        for(int i=0;i<s.length();i++){
            if(s.charAt(i) == now){
                count++;
            }else{
                ret += Math.min(last,count);
                last = count;
                now = s.charAt(i);
                count = 1;
            }
        }
        ret += Math.min(last,count);
        return ret;
    }
    public static void main(String[]ars){
        System.out.println(new CountBinarSubstrings().countBinarySubstrings("000100"));

        System.out.println(new CountBinarSubstrings().countBinarySubstrings1("10101"));
    }

    int countBinarySubstrings1(String s) {
        int now = s.charAt(0);
        int n = s.length();
        int last = 0;
        int res = 0, cnt = 0;
        for (int i = 0; i < n; i++) {
            if (now != s.charAt(i)) {
                res += Math.min(cnt, last);
                last = cnt;
                cnt = 1;
                now = s.charAt(i);
            } else {
                cnt++;
            }
        }
        res += Math.min(cnt, last);
        return res;
    }

}

