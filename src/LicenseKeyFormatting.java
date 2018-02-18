/**
 * @author boyang.lby
 * @date 2/16/18
 * @description
 */
public class LicenseKeyFormatting {
    public String licenseKeyFormatting(String S, int K) {
        if(S == null || S.length() == 0){
            return S;
        }
        char[]chars = S.toCharArray();
        int count = 0;
        StringBuffer sb = new StringBuffer();
        for(int j=chars.length-1;j>=0;j--){
            char c = chars[j];
            if(c >= 'a' && c <= 'z'){
                c -= 32;
            }
            if(c == '-'){
                continue;
            }else if(count == K){
                sb.append('-');
                sb.append(c);
                count = 1;
            }else{
                count++;
                sb.append(c);
            }
        }
        return sb.reverse().toString();
    }
   public static void main(String[]args) {
       System.out.println((char)('x' ^ 32));
       System.out.println(Integer.toBinaryString((int)('x')));
       System.out.println(Integer.toBinaryString((int)('x' ^ 32)));
   }
}
